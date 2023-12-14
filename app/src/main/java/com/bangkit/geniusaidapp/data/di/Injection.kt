package com.bangkit.geniusaidapp.data.di

import android.content.Context
import com.bangkit.geniusaidapp.data.preference.UserPreferences
import com.bangkit.geniusaidapp.data.preference.dataStore
import com.bangkit.geniusaidapp.data.remote.api.ApiConfig
import com.bangkit.geniusaidapp.data.repository.GeniusRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.runBlocking

object Injection {
    fun provideRepository(context : Context): GeniusRepository = runBlocking {
        val pref = UserPreferences.getInstance(context.dataStore)
        val user = pref.getUserPref().first()
        val apiService = ApiConfig.getApiService(user.token.toString())
        GeniusRepository.getInstance(apiService,pref)
    }

}



