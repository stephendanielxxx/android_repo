package com.ideaco.projectdia.ui.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.ideaco.projectdia.R
import com.ideaco.projectdia.databinding.FragmentHomeBinding
import com.ideaco.projectdia.ui.adapter.PokemonAdapter
import com.ideaco.projectdia.ui.model.PokemonModel

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var adapter: PokemonAdapter
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvPokemon.layoutManager = LinearLayoutManager(requireActivity())

        val pokemonList = ArrayList<PokemonModel>()
        pokemonList.add(PokemonModel("Bulbasaur",
            R.drawable.pokemon1,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/001.png"))
        pokemonList.add(PokemonModel("Ivysaur",
            R.drawable.pokemon2,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/002.png"))
        pokemonList.add(PokemonModel("Venusaur",
            R.drawable.pokemon3,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/003.png"))
        pokemonList.add(PokemonModel("Bulbasaur",
            R.drawable.pokemon1,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/001.png"))
        pokemonList.add(PokemonModel("Ivysaur",
            R.drawable.pokemon2,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/002.png"))
        pokemonList.add(PokemonModel("Venusaur",
            R.drawable.pokemon3,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/003.png"))
        pokemonList.add(PokemonModel("Bulbasaur",
            R.drawable.pokemon1,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/001.png"))
        pokemonList.add(PokemonModel("Ivysaur",
            R.drawable.pokemon2,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/002.png"))
        pokemonList.add(PokemonModel("Venusaur",
            R.drawable.pokemon3,
            "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/003.png"))
        adapter = PokemonAdapter(pokemonList)

        binding.rvPokemon.adapter = adapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}