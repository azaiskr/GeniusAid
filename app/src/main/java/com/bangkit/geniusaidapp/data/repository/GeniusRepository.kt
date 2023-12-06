package com.bangkit.geniusaidapp.data.repository

class GeniusRepository {



    companion object {
        @Volatile
        private var instance: GeniusRepository? = null
        fun getInstance(): GeniusRepository =
            instance ?: synchronized(this) {
                GeniusRepository().apply {
                    instance = this
                }
            }
    }
}