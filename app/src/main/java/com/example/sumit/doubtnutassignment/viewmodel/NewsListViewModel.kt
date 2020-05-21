package com.example.sumit.doubtnutassignment.viewmodel

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.example.sumit.doubtnutassignment.MyApplication
import com.example.sumit.doubtnutassignment.di.DIComponent
import com.example.sumit.doubtnutassignment.model.NewsInfo
import com.example.sumit.doubtnutassignment.retrofit.RetrofitRepository
import javax.inject.Inject


class NewsListViewModel: ViewModel() {

    @Inject
    lateinit var retrofitRepository: RetrofitRepository
    var newsInfoLiveData: LiveData<List<NewsInfo>> = MutableLiveData()

    init {
        var diComponent : DIComponent =  MyApplication().getMyComponent()
        diComponent.inject(this)
        fetchNewsInfoFromRepository()
    }

    fun fetchNewsInfoFromRepository(){
        newsInfoLiveData =  retrofitRepository.fetchNewsInfoList()
    }


}