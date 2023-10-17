package com.enescanpolat.composecleanarchitecturewallpaperapp.presentation.ArtDetailScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enescanpolat.composecleanarchitecturewallpaperapp.domain.usecases.getArtDetailUseCase
import com.enescanpolat.composecleanarchitecturewallpaperapp.util.Constants.IMAGEID
import com.enescanpolat.composecleanarchitecturewallpaperapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
@HiltViewModel
class ArtDetailViewModel @Inject constructor(
    private val getArtDetailUseCase: getArtDetailUseCase,
    private val savedStateHandle: SavedStateHandle
):ViewModel() {


    private val _state = mutableStateOf<ArtDetailState>(ArtDetailState())
    val state: State<ArtDetailState> = _state

    init {
        savedStateHandle.get<String>(IMAGEID.toString())?.let {

            getArtDetail(it.toInt())
        }
    }




    private fun getArtDetail(imageId:Int){
        getArtDetailUseCase.executegetArtDetail(imageId).onEach {
            when(it){

                is Resource.Success->{
                    _state.value= ArtDetailState(art=it.data)
                }
                is Resource.Error->{
                    _state.value= ArtDetailState(error=it.message?:"Error")

                }
                is Resource.Loading->{

                    _state.value=ArtDetailState(isloading = true)

                }


            }
        }.launchIn(viewModelScope)
    }


}


