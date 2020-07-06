package br.com.alura.aluraesporte.repository

import android.util.Log
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

    fun cadastra(email: String, senha: String) {
        val tarefa =
            firebaseAuth.createUserWithEmailAndPassword(email, senha)
        tarefa.addOnSuccessListener {
            Log.i(TAG, "cadastra: cadastro sucedido")
        }
        tarefa.addOnFailureListener {
            Log.e(TAG, "cadastra: cadastro falhou", it)
        }
    }

}