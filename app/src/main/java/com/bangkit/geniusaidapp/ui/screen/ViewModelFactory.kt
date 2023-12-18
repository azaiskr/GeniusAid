package com.bangkit.geniusaidapp.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bangkit.geniusaidapp.data.repository.GeniusRepository
import com.bangkit.geniusaidapp.ui.screen.hasilstatusbansos.HasilStatusBansosViewModel
import com.bangkit.geniusaidapp.ui.screen.detailprofilebansos.DetailBansosViewModel
import com.bangkit.geniusaidapp.ui.screen.home.HomeViewModel
import com.bangkit.geniusaidapp.ui.screen.login.LoginUserViewModel
import com.bangkit.geniusaidapp.ui.screen.profile.ProfileViewModel

class ViewModelFactory(private val repository: GeniusRepository) : ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailBansosViewModel::class.java)) {
            return DetailBansosViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(HasilStatusBansosViewModel::class.java)) {
            return HasilStatusBansosViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(ProfileViewModel::class.java)) {
            return ProfileViewModel(repository) as T
        }else if (modelClass.isAssignableFrom(LoginUserViewModel::class.java)) {
            return LoginUserViewModel(repository) as T
        }

//        if (modelClass.isAssignableFrom(LoginUserViewModel::class.java)) {
//            return LoginUserViewModel(repository) as T
//        }

        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }


}