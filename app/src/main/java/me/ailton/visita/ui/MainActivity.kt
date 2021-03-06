package me.ailton.visita.ui

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.observe
import me.ailton.visita.databinding.ActivityMainBinding
import me.ailton.visita.util.App



class MainActivity : AppCompatActivity() {

   private val binding by lazy {ActivityMainBinding.inflate(layoutInflater)}
    private  val  mainViewModel:MainViewModel by viewModels{
        MainViewModelFactory((application as App).repository)

    }

    private val adapter by lazy { BusinessAdapter() }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.rvCards.adapter = adapter
        getAllBusinessCard()
        insertListener()
    }

    private fun insertListener(){

        binding.fab.setOnClickListener{

            val intent = Intent(
                this@MainActivity,
                AddBusinessCardActivity::class.java
            )

            startActivity(intent)
        }
    }

    private fun getAllBusinessCard(){

        mainViewModel.getAll().observe( this ){ businessCard ->
            adapter.submitList(businessCard)

        }
    }


}

