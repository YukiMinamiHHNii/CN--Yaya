package com.example.hhnii.exercise2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public EditText input;
    public TextView output;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        input= (EditText) findViewById(R.id.input);
        output= (TextView) findViewById(R.id.output);
    }

    public void pressed(View view){
        try{
            output.setText(String.valueOf(Float.parseFloat(input.getText().toString())*3.1416));
        }catch(Exception e){
            Toast.makeText(this, "Please input a number", Toast.LENGTH_SHORT).show();
        }
    }

    public void action(View view){
        Toast.makeText(this, input.getText() + (String)view.getTag(), Toast.LENGTH_SHORT).show();
    }

}
