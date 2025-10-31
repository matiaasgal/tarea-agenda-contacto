package com.example.agenda_contactos

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.addAll
import kotlin.text.clear

class ContactoAdapter(private var lista: MutableList<Contacto>) :
    RecyclerView.Adapter<ContactoAdapter.ContactoViewHolder>() {

    class ContactoViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val txtNombre: TextView = itemView.findViewById(R.id.txtNombreContacto)
        val txtTelefono: TextView = itemView.findViewById(R.id.txtNumeroContacto)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.view_contacto, parent, false)
        return ContactoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ContactoViewHolder, position: Int) {
        val contacto = lista[position]
        holder.txtNombre.text = contacto.nombre
        holder.txtTelefono.text = contacto.telefono
    }

    override fun getItemCount(): Int =lista.size

    fun actualizarLista(nuevaLista: MutableList<Contacto>) {
        lista.clear()
        lista.addAll(nuevaLista)
        notifyDataSetChanged()
    }
}