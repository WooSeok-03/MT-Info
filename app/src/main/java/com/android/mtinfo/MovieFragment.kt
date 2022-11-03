package com.android.mtinfo

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.android.mtinfo.data.model.Information
import com.android.mtinfo.databinding.FragmentMovieBinding
import com.android.mtinfo.presentation.adapter.MovieAdapter
import com.android.mtinfo.presentation.viewmodel.movie.MovieViewModel

class MovieFragment : Fragment() {
    private lateinit var movieViewModel: MovieViewModel
    private lateinit var movieAdapter: MovieAdapter
    private lateinit var binding: FragmentMovieBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieBinding.bind(view)
        movieViewModel = (activity as MainActivity).movieViewModel
        movieAdapter = (activity as MainActivity).movieAdapter

        movieAdapter.setOnItemClickListener {
            val intent = Intent(context, InformationActivity::class.java)
            val information = Information(
                id = 1,
                title = it.title,
                overview = it.overview,
                poster_path = it.poster_path
            )
            intent.putExtra("info", information)

            (activity as MainActivity).startActivity(intent)
        }

        initRecyclerView()
        viewMovieList()
    }

    private fun initRecyclerView() {
        binding.rvMovie.apply {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(activity)
        }
    }

    private fun viewMovieList() {
        binding.progressBar.visibility = View.VISIBLE

        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(viewLifecycleOwner) {
            if (it != null) {
                movieAdapter.differ.submitList(it.toList())
                binding.progressBar.visibility = View.GONE
            } else {
                binding.progressBar.visibility = View.GONE
                Toast.makeText(context, "No data available", Toast.LENGTH_LONG).show()
            }
        }
    }
}