package com.gzslt.boardgame.main.ui.boardgamelist

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.SnackbarResult
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ErrorBody(message: String, onClick: () -> Unit) {
    val snackbarHostState = remember { SnackbarHostState() }
    val modifier = Modifier

    Box(
        modifier
            .fillMaxSize()
            .padding(8.dp)
    ) {
        LaunchedEffect(null) {
            val snackbarResult = snackbarHostState.showSnackbar(
                message = message,
                actionLabel = "Reload",
                duration = SnackbarDuration.Indefinite,
            )
            when (snackbarResult) {
                SnackbarResult.Dismissed -> {
                    // no- op
                }
                SnackbarResult.ActionPerformed -> onClick()
            }
        }
        SnackbarHost(
            hostState = snackbarHostState,
            modifier = Modifier.align(Alignment.BottomCenter),
        )
    }
}

@Preview
@Composable
private fun ErrorBodyPreview() {
    ErrorBody("Some error happened") {
        // no-op
    }
}
