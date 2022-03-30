package com.onlineexam.newsapp.presenter.view.news

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.onlineexam.newsapp.R
import com.onlineexam.newsapp.data.model.Article
import com.onlineexam.newsapp.databinding.FragmentInFoFragmentsBinding

class InFoFragments : Fragment() {


    lateinit var binding:FragmentInFoFragmentsBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        // Inflate the layout for this fragment
        binding=DataBindingUtil.inflate(layoutInflater,R.layout.fragment_in_fo_fragments, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args : InFoFragmentsArgs by navArgs()
        val article=args.articleArgs

        binding.webView.apply {
            article.url?.let { loadUrl(it) }
        }



    }


}