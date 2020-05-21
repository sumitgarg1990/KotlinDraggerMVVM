package com.example.sumit.doubtnutassignment.retrofit

import com.example.sumit.doubtnutassignment.model.Articles
import com.example.sumit.doubtnutassignment.model.NewsInfo
import io.reactivex.Single
import retrofit2.http.GET

interface APIService {
    @GET("top-headlines?country=in&apiKey=8a2482250029429cb9f0c6536f27a8e4")
    fun makeRequest(): Single<Articles>
}