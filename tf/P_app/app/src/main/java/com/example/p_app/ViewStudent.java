package com.example.p_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ListView;

import java.util.ArrayList;

public class ViewStudent extends AppCompatActivity {

    ListView listView;

    String[] week = {"2021 - Semana 37", "2021 - Semana 12", "2021 - Semana 08"};
    String[] date = {"13/09 - 19/09", "22/03 - 28/03", "22/02 - 28/02"};
    String[] status = { "0", "1", "1"};
    String[] post_date = {"14/09/21", "30/03/2021", "03/03/2021"};
    String[] post_hour = {"14:30", "08:34", "20:01"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_student);
        Intent intent = getIntent();
        String message = intent.getStringExtra("message");
        this.setTitle("Anderson Maciel/" + message);

        listView = this.findViewById(R.id.studentListView);

        if(intent.getStringExtra("week").equals("3")){
            CheckBox cb = this.findViewById(R.id.checkBox);
            cb.setChecked(true);
            cb = this.findViewById(R.id.checkBox2);
            cb.setChecked(true);
            cb = this.findViewById(R.id.checkBox7);
            cb.setChecked(true);
        }else if(intent.getStringExtra("week").equals("2")){
            CheckBox cb = this.findViewById(R.id.checkBox);
            cb.setChecked(true);
            cb = this.findViewById(R.id.checkBox7);
            cb.setChecked(true);
        }else{
            CheckBox cb = this.findViewById(R.id.checkBox3);
            cb.setChecked(true);
        }

        this.findViewById(R.id.checkBox).setEnabled(false);
        this.findViewById(R.id.checkBox2).setEnabled(false);
        this.findViewById(R.id.checkBox3).setEnabled(false);
        this.findViewById(R.id.checkBox4).setEnabled(false);
        this.findViewById(R.id.checkBox5).setEnabled(false);
        this.findViewById(R.id.checkBox7).setEnabled(false);



        if(intent.getStringExtra("pending").equals("1")) {
            ArrayList<Justificativa> arrayList = new ArrayList<>();

            this.findViewById(R.id.empty_box).setVisibility(View.INVISIBLE);

            arrayList.add(new Justificativa("2021 - Semana 37", "13/09 - 19/09", "Não Justificado", R.drawable.icon0));
            arrayList.add(new Justificativa("2021 - Semana 12", "22/03 - 28/03", "Justificado", R.drawable.icon1));
            arrayList.add(new Justificativa("2021 - Semana 08", "22/02 - 28/02", "Justificado", R.drawable.icon1));


            JustificativaAdapter justificativaAdapter = new JustificativaAdapter(this, R.layout.list_row_2, arrayList);

            listView.setAdapter(justificativaAdapter);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                public void onItemClick(AdapterView<?> listView, View itemView, int itemPosition, long itemId) {
                    Intent myIntent = new Intent(ViewStudent.this, j_activity.class);
                    myIntent.putExtra("message", message);
                    myIntent.putExtra("id", Long.toString(itemId));
                    myIntent.putExtra("week", week[(int) itemId]);
                    myIntent.putExtra("date", date[(int) itemId]);
                    myIntent.putExtra("status", status[(int) itemId]);
                    myIntent.putExtra("post_hour", post_hour[(int) itemId]);
                    myIntent.putExtra("post_date", post_date[(int) itemId]);
                    myIntent.putExtra("status", status[(int) itemId]);

                    ViewStudent.this.startActivity(myIntent);
                }
            });
        }

    }
}