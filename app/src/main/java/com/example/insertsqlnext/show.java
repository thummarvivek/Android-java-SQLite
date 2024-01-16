package com.example.insertsqlnext;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class show extends AppCompatActivity {
    ListView lv;
    ArrayList<User>arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        arrayList=new ArrayList<>();
        lv=findViewById(R.id.list);

        refresh();

    }
    public void refresh(){
        DBHelper dbHelper=new DBHelper(show.this);
        arrayList= (ArrayList<User>) dbHelper.show();
        Customadapter customadapter=new Customadapter(show.this,arrayList);
        lv.setAdapter(customadapter);
        registerForContextMenu(lv);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(0,0,0,"Update");
        menu.add(0,1,0,"delete");

    }

    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        AdapterView.AdapterContextMenuInfo acmi= (AdapterView.AdapterContextMenuInfo) item.getMenuInfo();
        int id=acmi.position;
        if(item.getItemId()==0)
        {
            Intent intent=new Intent(show.this,Update.class);
            intent.putExtra("id",arrayList.get(id).getId());
            intent.putExtra("name",arrayList.get(id).getName());
            intent.putExtra("address",arrayList.get(id).getAddress());
            startActivity(intent);


        }
        else if (item.getItemId()==1)
        {
            DBHelper dbHelper=new DBHelper(show.this);
            dbHelper.deletedata(arrayList.get(id).getId());
            refresh();


        }
        return super.onContextItemSelected(item);
    }
}