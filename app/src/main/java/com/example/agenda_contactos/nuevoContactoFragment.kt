package com.example.agenda_contactos

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController



class nuevoContactoFragment : Fragment() {
    private val viewModel: ContactoViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_nuevo_contacto, container, false)

        val btnGuardar = root.findViewById<Button>(R.id.btnGuardarContacto)
        val etNombre = root.findViewById<EditText>(R.id.etNombreContacto)
        val etTelefono = root.findViewById<EditText>(R.id.etNumeroContacto)

        btnGuardar.setOnClickListener {
            val nombre = etNombre.text.toString()
            val telefono = etTelefono.text.toString()

            if (nombre.isEmpty() || telefono.isEmpty()) {
                Toast.makeText(requireContext(), "Debes ingresar datos en todos los campos", Toast.LENGTH_SHORT).show()
            } else {
                viewModel.agregarContacto(nombre, telefono)
                findNavController().popBackStack()
            }
        }
        return root
    }
}
