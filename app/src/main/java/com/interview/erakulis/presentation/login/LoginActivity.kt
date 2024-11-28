package com.interview.erakulis.presentation.login

import android.content.Intent
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.interview.erakulis.R
import com.interview.erakulis.databinding.ActivityLoginBinding
import com.interview.erakulis.presentation.home.HomeActivity
import com.interview.erakulis.presentation.register.RegisterActivity
import org.koin.androidx.viewmodel.ext.android.viewModel  // Koin ViewModel injection

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private val loginViewModel: LoginViewModel by viewModel()  // Koin ViewModel injection

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Bind ViewModel with DataBinding
        binding.viewModel = loginViewModel
        binding.lifecycleOwner = this

        // Observe the login state
        loginViewModel.loginState.observe(this) { state ->
            when (state) {
                is LoginState.Loading -> showLoading(true)
                is LoginState.Success -> navigateToHomePage()
                is LoginState.Error -> showError(state.message)
            }
        }

        // Set up listeners for input validation
        binding.emailEditText.addTextChangedListener(emailTextWatcher)
        binding.passwordEditText.addTextChangedListener(passwordTextWatcher)

        binding.loginButton.setOnClickListener {
            val email = binding.emailEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            loginViewModel.login()  // Call login with inputs
        }

        binding.registerTextView.setOnClickListener {
            // Navigate to the registration page
            val intent = Intent(this, RegisterActivity::class.java)
            startActivity(intent)
        }
    }

    private fun showLoading(isLoading: Boolean) {
        binding.loadingProgressBar.visibility = if (isLoading) android.view.View.VISIBLE else android.view.View.GONE
    }

    private fun showError(message: String) {
        binding.errorTextView.text = message
        binding.errorTextView.visibility = android.view.View.VISIBLE
    }

    private fun navigateToHomePage() {
        // Navigate to the HomeActivity after successful login
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)

        // Optionally, finish the LoginActivity to prevent the user from returning to it
        finish()
    }

    private val emailTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(charSequence: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable?) {
            binding.emailLayout.error = null
        }
    }

    private val passwordTextWatcher = object : TextWatcher {
        override fun beforeTextChanged(charSequence: CharSequence?, start: Int, count: Int, after: Int) {}
        override fun onTextChanged(charSequence: CharSequence?, start: Int, before: Int, count: Int) {}
        override fun afterTextChanged(s: Editable?) {
            binding.passwordLayout.error = null
        }
    }
}
