package com.jamiltondamasceno.testeempregopetz.presentation

import android.graphics.Bitmap
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView.Adapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.bumptech.glide.load.DecodeFormat
import com.jamiltondamasceno.testeempregopetz.R
import com.jamiltondamasceno.testeempregopetz.data.model.Carta
import com.jamiltondamasceno.testeempregopetz.databinding.ItemRvCartaBinding
import com.squareup.picasso.Picasso

class CartaoAdapter(
    private val onClick: (Carta) -> Unit
) : Adapter<CartaoAdapter.CartaoViewHolder>() {

    inner class CartaoViewHolder(
        private val binding: ItemRvCartaBinding
    ) : ViewHolder(binding.root){

        fun bind( carta: Carta ){

            with(binding){

                textNome.text = carta.name

                clItemCarta.setOnClickListener {
                    onClick( carta )
                }

                if( carta.img.isNotEmpty() ){
                    Picasso.get()
                        .load( carta.img )
                        .into( imageCarta )
                }

            }

        }

    }

    private var listaCartas = emptyList<Carta>()
    fun atualizarLista( lista: List<Carta> ){
        listaCartas = lista
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CartaoViewHolder {

        val inflater = LayoutInflater.from(parent.context)
        val itemView = ItemRvCartaBinding.inflate(
            inflater, parent, false
        )

        return CartaoViewHolder(itemView)

    }

    override fun onBindViewHolder(holder: CartaoViewHolder, position: Int) {
        val carta = listaCartas[position]
        holder.bind( carta )
    }

    override fun getItemCount(): Int {
        return listaCartas.size
    }

}