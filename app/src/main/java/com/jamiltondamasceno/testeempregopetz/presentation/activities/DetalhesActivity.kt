package com.jamiltondamasceno.testeempregopetz.presentation.activities

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.jamiltondamasceno.testeempregopetz.R
import com.jamiltondamasceno.testeempregopetz.data.model.Carta
import com.jamiltondamasceno.testeempregopetz.databinding.ActivityDetalhesBinding
import com.jamiltondamasceno.testeempregopetz.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetalhesActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityDetalhesBinding.inflate( layoutInflater )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( binding.root )
        recuperarDetalhesCarta()
    }

    private fun recuperarDetalhesCarta() {

        val bundle = intent.extras
        if( bundle != null ){

            val carta = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
                bundle.getParcelable("carta", Carta::class.java)
                //Log.i("detalhes_info", "${carta?.cardId}" )
            } else {
                bundle.getParcelable("carta")
            }

            if( carta != null ){

                with( binding ){

                    Picasso.get()
                        .load( carta?.img )
                        .error( R.drawable.carta )
                        .into( imageUrl )

                    textId.text = carta?.cardId ?: ""
                    textName.text = carta?.name ?: ""
                    textSet.text = carta?.cardSet ?: ""
                    textAttack.text = carta?.attack.toString() ?: ""
                    textRace.text = carta?.race ?: ""
                    textDescription.text = carta?.text ?: ""
                    textType.text = carta?.type ?: ""


                }

            }
        }


    }
}