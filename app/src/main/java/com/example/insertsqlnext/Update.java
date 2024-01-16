package com.example.insertsqlnext;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Update extends AppCompatActivity {
    EditText txt1,txt2;
    Button btnsave;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        txt1=findViewById(R.id.editTextTextPersonName);
        txt2=findViewById(R.id.editTextTextPersonName2);
        Intent intent=getIntent();
        int id=intent.getIntExtra("id",0);
        String name=intent.getStringExtra("name");
        String address=intent.getStringExtra("address");
        txt1.setText(name);
        txt2.setText(address);
        btnsave=findViewById(R.id.button);


        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name=txt1.getText().toString();
                String address=txt2.getText().toString();
                User user=new User();
                user.setId(id);
                user.setName(name);
                user.setAddress(address);
                DBHelper dbHelper=new DBHelper(Update.this);
                dbHelper.Updatedate(user);
                Toast.makeText(Update.this, "Data insereted", Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(Update.this,show.class);
                startActivity(intent);
            }
        });
    }
}