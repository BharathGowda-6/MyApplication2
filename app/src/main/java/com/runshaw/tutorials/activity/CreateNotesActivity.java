package com.runshaw.tutorials.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import com.runshaw.tutorials.NotesModel;
import com.runshaw.tutorials.R;
import com.runshaw.tutorials.data.DbHelper;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class CreateNotesActivity extends AppCompatActivity {
    TextView tvDate;
    TextView tvTime;
    EditText etTitle;
    EditText etDesc;

    DbHelper dbHelper;
    String selectedDate="";
    String selectedTime="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_notes);
        
        tvDate=findViewById(R.id.tvDate);
        tvTime=findViewById(R.id.tvTime);
        etTitle=findViewById(R.id.etTitle);
        etDesc=findViewById(R.id.etDesc);

        dbHelper=new DbHelper(this);
    }
    public void selectDate(View view) {
        final Calendar c=Calendar.getInstance();

        int mDate=c.get(Calendar.DAY_OF_MONTH);
        int mMonth=c.get(Calendar.MONTH);
        int mYear=c.get(Calendar.YEAR);
        DatePickerDialog datePickerDialog=new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                int newMonth=month+1;
                String selectedDate=dayOfMonth+"/"+newMonth+"/"+year;
                tvDate.setVisibility(View.VISIBLE);
                tvDate.setText(selectedDate);

            }
        },mDate,mMonth,mYear);
        datePickerDialog.show();
    }
    public void selectTime(View view) {
        final Calendar c=Calendar.getInstance();
        int mHour=c.get(Calendar.HOUR_OF_DAY);
        int mMinute=c.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog=new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() {
            @Override
            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                String selectedTime=hourOfDay+":"+minute;
                tvTime.setVisibility(View.VISIBLE);
                tvTime.setText(selectedTime);//time will display(4:06),for required format proceed(12:03 AM)

                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("H:mm");
                //date(simplrdateformat)-> string using simpleDateFormat
                try {
                    Date date=simpleDateFormat.parse(selectedTime);
                    selectedTime=new SimpleDateFormat("h:mm a").format(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }
                tvTime.setVisibility(View.VISIBLE);
                tvTime.setText(selectedTime);
            }
    },mHour,mMinute,false);
        timePickerDialog.show();
    }
    public void submit(View view) {
        String title=etTitle.getText().toString();
        String desc=etDesc.getText().toString();
        //push values into database
        NotesModel notesModel=new NotesModel(title,desc,selectedDate,selectedTime);
        dbHelper.insertNotes(notesModel);
        dbHelper.getNotes();

        startActivity(new Intent(this,TodoActivity.class));
        finish();
    }
}
