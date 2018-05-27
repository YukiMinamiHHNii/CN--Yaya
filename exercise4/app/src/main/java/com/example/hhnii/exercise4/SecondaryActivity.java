package com.example.hhnii.exercise4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.MessageFormat;

public class SecondaryActivity extends Activity {

    private TextView termsLabel;
    private Button acceptButton, declineButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_secondary);

        termsLabel= findViewById(R.id.termsLabel);
        MessageFormat message= new MessageFormat(termsLabel.getText().toString());
        Bundle data= getIntent().getExtras();
        termsLabel.setText(message.format(new Object[]{data.getString("name")}));

        acceptButton= findViewById(R.id.acceptButton);
        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                accept(null);
            }
        });

        declineButton= findViewById(R.id.declineButton);
        declineButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decline(null);
            }
        });

    }

    private void accept(View view){
        Intent intent= new Intent();
        intent.putExtra("result", "OK");
        setResult(200, intent);
        finish();
    }

    private void decline(View view){
        Intent intent= new Intent();
        intent.putExtra("result", "NG");
        setResult(300, intent);
        finish();
    }

}
