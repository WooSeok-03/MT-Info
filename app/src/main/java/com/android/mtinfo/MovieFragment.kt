package com.android.mtinfo

import android.content.Intent
import android.os.Bundle
import android.os.Parcel
import android.os.Parcelable
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.mtinfo.data.model.Information
import com.android.mtinfo.databinding.FragmentMovieBinding
import com.android.mtinfo.domain.InformationCategory
import com.android.mtinfo.presentation.adapter.MovieAdapter
import com.android.mtinfo.presentation.viewmodel.movie.MovieViewModel
import com.android.mtinfo.presentation.viewmodel.movie.MovieViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MovieFragment : Fragment() {
    @Inject
    lateinit var factory: MovieViewModelFactory
    lateinit var viewModel: MovieViewModel
    lateinit var movieAdapter: MovieAdapter
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
        viewModel = ViewModelProvider(this, factory).get(MovieViewModel::class.java)

        initRecyclerView()
        viewMovieList()
    }

    private fun initRecyclerView() {
        movieAdapter = MovieAdapter()

        movieAdapter.setOnItemClickListener {
            val intent = Intent(context, InformationActivity::class.java)
            val information = Information(
                id = it.id,
                title = it.title,
                overview = it.overview,
                poster_path = it.poster_path,
                category = InformationCategory.MOVIE
            )
            intent.putExtra("info", information)

            requireActivity().startActivity(intent)
        }

        binding.rvMovie.apply {
            adapter = movieAdapter
            layoutManager = LinearLayoutManager(requireContext())
         }
    }

    private fun viewMovieList() {
        binding.progressBar.visibility = View.VISIBLE

        val responseLiveData = viewModel.getMovies()
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