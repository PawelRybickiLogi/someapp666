package com.company.coreArchitecture

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

@Suppress("PropertyName")
open class BaseViewModel<UM : UiModel> : ViewModel() {

    private val _uiLiveData = MutableLiveData<UM>()
    val uiLiveData: LiveData<UM> get() = _uiLiveData

    @Suppress("UNCHECKED_CAST")
    protected var uiState: UM?
        get() = _uiLiveData.value
        set(value) = when (value) {
            null -> _uiLiveData.value = value
            else -> _uiLiveData.value = _uiLiveData.value?.update(value) as? UM ?: value
        }
}
