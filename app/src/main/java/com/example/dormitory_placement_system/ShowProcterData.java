
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

public class ShowProcterData extends AppCompatActivity {
    EditText Pn;
    Button vw, bk;
    TextView fn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_procter_data);
        fn = findViewById(R.id.fname);
        Pn = findViewById(R.id.pnNumber);
        vw = findViewById(R.id.vew);
        bk = findViewById(R.id.back);
        RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext());
        bk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShowProcterData.this, Login.class);
                startActivity(intent);
            }
        });
//      
//
//        bk.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                openLogin();
//            }
//        }.);
        vw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (Pn.getText().toString().isEmpty()) {
                    Toast.makeText(ShowProcterData.this, "Enter your Id", Toast.LENGTH_SHORT).show();
                    return;
                }
                String url = "http://10.160.22.90/AndroidProjectAmo/ShowProcterData.php";
                StringRequest stringRequest = new StringRequest(Request.Method.POST,
                        url, response -> fn.setText(response),
                        error -> Toast.makeText(ShowProcterData.this, "Error", Toast.LENGTH_SHORT).show()) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("id", Pn.getText().toString());
                        return params;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(ShowProcterData.this);
                requestQueue.add(stringRequest);
            }
        });
    }
}