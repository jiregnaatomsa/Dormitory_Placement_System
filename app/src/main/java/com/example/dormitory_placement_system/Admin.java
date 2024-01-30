package com.example.dormitory_placement_system;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Admin extends AppCompatActivity {
    Button studentregister, procterregister, backs, delstd, delpro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);

        studentregister=findViewById(R.id.regstdBTN);
        procterregister=findViewById(R.id.regproBTN);
        backs=findViewById(R.id.backspace);
        delstd=findViewById(R.id.deletestd);
        delpro=findViewById(R.id.dltprocter);

        delpro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Admin.this,deleteprocter.class);
                startActivity(intent);
            }
        });
        backs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Admin.this,Login.class);
                startActivity(intent);
            }
        });
        delstd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(Admin.this,deleteStudent.class);
                startActivity(intent);
            }
        });

        studentregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openStudent();
            }
        });
        procterregister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openProcter();
            }
        });
    }
    public void openProcter(){
        Intent intent= new Intent(getApplicationContext(), procterregister.class);
        startActivity(intent);
    }
    public void openStudent(){
        Intent intent= new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}
