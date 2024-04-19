package com.example.mobile_bvt2002_mitrofanov.ui.screens.modes.audition.models

sealed class AuditionEvent {
    object checkClicked : AuditionEvent()
    object microphoneClicked : AuditionEvent()
}