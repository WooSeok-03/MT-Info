package com.android.mtinfo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.android.mtinfo.databinding.ActivityMainBinding
import com.android.mtinfo.presentation.adapter.MovieAdapter
import com.android.mtinfo.presentation.viewmodel.MovieViewModel
import com.android.mtinfo.presentation.viewmodel.MovieViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var movieFactory: MovieViewModelFactory
    @Inject
    lateinit var movieAdapter: MovieAdapter

    lateinit var movieViewModel: MovieViewModel
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bnvMenu.setupWithNavController(navController)

        movieViewModel = ViewModelProvider(this, movieFactory).get(MovieViewModel::class.java)
    }
}