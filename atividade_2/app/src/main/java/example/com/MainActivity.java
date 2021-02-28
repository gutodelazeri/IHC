package example.com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity implements SensorEventListener {

    private SensorManager mSensorManager;
    private Sensor mLuminosity;
    private Sensor mMagneticField;


    TextInputEditText luminosity;

    TextInputEditText north;
    TextInputEditText east;
    TextInputEditText up;

    TextInputEditText gps_lat;
    TextInputEditText gps_lon;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        mSensorManager = (SensorManager) getSystemService(SENSOR_SERVICE);
        mLuminosity = mSensorManager.getDefaultSensor(Sensor.TYPE_LIGHT);
        mMagneticField = mSensorManager.getDefaultSensor(Sensor.TYPE_MAGNETIC_FIELD);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        luminosity = findViewById(R.id.luminosity_field);

        north = findViewById(R.id.text_field_x);
        east = findViewById(R.id.text_field_y);
        up = findViewById(R.id.text_field_z);

        gps_lat = findViewById(R.id.gps_field_lat);
        gps_lon = findViewById(R.id.gps_field_lon);

        ActivityCompat.requestPermissions(MainActivity.this, new
               String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 123);

    }


    @Override
    protected void onResume() {
        super.onResume();
        if (mLuminosity != null)
            mSensorManager.registerListener(this, mLuminosity, SensorManager.SENSOR_DELAY_NORMAL);
        if (mMagneticField != null)
            mSensorManager.registerListener(this, mMagneticField, SensorManager.SENSOR_DELAY_NORMAL);
    }

    @Override
    protected void onPause() {
        super.onPause();
        mSensorManager.unregisterListener(this);
    }

    @SuppressLint("DefaultLocale")
    @Override
    public void onSensorChanged(SensorEvent event) {

        if (event.sensor.getType() == Sensor.TYPE_MAGNETIC_FIELD) {
            float sensorX = event.values[0];
            float sensorY = event.values[1];
            float sensorZ = event.values[2];

            north.setText(String.format("%.5g%n", sensorX));
            east.setText(String.format("%.5g%n", sensorY));
            up.setText(String.format("%.5g%n", sensorZ));
        } else if (event.sensor.getType() == Sensor.TYPE_LIGHT) {
            float sensorOutput = event.values[0];
            luminosity.setText(String.valueOf(sensorOutput));
        }

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {
    }


    public void onClick_updateButton(View view) {

        GPSTracker g = new GPSTracker(getApplicationContext());
        Location l = g.getLocation();
        if (l != null) {
            double lat = ((Location) l).getLatitude();
            double lon = l.getLongitude();

            gps_lat.setText(String.valueOf(lat));
            gps_lon.setText(String.valueOf(lon));

        }

    }
}
