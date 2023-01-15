package com.example.realtimechapapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.FirebaseAuth;

public class SignInActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    EditText emailText;
    EditText passwordText;
    Button submitButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mAuth=FirebaseAuth.getInstance();
        emailText=(EditText)findViewById(R.id.signinEmail);
        passwordText=(EditText)findViewById(R.id.signinPassword);
        submitButton=(Button)findViewById(R.id.signinSubmit);
        findViewById(R.id.uyeolButton).setOnClickListener(view ->
                startActivity(new Intent(SignInActivity.this,SignUpActivity.class)));

        submitButton.setOnClickListener(view ->
        {

            String password=passwordText.getText().toString();
            String email=emailText.getText().toString();
            if (email.isEmpty())
            {
                Toast.makeText(getApplicationContext(),"Email Boş Bırakılamaz",Toast.LENGTH_SHORT).show();
                return;
            }
            if (password.isEmpty())
            {
                Toast.makeText(getApplicationContext(),"Şifre Alanı Boş Bırakılamaz",Toast.LENGTH_SHORT).show();
                return;
            }
            mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(SignInActivity.this,task ->
            {
                if(task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(),"Başarılı Giriş",Toast.LENGTH_SHORT).show();
                     startActivity(new Intent(SignInActivity.this,MainActivity.class));
                }
                else {
                    Toast.makeText(getApplicationContext(),"Başarısız Giriş",Toast.LENGTH_SHORT).show();

                }
            });
        });
    }
}