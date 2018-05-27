package com.example.hhnii.exercise4;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.MessageFormat;

public class MainActivity extends Activity {

    private EditText nameInput;
    private Button verifyButton;
    private TextView resultLabel;
    private String resultValue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameInput= findViewById(R.id.nameInput);
        verifyButton= findViewById(R.id.verifyButton);
        resultLabel= findViewById(R.id.resultLabel);
        resultValue= resultLabel.getText().toString();

        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showSecondary(null);
            }
        });
    }

    private void showSecondary(View view){
        Intent intent= new Intent(this, SecondaryActivity.class);
        intent.putExtra("name", nameInput.getText().toString());
        startActivityForResult(intent, 1313);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            MessageFormat message = new MessageFormat(resultValue);
            resultLabel.setText(message.format(new Object[]{data.getExtras().getString("result")}));
            findViewById(R.id.mainLayout).invalidate();
        }catch(Exception e){
            Toast.makeText(this, "Please specify your decision", Toast.LENGTH_SHORT).show();
        }
    }

}
