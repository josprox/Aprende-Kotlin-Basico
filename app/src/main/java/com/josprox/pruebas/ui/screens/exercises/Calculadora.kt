package com.josprox.pruebas.ui.screens.exercises

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.josprox.pruebas.R

@Preview(showBackground = true)
@Composable
fun Calculadora(modifier: Modifier = Modifier) {
    var num1 by remember { mutableStateOf("") }
    var num2 by remember { mutableStateOf("") }
    var result by remember { mutableStateOf<String?>(null) }

    // Carga strings aquí
    val numberLabel = stringResource(R.string.number)
    val errorMessage = stringResource(R.string.enterValidNumbers)
    val addAmountLabel = stringResource(R.string.addAmount)
    val resultLabel = stringResource(R.string.result)

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = num1,
            onValueChange = { num1 = it },
            label = { Text("$numberLabel 1") },
            modifier = Modifier.padding(bottom = 8.dp)
        )

        TextField(
            value = num2,
            onValueChange = { num2 = it },
            label = { Text("$numberLabel 2") },
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Button(
            onClick = {
                val n1 = num1.toDoubleOrNull()
                val n2 = num2.toDoubleOrNull()
                result = if (n1 != null && n2 != null) {
                    (n1 + n2).toString()
                } else {
                    "Error: $errorMessage"
                }
            },
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text(addAmountLabel)
        }

        result?.let {
            Text("$resultLabel: $it")
        }
    }
}

