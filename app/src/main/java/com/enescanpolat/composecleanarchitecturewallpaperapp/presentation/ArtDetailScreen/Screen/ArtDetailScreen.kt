package com.enescanpolat.composecleanarchitecturewallpaperapp.presentation.ArtDetailScreen.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.Center
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.enescanpolat.composecleanarchitecturewallpaperapp.presentation.ArtDetailScreen.ArtDetailViewModel

@Composable
fun ArtDetailScreen(

    artDetailViewModel: ArtDetailViewModel= hiltViewModel()
) {
    val state=artDetailViewModel.state.value


    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Center)
    {
        state.art?.let {
            Column(
                verticalArrangement =Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = rememberAsyncImagePainter(model = it.previewURL),
                    contentDescription =it.tags,
                    modifier = Modifier
                        .padding(16.dp)
                        .size(400.dp, 400.dp)
                        .clip(RectangleShape)
                        .align(CenterHorizontally)
                    )

                Text(
                        text = it.tags,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(16.dp),
                        color = Color.White
                )


                Text(
                        text = it.type,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(16.dp),
                        color = Color.White
                )

                Text(
                    text = it.likes.toString(),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(16.dp),
                    color = Color.White
                )
                Text(
                    text = it.downloads.toString(),
                    textAlign = TextAlign.Center,
                    modifier = Modifier.padding(16.dp),
                    color = Color.White
                )

            }
        }

        if (state.error.isNotBlank()){
            Text(
                text = state.error,
                color = MaterialTheme.colorScheme.error,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(14.dp)
                    .align(Center)
            )
        }
        if (state.isloading){
            CircularProgressIndicator(modifier = Modifier.align(Center))
        }

    }

}