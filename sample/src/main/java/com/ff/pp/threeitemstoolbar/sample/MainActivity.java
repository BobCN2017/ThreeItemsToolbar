package com.ff.pp.threeitemstoolbar.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ff.pp.threeitemstoolbar.ThreeItemsToolbar;

public class MainActivity extends AppCompatActivity {

   private ThreeItemsToolbar threeItemsToolbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        threeItemsToolbar= (ThreeItemsToolbar) findViewById(R.id.threeItemsToolbar);
    }
}
