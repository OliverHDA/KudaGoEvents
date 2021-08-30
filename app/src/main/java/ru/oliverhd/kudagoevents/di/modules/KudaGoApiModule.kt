package ru.oliverhd.kudagoevents.di.modules

import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import ru.oliverhd.kudagoevents.api.KudaGoApi
import javax.inject.Named

@Module
class KudaGoApiModule {

    @Named("kudago_base_url")
    @Provides
    fun provideBaseUrl(): String = "https://kudago.com/public-api/v1.4/"

    @Provides
    fun provideKudaGoApi(@Named("kudago_base_url") baseUrl: String): KudaGoApi =
        Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(
                GsonConverterFactory.create(GsonBuilder().setLenient().create())
            )
            .client(
                OkHttpClient
                    .Builder()
                    .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .build()
            )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
            .create(KudaGoApi::class.java)
}
