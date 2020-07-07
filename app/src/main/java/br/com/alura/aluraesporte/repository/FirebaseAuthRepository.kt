package br.com.alura.aluraesporte.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

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

    fun cadastra(email: String, senha: String): LiveData<Boolean> {
        val liveData = MutableLiveData<Boolean>()
        val tarefa =
            firebaseAuth.createUserWithEmailAndPassword(email, senha)
        tarefa.addOnSuccessListener {
            Log.i(TAG, "cadastra: cadastro sucedido")
            liveData.value = true
        }
        tarefa.addOnFailureListener {
            Log.e(TAG, "cadastra: cadastro falhou", it)
            liveData.value = false
        }
        return liveData
    }

}