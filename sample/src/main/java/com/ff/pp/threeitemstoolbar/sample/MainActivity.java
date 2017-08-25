package com.ff.pp.threeitemstoolbar.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.widget.Toast;

import com.ff.pp.threeitemstoolbar.ThreeItemsToolbar;

public class MainActivity extends AppCompatActivity {

   private ThreeItemsToolbar threeItemsToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        threeItemsToolbar= (ThreeItemsToolbar) findViewById(R.id.threeItemsToolbar);
        threeItemsToolbar.setRightSideMenu(R.menu.main, new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                Toast.makeText(MainActivity.this,"settings",Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }
}
