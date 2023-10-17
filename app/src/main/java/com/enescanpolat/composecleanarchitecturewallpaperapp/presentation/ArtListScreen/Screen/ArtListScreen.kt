package com.enescanpolat.composecleanarchitecturewallpaperapp.presentation.ArtListScreen.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.enescanpolat.composecleanarchitecturewallpaperapp.Screen
import com.enescanpolat.composecleanarchitecturewallpaperapp.presentation.ArtListScreen.ArtListViewModel
import com.enescanpolat.composecleanarchitecturewallpaperapp.presentation.ArtListScreen.ArtsEvent

@Composable
fun ArtListScreen(
    navController: NavController,
    artListviewModel:ArtListViewModel = hiltViewModel()
) {
    val state=artListviewModel.state.value

    Box(modifier = Modifier
        .fillMaxSize()
        .background(Color.Black)){
        Column {

            ArtSearchBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(20.dp),
                hint = "Red",
                onSearch = {
                    artListviewModel.onEvent(ArtsEvent.search(it))
                }
            )
            LazyColumn(modifier = Modifier.fillMaxSize()){
                items(state.arts){art->
                    ArtListRow(art = art, onItemClick = {
                        navController.navigate(Screen.ArtDetailScreen.route+"/${art.id}")
                    })
                }
            }

        }
    }

}