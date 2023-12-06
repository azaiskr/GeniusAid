package com.bangkit.geniusaidapp.data.di

import com.bangkit.geniusaidapp.data.repository.GeniusRepository

object Injection {
    fun provideRepository(): GeniusRepository {
        return GeniusRepository()
    }
}