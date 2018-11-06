
import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import com.correro.alejandro.cacherepository_room_rxjava_retrofit.R

import io.reactivex.disposables.CompositeDisposable
import retrofit2.HttpException
import java.io.IOException
import java.net.SocketTimeoutException

abstract class ViewModelParent(application: Application) : AndroidViewModel(application) {
    val dbRepository= DBRepository.getInstance(application)
    val apiService: ApiService = ApiClient.getInstance().getService()
    var errorMessage = MutableLiveData<String>()
    val context = application
    val compositeDisposable= CompositeDisposable()



    override fun onCleared() {
        compositeDisposable.dispose()
        super.onCleared()
    }
}