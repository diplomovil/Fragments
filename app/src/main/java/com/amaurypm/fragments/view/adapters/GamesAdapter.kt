package com.amaurypm.fragments.view.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.amaurypm.fragments.databinding.FragmentGamesBinding
import com.amaurypm.fragments.databinding.GamesElementBinding
import com.amaurypm.fragments.model.Game
import com.amaurypm.fragments.view.fragments.GamesFragment

/**
 * Creado por Amaury Perea Matsumura el 15/10/22
 */
class GamesAdapter(private val context: Context, private val fragment: Fragment, val games: ArrayList<Game>): RecyclerView.Adapter<GamesAdapter.ViewHolder>(){

    private val layoutInflater = LayoutInflater.from(context)

    class ViewHolder(view: GamesElementBinding): RecyclerView.ViewHolder(view.root){
        val tvTitle = view.tvTitle
        val tvGenre = view.tvGenre
        val tvDeveloper = view.tvDeveloper
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = GamesElementBinding.inflate(layoutInflater)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.tvTitle.text = games[position].title
        holder.tvGenre.text = games[position].genre
        holder.tvDeveloper.text = games[position].developer

        //Para los clicks de cada elemento viewholder

        holder.itemView.setOnClickListener {
            //Manejar el click
            if(fragment is GamesFragment) fragment.selectedGame(games[position])
        }

    }

    override fun getItemCount(): Int {
        return games.size
    }

}