import com.google.gson.Gson
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create

object APIclient {
    var  retrofit = Retrofit
        .Builder()
        .baseUrl("https://jsonplaceholder.typicode.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
    fun<T> buildApiInterface(apiInterface: Class<T>):T{
        return retrofit.create(apiInterface)
    }
}