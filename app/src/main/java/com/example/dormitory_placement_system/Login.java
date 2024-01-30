package com.example.dormitory_placement_system;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.android.material.textfield.TextInputEditText;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Login extends AppCompatActivity {
    TextInputEditText textInputEditTextUsername, textInputEditTextPassword;
    Button buttonLogin;
    TextView textViewSignUp;
    ProgressBar progressBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        textInputEditTextUsername = findViewById(R.id.username);
        textInputEditTextPassword = findViewById(R.id.password);
        buttonLogin = findViewById(R.id.buttonLogin);
        textViewSignUp = findViewById(R.id.signUpText);
        progressBar = findViewById(R.id.progress);

        buttonLogin.setOnClickListener(view -> {
            if (Objects.requireNonNull(textInputEditTextUsername.getText()).toString().isEmpty() && Objects.requireNonNull(textInputEditTextPassword.getText()).toString().isEmpty()) {
                Toast.makeText(Login.this, "enter your username and password", Toast.LENGTH_SHORT).show();
                return;
            }
            String url = "http://172.31.0.1/AndroidProjectAmo/login.php";
            StringRequest stringRequest = new StringRequest(Request.Method.POST,
                    url, response -> {
                        if (response.equals("admin")){
                            Intent intent=new Intent(getApplicationContext(), MainActivity.class);
                            //intent.putExtra("pinNumber",textInputEditTextUsername.getText().toString());
                            startActivity(intent);
                            finish();
                        }else{
                            Toast.makeText(Login.this, response, Toast.LENGTH_SHORT).show();
                        }
                    },
                    error -> Toast.makeText(Login.this, "Error", Toast.LENGTH_SHORT).show()) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<>();
                    params.put("username", textInputEditTextUsername.getText().toString());
                    params.put("password", Objects.requireNonNull(textInputEditTextPassword.getText()).toString());
                    return params;
                }
            };
            RequestQueue requestQueue = Volley.newRequestQueue(Login.this);
            requestQueue.add(stringRequest);
        });
    }
}
