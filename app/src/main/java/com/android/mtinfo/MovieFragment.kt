package com.android.mtinfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
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
            val bundle = bundleOf(
                "key" to "movie",
                "title" to it.title,
                "poster" to it.poster_path,
                "overview" to it.overview
            )
            findNavController().navigate(
                R.id.action_movieFragment_to_informationFragment,
                bundle
            )
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
        val responseLiveData = movieViewModel.getMovies()
        responseLiveData.observe(viewLifecycleOwner) {
            movieAdapter.differ.submitList(it?.toList())
        }
    }
}