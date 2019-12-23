package br.com.chucknorris.coreui.di.network

import android.content.Context
import android.net.ConnectivityManager
import br.com.chucknorris.core.NetworkAvailability
import br.com.chucknorris.coreui.BuildConfig
import br.com.chucknorris.coreui.network.NetworkAvailabilityImpl
import br.com.chucknorris.coreui.network.UnsafeOkHttpClient
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.security.KeyStore
import javax.inject.Singleton
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManagerFactory

private const val ENDPOINT_URL = "https://api.chucknorris.io/"

@Module
class NetworkModule {

    @Singleton
    @Provides
    fun networkAvailability(networkAvailability: NetworkAvailabilityImpl): NetworkAvailability = networkAvailability

    @Singleton
    @Provides
    fun provideConnectivityManager(context: Context) =
        context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

    @Provides
    fun provideOkHttpClient(interceptor: HttpLoggingInterceptor): OkHttpClient {
        return UnsafeOkHttpClient.getUnsafeOkHttpClient()
            .addInterceptor(interceptor)
            .build()
    }

    @Provides
    fun provideLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor.Level.BODY
        } else {
            HttpLoggingInterceptor.Level.NONE
        }
    }

    @Provides
    @Singleton
    fun provideGson(): Gson = Gson()

    @Provides
    @Singleton
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory = GsonConverterFactory.create(gson)

    @Provides
    @Singleton
    fun providesRetrofit(
        okHttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(ENDPOINT_URL)
            .callFactory(okHttpClient)
            .addConverterFactory(converterFactory)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}
