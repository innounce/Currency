package com.home.currency;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText ntd;
    private Button go;
    static float US_RATE = 30.9f;

    String S_nt;
    float us;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViews();
    }

    private void findViews() {
        ntd = findViewById(R.id.ntd);
        go = findViewById(R.id.go);

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AlertDialog.Builder(MainActivity.this).setTitle("Result").setMessage( calcRate() ).setPositiveButton("OK",null).show();
            }
        });
    }

    private String calcRate(){
        S_nt = ntd.getText().toString();
        try{
            us = (Float.parseFloat(S_nt)) / US_RATE;
            return "USD is "+us;
        }catch (Exception e){
            return "Please enter your NTD amount！";
        }
    }


}
