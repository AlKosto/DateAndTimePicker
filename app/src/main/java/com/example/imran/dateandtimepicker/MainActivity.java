package com.example.imran.dateandtimepicker;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements
        DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

    Button b_pick;
    TextView tv_result;
    int day, month, year, hour, minute;
    int dayFinal, monthFinal, yearFinal, hourFinal, minuteFinal;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b_pick =(Button)findViewById(R.id.b_pick);
        tv_result = (TextView)findViewById(R.id.tv_result);


        b_pick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day =c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this , MainActivity.this,
                        year, month, day);
                datePickerDialog.show();

            }
        });
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        yearFinal = year;
        monthFinal = month + 1;
        dayFinal = dayOfMonth;


        Calendar c= Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(MainActivity.this, MainActivity.this,
                hour, minute, true);

        timePickerDialog.show();
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        hourFinal = hourOfDay;
        minuteFinal = minute;


        tv_result.setText("Year: " + yearFinal +"\n"+
        "Month: " + monthFinal +"\n"+
        "Date: " + dayFinal+ "\n"+
                "hour"+hourFinal+"\n"+
        "minute: " + minuteFinal);
    }
}


















