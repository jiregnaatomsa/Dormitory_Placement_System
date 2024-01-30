package com.example.dormitory_placement_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProcterPage extends AppCompatActivity {
    TextView t;
    Button vwyd,vwsd,bcks;
    ProgressBar prgo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_procter_page);

        t=findViewById(R.id.txtViw);
        vwyd=findViewById(R.id.vwyourdata);
        vwsd=findViewById(R.id.vwstddata);
        bcks=findViewById(R.id.bk);
        prgo=findViewById(R.id.prg);

        bcks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ProcterPage.this,Login.class);
                startActivity(intent);
            }
        });


    }
}