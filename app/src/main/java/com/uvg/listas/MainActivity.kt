package com.uvg.listas

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*
import java.text.FieldPosition

class MainActivity : AppCompatActivity() {
    private val adaptador = Adaptador { clickListener ->
        showItemClick(clickListener)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        var num= 1
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*val items : MutableList<String> = mutableListOf()
        items.add("Prueba 1")
        items.add("Prueba 2")
        items.add("Prueba 3")*/

        //val adaptador = Adaptador(items)

        val items : MutableList<String> = mutableListOf()
        items.add("Prueba 1")
        items.add("Prueba 2")
        items.add("Prueba 3")

        adaptador.setItems(items)

        //al darle click al boton crear mas items
        btnInsertar.setOnClickListener{
            items.add("item $num")
            num++
            adaptador.setItems(items)
        }



        lista.layoutManager = LinearLayoutManager(this)
        lista.adapter = adaptador


    }
    fun showItemClick(position: Int){
        val item = adaptador.getItem(position)
        Toast.makeText(this,"$item eliminado",Toast.LENGTH_SHORT).show()
        adaptador.removeItem(position)
        lista.layoutManager = LinearLayoutManager(this)
        lista.adapter = adaptador

        


    }

}