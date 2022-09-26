package com.android.mtinfo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavArgs
import androidx.navigation.fragment.navArgs
import com.android.mtinfo.data.model.movie.Movie
import com.android.mtinfo.databinding.FragmentInformationBinding
import com.android.mtinfo.databinding.FragmentMovieBinding
import com.android.mtinfo.presentation.viewmodel.MovieViewModel
import com.bumptech.glide.Glide

class InformationFragment : Fragment() {
    private lateinit var fragmentInformationBinding: FragmentInformationBinding
    private lateinit var movieViewModel: MovieViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_information, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentInformationBinding = FragmentInformationBinding.bind(view)

        val args: InformationFragmentArgs by navArgs()
        val movie = args.selectedMovie
        showMovieInfo(movie)
    }

    private fun showMovieInfo(movie: Movie) {
        movieViewModel = (activity as MainActivity).movieViewModel
        fragmentInformationBinding.tvTitle.text = movie.title
        fragmentInformationBinding.tvDescription.text = movie.overview

        val posterURL = BuildConfig.POSTER_URL + movie.poster_path
        Glide.with(fragmentInformationBinding.ivPoster.context)
            .load(posterURL)
            .into(fragmentInformationBinding.ivPoster)
    }
}