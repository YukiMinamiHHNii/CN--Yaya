package com.example.hhnii.exercise3;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.support.v4.app.FragmentTabHost;

public class MainActivity extends FragmentActivity {

    private FragmentTabHost tabs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabs= findViewById(R.id.mainTabhost);
        tabs.setup(this, getSupportFragmentManager(), R.id.tabContent);
        tabs.addTab(tabs.newTabSpec("tab1").setIndicator("First Tab"), Tab1.class, null);
        tabs.addTab(tabs.newTabSpec("tab2").setIndicator("Second Tab"), Tab2.class, null);
        tabs.addTab(tabs.newTabSpec("tab3").setIndicator("Third Tab"), Tab3.class, null);

    }

}
