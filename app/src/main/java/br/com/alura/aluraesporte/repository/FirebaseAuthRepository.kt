package br.com.alura.aluraesporte.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.*
import java.lang.IllegalArgumentException

private const val TAG = "FirebaseAuthRepository"

class FirebaseAuthRepository(private val firebaseAuth: FirebaseAuth) {

    private fun desloga(firebaseAuth: FirebaseAuth) {
        firebaseAuth.signOut()
    }

    private fun verificaUsuario(firebaseAuth: FirebaseAuth) {
        val usuarioFirebase: FirebaseUser? = firebaseAuth.currentUser
        if (usuarioFirebase != null) {

        } else {
        }
    }

    private fun autenticaUsuario(firebaseAuth: FirebaseAuth) {
        firebaseAuth.signInWithEmailAndPassword("alex@aluraesporte.com", "teste123")
            .addOnSuccessListener {
            }.addOnFailureListener {
            }
    }

    fun cadastra(email: String, senha: String): LiveData<Resource<Boolean>> {
        val liveData = MutableLiveData<Resource<Boolean>>()
        try {
            val tarefa =
                firebaseAuth.createUserWithEmailAndPassword(email, senha)
            tarefa.addOnSuccessListener {
                Log.i(TAG, "cadastra: cadastro sucedido")
                liveData.value = Resource(true)
            }
            tarefa.addOnFailureListener {exception ->
                Log.e(TAG, "cadastra: cadastro falhou", exception)
                val mensagemErro: String = when(exception){
                    is FirebaseAuthWeakPasswordException -> "Senha precisa de pelo menos 6 dígitos"
                    is FirebaseAuthInvalidCredentialsException -> "E-mail inválido"
                    is FirebaseAuthUserCollisionException -> "E-mail já cadastrado"
                    else -> "Erro desconhecido"
                }
                liveData.value = Resource(false, mensagemErro)
            }
        } catch (e: IllegalArgumentException) {
            liveData.value = Resource(false, "E-mail ou senha não ser vazio")
        }
        return liveData
    }

}