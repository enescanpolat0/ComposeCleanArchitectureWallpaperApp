package com.enescanpolat.composecleanarchitecturewallpaperapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.enescanpolat.composecleanarchitecturewallpaperapp.presentation.ArtDetailScreen.Screen.ArtDetailScreen
import com.enescanpolat.composecleanarchitecturewallpaperapp.presentation.ArtListScreen.Screen.ArtListScreen
import com.enescanpolat.composecleanarchitecturewallpaperapp.presentation.ui.theme.ComposeCleanArchitectureWallpaperAppTheme
import com.enescanpolat.composecleanarchitecturewallpaperapp.util.Constants.IMAGEID
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCleanArchitectureWallpaperAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val navController = rememberNavController()
                    NavHost(navController = navController,
                        startDestination = Screen.ArtListScreen.route
                    ){
                        composable(route = Screen.ArtListScreen.route){
                            ArtListScreen(navController = navController)
                        }
                        composable(route = Screen.ArtDetailScreen.route+"/{${IMAGEID}}"){
                            ArtDetailScreen()
                        }

                    }


                }
            }
        }
    }
}

