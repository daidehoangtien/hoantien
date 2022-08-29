package vn.edu.csc.bt_advanceui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity3 extends AppCompatActivity implements View.OnClickListener {

    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        img = findViewById(R.id.imageView);
        img.setOnClickListener(MainActivity3.this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.imageView){
            PopupMenu popupMenu = new PopupMenu(MainActivity3.this,view);
            popupMenu.inflate(R.menu.popup_menu);
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem menuItem) {
                    switch (menuItem.getItemId()){
                        case R.id.mnu_new_game:
                            Toast.makeText(MainActivity3.this, "New game", Toast.LENGTH_SHORT).show();
                            break;
                        case R.id.mnu_about:
                            Toast.makeText(MainActivity3.this, "About", Toast.LENGTH_SHORT).show();
                            break;
                    }
                    return false;
                }
            });
            popupMenu.show();
        }
    }
}