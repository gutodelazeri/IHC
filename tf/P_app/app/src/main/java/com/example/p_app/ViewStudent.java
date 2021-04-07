package com.example.p_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewStudent extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        this.setTitle("Sergio Cechin/" + message);

        listView = this.findViewById(R.id.studentListView);

        ArrayList<Justificativa> arrayList = new ArrayList<>();

        arrayList.add(new Justificativa("2021 - Semana 37", "DD/MM - DD/MM", "Não Justificado", R.drawable.icon0));
        arrayList.add(new Justificativa("2021 - Semana 12", "DD/MM - DD/MM", "Justificado", R.drawable.icon1));
        arrayList.add(new Justificativa("2021 - Semana 08", "DD/MM - DD/MM", "Justificado", R.drawable.icon1));


        JustificativaAdapter justificativaAdapter = new JustificativaAdapter(this, R.layout.list_row_2, arrayList);

        listView.setAdapter(justificativaAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> listView, View itemView, int itemPosition, long itemId)  {
                System.out.println(itemId);

                //TextInputEditText textEdit = findViewById(R.id.text_field);

                //if (textEdit.getText() == null)
                //   return;

                Intent myIntent = new Intent(ViewStudent.this, j_activity.class);
                myIntent.putExtra("message", "hello");
                ViewStudent.this.startActivity(myIntent);
            }
        });
    }
}