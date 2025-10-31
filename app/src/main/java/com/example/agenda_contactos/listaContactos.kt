package com.example.agenda_contactos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.fragment.app.activityViewModels


class listaContactos : Fragment() {
    private lateinit var adapter: ContactoAdapter
    private val viewModel: ContactoViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_lista_contactos, container, false)
        val btn = root.findViewById<Button>(R.id.btnNuevoContacto)
        btn.setOnClickListener {
            findNavController().navigate(R.id.action_listaContactos_to_nuevoContactoFragment)
        }
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        adapter = ContactoAdapter(mutableListOf())
        val recyclerView = view.findViewById<RecyclerView>(R.id.rView)
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = adapter

       viewModel.contactos.observe(viewLifecycleOwner) { listaActualizada ->
            adapter.actualizarLista(listaActualizada)
        }
    }
}