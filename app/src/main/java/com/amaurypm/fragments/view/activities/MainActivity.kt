package com.amaurypm.fragments.view.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.fragment.app.FragmentTransaction
import com.amaurypm.fragments.R
import com.amaurypm.fragments.databinding.ActivityMainBinding
import com.amaurypm.fragments.view.fragments.AnimesFragment
import com.amaurypm.fragments.view.fragments.GamesFragment
import com.amaurypm.fragments.view.fragments.InitialFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private lateinit var animesFragment: AnimesFragment
    private lateinit var gamesFragment: GamesFragment
    private lateinit var initialFragment: InitialFragment
    private lateinit var transaction: FragmentTransaction

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        animesFragment = AnimesFragment()
        gamesFragment = GamesFragment()
        initialFragment = InitialFragment()

        supportFragmentManager.beginTransaction().add(R.id.flFragmentContainer, initialFragment).commit()

    }

    fun click(view: View) {

        val transaction = supportFragmentManager.beginTransaction()

        when(view.id){
            R.id.btnAnimes -> {
                transaction.replace(R.id.flFragmentContainer, animesFragment).commit()
                //transaction.addToBackStack(null)
            }
            R.id.btnGames -> {
                transaction.replace(R.id.flFragmentContainer, gamesFragment).commit()
                //transaction.addToBackStack(null)
            }
        }
    }
}