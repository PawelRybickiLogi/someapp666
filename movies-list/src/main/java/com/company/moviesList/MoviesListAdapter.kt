package com.company.moviesList

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.company.movies.networking.dto.Movie
import com.company.utils.extensions.onClick
import kotlinx.android.synthetic.main.item_list_movie.view.*

class MoviesListAdapter(
    val onMovieSelected: (Movie) -> Unit
) : RecyclerView.Adapter<MoviesListAdapter.ViewHolder>() {

    private var items = mutableListOf<Movie>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(
        LayoutInflater.from(parent.context).inflate(R.layout.item_list_movie, parent, false)
    )

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setTeams(teams: List<Movie>) {
        this.items = teams.toMutableList()
        notifyDataSetChanged()
    }

    inner class ViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        fun bind(item: Movie) {
            with(view) {
                onClick { onMovieSelected(item) }
                moviesListItemTitle.text = item.title
                movieListItemImg.load(item.image)
            }
        }
    }
}