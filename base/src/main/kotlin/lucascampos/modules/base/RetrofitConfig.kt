package lucascampos.modules.base

import lucascampos.modules.base.data.Api
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitConfig {

    var api : Api? = null
        get() {
            return field ?:
            Retrofit.Builder()
                    .baseUrl("https://api.github.com/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(getHttpClient())
                    .build()
                    .create(Api::class.java)
        }

    private fun getHttpClient() =
            OkHttpClient.Builder()
                    .addInterceptor(getHttpLogging())
                    .build()

    private fun getHttpLogging(): HttpLoggingInterceptor =
            if (BuildConfig.DEBUG)
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            else
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)

}
