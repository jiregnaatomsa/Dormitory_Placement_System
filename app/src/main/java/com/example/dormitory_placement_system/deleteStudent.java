package com.example.dormitory_placement_system;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class deleteStudent extends AppCompatActivity {
    EditText DeleteStudent;
    Button BD,BB;
    TextView succusess;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_student);

        DeleteStudent=findViewById(R.id.DeleteStudent);
        BD=findViewById(R.id.BD);
        BB=findViewById(R.id.BB);
        succusess=findViewById(R.id.succusess);


        BB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(deleteStudent.this,Admin.class);
                startActivity(intent);
            }
        });
        BD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (DeleteStudent.getText().toString().isEmpty()) {
                    Toast.makeText(deleteStudent.this, "Enter students user name", Toast.LENGTH_SHORT).show();
                    return;
                }
                String url = "http://10.160.22.90/AndroidProjectAmo/deletestd.php?User_name";

                StringRequest stringRequest = new StringRequest(Request.Method.POST,
                        url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(deleteStudent.this, response, Toast.LENGTH_LONG).show();
                        succusess.setText(response);
                    }
                }, error -> Toast.makeText(deleteStudent.this, "Error", Toast.LENGTH_LONG).show()) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("User_name", DeleteStudent.getText().toString());
                        return params;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(deleteStudent.this);
                requestQueue.add(stringRequest);
            }
        });
    }
}