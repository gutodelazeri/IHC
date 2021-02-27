package example.com;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mAccelerometer;

    private final float SENSIBILITY = 2;

    private boolean good_to_go;

    private float old_x;
    private float old_y;
    private float old_z;

    TextInputEditText coordinate_x;
    TextInputEditText coordinate_y;
    TextInputEditText  coordinate_z;

    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mAccelerometer = mSensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);

        old_x = 0;
        old_y = (float) 9.65;
        old_z = (float) 1.74;

        good_to_go = false;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        coordinate_x = findViewById(R.id.text_field_x);
        coordinate_y = findViewById(R.id.text_field_y);
        coordinate_z = findViewById(R.id.text_field_z);


    }


    @Override
    protected void onResume() {
        super.onResume();
        mSensorManager.registerListener(this, mAccelerometer, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float sensorX = event.values[0];
            float sensorY = event.values[1];
            float sensorZ = event.values[2];

            coordinate_x.setText(String.format("%.5g%n", sensorX));
            coordinate_y.setText(String.format("%.5g%n", sensorY));
            coordinate_z.setText(String.format("%.5g%n", sensorZ));

            if(good_to_go && (Math.abs(sensorX - old_x) > SENSIBILITY || Math.abs(sensorY - old_y) > SENSIBILITY || Math.abs(sensorZ - old_z) > SENSIBILITY)){
                Intent myIntent = new Intent(MainActivity.this, MainActivity2.class);
                myIntent.putExtra("message", "You are moving too fast!");
                MainActivity.this.startActivity(myIntent);
                good_to_go = false;
            }
            else
                good_to_go = true;

            old_x = sensorX;
            old_y = sensorY;
            old_z = sensorZ;
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }
}