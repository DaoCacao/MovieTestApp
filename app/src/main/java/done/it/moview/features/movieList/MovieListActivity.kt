package done.it.moview.features.movieList

import android.os.Bundle
import android.view.View.GONE
import done.it.moview.R
import done.it.moview.base.BaseActivity
import done.it.moview.data.entities.MovieListItem
import done.it.moview.features.search.SearchActivity
import done.it.moview.movieAdapter.MovieAdapter
import kotlinx.android.synthetic.main.activity_movie_list.progressLoading
import kotlinx.android.synthetic.main.activity_movie_list.recyclerMovies
import kotlinx.android.synthetic.main.activity_movie_list.toolbar
import javax.inject.Inject

class MovieListActivity : BaseActivity<Presenter>(), View {

    @Inject lateinit var adapter: MovieAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        recyclerMovies.adapter = adapter

        toolbar.apply {
            inflateMenu(R.menu.search)
            setOnMenuItemClickListener {
                presenter.onSearchClick()
                true
            }
        }
        presenter.onViewInit()
    }

    override fun showMovies(movies: List<MovieListItem>) {
        progressLoading.visibility = GONE
        adapter.movies = movies
    }

    override fun navigateToSearch() = SearchActivity.start(this)
}