package done.it.moview.movieAdapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.bumptech.glide.Glide
import done.it.moview.R
import done.it.moview.data.entities.MovieListItem
import done.it.moview.extentions.inflate
import done.it.moview.features.details.DetailsActivity
import kotlinx.android.synthetic.main.item_movie.view.image
import kotlinx.android.synthetic.main.item_movie.view.textDescription
import kotlinx.android.synthetic.main.item_movie.view.textRating
import kotlinx.android.synthetic.main.item_movie.view.textTitle
import kotlinx.android.synthetic.main.item_movie.view.textYear

class MovieVH(parent: ViewGroup) : RecyclerView.ViewHolder(parent.inflate(R.layout.item_movie)) {

    fun onBind(movie: MovieListItem) {

        Glide.with(itemView)
            .load("https://image.tmdb.org/t/p/w500${movie.poster_path}")
            .into(itemView.image)

        itemView.textTitle.text = movie.title
        itemView.textDescription.text = movie.overview
        itemView.textRating.text = "${movie.vote_average} (${movie.vote_count})"
        itemView.textYear.text = movie.release_date

        itemView.setOnClickListener { DetailsActivity.start(it.context, movie.id) }
    }
}