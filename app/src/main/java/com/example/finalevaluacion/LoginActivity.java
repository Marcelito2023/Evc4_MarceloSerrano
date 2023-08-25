package com.example.finalevaluacion;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;

import com.example.finalevaluacion.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    private ActivityLoginBinding binding;

    private SharedPreferences sharedPreferences;
    public static String SESSION_PREFERENCE = "SESSION_PREFERENCE";

    public static String SESSION_ACTIVATED = "SESSION_ACTIVATED";

    private static final String VALID_EMAIL = "ejemploe@idat.com.pe";
    private static final String VALID_PASSWORD = "Peru123.";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        sharedPreferences = getSharedPreferences(SESSION_PREFERENCE, MODE_PRIVATE);

        boolean isSessionActivated = sharedPreferences.getBoolean(LoginActivity.SESSION_ACTIVATED, false);
        if (isSessionActivated) {
            Intent intent = new Intent(this, PrincipalActivity.class);
            startActivity(intent);
            finish();
        }

        binding.btnLogin.setEnabled(false); // Deshabilitar el botón al inicio

        binding.btnLogin.setOnClickListener(v -> {
            String email = binding.tilEmail.getEditText().getText().toString();
            String password = binding.password.getEditText().getText().toString();

            if (email.equals(VALID_EMAIL) && password.equals(VALID_PASSWORD)) {
                sharedPreferences.edit().putBoolean(SESSION_ACTIVATED, true).apply();
                Intent intent = new Intent(this, PrincipalActivity.class);
                startActivity(intent);
                finish();
            } else {
                // No se podrá iniciar sesión
            }
        });

        binding.tilEmail.getEditText().addTextChangedListener(textWatcher);
        binding.password.getEditText().addTextChangedListener(textWatcher);
    }

    private final TextWatcher textWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String email = binding.tilEmail.getEditText().getText().toString();
            String password = binding.password.getEditText().getText().toString();
            boolean isOK = email.equals(VALID_EMAIL) && password.equals(VALID_PASSWORD);
            binding.btnLogin.setEnabled(isOK);
        }

        @Override
        public void afterTextChanged(Editable s) {}
    };
}