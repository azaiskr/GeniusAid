//package com.bangkit.geniusaidapp.ui.screen.home
//
//import androidx.compose.runtime.State
//import androidx.compose.runtime.getValue
//import androidx.compose.runtime.mutableStateOf
//import androidx.compose.runtime.setValue
//import androidx.lifecycle.ViewModel
//import androidx.lifecycle.viewModelScope
//import com.bangkit.geniusaidapp.data.remote.response.BansosResponse
//import com.bangkit.geniusaidapp.data.remote.response.PostSubmissionResponse
//import com.bangkit.geniusaidapp.data.remote.response.QuestionResponse
//import com.bangkit.geniusaidapp.data.remote.response.UserProfileResponse
//import com.bangkit.geniusaidapp.data.repository.GeniusRepository
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.launch
//import kotlinx.coroutines.withContext
//
//class CobaViewModel(private val repository: GeniusRepository) : ViewModel() {
//
//    var bansosResponse by mutableStateOf<BansosResponse?>(null)
//    var postSubmissionResponse by mutableStateOf<PostSubmissionResponse?>(null)
//    var questionResponse by mutableStateOf<QuestionResponse?>(null)
//    var isLoading by mutableStateOf(false)
//
//    fun getBansos() {
//        viewModelScope.launch {
//            isLoading = true
//            try {
//                withContext(Dispatchers.IO) {
//                    bansosResponse = repository.getBansos()
//                }
//            } catch (e: Exception) {
//                // Handle error
//            } finally {
//                isLoading = false
//            }
//        }
//    }
//
//    fun postSubmission(bansosId: Int) {
//        viewModelScope.launch {
//            isLoading = true
//            try {
//                withContext(Dispatchers.IO) {
//                    postSubmissionResponse = repository.postSubmission(bansosId)
//                }
//            } catch (e: Exception) {
//                // Handle error
//            } finally {
//                isLoading = false
//            }
//        }
//    }
//
//    fun getQuestioner() {
//        viewModelScope.launch {
//            isLoading = true
//            try {
//                withContext(Dispatchers.IO) {
//                    questionResponse = repository.getQuestioner()
//                }
//            } catch (e: Exception) {
//                // Handle error
//            } finally {
//                isLoading = false
//            }
//        }
//    }
//
//
//
//    private val _userProfile = mutableStateOf<UserProfileResponse?>(null)
//    val userProfile: State<UserProfileResponse?> = _userProfile
//
//    fun getUserProfile() {
//        viewModelScope.launch {
//            _userProfile.value = repository.getUserProfile()
//        }
//    }
//
//}