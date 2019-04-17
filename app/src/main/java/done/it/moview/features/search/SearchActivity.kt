package done.it.moview.features.search

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import done.it.moview.R
import done.it.moview.base.BaseActivity
import done.it.moview.data.entities.MovieListItem
import done.it.moview.extentions.addTextWatcher
import done.it.moview.extentions.hideSoftKeyboard
import done.it.moview.movieAdapter.MovieAdapter
import kotlinx.android.synthetic.main.activity_search.editSearch
import kotlinx.android.synthetic.main.activity_search.imageBack
import kotlinx.android.synthetic.main.activity_search.imageClear
import kotlinx.android.synthetic.main.activity_search.progressLoading
import kotlinx.android.synthetic.main.activity_search.recyclerMovies
import kotlinx.android.synthetic.main.activity_search.textNoResults
import javax.inject.Inject

class SearchActivity : BaseActivity<Presenter>(), View {

    companion object {
        fun start(context: Context) = context.startActivity(Intent(context, SearchActivity::class.java))
    }

    @Inject lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        recyclerMovies.adapter = adapter

        editSearch.apply {
            addTextWatcher { presenter.onTextChanged(it) }
            setOnEditorActionListener { _, _, _ ->
                hideSoftKeyboard()
                true
            }
        }

        imageBack.setOnClickListener { onBackPressed() }
        imageClear.setOnClickListener { editSearch.setText("") }

        progressLoading.visibility = GONE
        textNoResults.visibility = GONE
        recyclerMovies.visibility = GONE
    }

    override fun showLoading() {
        progressLoading.visibility = VISIBLE
        textNoResults.visibility = GONE
        recyclerMovies.visibility = GONE
    }

    override fun showNoResults() {
        progressLoading.visibility = GONE
        textNoResults.visibility = VISIBLE
        recyclerMovies.visibility = GONE
    }

    override fun showResults(movies: List<MovieListItem>) {
        adapter.movies = movies

        progressLoading.visibility = GONE
        textNoResults.visibility = GONE
        recyclerMovies.visibility = VISIBLE
    }
}