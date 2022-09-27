package com.android.mtinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.android.mtinfo.databinding.ActivityMainBinding
import com.android.mtinfo.presentation.adapter.MovieAdapter
import com.android.mtinfo.presentation.adapter.TvShowAdapter
import com.android.mtinfo.presentation.viewmodel.movie.MovieViewModel
import com.android.mtinfo.presentation.viewmodel.movie.MovieViewModelFactory
import com.android.mtinfo.presentation.viewmodel.tvshow.TvShowViewModel
import com.android.mtinfo.presentation.viewmodel.tvshow.TvShowViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    // Movie
    @Inject
    lateinit var movieFactory: MovieViewModelFactory
    @Inject
    lateinit var movieAdapter: MovieAdapter
    lateinit var movieViewModel: MovieViewModel

    // TvShow
    @Inject
    lateinit var tvShowFactory: TvShowViewModelFactory
    @Inject
    lateinit var tvShowAdapter: TvShowAdapter
    lateinit var tvShowViewModel: TvShowViewModel


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bnvMenu.setupWithNavController(navController)

        movieViewModel = ViewModelProvider(this, movieFactory).get(MovieViewModel::class.java)
        tvShowViewModel = ViewModelProvider(this, tvShowFactory).get(TvShowViewModel::class.java)
    }

}