package done.it.moview.features.details

import android.content.Context
import android.content.Intent
import android.os.Bundle
import com.bumptech.glide.Glide
import done.it.moview.R
import done.it.moview.base.BaseActivity
import done.it.moview.data.entities.MovieDetailsItem
import kotlinx.android.synthetic.main.activity_details.image
import kotlinx.android.synthetic.main.activity_details.textDescription
import kotlinx.android.synthetic.main.activity_details.textGenres
import kotlinx.android.synthetic.main.activity_details.textHomepage
import kotlinx.android.synthetic.main.activity_details.textRating
import kotlinx.android.synthetic.main.activity_details.textTagline
import kotlinx.android.synthetic.main.activity_details.toolbar

class DetailsActivity : BaseActivity<Presenter>(), View {

    companion object {
        private const val MOVIE_ID = "movieID"

        fun start(context: Context, movieId: Int) =
            context.startActivity(Intent(context, DetailsActivity::class.java).apply { putExtra(MOVIE_ID, movieId) })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        toolbar.setNavigationOnClickListener { onBackPressed() }

        presenter.onViewInit(intent.getIntExtra(MOVIE_ID, -1))
    }

    override fun showDetails(details: MovieDetailsItem) {
        Glide.with(this)
            .load("https://image.tmdb.org/t/p/w500${details.poster_path}")
            .into(image)

        toolbar.title = details.title
        textTagline.text = details.tagline

        textGenres.text = details.genres.joinToString { it.name }
        textDescription.text = details.overview

        textHomepage.text = details.homepage
        textRating.text = "${details.vote_average} (${details.vote_count})"
    }
}