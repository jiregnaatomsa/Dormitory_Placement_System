
package com.example.dormitory_placement_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class ShowStudentData extends AppCompatActivity {
    EditText PinNum;
    Button view,bkc;
    TextView fristname;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_student_data);
        fristname = findViewById(R.id.firstname);
        PinNum = findViewById(R.id.pinNumber);
        view = findViewById(R.id.view);
        bkc = findViewById(R.id.bck);
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        bkc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowStudentData.this, Login.class);
                startActivity(intent);
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (PinNum.getText().toString().isEmpty()) {
                    Toast.makeText(ShowStudentData.this, "enter your pin", Toast.LENGTH_SHORT).show();
                    return;
                }
                String url = "http://10.160.22.90/AndroidProjectAmo/ShowStudentData.php";
                StringRequest stringRequest = new StringRequest(Request.Method.POST,
                        url, response -> fristname.setText(response),
                        error -> Toast.makeText(ShowStudentData.this, "Error", Toast.LENGTH_SHORT).show()) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("id", PinNum.getText().toString());
                        return params;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(ShowStudentData.this);
                requestQueue.add(stringRequest);
            }
        });
    }
}