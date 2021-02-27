package example.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onButtonClick(View view) {
        TextInputEditText textEdit = findViewById(R.id.text_field);

        if (textEdit.getText() == null)
            return;

        Intent myIntent = new Intent(MainActivity.this, MainActivity2.class);
        myIntent.putExtra("message", textEdit.getText().toString());
        MainActivity.this.startActivity(myIntent);
    }
}