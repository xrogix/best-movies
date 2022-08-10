package com.igor.bestmovies.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.fragment.app.DialogFragment
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.igor.bestmovies.R
import com.igor.bestmovies.presentation.model.ShowPresentation
import com.igor.bestmovies.utils.ImageUrlBuilder

class DetailFragment : DialogFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail, container, false)
    }

    override fun getTheme(): Int {
        return R.style.FullScreenDialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<ImageButton>(R.id.close).setOnClickListener {
            dismiss()
        }

        arguments?.apply {
            getParcelable<ShowPresentation>(SHOW)?.run {
                view.findViewById<TextView>(R.id.tvName).text = name
                view.findViewById<TextView>(R.id.tvOriginalLanguage).text = originalLanguage
                view.findViewById<TextView>(R.id.tvOriginalName).text = originalName
                view.findViewById<TextView>(R.id.tvVoteCount).text = voteCount.toString()
                view.findViewById<TextView>(R.id.tvOverview).text = overview

                Glide.with(view)
                    .load(backdropPath?.let { ImageUrlBuilder.buildPosterUrl(it) })
                    .apply(RequestOptions().placeholder(R.drawable.image_placeholder))
                    .into(view.findViewById(R.id.imagePoster))
            }
        }
    }

    companion object {
        private const val SHOW = "show"

        fun newInstance(show: ShowPresentation): DetailFragment{
            val args = Bundle()
            args.putParcelable(SHOW, show)

            val fragment = DetailFragment()
            fragment.arguments = args
            return fragment
        }
    }
}