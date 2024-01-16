package com.example.insertsqlnext;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class Customadapter extends BaseAdapter {

    Context context;
    ArrayList<User>arrayList;
    public Customadapter(Context context, ArrayList<User>arrayList){
        this.context=context;
        this.arrayList=arrayList;

    }
    @Override
    public int getCount() {
        return arrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater1= (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v=inflater1.inflate(R.layout.custom,null);
        TextView t1=v.findViewById(R.id.t1);
        TextView t2=v.findViewById(R.id.t2);
        TextView t3=v.findViewById(R.id.t3);
        t1.setText(arrayList.get(i).getId()+ " ");
        t2.setText(arrayList.get(i).getName());
        t3.setText(arrayList.get(i).getAddress());
        return v;
    }
}