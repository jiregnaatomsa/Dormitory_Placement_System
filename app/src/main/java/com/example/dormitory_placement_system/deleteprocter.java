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

public class deleteprocter extends AppCompatActivity {
    EditText DeleteProcter;
    Button del,bac;
    TextView succusessf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deleteprocter);

        DeleteProcter=findViewById(R.id.Deletepro1);
        del=findViewById(R.id.delBTN);
        bac=findViewById(R.id.BBack);
        succusessf=findViewById(R.id.succusessfu);

        bac.setOnClickListener(new View.OnClickListener() {
       @Override
       public void onClick(View view) {
        Intent intent= new Intent(deleteprocter.this,Admin.class);
        startActivity(intent);
        return;
    }
});
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (DeleteProcter.getText().toString().isEmpty()) {
                    Toast.makeText(deleteprocter.this, "Enter procter password", Toast.LENGTH_SHORT).show();
                    return;
                }
                String url = "http://10.160.22.90/AndroidProjectAmo/deletepro.php";
                StringRequest stringRequest = new StringRequest(Request.Method.POST,
                        url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(deleteprocter.this, response, Toast.LENGTH_LONG).show();
                        succusessf.setText(response);
                    }
                }, error -> Toast.makeText(deleteprocter.this, "Error", Toast.LENGTH_LONG).show()) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> params = new HashMap<>();
                        params.put("User_name", DeleteProcter.getText().toString());
                        return params;
                    }
                };
                RequestQueue requestQueue = Volley.newRequestQueue(deleteprocter.this);
                requestQueue.add(stringRequest);
            }
        });
    }
}