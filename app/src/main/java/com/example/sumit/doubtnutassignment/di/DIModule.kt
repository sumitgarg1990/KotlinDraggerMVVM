package com.example.sumit.doubtnutassignment.di

import com.example.sumit.doubtnutassignment.retrofit.RetrofitRepository
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import okhttp3.OkHttpClient
import com.google.gson.Gson
import dagger.Module
import javax.inject.Singleton
import dagger.Provides
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import java.util.concurrent.TimeUnit


@Module
class DIModule {

    @Singleton
    @Provides
    fun provideOKHttpClient():OkHttpClient{
        return  OkHttpClient.Builder()
                .readTimeout(1200,TimeUnit.SECONDS)
                .connectTimeout(1200, TimeUnit.SECONDS)
                .build()

    }
    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl("https://newsapi.org/v2/")
                .client(okHttpClient)
                .build()
    }
    @Provides
    fun provideRetroRepository(): RetrofitRepository {
        return RetrofitRepository()
    }
}