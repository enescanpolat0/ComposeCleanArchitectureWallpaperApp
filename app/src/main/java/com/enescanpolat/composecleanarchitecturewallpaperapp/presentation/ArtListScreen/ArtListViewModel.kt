package com.enescanpolat.composecleanarchitecturewallpaperapp.presentation.ArtListScreen

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.enescanpolat.composecleanarchitecturewallpaperapp.domain.usecases.getArtsUseCase
import com.enescanpolat.composecleanarchitecturewallpaperapp.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject
@HiltViewModel
class ArtListViewModel @Inject constructor(
    private val getArtsUseCase: getArtsUseCase
    ):ViewModel() {


    private val _state= mutableStateOf<ArtsState>(ArtsState())
    val state: State<ArtsState> = _state

    private var job: Job? =null

    init {

        getArts(_state.value.search)

    }


    private fun getArts(search:String){
        job?.cancel()
        job = getArtsUseCase.executeGetArts(search).onEach {
            when(it){
                is Resource.Success->{
                    _state.value= ArtsState(arts = it.data?: emptyList())
                }
                is Resource.Error->{
                    _state.value=ArtsState(error = it.message?:"error")
                }
                is Resource.Loading->{
                    _state.value=ArtsState(isLoading = true)

                }
            }
        }.launchIn(viewModelScope)
    }

    fun onEvent(event: ArtsEvent){
        when(event){
            is ArtsEvent.search->{
                getArts(event.search)
            }
        }
    }

}