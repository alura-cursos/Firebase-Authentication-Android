package br.com.alura.aluraesporte.ui.viewmodel

import androidx.lifecycle.ViewModel
import br.com.alura.aluraesporte.repository.FirebaseAuthRepository
import br.com.alura.aluraesporte.repository.LoginRepository

class LoginViewModel(
    private val repository: LoginRepository,
    private val firebaseAuthRepository: FirebaseAuthRepository
) : ViewModel() {

    fun loga() {
        repository.loga()
    }

    fun desloga() {
        firebaseAuthRepository.desloga()
    }

    fun estaLogado(): Boolean = firebaseAuthRepository.estaLogado()

    fun naoEstaLogado(): Boolean = !estaLogado()

}
