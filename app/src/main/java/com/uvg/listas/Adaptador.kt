package com.uvg.listas;

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_listas.view.*

class Adaptador(private val clickListener:(Int) -> Unit): RecyclerView.Adapter<Adaptador.ItemViewHolder>() {
    private var items: MutableList<String> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_listas,parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]
        holder.bind(item,clickListener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    fun setItems(nuevosItems:MutableList<String>){
        this.items = nuevosItems
        notifyDataSetChanged()
    }

    fun getItem(position: Int):String{
        return items[position]
    }
    //par eliminar los item que se seleccionaron
    fun removeItem(position: Int){
        this.items.removeAt(position)
    }

    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        fun bind(item:String, listener:(Int)->Unit) = with(itemView){
            txtTitulo.text=item

            setOnClickListener{ listener(adapterPosition) }
        }
    }
}