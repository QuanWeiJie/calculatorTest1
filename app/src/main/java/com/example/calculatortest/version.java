package com.example.calculatortest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class version extends AppCompatActivity {
    private int input_flag;   //输入进制标志位
    private EditText input_text;
    private Button change;
    private RadioGroup input_group;
    private RadioButton input_two;
    private RadioButton input_eight;
    private RadioButton input_ten;
    private RadioButton input_sixteen;
    private TextView output_two;
    private TextView output_eight;
    private TextView output_ten;
    private TextView output_sixteen;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_version);

        input_text = (EditText) findViewById(R.id.input_text);
        input_group = (RadioGroup) findViewById(R.id.input_group);
        input_two = (RadioButton) findViewById(R.id.input_two);
        input_eight = (RadioButton) findViewById(R.id.input_eight);
        input_ten = (RadioButton) findViewById(R.id.input_ten);
        input_sixteen = (RadioButton) findViewById(R.id.input_sixteen);
        change = (Button) findViewById(R.id.change);
        output_two = (TextView) findViewById(R.id.bin_text);
        output_eight = (TextView) findViewById(R.id.oct_text);
        output_ten = (TextView) findViewById(R.id.ten_text);
        output_sixteen = (TextView) findViewById(R.id.hex_text);


        //设置初始状态 默认输入十进制
        input_ten.setChecked(true);
        input_flag = 10;

        //进制输入RadioButton检测

        input_group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                i = radioGroup.getCheckedRadioButtonId();  //获取按钮ID
                if (i == input_two.getId()) input_flag = 2;
                if (i == input_eight.getId()) input_flag = 8;
                if (i == input_ten.getId()) input_flag = 10;
                if (i == input_sixteen.getId()) input_flag = 16;
            }
        });

        //转换按键监听器
        change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            /*    Log.d("男：", "现在可以吗？");
                Log.d("女：", "这样不好吧");*/
                change();
            }
        });

    }
    public void change(){
        try {
            String str="";
            int input_num = 0;
            char a = '0';
            int enable_flag = 0;
            String cha="";
            String result = "";  //初始化
            cha = input_text.getText().toString();
            if(input_flag == 2) {
                for(int i = 0; i < cha.length(); i ++){
                    a = cha.charAt(i);
                    //判断是否有输入错误
                    if(a >= '0' && a <= '1')
                        enable_flag = 0;
                    else
                        enable_flag = 1;
                }
                if(enable_flag == 0) {
                    str = Integer.valueOf(cha, 2).toString();  //二进制转十进制
                    input_num = Integer.valueOf(str).intValue();
                }
                else{
                    Toast.makeText(version.this,"输入错误", Toast.LENGTH_SHORT).show();
                }
            }
            else if(input_flag == 8){
                for(int i = 0; i < cha.length(); i ++){
                    a = cha.charAt(i);
                    //判断是否有输入错误
                    if(a >= '0' && a <= '7')
                        enable_flag = 0;
                    else
                        enable_flag = 1;
                }
                if(enable_flag == 0) {
                    str = Integer.valueOf(cha, 8).toString();  //八进制转十进制
                    input_num = Integer.valueOf(str).intValue();
                }
                else{
                    Toast.makeText(version.this,"输入错误",Toast.LENGTH_SHORT).show();
                }
            }
            else if(input_flag == 10){
                for(int i = 0; i < cha.length(); i ++){
                    a = cha.charAt(i);
                    //判断是否有输入错误
                    if(a >= '0' && a <= '9')
                        enable_flag = 0;
                    else
                        enable_flag = 1;
                }
                if(enable_flag == 0) {
                    str = cha;
                    input_num = Integer.valueOf(str).intValue();
                }
                else{
                    Toast.makeText(version.this,"输入错误",Toast.LENGTH_SHORT).show();
                }
            }
            else if(input_flag == 16){
                for(int i = 0; i < cha.length(); i ++){
                    a = cha.charAt(i);
                    //判断是否有输入错误
                    if((a >= '0' && a <= '9') || (a >= 'A' && a <= 'F')|| (a >= 'a' && a <= 'f'))
                        enable_flag = 0;
                    else
                        enable_flag = 1;
                }
                if(enable_flag == 0) {
                    str = Integer.valueOf(cha, 16).toString();  //十六进制转十进制
                    input_num = Integer.valueOf(str).intValue();
                }
                else{
                    Toast.makeText(version.this,"输入错误",Toast.LENGTH_SHORT).show();
                }
            }


            result = Integer.toBinaryString(input_num);  //十进制转二进制
            output_two.setText(result);  //二进制输出
            result = Integer.toOctalString(input_num);  //十进制转八进制
            output_eight.setText(result); //八进制输出
            result = Integer.toString(input_num);
            output_ten.setText(result); //十进制输出
            result = Integer.toHexString(input_num);    //十进制转十六进制
            output_sixteen.setText(result);//十六进制输出


            enable_flag = 0;  //标志位清零

        }
        catch (Exception e) {
            e.printStackTrace();
            Log.e("error", Log.getStackTraceString(e));
        }
    }
}
