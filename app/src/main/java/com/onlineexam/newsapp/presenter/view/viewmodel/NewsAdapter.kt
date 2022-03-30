package com.onlineexam.newsapp.presenter.view.viewmodel

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.onlineexam.newsapp.R
import com.onlineexam.newsapp.data.model.Article
import com.onlineexam.newsapp.databinding.NewsListItemBinding

class NewsAdapter: RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {

    private val callback=object : DiffUtil.ItemCallback<Article>() {
        override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
           return oldItem.url==newItem.url
        }

        override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
            return oldItem == newItem
        }

    }

    val differ=AsyncListDiffer(this,callback)





    inner class MyViewHolder(private val itemBinding: NewsListItemBinding):RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(article: Article) {

            itemBinding.tvDescription.text=article.description
            itemBinding.tvTitle.text=article.title
            itemBinding.tvSource.text = article.source?.name
            Glide.with(itemBinding.ivArticleImage.context).load(article.urlToImage).into(itemBinding.ivArticleImage)

            itemBinding.root.setOnClickListener {
                itemClickListener?.let {
                    it(article)
                }
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       val layoutInflater=LayoutInflater.from(parent.context)
       val binding:NewsListItemBinding=DataBindingUtil.inflate(layoutInflater, R.layout.news_list_item,parent,false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(differ.currentList[position])

    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    private var itemClickListener: ((Article) -> Unit)? =null

    fun setOnclickItemListener(listener:(Article)->Unit){
        itemClickListener=listener
    }


}