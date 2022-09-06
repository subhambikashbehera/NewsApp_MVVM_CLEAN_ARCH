package com.onlineexam.newsapp.presenter

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
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
    lateinit var viewModelFactory: LiveNewsViewModelFactory

    lateinit var viewModel: LiveNewsViewModel

    @Inject
    lateinit var newsAdapter: NewsAdapter


    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        supportActionBar?.hide()


        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView2) as NavHostFragment
        val navController = navHostFragment.navController
        binding.bottomNav.setupWithNavController(navController)
        viewModel = ViewModelProvider(this, viewModelFactory)[LiveNewsViewModel::class.java]

 /*       binding.bottomNav.setOnNavigationItemSelectedListener { it ->
            when (it.itemId) {
                R.id.savedNewsFragment -> {
                    navController.navigate(R.id.savedNewsFragment)
                    true
                }
                R.id.newsFragment -> {


                    navController.navigate(R.id.newsFragment)
                    true
                }

                R.id.extraFragment -> {
                    Toast.makeText(this, "features not available", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                  false
                }
            }
        }

*/

        binding.bottomNav.setOnItemSelectedListener {
            if (NavigationUI.onNavDestinationSelected(it, navController)) {
                true
            } else {
                when (it.itemId) {
                    R.id.savedNewsFragment -> {
                        navController.navigate(R.id.savedNewsFragment)
                        true
                    }
                    R.id.newsFragment -> {
                        navController.navigate(R.id.newsFragment)
                        true
                    }

                    R.id.extraFragment -> {
                        Toast.makeText(this, "features not available", Toast.LENGTH_SHORT).show()
                        true
                    }
                    else -> {
                        false
                    }
                }
            }
        }


    }


}