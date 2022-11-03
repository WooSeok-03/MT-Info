package com.android.mtinfo

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.android.mtinfo.data.model.Information
import com.android.mtinfo.databinding.ActivityInformationBinding
import com.bumptech.glide.Glide

class InformationActivity : AppCompatActivity() {
    lateinit var binding: ActivityInformationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityInformationBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val information = intent.getSerializableExtra("info") as Information

        binding.tvTitle.text = information.title
        binding.tvDescription.text = information.overview
        val posterURL = BuildConfig.POSTER_URL + information.poster_path
        Glide.with(binding.ivPoster.context)
            .load(posterURL)
            .into(binding.ivPoster)

        binding.btLike.setOnClickListener {
            Toast.makeText(this, "Add to Interest!", Toast.LENGTH_SHORT).show()
        }
    }

}