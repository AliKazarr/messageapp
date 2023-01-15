package com.example.realtimechapapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

public class SignUpActivity extends AppCompatActivity {

    private FirebaseAuth mAuth;
    EditText emailText;
    EditText passwordText;
    Button submitButton;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();
        emailText = (EditText) findViewById(R.id.signupEmail);
        passwordText = (EditText) findViewById(R.id.signupPassword);
        submitButton = (Button) findViewById(R.id.signupSubmit);

        findViewById(R.id.girisyapButton).setOnClickListener(view ->
                startActivity (new Intent(SignUpActivity.this, SignInActivity.class)));

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = emailText.getText().toString();
                String password = passwordText.getText().toString();
                if (email.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Email Boş Bırakılamaz", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (password.isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Şifre Alanı Boş Bırakılamaz", Toast.LENGTH_SHORT).show();
                    passwordText.setError("Şifre alanı boş bırakılamaz");
                    return;
                }
                mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(SignUpActivity.this, task ->
                {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "Kayıt Başarıyla Oluşturuldu", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(SignUpActivity.this, SignInActivity.class));
                    } else {
                        Toast.makeText(getApplicationContext(), "Kayıt Oluşturulamadı", Toast.LENGTH_SHORT).show();

                    }
                });
            }
            });
    }
}
