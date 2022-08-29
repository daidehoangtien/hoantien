package vn.edu.csc.bt_advanceui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Toolbar toolbar;
    TextView tvTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar = findViewById(R.id.toolbar);
//        toolbar.setTitle("Food Now");
        tvTitle = toolbar.findViewById(R.id.tvTitle);
        tvTitle.setText("Food Now");
    }
}