package com.onlineexam.newsapp.presenter.view.news

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.SearchView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.onlineexam.newsapp.R
import com.onlineexam.newsapp.data.model.Article
import com.onlineexam.newsapp.data.util.Resource
import com.onlineexam.newsapp.databinding.LiveNewsFragmentBinding
import com.onlineexam.newsapp.presenter.HomeActivity
import com.onlineexam.newsapp.presenter.view.viewmodel.LiveNewsViewModel
import com.onlineexam.newsapp.presenter.view.viewmodel.NewsAdapter
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject
import kotlin.jvm.internal.PropertyReference0

class NewsFragment : Fragment() {

    var page=1
    var pages=0
    var isLastPage=false
    var isLoading=false
    var isScrolling=false
    private lateinit var binding:LiveNewsFragmentBinding
    lateinit var viewModel: LiveNewsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding=DataBindingUtil.inflate(layoutInflater,R.layout.live_news_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel=(activity as HomeActivity).viewModel
        val newsAdapter=(activity as HomeActivity).newsAdapter
        binding.recyclerView.layoutManager= LinearLayoutManager(requireContext())
        binding.recyclerView.adapter=newsAdapter
        binding.recyclerView.addOnScrollListener(this.onScrollListener)
        binding.viewModel=viewModel


        newsAdapter.setOnclickItemListener {
            val bundle=Bundle().apply {
                putSerializable("articleArgs",it)
            }
            findNavController().navigate(R.id.action_newsFragment_to_inFoFragments,bundle)
        }



        viewModel.getNewsHeadLines("us",1)
        viewModel.topHeadingData.observe(viewLifecycleOwner){
            isLoading=false
            if (it != null) {
                it.data?.let { it1->
                    newsAdapter.differ.submitList(it1.articles.toList())
                    pages = if (it1.totalResults % 20 ==0){
                        it1.totalResults /20
                    }else{
                        it1.totalResults /20 +1
                    }

                    isLastPage = page == pages

                }
            }
        }

       binding.searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener,
           androidx.appcompat.widget.SearchView.OnQueryTextListener {
           override fun onQueryTextSubmit(p0: String?): Boolean {
              viewModel.searchNews(p0!!)
               return false
           }

           override fun onQueryTextChange(p0: String?): Boolean {
               MainScope().launch {
                   delay(2000)
                   viewModel.searchNews(p0!!)
               }
               return false
           }

       })


    }


    private val onScrollListener=object:RecyclerView.OnScrollListener(){
        override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
            super.onScrollStateChanged(recyclerView, newState)
            if(newState == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                isScrolling = true
            }
        }

        override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
            super.onScrolled(recyclerView, dx, dy)
            val layoutManager=binding.recyclerView.layoutManager as LinearLayoutManager
            val sizeOfTheList=layoutManager.itemCount
            val visibleItems=layoutManager.childCount
            val topPosition=layoutManager.findFirstCompletelyVisibleItemPosition()

            val hasReachedEnd=topPosition+visibleItems>=sizeOfTheList
            val shouldPaginate= !isLoading && !isLastPage && isScrolling && hasReachedEnd

            if (shouldPaginate){
                page++
                viewModel.getNewsHeadLines("us",page)
                isScrolling=false
            }
        }
    }




}