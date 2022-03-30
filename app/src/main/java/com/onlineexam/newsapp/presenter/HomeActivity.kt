package com.onlineexam.newsapp.presenter

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.onlineexam.newsapp.R
import com.onlineexam.newsapp.databinding.ActivityMainBinding
import com.onlineexam.newsapp.presenter.view.viewmodel.LiveNewsViewModel
import com.onlineexam.newsapp.presenter.view.viewmodel.LiveNewsViewModelFactory
import com.onlineexam.newsapp.presenter.view.viewmodel.NewsAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory:LiveNewsViewModelFactory

    lateinit var viewModel:LiveNewsViewModel

    @Inject
    lateinit var newsAdapter: NewsAdapter


    private lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        supportActionBar?.hide()


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        val navController = navHostFragment.navController
//        val appBarConfiguration= AppBarConfiguration(setOf(R.id.newsFragment,R.id.savedNewsFragment))
//        setupActionBarWithNavController(navController,appBarConfiguration)
        binding.bottomNav.setupWithNavController(navController)
        viewModel= ViewModelProvider(this,viewModelFactory)[LiveNewsViewModel::class.java]

    }



}