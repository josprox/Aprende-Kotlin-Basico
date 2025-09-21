package com.josprox.pruebas.ui.screens

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.josprox.pruebas.R
import com.josprox.pruebas.ui.navigation.AppRoute
import com.josprox.pruebas.ui.theme.AppTheme
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun AppPreview() {
    AppTheme {
        AppScaffold()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppScaffold() {
    var selectedScreen by remember { mutableStateOf<AppRoute>(AppRoute.Greeting) }
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val menuText = stringResource(R.string.menu)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet {
                Text(
                    text = menuText,
                    modifier = Modifier.padding(16.dp),
                    style = MaterialTheme.typography.titleMedium
                )

                // Recorremos dinámicamente todas las rutas
                AppRoute.allRoutes.forEach { screen ->
                    NavigationDrawerItem(
                        label = { Text(screen.title()) },
                        selected = selectedScreen == screen,
                        onClick = {
                            selectedScreen = screen
                            scope.launch { drawerState.close() }
                        }
                    )
                }
            }
        }
    ) {
        Scaffold(
            // Menú de hamburguesa
            topBar = {
                TopAppBar(
                    title = { Text(selectedScreen.title()) }, // 🔹 lambda evaluada aquí
                    navigationIcon = {
                        IconButton(onClick = { scope.launch { drawerState.open() } }) {
                            Icon(Icons.Default.Menu, contentDescription = menuText)
                        }
                    }
                )
            }
        ) { innerPadding ->
            selectedScreen.content(Modifier.padding(innerPadding))
        }
    }
}
