package com.example.sumit.doubtnutassignment

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.sumit.doubtnutassignment.databinding.ActivityDetailBinding
import com.example.sumit.doubtnutassignment.model.NewsInfo

class DetailActivity : AppCompatActivity(){

    lateinit var binding : ActivityDetailBinding
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
         binding=DataBindingUtil.setContentView(this, R.layout.activity_detail)

         val newsInfo = intent.getParcelableExtra("data") as? NewsInfo

         binding.model=newsInfo

         Glide.with(this).load(newsInfo?.urlToImage).into(binding.img)

    }
}