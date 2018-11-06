
import com.correro.alejandro.cacherepository_room_rxjava_retrofit.data.models.PlanetsResult
import io.reactivex.Observable
import retrofit2.http.*


interface ApiService {

    @GET("starships")
    fun getStarship(): Observable<PlanetsResult>


}