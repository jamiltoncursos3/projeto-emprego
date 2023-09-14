package com.jamiltondamasceno.testeempregopetz.presentation.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.jamiltondamasceno.testeempregopetz.R
import com.jamiltondamasceno.testeempregopetz.data.model.Carta
import com.jamiltondamasceno.testeempregopetz.databinding.ActivityMainBinding
import com.jamiltondamasceno.testeempregopetz.presentation.CartaoAdapter
import com.jamiltondamasceno.testeempregopetz.presentation.viewmodels.CartoesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val cartoesViewModel: CartoesViewModel by viewModels()
    private val binding by lazy {
        ActivityMainBinding.inflate( layoutInflater )
    }
    private lateinit var cartaoAdapter: CartaoAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( binding.root )
        inicializarRecyclerView()
        inicializarObservables()

    }

    private fun inicializarRecyclerView() {

        cartaoAdapter = CartaoAdapter { carta ->
            val intent = Intent(applicationContext, DetalhesActivity::class.java)
            intent.putExtra("carta", carta)
            startActivity(intent)
        }
        binding.rvCartas.adapter = cartaoAdapter
        binding.rvCartas.layoutManager = GridLayoutManager(this, 3)

    }

    private fun inicializarObservables() {

        cartoesViewModel.listaCartas.observe(this){ listaCartas ->
            /*var lista = ""
            listaCartas.forEach { carta ->
                lista += " ${carta.cardId} \n"
            }
            Log.i("mensagem_api_cartas", lista )*/

            val listaCartasNova = mutableListOf<Carta>()
            listaCartas.forEach { carta ->
                if ( carta.img.isNotEmpty() || carta.img != null )
                    listaCartasNova.add(carta)
            }

            if( listaCartasNova.isNotEmpty() ){
                cartaoAdapter.atualizarLista( listaCartasNova )
            }

        }

    }

    override fun onStart() {
        super.onStart()
        cartoesViewModel.recuperarCartoes()
    }

}