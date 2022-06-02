package com.igor.bestmovies.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.igor.bestmovies.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModels()

    private val mainAdapter by lazy {
        MainAdapter { id ->
            viewModel.getShow(id)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        configView()
        configViewModel()
    }

    private fun configViewModel() {
        viewModel.loadShows()

        viewModel.show.observe(this) {
            mainAdapter.setItems(it)
        }

        viewModel.detail.observe(this) {
            DetailFragment.newInstance(it).show(supportFragmentManager, "dialog_detail_show")
        }

        viewModel.error.observe(this) {
            Toast.makeText(baseContext, it, Toast.LENGTH_SHORT).show()
        }
    }

    private fun configView() {
        findViewById<RecyclerView>(R.id.rv_show_list).run {
            adapter = mainAdapter
        }
    }
}