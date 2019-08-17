package com.example.myapplication.di.modules

import androidx.annotation.NonNull
import okhttp3.OkHttpClient
import com.example.myapplication.di.scopes.PerApplication
import dagger.Provides
import com.google.gson.GsonBuilder
import com.google.gson.Gson
import dagger.Module
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import com.example.myapplication.BuildConfig
import com.example.myapplication.data.network.FactsApi
import okhttp3.logging.HttpLoggingInterceptor
import javax.inject.Singleton




@Module
class NetworkModule {
    private val BASE_URL = "https://cat-fact.herokuapp.com/"

    @NonNull
    @Provides
    @PerApplication
    fun provideRetrofit(@NonNull okHttpClient: OkHttpClient, @NonNull gson: Gson): FactsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build().create<FactsApi>(FactsApi::class.java)
    }

    @NonNull
    @Provides
    @PerApplication
    fun provideGson(): Gson {
        return GsonBuilder()
            .create()
    }

    @Provides
    @PerApplication
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)
    }

    @NonNull
    @Provides
    @PerApplication
    fun provideOkHttpClient(@NonNull httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }
}