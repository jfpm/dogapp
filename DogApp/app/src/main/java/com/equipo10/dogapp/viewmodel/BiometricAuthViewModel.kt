package com.equipo10.dogapp.viewmodel

import android.content.Intent
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import android.provider.Settings
import androidx.biometric.BiometricManager
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch
class BiometricAuthViewModel: ViewModel() {

    private val _biometricAuthState = MutableStateFlow<BiometricAuthState?>(null)
    val biometricAuthState: StateFlow<BiometricAuthState?> = _biometricAuthState

    sealed class BiometricAuthState {
        object Success : BiometricAuthState()
        object Error : BiometricAuthState()
        object NoHardware : BiometricAuthState()
        object HardwareUnavailable : BiometricAuthState()
        object NoneEnrolled : BiometricAuthState()
    }

    fun startBiometricAuthentication() {
        viewModelScope.launch {
            // Simulamos la autenticación biométrica exitosa después de un breve retraso
            kotlinx.coroutines.delay(2000)
            _biometricAuthState.value = BiometricAuthState.Success
        }
    }

    fun openBiometricSettings() {
        // Abre la configuración de biometría del dispositivo
        val intent = Intent(Settings.ACTION_BIOMETRIC_ENROLL).apply {
            putExtra(
                Settings.EXTRA_BIOMETRIC_AUTHENTICATORS_ALLOWED,
                BiometricManager.Authenticators.BIOMETRIC_STRONG or BiometricManager.Authenticators.DEVICE_CREDENTIAL
            )
        }
        // No necesitamos iniciar una actividad con un resultado aquí
    }

    fun sendErrorMessage(message: String) {
        _biometricAuthState.value = BiometricAuthState.Error
    }

    fun navigateToNextPage() {
        _biometricAuthState.value = BiometricAuthState.Success
    }
}