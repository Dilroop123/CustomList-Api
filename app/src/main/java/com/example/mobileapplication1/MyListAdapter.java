package com.example.mobileapplication1;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class
MyListAdapter extends ArrayAdapter<String> {

    private final Activity context;
    private final ArrayList name;
    private final ArrayList ownerLoginName;

    public MyListAdapter(Activity context, ArrayList name,ArrayList fullname) {
        super(context, R.layout.custom_list, name);

        this.context=context;
        this.name=name;
        this.ownerLoginName=fullname;
    }

    public View getView(int position,View view,ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View listview=inflater.inflate(R.layout.custom_list, null,true);

        TextView nameText = (TextView) listview.findViewById(R.id.name);
        TextView fullNameText = (TextView) listview.findViewById(R.id.fullName);
        //HERE NAME AND OWNER LOGIN NAME IS SET TO LIST VIEW
        nameText.setText(name.get(position).toString());
        fullNameText.setText(ownerLoginName.get(position).toString());

        return listview;

    };
}