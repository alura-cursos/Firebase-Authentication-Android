package br.com.alura.aluraesporte.ui.viewmodel

import androidx.lifecycle.ViewModel
import br.com.alura.aluraesporte.repository.FirebaseAuthRepository

class CadastroUsuarioViewModel(private val repository: FirebaseAuthRepository) : ViewModel(){

    fun cadastra(email: String, senha: String){
        repository.cadastra(email, senha)
    }

}