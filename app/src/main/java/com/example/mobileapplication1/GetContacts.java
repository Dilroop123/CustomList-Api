package com.example.mobileapplication1;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;


class GetContacts extends AsyncTask<String,Integer,String> implements AdapterView.OnItemClickListener {
    Context con;
    ListView customList;
    Activity context;
    ProgressDialog loader;
    ArrayList nameList, OwnerfullNameList;

    public GetContacts(MainActivity mainActivity) {
        context=mainActivity;
        con=mainActivity;
        customList = (ListView) mainActivity.findViewById(R.id.lv1);
        customList.setOnItemClickListener(this);
    }

    @Override
    protected void onPreExecute() {
        //THIS WILL OPEN THE LOADER BEFORE THE LIST IS FETCHED
        loader = new ProgressDialog(con);
        loader.setTitle("Please Wait..");
        loader.setMessage("Loading..");
        loader.setCancelable(false);
        loader.show();
        super.onPreExecute();
    }






    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
        // THIS WILL TOAST THE NAME , WHEN ITEM IS CLICKED
        String name= String.valueOf(nameList.get(i));
        Toast.makeText(context, name, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPostExecute(String s) {
        //FIRST , LOADER IS MADE DISMISSED
        loader.dismiss();
        nameList = new ArrayList();
        OwnerfullNameList = new ArrayList();
        try {
            JSONArray contactListData = new JSONArray(s);
            //ITERATE THE LIST AND GET THE NAME AND LOGIN NAME
            for(int i =0; i<contactListData.length();i++)
            {
                JSONObject contacts = contactListData.getJSONObject(i);
                String name = contacts.getString("name");

                JSONObject ownerData = contacts.getJSONObject("owner");
                // GO DEEPER IN OWNER TO GET THE LOGIN NAME
                String OwnerLoginName = ownerData.getString("login");

                nameList.add(name);
                OwnerfullNameList.add(OwnerLoginName);
            }

            MyListAdapter adapter=new MyListAdapter(context, nameList, OwnerfullNameList);
            customList.setAdapter(adapter);

        } catch (JSONException e) {

            e.printStackTrace();

        }

        super.onPostExecute(s);
    }

    @Override
    protected String doInBackground(String... strings)
    {
        String s = strings[0];
        String download = "";

        DownLoadURL url = new DownLoadURL();
        try {
            download = url.downloadurl(s);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return download;
    }

}