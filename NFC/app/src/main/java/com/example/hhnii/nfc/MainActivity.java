package com.example.hhnii.nfc;

import android.nfc.NfcAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private NfcAdapter nfcAdapter;
    private TextView nfcLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nfcLabel= findViewById(R.id.nfcLabel);
        nfcAdapter= NfcAdapter.getDefaultAdapter(this);

        if(nfcAdapter==null){
            Toast.makeText(this, "No NFC support on device...", Toast.LENGTH_SHORT).show();
            finish();
        }else
            if(!nfcAdapter.isEnabled()){
            nfcLabel.setText("NFC not enabled");
            finish();
        }else{
            nfcLabel.setText("Microwave ;)");
        }

    }
}
