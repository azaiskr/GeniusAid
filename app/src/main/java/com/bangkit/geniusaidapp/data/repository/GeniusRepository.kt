package com.bangkit.geniusaidapp.data.repository

import com.bangkit.geniusaidapp.data.remote.api.ApiService
import com.bangkit.geniusaidapp.model.ListProfilBansos
import com.bangkit.geniusaidapp.model.ProfileBansos
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf

class GeniusRepository {

//    private val apiService: ApiService,
//    private val userPreference: UserPreference,
//    private val database: DatabaseStory,

    private val listCrew = mutableListOf<ProfileBansos>()

    init {
        ListProfilBansos.profilBansos.forEach {
            listCrew.add(
                ProfileBansos(it.id, it.nameSigkat, it.name, it.description, it.photoUrl)
            )
        }
    }

    fun getAllProfilBansos(): Flow<List<ProfileBansos>> {
        return flowOf(listCrew)
    }

    fun getProfilBansosById(crewId: Long): ProfileBansos {
        return listCrew.first {
            it.id == crewId
        }
    }

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