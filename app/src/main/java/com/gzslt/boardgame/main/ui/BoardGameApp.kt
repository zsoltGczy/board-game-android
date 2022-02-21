package com.gzslt.boardgame.main.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.gzslt.boardgame.R
import com.gzslt.boardgame.main.ui.boardgamelist.BoardGameListScreen

@Composable
fun BoardGameApp() {

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.app_name))
                }
            )
        }
    ) { innerPadding ->
        BoardGameListScreen(modifier = Modifier.padding(innerPadding))
    }
}

@Composable
@Preview
private fun BoardGameAppPreview() {
    BoardGameApp()
}
