package com.example.sumit.doubtnutassignment

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import com.example.sumit.doubtnutassignment.adapter.NewsListAdapter
import com.example.sumit.doubtnutassignment.databinding.ActivityMainBinding
import com.example.sumit.doubtnutassignment.model.NewsInfo
import com.example.sumit.doubtnutassignment.retrofit.RetrofitRepository
import com.example.sumit.doubtnutassignment.viewmodel.NewsListViewModel
import retrofit2.Retrofit
import javax.inject.Inject
import android.content.Intent



class MainActivity : AppCompatActivity(), NewsListAdapter.OnCardClickListner {
    lateinit var newsListViewModel: NewsListViewModel
    private  var listAdapter:NewsListAdapter?=null
    lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView( this,R.layout.activity_main)
        newsListViewModel = ViewModelProviders.of(this).get(NewsListViewModel::class.java)

        binding.newsList.setLayoutManager(LinearLayoutManager(this))
        listAdapter=NewsListAdapter(this)
        binding.newsList.setAdapter(listAdapter)

        fetchRetroInfo()
        listAdapter?.setOnCardClickListner(this@MainActivity)
    }
    fun fetchRetroInfo(){
        newsListViewModel.newsInfoLiveData?.observe(this,object: Observer<List<NewsInfo>> {
            override fun onChanged(t: List<NewsInfo>?) {
                t?.apply {
                    listAdapter?.setAdapterList(t)
                }
            }
        })
    }

    override fun OnCardClicked(view: View, position: Int) {
        val intent = Intent(this@MainActivity, DetailActivity::class.java)
        intent.putExtra("data", listAdapter?.list?.get(position))
        startActivity(intent)

    }
}
