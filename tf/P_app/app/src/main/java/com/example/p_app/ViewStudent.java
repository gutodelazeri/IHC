package com.example.p_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewStudent extends AppCompatActivity {

    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);
        Intent intent = getIntent();
        this.setTitle("Sergio Cechin/Nome Aluno");
        String message = intent.getStringExtra("message");

        listView = this.findViewById(R.id.studentListView);

        ArrayList<Justificativa> arrayList = new ArrayList<>();

        arrayList.add(new Justificativa("2021 - Semana 37", "DD/MM - DD/MM", "Não Justificado", R.drawable.icon0));
        arrayList.add(new Justificativa("2021 - Semana 12", "DD/MM - DD/MM", "Justificado", R.drawable.icon1));
        arrayList.add(new Justificativa("2021 - Semana 08", "DD/MM - DD/MM", "Justificado", R.drawable.icon1));


        JustificativaAdapter justificativaAdapter = new JustificativaAdapter(this, R.layout.list_row_2, arrayList);

        listView.setAdapter(justificativaAdapter);
    }
}