package vn.edu.csc.bt_advanceui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;

public class MainActivity4 extends AppCompatActivity {

    ViewPager2 vpWeather;
    WeatherAdapter weatherAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        vpWeather = findViewById(R.id.vpWeather);
        weatherAdapter = new WeatherAdapter(MainActivity4.this);
        vpWeather.setAdapter(weatherAdapter);

    }
}