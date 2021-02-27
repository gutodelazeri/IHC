package example.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText text_field_1;
    private TextInputEditText text_field_2;
    private TextView result_field;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.text_field_1 = findViewById(R.id.text_1);
        this.text_field_2 = findViewById(R.id.text_2);
        this.result_field = findViewById(R.id.result);
    }

    public void onButtonClick(View view) {
        Editable field_1 = this.text_field_1.getText();
        Editable field_2 = this.text_field_2.getText();

        if(field_1 == null || field_2 == null)
            return;


        String text_1 = field_1.toString();
        String text_2 = field_2.toString();

        float a, b;
        try {
            a = Float.parseFloat(text_1);
            b = Float.parseFloat(text_2);

            this.result_field.setText(String.format(Float.toString(a + b), 3));
        }
        catch (NullPointerException ignored){
        }
        catch (NumberFormatException ignored){
        }
    }
}