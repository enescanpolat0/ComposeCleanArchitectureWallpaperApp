package com.enescanpolat.composecleanarchitecturewallpaperapp.presentation.ArtListScreen.Screen

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import coil.compose.rememberImagePainter
import com.enescanpolat.composecleanarchitecturewallpaperapp.domain.model.imageResponse

@Composable
fun ArtListRow(
    art:imageResponse,
    onItemClick:(imageResponse)->Unit
) {
    
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onItemClick(art) }
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        
        Image(
            painter = rememberAsyncImagePainter(model = art.previewURL),
            contentDescription = art.tags,
            modifier = Modifier
                .padding(16.dp)
                .size(200.dp, 200.dp)
                .clip(RectangleShape)
            )
        Column(modifier = Modifier.align(CenterVertically), horizontalAlignment = Alignment.CenterHorizontally) {
            Text(art.tags,
                style = MaterialTheme.typography.bodyMedium,
                overflow = TextOverflow.Ellipsis,
                color = Color.White,
                textAlign = TextAlign.Center)
        }

    }
    
    

}