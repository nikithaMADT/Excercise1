package com.example.car;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, CompoundButton.OnCheckedChangeListener {
    TextView rate,ins,tot,days;
    RadioButton r1a,r2a,r3a;
    CheckBox ch1a,ch2a,ch3a;
    Spinner list;
    ImageView img1;
    Button calu;
    Double value=0.0,count=0.0,t=0.0;
    ArrayList<crs> cars=new ArrayList<>();
    ArrayList<String> names=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        filldata();
        rate=findViewById(R.id.txtrate);
        ins=findViewById(R.id.txtins);
        tot=findViewById(R.id.txttotal);
        days=findViewById(R.id.txtdays);
        r1a=findViewById(R.id.r1);
        r2a=findViewById(R.id.r2);
        r3a=findViewById(R.id.r3);
        ch1a=findViewById(R.id.ch1);
        ch2a=findViewById(R.id.ch2);
        ch3a=findViewById(R.id.ch3);
        list=findViewById(R.id.spcar);
        img1=findViewById(R.id.img);
        calu=findViewById(R.id.cal);
        r1a.setOnClickListener(this);
        r2a.setOnClickListener(this);
        r3a.setOnClickListener(this);
        ch1a.setOnCheckedChangeListener(this);
        ch2a.setOnCheckedChangeListener(this);
        ch3a.setOnCheckedChangeListener(this);
        calu.setOnClickListener(this);
        ArrayAdapter a1=new ArrayAdapter(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,names);
        list.setAdapter(a1);
        list.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                rate.setText(String.valueOf(cars.get(i).getRate()));
                img1.setImageResource(cars.get(i).getPic());
                r1a.setChecked(true);
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
    public void filldata(){
        cars.add(new crs("BMW",200.12,1,R.drawable.taj));
        cars.add(new crs("Audi",250.20,1,R.drawable.qutub));
        cars.add(new crs("Toyota",360.00,0,R.drawable.toronto));
        cars.add(new crs("Kia",600.00,1,R.drawable.scar));
        for(crs cfe:cars)
            if(cfe.getStatus()==1)
            names.add(cfe.getName());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.r1:
                ins.setText(String.valueOf(15));
                value+=15.0;
            case R.id.r2:
                ins.setText(String.valueOf(7));
                value+=7.0;
            case R.id.r3:
                ins.setText(String.valueOf(10));
                value+=10.0;
            case R.id.cal:
                count=Double.parseDouble(days.getText().toString());
                t=count*value;
                tot.setText(String.format("%.2f",t));

        }
    }


    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        double extra=0.0;
        if(compoundButton.getId()==R.id.ch1) {
            if(ch1a.isChecked())
            extra+= 7.0;
            else
                extra-= 7.0;
        }
        if(compoundButton.getId()==R.id.ch2){
            if(ch2a.isChecked())
                extra+=5.0;
            else
                extra-= 5.0;
        }
        if(compoundButton.getId()==R.id.ch3){
            if(ch3a.isChecked())
                extra+=15;
            else
                extra-= 15.0;
        }
        value+=extra;
    }
}