package com.example.realtimechapapp;



import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;

public class SplashhActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splashh);



        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            startActivity(new Intent (SplashhActivity.this,MainActivity.class));
            return;
        }
        else {
            startActivity(new Intent(SplashhActivity.this,SignInActivity.class));

        }
        findViewById(R.id.girisyap).setOnClickListener(viewClickListener ->
                startActivity(new Intent(SplashhActivity.this, SignInActivity.class)));

        findViewById(R.id.kayitol).setOnClickListener(viewClickListener ->
                startActivity(new Intent(SplashhActivity.this, SignUpActivity.class)));
    }
}