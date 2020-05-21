package com.example.sumit.doubtnutassignment.di

import com.example.sumit.doubtnutassignment.MainActivity
import com.example.sumit.doubtnutassignment.retrofit.RetrofitRepository
import com.example.sumit.doubtnutassignment.viewmodel.NewsListViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [DIModule::class])
public interface DIComponent {
    fun inject(retrofitRepository: RetrofitRepository)
     fun inject(newsListViewModel: NewsListViewModel)
    fun inject(mainActivity: MainActivity)
   // fun inject(retroViewModelFactory:RetroViewModelFactory)
}