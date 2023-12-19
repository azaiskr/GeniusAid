package com.bangkit.geniusaidapp.ui.screen.question

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bangkit.geniusaidapp.data.remote.response.QuostionResponse
import com.bangkit.geniusaidapp.data.repository.GeniusRepository
import com.bangkit.geniusaidapp.model.ProfileBansosList
import com.bangkit.geniusaidapp.ui.screen.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class QuestionViewModel(private val repository: GeniusRepository) : ViewModel() {


    private val _result: MutableStateFlow<Result<ProfileBansosList>> =
        MutableStateFlow(Result.Loading)
    val result: StateFlow<Result<ProfileBansosList>>
        get() = _result

    suspend fun getBansosById(bansosId: Int): List<ProfileBansosList> {
        return repository.getPrfileBansosName(bansosId)
    }




    ////// halaman question
    private val _questionResponse = mutableStateOf<QuostionResponse?>(null)
    val questionResponse: State<QuostionResponse?> = _questionResponse

    fun getQuestions() {
        viewModelScope.launch {
            _questionResponse.value = repository.getQuestions()
        }
    }





}