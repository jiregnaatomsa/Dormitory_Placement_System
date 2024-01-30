package com.example.dormitory_placement_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    EditText fullname, idnumber,username,password, email, college, amanuel;
    Button insert, show;
    RequestQueue requestQueue;
    String insertUrl = "http://172.31.0.1/AndroidProjectAmo/androidphpproject.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fullname= findViewById(R.id.name);
        idnumber=findViewById(R.id.id);
        username=findViewById(R.id.username);
        password= findViewById(R.id.password);
        email= findViewById(R.id.email);
        college= findViewById(R.id.college);
        amanuel=findViewById(R.id.PASS);
        insert=findViewById(R.id.button);
        show=findViewById(R.id.button1);

        requestQueue = Volley.newRequestQueue(getApplicationContext());
//        show.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(com.example.dormitory_placement_system.MainActivity.this, viewDataOfStudent.class);
//                startActivity(intent);
//
//            }
//        });
        insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest request = new StringRequest(Request.Method.POST, insertUrl, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(com.example.dormitory_placement_system.MainActivity.this, response,Toast.LENGTH_LONG ).show();
                        return;
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(com.example.dormitory_placement_system.MainActivity.this, error.getMessage(),Toast.LENGTH_LONG ).show();
                        return;
                    }
                }){
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> parameters = new HashMap<String, String>();
                        parameters.put("First_name", fullname.getText().toString());
                        parameters.put("Middle_name", idnumber.getText().toString());
                        parameters.put("Last_name", username.getText().toString());
                        parameters.put("Sex", password.getText().toString());
                        parameters.put("Id_number", email.getText().toString());
                        parameters.put("User_name", college.getText().toString());
                        parameters.put("Password", amanuel.getText().toString());
                        return parameters;
                    }
                };
                requestQueue.add(request);
            }
        });
    }
}