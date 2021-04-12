package com.example.p_app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

public class j_activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_j_activity);

        Intent intent = getIntent();
        this.setTitle("Anderson Maciel/" + intent.getStringExtra("message"));

        if(intent.getStringExtra("id").equals("0")){
            CheckBox cb = this.findViewById(R.id.checkBox);
            cb.setChecked(true);
            cb = this.findViewById(R.id.checkBox2);
            cb.setChecked(true);
            cb = this.findViewById(R.id.checkBox7);
            cb.setChecked(true);
        }else if(intent.getStringExtra("id").equals("1")){
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


        TextView textview= (TextView) findViewById(R.id.textView4);
        textview.setMovementMethod(new ScrollingMovementMethod());


        TextView t =  this.findViewById(R.id.textView);
        t.setText(intent.getStringExtra("week"));

        t = this.findViewById(R.id.textView8);
        t.setText(intent.getStringExtra("date"));

        if(intent.getStringExtra("status").equals("1")) {
            String tmp;

            this.findViewById(R.id.empty_file).setVisibility(View.INVISIBLE);

            t = this.findViewById(R.id.textView16);
            tmp = "E-mail do aluno: ousadiaealegria@inf.ufrgs.br";
            t.setText(tmp);

            t = this.findViewById(R.id.textView17);
            tmp = "Cartão do aluno: 00301719";
            t.setText(tmp);

            t = this.findViewById(R.id.textView14);
            tmp = "Hora da postagem: " + intent.getStringExtra("post_hour");
            t.setText(tmp);

            t = this.findViewById(R.id.textView15);
            tmp = "Data da postagem: " + intent.getStringExtra("post_date");
            t.setText(tmp);
        }else{
            String tmp;

            t = this.findViewById(R.id.textView16);
            tmp = "E-mail do aluno: ---";
            t.setText(tmp);

            t = this.findViewById(R.id.textView17);
            tmp = "Cartão do aluno: ---";
            t.setText(tmp);

            t = this.findViewById(R.id.textView14);
            tmp = "Hora da postagem: ---";
            t.setText(tmp);

            t = this.findViewById(R.id.textView15);
            tmp = "Data da postagem: ---";
            t.setText(tmp);

            t = this.findViewById(R.id.textView4);
            t.setText("");
        }
    }
}