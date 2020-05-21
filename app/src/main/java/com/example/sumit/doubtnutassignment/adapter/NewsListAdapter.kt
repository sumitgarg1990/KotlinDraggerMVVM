package com.example.sumit.doubtnutassignment.adapter

import android.content.Context
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.example.sumit.doubtnutassignment.BR
import com.example.sumit.doubtnutassignment.R
import com.example.sumit.doubtnutassignment.databinding.NewsListItemBinding
import com.example.sumit.doubtnutassignment.model.NewsInfo






class NewsListAdapter(var context: Context) : RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {
      var list: List<NewsInfo> = emptyList<NewsInfo>()
    lateinit var onCardClickListner1: OnCardClickListner
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val binding: NewsListItemBinding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.news_list_item, parent, false)
        return NewsListAdapter.ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Log.d("ADapter","Info:::"+list.get(position))
        holder.bind(list.get(position))

        holder.itemView.setOnClickListener(View.OnClickListener { v -> onCardClickListner1.OnCardClicked(v, position) })
    }

    fun setAdapterList(list: List<NewsInfo> ){
        this.list = list
        notifyDataSetChanged()
    }
    override fun getItemCount(): Int = list.size

    class ViewHolder(val binding: NewsListItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(data: Any) {
            binding.setVariable(BR.model, data) //BR - generated class; BR.user - 'user' is variable name declared in layout
            binding.executePendingBindings()
        }
    }

    interface OnCardClickListner {
        fun OnCardClicked(view: View, position: Int)
    }

    fun setOnCardClickListner(onCardClickListner: OnCardClickListner) {
        this.onCardClickListner1 = onCardClickListner
    }
}
