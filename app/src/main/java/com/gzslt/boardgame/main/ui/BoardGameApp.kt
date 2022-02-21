package com.gzslt.boardgame.main.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.gzslt.boardgame.R
import com.gzslt.boardgame.main.navigation.BoardGameListNavigationNames
import com.gzslt.boardgame.main.ui.boardgamelist.BoardGameListScreen

@Composable
fun BoardGameApp() {

    val navController = rememberNavController()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.app_name))
                }
            )
        }
    ) { innerPadding ->
        SampleMovieDbComposeNavHost(navController, Modifier.padding(innerPadding))
    }
}

@Composable
fun SampleMovieDbComposeNavHost(navController: NavHostController, modifier: Modifier = Modifier) {
    NavHost(
        navController = navController,
        startDestination = BoardGameListNavigationNames.BoardGameList.name,
        modifier = modifier,
    ) {
        composable(route = BoardGameListNavigationNames.BoardGameList.name) {
            BoardGameListScreen()
        }
    }
}

@Composable
@Preview
private fun BoardGameAppPreview() {
    BoardGameApp()
}
