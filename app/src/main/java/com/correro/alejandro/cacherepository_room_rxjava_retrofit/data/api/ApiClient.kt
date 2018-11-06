
import android.content.Context
import com.correro.alejandro.cacherepository_room_rxjava_retrofit.utils.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class ApiClient private constructor() {

    private val service: ApiService

    init {
        val builder: OkHttpClient.Builder = OkHttpClient.Builder()
        builder.addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
        builder.connectTimeout(1, TimeUnit.MINUTES)
        builder.readTimeout(1, TimeUnit.MINUTES)
        val client: OkHttpClient = builder.build();
        val retrofit = Retrofit.Builder()
                .baseUrl(Constants.ADDRESS)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()

        service = retrofit.create<ApiService>(ApiService::class.java)
    }

    companion object Factory {
        private var ourInstance: ApiClient? = null

        @Synchronized
        fun getInstance(): ApiClient {
            if (ourInstance == null) {
                ourInstance = ApiClient()
            }
            return ourInstance as ApiClient
        }
    }

    fun getService(): ApiService {
        return service
    }
}