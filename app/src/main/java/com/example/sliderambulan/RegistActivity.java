package com.example.sliderambulan;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RegistActivity extends AppCompatActivity {
    private FirebaseAuth mAuth;
    private EditText etUsername, etPassword;
    Button btnLogin;
    Button btnRegister;
    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        mAuth = FirebaseAuth.getInstance();

        etUsername = findViewById(R.id.et_username);
        etPassword = findViewById(R.id.pw);
        //etEmail = findViewById(R.id.email);
        btnLogin = findViewById(R.id.btn_login);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goLogin = new Intent(RegistActivity.this, SlideLogActivity.class);
                startActivity(goLogin);
                finish();
            }
        });

        btnRegister = findViewById(R.id.btn_register);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String username = etUsername.getText().toString();
                String password = etPassword.getText().toString();


                if (username.equals("")) {
                    Toast.makeText(RegistActivity.this, "Silahkan isi username Anda.",
                            Toast.LENGTH_SHORT).show();
                } else if (password.equals("")) {
                    Toast.makeText(RegistActivity.this, "Silahkan isi password Anda.",
                            Toast.LENGTH_SHORT).show();
                /*} else if (email.equals("")) {
                    Toast.makeText(RegisterActivity.this, "Silahkan isi email Anda.",
                            Toast.LENGTH_SHORT).show();*/
                } else {

                    mAuth.createUserWithEmailAndPassword(username, password)
                            .addOnCompleteListener(RegistActivity.this, new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {
                                    if (task.isSuccessful()) {
                                        // Sign in success, update UI with the signed-in user's information

                                        FirebaseUser user = mAuth.getCurrentUser();

                                        Toast.makeText(RegistActivity.this, "Authentication success.",
                                                Toast.LENGTH_SHORT).show();


                                    } else {
                                        // If sign in fails, display a message to the user.

                                        Toast.makeText(RegistActivity.this, "Authentication failed.",
                                                Toast.LENGTH_SHORT).show();



                                    }

                                    // ...
                                }
                            });
                }
            }
        });
    }

    @Override

        public void onBackPressed(){
            Intent goLogin = new Intent(RegistActivity.this, SlideLogActivity.class);
            startActivity(goLogin);
            finish();
    }

        @Override
        public void onStart(){
        super.onStart();
        FirebaseUser currentUser = mAuth.getCurrentUser();
        }

}