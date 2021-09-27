package com.bitlogicsolution;

import android.app.DatePickerDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

public class ageCalculator extends AppCompatActivity {
    EditText startDate, endDate;
    Button clear, calculate;
    TextView yearstv, monthtv, daystv;
    Calendar c;
    int mYear, mMonth, mDay;

    Date today, birthday;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_age_calculator);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Age Calculator");
        c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        startDate = findViewById(R.id.startdate);
        endDate = findViewById(R.id.today);
        clear = findViewById(R.id.clear);
        calculate = findViewById(R.id.calculate);
        yearstv = findViewById(R.id.year);
        monthtv = findViewById(R.id.month);
        daystv = findViewById(R.id.days);

        endDate.setText("" + mDay + "-" + (mMonth + 1) + "-" + mYear);
        today = new Date(mYear, mMonth, mDay);

        startDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(ageCalculator.this, R.style.DialogTheme,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {
                                birthday = new Date(year, monthOfYear, dayOfMonth);

                                startDate.setText("" + dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();
            }
        });
        endDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(ageCalculator.this, R.style.DialogTheme,
                        new DatePickerDialog.OnDateSetListener() {

                            @Override
                            public void onDateSet(DatePicker view, int year,
                                                  int monthOfYear, int dayOfMonth) {

                                today = new Date(year, monthOfYear, dayOfMonth);
                                endDate.setText("" + dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);
                            }
                        }, mYear, mMonth, mDay);
                datePickerDialog.show();

            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startDate.setText("");
                endDate.setText("");
            }
        });
        calculate.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View v) {
                if (!(startDate.getText().toString().trim().isEmpty() && endDate.getText().toString().isEmpty())) {

                    getDateDifferenceInDDMMYYYY(birthday, today);


                } else {
                    Toast.makeText(ageCalculator.this, "Some Field Missing!", Toast.LENGTH_SHORT).show();
                }

            }
        });
    }

    public void getDateDifferenceInDDMMYYYY(Date from, Date to) {
        Calendar fromDate = Calendar.getInstance();
        Calendar toDate = Calendar.getInstance();
        fromDate.setTime(from);
        toDate.setTime(to);
        int increment = 0;
        int year, month, day;
        System.out.println(fromDate.getActualMaximum(Calendar.DAY_OF_MONTH));
        if (fromDate.get(Calendar.DAY_OF_MONTH) > toDate.get(Calendar.DAY_OF_MONTH)) {
            increment = fromDate.getActualMaximum(Calendar.DAY_OF_MONTH);
        }
        System.out.println("increment" + increment);
// DAY CALCULATION
        if (increment != 0) {
            day = (toDate.get(Calendar.DAY_OF_MONTH) + increment) - fromDate.get(Calendar.DAY_OF_MONTH);
            increment = 1;
        } else {
            day = toDate.get(Calendar.DAY_OF_MONTH) - fromDate.get(Calendar.DAY_OF_MONTH);
        }

// MONTH CALCULATION
        if ((fromDate.get(Calendar.MONTH) + increment) > toDate.get(Calendar.MONTH)) {
            month = (toDate.get(Calendar.MONTH) + 12) - (fromDate.get(Calendar.MONTH) + increment);
            increment = 1;
        } else {
            month = (toDate.get(Calendar.MONTH)) - (fromDate.get(Calendar.MONTH) + increment);
            increment = 0;
        }

// YEAR CALCULATION
        year = toDate.get(Calendar.YEAR) - (fromDate.get(Calendar.YEAR) + increment);
        daystv.setText("" + day);
        monthtv.setText("" + month);
        yearstv.setText("" + year);


    }


}


