package com.example.test3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.tomer.fadingtextview.FadingTextView;

public class MainActivity extends AppCompatActivity {
    private FadingTextView fadingTextView;
    Spinner mSpinner;
    TextView mOutputSpinner;
    String[] mOptions = {"English","தமிழ்"};
    private ImageButton tick_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fadingTextView= findViewById(R.id.fade_in_text_view);
        tick_button = (ImageButton) findViewById(R.id.imageButton);
        tick_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentLoadNewActivity = new Intent(MainActivity.this,Slide1.class);
                startActivity(intentLoadNewActivity);
            }
        });

        mSpinner=findViewById(R.id.spinner);
        mOutputSpinner=findViewById(R.id.textView);
        ArrayAdapter a=new ArrayAdapter(this,android.R.layout.simple_spinner_item,mOptions);
        a.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(a);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                if(i==0){
                   mOutputSpinner.setText("Welcome");
                }
                if(i==1){
                   mOutputSpinner.setText("வணக்கம்");
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
