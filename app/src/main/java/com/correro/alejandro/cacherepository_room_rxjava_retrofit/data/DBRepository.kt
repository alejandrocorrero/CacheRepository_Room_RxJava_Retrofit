import android.app.Application
import android.arch.persistence.room.Room
import com.correro.alejandro.cacherepository_room_rxjava_retrofit.data.models.Result
import com.correro.alejandro.cacherepository_room_rxjava_retrofit.utils.Constants
import com.example.fitcel.fitcel.data.appdatabase.dao.AppDatabase
import io.reactivex.Observable

class DBRepository(application: Application) {



    private var appDatabase: AppDatabase = Room.databaseBuilder(application, AppDatabase::class.java, Constants.KEY_DATABASE)
            .fallbackToDestructiveMigration().build()

    private var api: ApiService = ApiClient.getInstance().getService()


    companion object Factory {
        private var ourInstance: DBRepository? = null

        @Synchronized
        fun getInstance(application: Application): DBRepository {
            if (ourInstance == null) {
                ourInstance = DBRepository(application)
            }
            return ourInstance as DBRepository
        }
    }

    fun getResults(): Observable<ArrayList<Result>> {
        return Observable.concatArrayEager(
                getResultsFromDb() as Observable<ArrayList<Result>>,
                getResultsFromApi())
                .map { it }
    }

    private fun getResultsFromApi(): Observable<ArrayList<Result>?>? {
        return api.getStarship().map { if (it.count!! > 0) it.results else null }.doOnNext {
            appDatabase.resultDao().insertResult(it!!)
        }.onErrorReturn {
            ArrayList()
        }

    }


    private fun getResultsFromDb(): Observable<List<Result>?>? {
        return appDatabase.resultDao().getResult()?.toObservable()
    }
}
