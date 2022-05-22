package com.example.adapterlistview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    String [] contacts = {"Yash","Kalyani","Mayur"};
    ArrayAdapter<String> arrayAdapter;
    int menuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = findViewById(R.id.listView);
        arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1,contacts);
        listView.setAdapter(arrayAdapter);
        registerForContextMenu(listView);
    }

    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.context_menu,menu);
        menu.setHeaderTitle("Context Menu");
    }


    @Override
    public boolean onContextItemSelected(@NonNull MenuItem item) {
        menuItem = item.getItemId();
        switch (menuItem)
        {
            case R.id.call:
                makeToast("Call");
                break;
            case R.id.sms:
                makeToast("SMS");
                break;
            case R.id.whatsApp:
                makeToast("WhatsApp");
                break;
        }
        return super.onContextItemSelected(item);
    }

    private void makeToast(String text)
    {
        Toast.makeText(this,text,Toast.LENGTH_LONG).show();
    }



}