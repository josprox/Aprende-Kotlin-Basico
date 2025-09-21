package com.josprox.pruebas.ui.screens.exercises

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.*
import androidx.compose.material3.HorizontalDivider
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.josprox.pruebas.R
import com.josprox.pruebas.ui.viewmodel.FibonacciViewModel

@Preview(showBackground = true)
@Composable
fun PantallaFibonacci(
    modifier: Modifier = Modifier,
    viewModel: FibonacciViewModel = viewModel()
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // Entrada del usuario
        TextField(
            value = viewModel.cantidadTerminos,
            onValueChange = { viewModel.actualizarCantidadTerminos(it) },
            label = { R.string.enterNumberTerms },
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 16.dp)
        )

        // Botón para calcular la serie
        Button(
            onClick = { viewModel.calcularSerie() },
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text(stringResource(R.string.calculate))
        }

        // Mostrar resultados en tabla
        if (viewModel.serieFibonacci.isNotEmpty()) {
            Text(
                stringResource(R.string.fibonacciSequenceTable),
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 8.dp)
            )

            // Encabezado de la tabla
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 4.dp)
            ) {
                Text("n", modifier = Modifier.weight(1f))
                Text("F(n)", modifier = Modifier.weight(3f))
            }

            HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)

            LazyColumn(
                modifier = Modifier.fillMaxWidth()
            ) {
                itemsIndexed(viewModel.serieFibonacci) { index, numero ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 4.dp)
                    ) {
                        Text("$index", modifier = Modifier.weight(1f))
                        Text("$numero", modifier = Modifier.weight(3f))
                    }
                    HorizontalDivider(Modifier, DividerDefaults.Thickness, DividerDefaults.color)
                }
            }
        }
    }
}
