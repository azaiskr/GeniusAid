package com.bangkit.geniusaidapp.ui.screen.profile

import android.text.BoringLayout
import androidx.lifecycle.ViewModel
import com.bangkit.geniusaidapp.data.repository.GeniusRepository

class ProfileViewModel(private val repository: GeniusRepository) : ViewModel() {

    suspend fun logout() {
        repository.logout()
    }

}