package com.bitlogicsolution;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    ImageView standard, scientific, unit, age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        standard = findViewById(R.id.button1);
        scientific = findViewById(R.id.button);
        unit = findViewById(R.id.button2);
        age = findViewById(R.id.ageCalculator);
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;
        standard.getLayoutParams().height=height/4;
        standard.getLayoutParams().width=width/4;
        scientific.getLayoutParams().height=height/4;
        scientific.getLayoutParams().width=width/4;
        unit.getLayoutParams().height=height/4;
        unit.getLayoutParams().width=width/4;
        age.getLayoutParams().width=width/4;
        age.getLayoutParams().height=height/4;

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.sharebutton, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        super.onOptionsItemSelected(item);
        if (item.getItemId() == R.id.share) {
            Intent share = new Intent(android.content.Intent.ACTION_SEND);
            share.setType("text/plain");
            share.addFlags(Intent.FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET);

            // Add data to the intent, the receiving app will decide
            // what to do with it.
            share.putExtra(Intent.EXTRA_SUBJECT, "Title Of The Post");
            share.putExtra(Intent.EXTRA_TEXT, "https://play.google.com/store/apps/details?id=" + getPackageName());

            startActivity(Intent.createChooser(share, "Share link!"));
        } else if (item.getItemId() == R.id.rateUs) {
            Uri uri = Uri.parse("https://play.google.com/store/apps/details?id=" + getPackageName());
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        else if(item.getItemId()==R.id.info)
        {
          final AlertDialog.Builder builder=new AlertDialog.Builder(this);
          builder.setTitle("Scientific Calcuator");
          builder.setIcon(R.mipmap.ic_launcher);
          builder.setMessage("This application offers completely different functions like what a true scientific calculator has, it will calculate powers, roots, exponent and exponential functions, proportion calculations, pure mathematics functions in degrees, radians or gradients, hyperbolic functions, factorials, permutations and combos, fastened purpose, scientific and engineering notation show modes, adjustable decimal places, hex, positional notation and binary modes with logical operator functions.");

          builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
              @Override
              public void onClick(DialogInterface dialog, int which) {
                  dialog.dismiss();
              }
          });builder.show();
        }

        return true;
    }

    public void onClick(View view) {
        Intent i;
        if (view.getId() == R.id.button1) {
            i = new Intent(this, StandardCal.class);
            startActivity(i);
        } else if (view.getId() == R.id.button) {
            i = new Intent(this, ScientificCal.class);
            startActivity(i);
        } else if (view.getId() == R.id.button2) {
            i = new Intent(this, UnitCoverter.class);
            startActivity(i);
        } else if (view.getId() == R.id.ageCalculator) {
            i = new Intent(this, ageCalculator.class);
            startActivity(i);
        }

    }

}
