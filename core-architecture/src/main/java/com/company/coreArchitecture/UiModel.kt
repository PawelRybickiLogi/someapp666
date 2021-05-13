package com.company.coreArchitecture

abstract class UiModel {
    abstract fun update(newModel: UiModel): UiModel
}
