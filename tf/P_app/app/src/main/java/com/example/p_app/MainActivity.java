package com.example.p_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


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

                //TextInputEditText textEdit = findViewById(R.id.text_field);

                //if (textEdit.getText() == null)
                 //   return;

                Intent myIntent = new Intent(MainActivity.this, ViewStudent.class);
                myIntent.putExtra("message", "hello");
                MainActivity.this.startActivity(myIntent);
            }
        });

    }
}