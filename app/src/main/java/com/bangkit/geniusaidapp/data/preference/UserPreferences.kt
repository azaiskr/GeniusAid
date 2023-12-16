package com.bangkit.geniusaidapp.data.preference

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.bangkit.geniusaidapp.data.remote.response.LoginResult
import com.bangkit.geniusaidapp.data.remote.response.Payload
import com.google.gson.Gson
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "loginSession")
class UserPreferences private constructor(private val dataStore: DataStore<Preferences>){



    private val gson = Gson()
    suspend fun saveUser(user: LoginResult) {
        val payloadJson = gson.toJson(user.payload)
        dataStore.edit { preferences ->
            preferences[PAYLOAD_KEY] = payloadJson
            preferences[TOKEN_KEY] = user.token.orEmpty()
        }
    }


    fun getUser(): Flow<LoginResult> {
        return dataStore.data.map { preferences ->
            val payloadJson = preferences[PAYLOAD_KEY] ?: ""
            val payload = if (payloadJson.isNotBlank()) {
                gson.fromJson(payloadJson, Payload::class.java)
            } else {
                null
            }
            val token = preferences[TOKEN_KEY] ?: ""

            LoginResult(payload, token)
        }
    }


    fun getUserPref(): Flow<LoginResult> {
        return dataStore.data.map { preferences ->
            val payloadJson = preferences[PAYLOAD_KEY] ?: ""
            val payload = gson.fromJson(payloadJson, Payload::class.java)
            val token = preferences[TOKEN_KEY] ?: ""

            LoginResult(payload, token)
        }
    }



    suspend fun logOut() {
        dataStore.edit { preferences ->
            preferences.remove(PAYLOAD_KEY)
            preferences.remove(TOKEN_KEY)
        }
    }


    suspend fun clearUserPref(){
        dataStore.edit { preferences ->
            preferences.clear()
        }
    }

    companion object{
        @Volatile
        private var INSTANCE: UserPreferences? = null

        private val PAYLOAD_KEY = stringPreferencesKey("payload")
        private val TOKEN_KEY = stringPreferencesKey("token")


        fun getInstance(dataStore: DataStore<Preferences>): UserPreferences{
            return INSTANCE ?: synchronized(this){
                val _instance = UserPreferences(dataStore)
                INSTANCE = _instance
                _instance
            }
        }

    }
}