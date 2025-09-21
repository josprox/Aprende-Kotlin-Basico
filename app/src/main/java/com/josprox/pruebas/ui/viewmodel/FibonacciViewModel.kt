package com.josprox.pruebas.ui.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class FibonacciViewModel : ViewModel() {

    // Número de términos ingresado por el usuario
    var cantidadTerminos by mutableStateOf("")
        private set

    // Lista con los números de la serie
    var serieFibonacci by mutableStateOf<List<Long>>(emptyList())
        private set

    // Actualiza la cantidad de términos
    fun actualizarCantidadTerminos(entrada: String) {
        cantidadTerminos = entrada
    }

    // Función recursiva para calcular el n-ésimo término
    private fun fibonacci(n: Int): Long {
        return if (n <= 1) n.toLong() else fibonacci(n - 1) + fibonacci(n - 2)
    }

    // Genera la serie de Fibonacci
    fun calcularSerie() {
        val n = cantidadTerminos.toIntOrNull()
        if (n == null || n <= 0) {
            serieFibonacci = emptyList()
            return
        }

        // Generar n términos empezando en 0
        serieFibonacci = List(n) { index -> fibonacci(index) }
    }
}
