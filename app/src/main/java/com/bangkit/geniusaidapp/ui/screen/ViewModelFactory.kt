package com.bangkit.geniusaidapp.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.bangkit.geniusaidapp.data.repository.GeniusRepository
import com.bangkit.geniusaidapp.ui.screen.cekbansos.CekBansosViewModel
import com.bangkit.geniusaidapp.ui.screen.cekbansos.HasilCekBansosViewModel
import com.bangkit.geniusaidapp.ui.screen.detailprofilebansos.DetailBansosViewModel
import com.bangkit.geniusaidapp.ui.screen.home.HomeViewModel
import com.bangkit.geniusaidapp.ui.screen.profile.ProfileViewModel

class ViewModelFactory(private val repository: GeniusRepository) : ViewModelProvider.NewInstanceFactory(){

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailBansosViewModel::class.java)) {
            return DetailBansosViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }


}