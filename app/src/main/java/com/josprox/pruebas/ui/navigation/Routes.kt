package com.josprox.pruebas.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.josprox.pruebas.R
import com.josprox.pruebas.ui.screens.exercises.Calculadora
import com.josprox.pruebas.ui.screens.exercises.PantallaFibonacci
import com.josprox.pruebas.ui.screens.exercises.PantallaMaps
import com.josprox.pruebas.ui.screens.exercises.Saludo

sealed interface AppRoute {
    val route: String
    val title: @Composable () -> String
    val content: @Composable (Modifier) -> Unit

    // Implementaciones como objetos (singleton)
    object Greeting : AppRoute {
        override val route: String = "saludo"
        override val title: @Composable () -> String = { stringResource(R.string.welcomeGreeting) }
        // -> La lambda es @Composable y recibe el Modifier explícitamente
        override val content: @Composable (Modifier) -> Unit = { modifier ->
            Saludo(modifier)
        }
    }

    object Calculator : AppRoute {
        override val route: String = "calculadora"
        override val title: @Composable () -> String = { stringResource(R.string.SimpleCalculator) }
        override val content: @Composable (Modifier) -> Unit = { modifier ->
            Calculadora(modifier)
        }
    }

    object FibonacciRecursiva : AppRoute {
        override val route = "fibonacciRecursiva"
        override val content: @Composable (Modifier) -> Unit = { modifier ->
            PantallaFibonacci(modifier)
        }
        override val title: @Composable () -> String = { stringResource(R.string.fibonacciSeriesCalculator) }
    }

    object Maps : AppRoute {
        override val route = "maps"
        override val content: @Composable (Modifier) -> Unit = { PantallaMaps(it) }
        override val title: @Composable () -> String = { stringResource(R.string.googlemaps) }
    }


    companion object {
        // Lista centralizada que puedes recorrer sin mantenerla en varios sitios
        val allRoutes: List<AppRoute> = listOf(
            Greeting,
            Calculator,
            FibonacciRecursiva,
            Maps
        )
    }
}
