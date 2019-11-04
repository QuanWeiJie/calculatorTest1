package com.example.calculatortest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class unit extends AppCompatActivity {
    private int input_flag;   //输入进制标志位
    private EditText input_text;
    private Button change;
    private RadioGroup input_group;
    private RadioButton input_kilo;
    private RadioButton input_meter;
    private RadioButton input_deci;
    private RadioButton input_centi;
    private RadioButton input_milli;
    private RadioButton input_micro;
    private RadioButton input_foot;
    private RadioButton input_inch;
    private TextView output_kilo;
    private TextView output_meter;
    private TextView output_deci;
    private TextView output_centi;
    private TextView output_milli;
    private TextView output_micro;
    private TextView output_foot;
    private TextView output_inch;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_unit);
        input_text = (EditText) findViewById(R.id.input_text);
        input_group = (RadioGroup) findViewById(R.id.input_group);
        input_kilo = (RadioButton) findViewById(R.id.kilo);
        input_meter = (RadioButton) findViewById(R.id.meter);
        input_deci = (RadioButton) findViewById(R.id.deci);
        input_centi = (RadioButton) findViewById(R.id.centi);
        input_milli = (RadioButton) findViewById(R.id.milli);
        input_micro = (RadioButton) findViewById(R.id.micro);
        input_foot = (RadioButton) findViewById(R.id.foot);
        input_inch = (RadioButton) findViewById(R.id.inch);
        output_kilo = (TextView) findViewById(R.id.kilo_output);
        output_meter = (TextView) findViewById(R.id.meter_output);
        output_centi = (TextView) findViewById(R.id.centi_output);
        output_micro = (TextView) findViewById(R.id.micro_output);
        output_milli = (TextView) findViewById(R.id.milli_output);
        output_deci = (TextView) findViewById(R.id.deci_output);
        output_foot = (TextView) findViewById(R.id.foot_output);
        output_inch = (TextView) findViewById(R.id.inch_output);
        change = (Button) findViewById(R.id.change);

        //设置初始状态 默认输入 米
        input_meter.setChecked(true);
        input_flag = 2;

        //输入RadioButton检测
        input_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                i = radioGroup.getCheckedRadioButtonId();  //获取按钮ID
                if (i == input_kilo.getId()) input_flag = 1;
                if (i == input_meter.getId()) input_flag = 2;
                if (i == input_deci.getId())  input_flag = 3;
                if (i == input_centi.getId()) input_flag = 4;
                if (i == input_milli.getId()) input_flag = 5;
                if (i == input_micro.getId()) input_flag = 6;
                if (i == input_foot.getId()) input_flag = 7;
                if (i == input_inch.getId()) input_flag = 8;
            }
        });
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                change();
            }
        });
    }

    public  void change(){

        double a = Double.parseDouble(input_text.getText().toString());
        double result=0.0; //输入的数值先转换成 米 为单位
        switch (input_flag){
            case 1: result = a*1000; break;
            case 2: result = a; break;
            case 3: result = a/10; break;
            case 4: result = a/100; break;
            case 5: result = a/1000; break;
            case 6: result = a/1000000; break;
            case 7: result = a/3.2808399; break;
            case 8:result = a/39.370079; break;
            default:
        }
        output_kilo.setText(Double.toString(result/1000));
        output_meter.setText(Double.toString(result));
        output_deci.setText(Double.toString(result*10));
        output_centi.setText(Double.toString(result*100));
        output_milli.setText(Double.toString(result*1000));
        output_micro.setText(Double.toString(result*1000000));
        output_foot.setText(Double.toString(result*3.2808399));
        output_inch.setText(Double.toString(result*39.370079));

    }
}
