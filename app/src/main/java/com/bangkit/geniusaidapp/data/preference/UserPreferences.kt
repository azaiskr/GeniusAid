package com.bangkit.geniusaidapp.data.preference

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.bangkit.geniusaidapp.data.remote.response.LoginResult
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore by preferencesDataStore(name = "loginSession")
class UserPreferences private constructor(private val dataStore: DataStore<Preferences>){

//    suspend fun saveUserPref(user: LoginResult){
//        dataStore.edit { preferences ->
//            preferences[NIK_KEY] = user.payload.toString()
//            preferences[TOKEN_KEY] = user.token.toString()
//        }
//    }


    suspend fun saveUser(user: UserModel) {
        dataStore.edit { preferences ->
            preferences[TOKEN_KEY] = user.token
            preferences[NAME_KEY] = user.name
            preferences[NIK_KEY] = user.nik
            preferences[IS_LOGIN_KEY] = true
        }
    }


    fun getUser(): Flow<UserModel> {
        return dataStore.data.map { preferences ->
            UserModel(
                preferences[TOKEN_KEY].toString(),
                preferences[NAME_KEY].toString(),
                preferences[NIK_KEY].toString(),
                preferences[IS_LOGIN_KEY] ?: false
            )
        }
    }

    suspend fun logOut() {
        dataStore.edit { preferences ->
            preferences[TOKEN_KEY] = ""
            preferences[NAME_KEY] = ""
            preferences[NIK_KEY] = ""
            preferences[IS_LOGIN_KEY] = false
        }
    }




    fun getUserPref(): Flow<LoginResult>{
        return dataStore.data.map { preferences ->
            LoginResult(
                preferences[NIK_KEY] ?: "",
                preferences[TOKEN_KEY] ?: ""
            )
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

        private val NIK_KEY = stringPreferencesKey("nik")
        private val TOKEN_KEY = stringPreferencesKey("token")
        private val NAME_KEY = stringPreferencesKey("name")
        private val IS_LOGIN_KEY = booleanPreferencesKey("isLogin")

        fun getInstance(dataStore: DataStore<Preferences>): UserPreferences{
            return INSTANCE ?: synchronized(this){
                val _instance = UserPreferences(dataStore)
                INSTANCE = _instance
                _instance
            }
        }

    }
}