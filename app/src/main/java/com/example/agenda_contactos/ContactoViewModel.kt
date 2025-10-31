package com.example.agenda_contactos

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


class ContactoViewModel : ViewModel() {
    private val _contactos = MutableLiveData<MutableList<Contacto>>()

    val contactos: LiveData<MutableList<Contacto>> = _contactos

    init {
        val listaInicial = mutableListOf<Contacto>()
        _contactos.value = listaInicial
    }

    fun agregarContacto(nombre: String, telefono: String) {
        val nuevoContacto = Contacto(nombre, telefono)

        val listaActual = _contactos.value ?: mutableListOf()

        listaActual.add(nuevoContacto)

        _contactos.value = listaActual
    }
}