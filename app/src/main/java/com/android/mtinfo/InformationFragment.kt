package com.android.mtinfo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.android.mtinfo.data.model.movie.Movie
import com.android.mtinfo.databinding.FragmentInformationBinding
import com.android.mtinfo.presentation.viewmodel.movie.MovieViewModel
import com.android.mtinfo.presentation.viewmodel.tvshow.TvShowViewModel
import com.bumptech.glide.Glide
import java.util.function.LongFunction

class InformationFragment : Fragment() {
    private lateinit var binding: FragmentInformationBinding
    private val args: InformationFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_information, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentInformationBinding.bind(view)

        showInfo()
        //findNavController().popBackStack()
    }

    private fun showInfo() {
        binding.tvTitle.text = args.title
        binding.tvDescription.text = args.overview

        val posterURL = BuildConfig.POSTER_URL + args.poster
        Glide.with(binding.ivPoster.context)
            .load(posterURL)
            .into(binding.ivPoster)
    }
}