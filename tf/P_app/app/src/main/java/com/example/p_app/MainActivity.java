package com.example.p_app;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.p_app.ui.login.LoginActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    String[] names = {"Renan Martins", "Gustavo Delazeri", "Neymar"};
    String[] pending = {"0", "0", "1"};
    String[] week = {"3", "2", "1"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.setTitle("Anderson Maciel");


        listView = findViewById(R.id.listView);

        ArrayList<Person> arrayList = new ArrayList<>();

        arrayList.add(new Person(R.drawable.image1, "Renan Martins", "Na semana: 3/4", "Pendências: 0"));
        arrayList.add(new Person(R.drawable.image2, "Gustavo Delazeri", "Na semana: 2/4", "Pendências: 0"));
        arrayList.add(new Person(R.drawable.image3, "Neymar", "Na semana: 1/4", "Pendências: 1"));


        PersonAdapter personAdapter = new PersonAdapter(this, R.layout.list_row, arrayList);

        listView.setAdapter(personAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> listView, View itemView, int itemPosition, long itemId)  {
                System.out.println(itemId);


                Intent myIntent = new Intent(MainActivity.this, ViewStudent.class);
                myIntent.putExtra("message", names[(int) itemId]);
                myIntent.putExtra("pending", pending[(int) itemId]);
                myIntent.putExtra("week", week[(int) itemId]);
                MainActivity.this.startActivity(myIntent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.menu_logout){
            Intent myIntent = new Intent(MainActivity.this, LoginActivity.class);
            MainActivity.this.startActivity(myIntent);
        }else {
            System.out.println("Not implemented.");
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}