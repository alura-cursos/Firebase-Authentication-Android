package br.com.alura.aluraesporte.ui.viewmodel

import androidx.lifecycle.ViewModel
import br.com.alura.aluraesporte.repository.FirebaseAuthRepository

class MinhaContaViewModel(private val repository: FirebaseAuthRepository) : ViewModel() {

    val email: String = "alex@aluraesporte.com"

}