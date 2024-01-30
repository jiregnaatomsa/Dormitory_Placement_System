package com.example.dormitory_placement_system;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class procterregister extends AppCompatActivity {
    EditText Fnm, Mnm,Lnm,SX, IDn, Unm, pas, Blck, Rom;
    Button submit;
    RequestQueue requestQueue;
    String insertUrl = "http://10.160.22.90/AndroidProjectAmo/procterregister.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procterregister);

        Fnm= findViewById(R.id.fnm);
        Mnm=findViewById(R.id.mnm);
        Lnm=findViewById(R.id.lnm);
        SX= findViewById(R.id.sX);
        IDn= findViewById(R.id.iD);
        Unm= findViewById(R.id.unm);
        pas=findViewById(R.id.PAS);
        Blck=findViewById(R.id.blck);
        Rom=findViewById(R.id.rom);
        submit=findViewById(R.id.SubBTN);

        requestQueue = Volley.newRequestQueue(getApplicationContext());
//        show.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(com.example.dormitory_placement_system.MainActivity.this, viewDataOfStudent.class);
//                startActivity(intent);
//
//            }
//        });
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringRequest request = new StringRequest(Request.Method.POST, insertUrl, response ->
                    Toast.makeText(procterregister.this, response, Toast.LENGTH_LONG).show(),
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(procterregister.this, error.getMessage(), Toast.LENGTH_LONG).show();
                        return;
                    }
                }) {
                    @Override
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String, String> parameters = new HashMap<String, String>();
                        parameters.put("First_name", Fnm.getText().toString());
                        parameters.put("Middle_name", Mnm.getText().toString());
                        parameters.put("Last_name", Lnm.getText().toString());
                        parameters.put("Sex", SX.getText().toString());
                        parameters.put("Id_number", IDn.getText().toString());
                        parameters.put("User_name", Unm.getText().toString());
                        parameters.put("Password", pas.getText().toString());
                        parameters.put("Block", Blck.getText().toString());
                        parameters.put("Room", Rom.getText().toString());
                        return parameters;
                    }
                };
                requestQueue.add(request);
            }
        });
    }
}