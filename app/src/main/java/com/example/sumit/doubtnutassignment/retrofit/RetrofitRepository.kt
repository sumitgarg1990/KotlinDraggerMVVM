package com.example.sumit.doubtnutassignment.retrofit

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.example.sumit.doubtnutassignment.MyApplication
import com.example.sumit.doubtnutassignment.di.DIComponent
import com.example.sumit.doubtnutassignment.model.Articles
import com.example.sumit.doubtnutassignment.model.NewsInfo
import io.reactivex.SingleObserver
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.plugins.RxJavaPlugins.onSubscribe
import io.reactivex.schedulers.Schedulers
import retrofit2.Call
import retrofit2.Retrofit
import javax.inject.Inject

class RetrofitRepository {
    var postInfoMutableList: MutableLiveData<List<NewsInfo>> = MutableLiveData()
    lateinit var diComponent: DIComponent
    @Inject
    lateinit var retrofit: Retrofit

    init {

        var diComponent :DIComponent =  MyApplication().getMyComponent()
        diComponent.inject(this)
    }
    fun fetchNewsInfoList(): LiveData<List<NewsInfo>> {

        var apiService:APIService = retrofit.create(APIService::class.java)
        apiService.makeRequest().observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(object:SingleObserver<Articles> {
                    override fun onSubscribe( d : Disposable) {

                    }

                    override fun onSuccess(articles: Articles) {
                        postInfoMutableList.value = articles.articles;

                    }

                    override fun  onError(e:Throwable) {
                        Log.d("RetroRepository","Failed:::"+e.message)
                    }
                });



        return  postInfoMutableList

    }
}