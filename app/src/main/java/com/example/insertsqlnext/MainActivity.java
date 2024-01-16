package com.example.insertsqlnext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText txt1,txt2;
    Button btnsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txt1=findViewById(R.id.editTextTextPersonName);
        txt2=findViewById(R.id.editTextTextPersonName2);
        btnsave=findViewById(R.id.button);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=txt1.getText().toString();
                String address=txt2.getText().toString();
                User user=new User();
                user.setName(name);
                user.setAddress(address);
                DBHelper dbHelper=new DBHelper(MainActivity.this);
                dbHelper.dataInsert(user);
                Toast.makeText(MainActivity.this, "Data Saved", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(MainActivity.this,show.class);
                startActivity(intent);
            }
        });
    }
}