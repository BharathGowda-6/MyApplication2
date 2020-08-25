package com.runshaw.tutorials.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;
import android.widget.ToggleButton;

import com.runshaw.tutorials.R;

public class MainActivity extends AppCompatActivity {
    EditText editTestTextPersonName;
    TextView tvResult;
    DatePicker datePicker;
    TimePicker timePicker;
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG,"onCreate is called");
        Button btnSubmit= findViewById(R.id.btnSubmit);

        editTestTextPersonName=findViewById(R.id.editTestTextPersonName);
        tvResult=findViewById(R.id.tvResult);
        datePicker=findViewById(R.id.datePicker);
        timePicker=findViewById(R.id.timePicker);
        btnSubmit.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText( MainActivity.this,"Button Clicked!!",Toast.LENGTH_SHORT).show();
            }

        });
        ToggleButton toggleButton=findViewById(R.id.toggleBtn);
        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                Toast.makeText(MainActivity.this,"toggle button clicked!",Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void showName(View view) {
        String name=editTestTextPersonName.getText().toString();
        tvResult.setText(name);

    }

    public void radioButtonSelect(View view) {
        //perform action on click
        Boolean checked=((RadioButton)view).isChecked();

        switch (view.getId()){
            case R.id.rdBurger:
                if(checked)
                    Toast.makeText(this,"i like burger",Toast.LENGTH_SHORT).show();
                break;
            case R.id.rdPizza:
                if(checked)
                    Toast.makeText(this,"i like pizza",Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void checkBoxSelect(View view) {
        Boolean checked=((CheckBox) view).isChecked();
        switch (view.getId()){
            case R.id.cbGOT:
                if(checked){
                    Toast.makeText(this,"i like this Series<3",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(this,"i don't like this series",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.cb13ry:
                if(checked){
                    Toast.makeText(this,"i like this Series<3",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(this,"i don't like this series",Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.cbRD:
                if(checked){
                    Toast.makeText(this,"i like this Series<3",Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(this,"i don't like this series",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    public void selectDate(View view) {
        String selectedDate=datePicker.getDayOfMonth() +"/"+ datePicker.getMonth() +"/"+datePicker.getYear();
        Toast.makeText(this,selectedDate,Toast.LENGTH_LONG).show();

        Log.d(TAG,"selected date:"+ selectedDate);
    }

    public void selectTime(View view) {
        String selectedTime=timePicker.getHour()+":"+timePicker.getMinute();
        Toast.makeText(this,selectedTime,Toast.LENGTH_LONG).show();
        Log.d(TAG,"selected time"+selectedTime);

    }
    /*public void showName(View view){
        String name=editTestTextPersonName.getText().toString();
        tvResult.setText(name);
    }

   /* public void buttonClicked(View view){
        Toast.makeText(this, "Button Clicked!!",Toast.LENGTH_SHORT).show();
    }*/
    @Override
    protected void onStart(){
        super.onStart();
        Log.d(TAG,"onResume is called");
    }
    @Override
    protected void onResume(){
        super.onResume();
        Log.d(TAG,"onResume is called");
    }
    @Override
    protected void onPause(){
        super.onPause();
        Log.d(TAG,"onPause is called");
    }
    @Override
    protected void onStop(){
        super.onStop();
        Log.d(TAG,"onStop is called");
    }
    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.d(TAG,"onDestroy is called");
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d(TAG,"onRestart is called");
    }

    public void goToLinearLayout(View view) {
        Intent intent=new Intent(MainActivity.this, LinearLayoutExampleActivity.class);
        startActivity(intent);
    }

    public void goToRelativeLayout(View view) {
        Intent intent=new Intent(MainActivity.this, RelativeLayoutExampleActivity.class);
        startActivity(intent);
    }

    public void goToLogin(View view) {
        Intent intent=new Intent(MainActivity.this, LoginActivity.class);
        startActivity(intent);
    }

    public void goToFrameLayout(View view) {
        startActivity(new Intent(MainActivity.this, FrameLayoutActivity.class));
    }

    public void goToCardView(View view) {
        startActivity(new Intent(MainActivity.this, CardViewActivity.class));
    }

    public void goToFragment(View view) {
        startActivity(new Intent(MainActivity.this, FragementHostActivity.class));
    }

    public void goToTODO(View view) {
        startActivity(new Intent(MainActivity.this, TodoActivity.class));
    }

    public void goToUI(View view) {
        startActivity(new Intent(MainActivity.this, UIActivity.class));
    }
}

