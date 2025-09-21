package com.josprox.pruebas.ui.screens.exercises

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.android.gms.maps.model.CameraPosition
import com.google.android.gms.maps.model.LatLng
import com.google.maps.android.compose.GoogleMap
import com.google.maps.android.compose.Marker
import com.google.maps.android.compose.rememberCameraPositionState
import com.google.maps.android.compose.rememberUpdatedMarkerState

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun PantallaMaps(modifier: Modifier = Modifier) {
    val unitecEcatepec = LatLng(19.555993318230474, -99.01889424302716)

    val cameraPositionState = rememberCameraPositionState {
        position = CameraPosition.fromLatLngZoom(unitecEcatepec, 16f)
    }

    // Crea el estado del marcador usando rememberMarkerState
    val markerState = rememberUpdatedMarkerState(position = unitecEcatepec)

    GoogleMap(
        modifier = modifier
            .fillMaxSize(),

        cameraPositionState = cameraPositionState
    ) {
        Marker(
            state = markerState, // Usa el estado
        )
    }

}