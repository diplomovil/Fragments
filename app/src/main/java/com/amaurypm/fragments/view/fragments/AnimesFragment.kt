package com.amaurypm.fragments.view.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.FragmentResultListener
import com.amaurypm.fragments.databinding.FragmentAnimesBinding
import com.amaurypm.fragments.model.Anime
import com.amaurypm.fragments.view.adapters.AnimesAdapter


class AnimesFragment : Fragment() {

    private var _binding: FragmentAnimesBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_animes, container, false)

        _binding = FragmentAnimesBinding.inflate(inflater, container, false)

        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val datos = ArrayList<Anime>()

        for (i in 1..10) {
            val animeTmp = Anime(i.toLong(), "Anime $i", "Tipo $i", "Fecha $i")
            datos.add(animeTmp)
        }

        val adapter = AnimesAdapter(requireActivity(), datos)

        binding.lvAnimes.adapter = adapter

        binding.lvAnimes.setOnItemClickListener { parent, view, position, id ->
            Toast.makeText(
                requireActivity(),
                "El item seleccionado tiene el id: $id",
                Toast.LENGTH_LONG
            ).show()

        }

        parentFragmentManager.setFragmentResultListener(
            "datos",
            this,
            FragmentResultListener { requestKey, result ->
                val game = result.getString("dato1", "")
                val nombre = result.getString("nombre", "")
                val sesion = result.getInt("sesion", 0)

                if (game.isNotEmpty()) {
                    Toast.makeText(
                        requireActivity(),
                        "El juego recibido del fragment Games es: $game",
                        Toast.LENGTH_LONG
                    ).show()
                    Toast.makeText(
                        requireActivity(),
                        "El nombre recibido es $nombre y la sesión $sesion",
                        Toast.LENGTH_LONG
                    ).show()
                }
            })

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}