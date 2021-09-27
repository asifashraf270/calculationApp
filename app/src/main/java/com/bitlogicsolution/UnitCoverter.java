package com.bitlogicsolution;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class UnitCoverter extends AppCompatActivity {
ImageView area,temperation,weight,length;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit_coverter);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        area=findViewById(R.id.area);
        temperation=findViewById(R.id.tempearture);
        weight=findViewById(R.id.weight);
        length=findViewById(R.id.length);
        area.getLayoutParams().height=height/4;
        area.getLayoutParams().width=width/4;
        temperation.getLayoutParams().height=height/4;
        temperation.getLayoutParams().width=width/4;
        weight.getLayoutParams().height=height/4;
        weight.getLayoutParams().width=width/4;
        length.getLayoutParams().height=height/4;
        length.getLayoutParams().width=width/4;


    }

    public void onClick(View v) {
        Intent i;
        switch (v.getId()) {
            case R.id.area:
                i = new Intent(this, UnitArea.class);
                startActivity(i);
                break;
            case R.id.length:
                i = new Intent(this, UnitLength.class);
                startActivity(i);
                break;
            case R.id.weight:
                i = new Intent(this, UnitWeight.class);
                startActivity(i);
                break;
            case R.id.tempearture:
                i = new Intent(this, UnitTemperature.class);
                startActivity(i);
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
