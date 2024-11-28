package com.interview.erakulis.presentation.register

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.interview.erakulis.databinding.ActivityRegisterBinding
import com.interview.erakulis.domain.User
import org.koin.androidx.viewmodel.ext.android.viewModel // Koin ViewModel injection

class RegisterActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding
    private val registerViewModel: RegisterViewModel by viewModel() // Koin ViewModel injection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Initialize the DataBinding
        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Bind the ViewModel to the UI via DataBinding
        binding.viewModel = registerViewModel
        binding.lifecycleOwner = this

        // Observe registration state changes (loading, success, error)
        registerViewModel.registerState.observe(this, Observer { state ->
            when (state) {
                is RegisterState.Loading -> {
                    showLoading(true)
                    showError(false)
                }
                is RegisterState.Success -> {
                    showLoading(false)
                    showError(false)
                    navigateToHome(state.user)
                }
                is RegisterState.Error -> {
                    showLoading(false)
                    showError(true, state.errorMessage)
                }
                else -> {}
            }
        })

        // Set up action for Register Button
        binding.registerButton.setOnClickListener {
            registerViewModel.register()
        }

        // Set up action for navigating to Login Activity
        binding.loginTextView.setOnClickListener {
            navigateToLogin()
        }
    }

    private fun navigateToHome(user: User) {
        // Handle navigation to Home Activity (or wherever you want to display the user's info)
        // Example:
        // startActivity(Intent(this, HomeActivity::class.java).putExtra("user", user))
        finish() // Finish RegisterActivity after successful registration
    }

    private fun navigateToLogin() {
        // Navigate to LoginActivity
        finish() // Close RegisterActivity and return to Login
    }

    private fun showLoading(isLoading: Boolean) {
        binding.loadingProgressBar.visibility = if (isLoading) View.VISIBLE else View.GONE
    }

    private fun showError(isError: Boolean, errorMessage: String? = null) {
        binding.errorTextView.visibility = if (isError) View.VISIBLE else View.GONE
        binding.errorTextView.text = errorMessage ?: ""
    }
}
