package com.example.mobileapplication1;

import android.app.Activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MyListAdapter extends BaseAdapter {

    private final Activity context;
    ArrayList<Contact> contactArrayList;

    public MyListAdapter(Activity context, ArrayList<Contact> contactArrayList) {
           this.contactArrayList=contactArrayList;
        this.context=context;

    }


    @Override
    public int getCount() {
        return contactArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return contactArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View listview=inflater.inflate(R.layout.custom_list, null,true);

        TextView nameText = (TextView) listview.findViewById(R.id.name);
        TextView fullNameText = (TextView) listview.findViewById(R.id.fullName);
        //HERE NAME AND OWNER LOGIN NAME IS SET TO LIST VIEW
        nameText.setText(contactArrayList.get(position).getName());
        fullNameText.setText(contactArrayList.get(position).getOwnerLoginName());

        return listview;

    };
}