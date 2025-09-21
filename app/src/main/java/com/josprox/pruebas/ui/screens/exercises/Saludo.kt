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
import androidx.compose.ui.unit.dp
import com.josprox.pruebas.R

@Composable
fun Saludo(modifier: Modifier = Modifier) {
    var input by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = input,
            onValueChange = { input = it },
            label = { Text(stringResource(R.string.enterName)) },
            modifier = Modifier.padding(bottom = 8.dp)
        )

        Button(
            onClick = { name = input },
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text(stringResource(R.string.showGreeting))
        }

        if (name.isNotBlank()) {
            Text(text = "${stringResource(R.string.hello)} $name")
        }
    }
}
