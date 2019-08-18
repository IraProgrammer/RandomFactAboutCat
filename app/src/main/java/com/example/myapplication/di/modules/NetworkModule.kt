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
import com.example.myapplication.data.network.ApiKeyInterceptor
import com.example.myapplication.data.network.CatsApi
import okhttp3.logging.HttpLoggingInterceptor


@Module
class NetworkModule {
    private val BASE_URL = "https://api.thecatapi.com/v1/"

    @NonNull
    @Provides
    @PerApplication
    fun provideRetrofit(@NonNull okHttpClient: OkHttpClient, @NonNull gson: Gson): CatsApi {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .client(okHttpClient)
            .build().create<CatsApi>(CatsApi::class.java)
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
    fun provideApiKeyInterceptor(): ApiKeyInterceptor {
        return ApiKeyInterceptor()
    }

    @Provides
    @PerApplication
    fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)
    }

    @NonNull
    @Provides
    @PerApplication
    fun provideOkHttpClient(
        apiKeyInterceptor: ApiKeyInterceptor,
        httpLoggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(apiKeyInterceptor)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }
}