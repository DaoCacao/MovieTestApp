package done.it.moview.movieAdapter

import android.support.v7.widget.RecyclerView.Adapter
import android.view.ViewGroup
import done.it.moview.data.entities.MovieListItem

class MovieAdapter : Adapter<MovieVH>() {

    var movies = emptyList<MovieListItem>()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): MovieVH = MovieVH(parent)
    override fun getItemCount(): Int = movies.size
    override fun onBindViewHolder(holder: MovieVH, pos: Int) = holder.onBind(movies[pos])
}