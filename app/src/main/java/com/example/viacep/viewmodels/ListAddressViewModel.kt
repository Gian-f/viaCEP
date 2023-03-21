package com.example.viacep.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.viacep.domain.model.Address
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ListAddressViewModel @Inject constructor(): ViewModel()  {

    private val _addresList = MutableLiveData<MutableList<Address>>()
    val currentAddressList: LiveData<MutableList<Address>> = _addresList

    fun insertAddress(address: Address) {
        val currentList = _addresList.value ?: mutableListOf()
        currentList.add(address)
        _addresList.value = currentList
    }
}