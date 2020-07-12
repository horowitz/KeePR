package com.dhorowitz.keepr

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.OAuthProvider
import com.google.firebase.auth.zze


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        authenticate()
    }

    private fun authenticate() {
        val firebaseAuth = FirebaseAuth.getInstance()
        val provider = OAuthProvider.newBuilder("github.com")
            .apply { scopes = listOf("user", "repo", "read:org") }

        val pendingResultTask: Task<AuthResult>? = firebaseAuth.pendingAuthResult
        if (pendingResultTask != null) {
            // There's something already here! Finish the sign-in for your user.
            pendingResultTask.addListeners(::handleSuccess, ::handleFailure)
        } else {
            firebaseAuth
                .startActivityForSignInWithProvider(this, provider.build())
                .addListeners(::handleSuccess, ::handleFailure)
        }

    }

    private fun handleSuccess(authResult: AuthResult) {
        Toast.makeText(this, (authResult.credential as zze).accessToken, Toast.LENGTH_LONG).show()
    }

    private fun handleFailure(exception: Exception) {
        Toast.makeText(this, exception.toString(), Toast.LENGTH_LONG).show()
    }
}

private fun Task<AuthResult>?.addListeners(
    success: (AuthResult) -> Unit,
    fail: (Exception) -> Unit
) {
    this?.addOnSuccessListener { success(it) }
    this?.addOnFailureListener { fail(it) }
}

