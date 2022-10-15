package com.amaurypm.fragments.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.amaurypm.fragments.R
import com.amaurypm.fragments.databinding.FragmentAnimesBinding
import com.amaurypm.fragments.databinding.FragmentGamesBinding
import com.amaurypm.fragments.model.Game
import com.amaurypm.fragments.view.adapters.GamesAdapter


class GamesFragment : Fragment() {

    private var _binding: FragmentGamesBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        _binding = FragmentGamesBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val games = ArrayList<Game>()

        for(i in 1..100){
            val gameTmp = Game(i.toLong(), "Juego $i", "Género $i", "Developer $i")
            games.add(gameTmp)
        }

        val adapter = GamesAdapter(requireActivity(), this, games)

        binding.rvGames.layoutManager = LinearLayoutManager(requireActivity())

        binding.rvGames.adapter = adapter



    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    fun selectedGame(game: Game) {
        Toast.makeText(requireActivity(), "Juego seleccionado: ${game.title}", Toast.LENGTH_LONG)
            .show()

        //Aquí se puede llamar a un intent, una conexión

        val bundle = Bundle()

        bundle.putString("dato1", "${game.title}")
        bundle.putString("nombre", "Amaury")
        bundle.putInt("sesion", 1234)

        parentFragmentManager.setFragmentResult("datos", bundle)

    }


}