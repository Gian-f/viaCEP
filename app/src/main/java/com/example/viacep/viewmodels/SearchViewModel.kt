package com.example.viacep.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.viacep.domain.usecase.GetAddressUseCase
import com.example.viacep.util.StateView
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class SearchViewModel@Inject constructor(
    private val getAddressUseCase: GetAddressUseCase
    ): ViewModel() {

        fun getAddress(cep: String) = liveData(Dispatchers.IO) {
            try {
                emit(StateView.Loading())

                val address = getAddressUseCase(cep)

                emit(StateView.Success(address))
            } catch (e: Exception) {
                e.printStackTrace()
                emit(StateView.Error(message = e.message))
            }
        }
}