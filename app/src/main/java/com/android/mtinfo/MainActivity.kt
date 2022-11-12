package com.android.mtinfo

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.RelativeLayout
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import androidx.viewpager2.widget.ViewPager2
import com.android.mtinfo.databinding.ActivityMainBinding
import com.android.mtinfo.presentation.adapter.InterestAdapter
import com.android.mtinfo.presentation.adapter.MovieAdapter
import com.android.mtinfo.presentation.adapter.TvShowAdapter
import com.android.mtinfo.presentation.viewmodel.MainActivityViewModel
import com.android.mtinfo.presentation.viewmodel.MainActivityViewModelFactory
import com.android.mtinfo.presentation.viewmodel.interest.InterestViewModel
import com.android.mtinfo.presentation.viewmodel.interest.InterestViewModelFactory
import com.android.mtinfo.presentation.viewmodel.movie.MovieViewModel
import com.android.mtinfo.presentation.viewmodel.movie.MovieViewModelFactory
import com.android.mtinfo.presentation.viewmodel.tvshow.TvShowViewModel
import com.android.mtinfo.presentation.viewmodel.tvshow.TvShowViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainFactory: MainActivityViewModelFactory
    lateinit var mainActivityViewModel: MainActivityViewModel


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setBottomNavigation()

        mainActivityViewModel = ViewModelProvider(this, mainFactory).get(MainActivityViewModel::class.java)
    }

    private fun setBottomNavigation() {
        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bnvMenu.setupWithNavController(navController)
    }
}