package com.example.calculatortest;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import android.widget.Button;
import android.widget.TextView;

import java.util.Stack;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    Button btn_0, btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_pt;
    Button btn_mul, btn_div, btn_add, btn_sub;
    Button btn_clr, btn_del, btn_eq, btn_non;
    TextView et_input;

    Button btn_left, btn_right, btn_sin, btn_cos, btn_x2, btn_x3, btn_factorial, btn_decimal, btn_ln, btn_ex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //实例化对象
         try{
        btn_0 = (Button) findViewById(R.id.btn_zero);
        btn_1 = (Button) findViewById(R.id.btn_1);
        btn_2 = (Button) findViewById(R.id.btn_2);
        btn_3 = (Button) findViewById(R.id.btn_3);
        btn_4 = (Button) findViewById(R.id.btn_4);
        btn_5 = (Button) findViewById(R.id.btn_5);
        btn_6 = (Button) findViewById(R.id.btn_6);
        btn_7 = (Button) findViewById(R.id.btn_7);
        btn_8 = (Button) findViewById(R.id.btn_8);
        btn_9 = (Button) findViewById(R.id.btn_9);
        btn_pt = (Button) findViewById(R.id.btn_point);
        btn_add = (Button) findViewById(R.id.btn_add);
        btn_clr = (Button) findViewById(R.id.btn_clr);
        btn_del = (Button) findViewById(R.id.btn_del);
        btn_div = (Button) findViewById(R.id.btn_div);
        btn_mul = (Button) findViewById(R.id.btn_mul);
        btn_sub = (Button) findViewById(R.id.btn_sub);
        btn_non = (Button) findViewById(R.id.btn_取反);
        et_input = (TextView) findViewById(R.id.et_input);
        btn_left = (Button) findViewById(R.id.left);
        btn_right = (Button) findViewById(R.id.right);
        btn_sin = (Button) findViewById(R.id.sin);
        btn_cos = (Button) findViewById(R.id.cos);
        btn_x2 = (Button) findViewById(R.id.square);
        btn_x3 = (Button) findViewById(R.id.cubic);
        btn_factorial = (Button) findViewById(R.id.factorial);
        btn_decimal = (Button) findViewById(R.id.decimal);
        btn_ln = (Button) findViewById(R.id.ln_x);
        btn_ex = (Button) findViewById(R.id.e_x);

        //给按钮设置的点击事件
             btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);
        btn_pt.setOnClickListener(this);
        btn_add.setOnClickListener(this);
        btn_clr.setOnClickListener(this);
        btn_del.setOnClickListener(this);
        btn_div.setOnClickListener(this);
        btn_mul.setOnClickListener(this);
        btn_sub.setOnClickListener(this);
        btn_non.setOnClickListener(this);
        et_input.setOnClickListener(this);
        btn_left.setOnClickListener(this);
        btn_right.setOnClickListener(this);
        btn_sin.setOnClickListener(this);
        btn_cos.setOnClickListener(this);
        btn_x2.setOnClickListener(this);
        btn_x3.setOnClickListener(this);
        btn_factorial.setOnClickListener(this);
        btn_decimal.setOnClickListener(this);
        btn_ln.setOnClickListener(this);
        btn_ex.setOnClickListener(this);
    }
   catch(Exception e)
    {
        e.printStackTrace();
        Log.e("error",Log.getStackTraceString(e));
    }

}
   //@Override
           public void onClick(View view) {

      String str = et_input.getText().toString();
               try {    switch (view.getId()) {
            case R.id.btn_zero:
            case R.id.btn_1:
            case R.id.btn_2:
            case R.id.btn_3:
            case R.id.btn_4:
            case R.id.btn_5:
            case R.id.btn_6:
            case R.id.btn_7:
            case R.id.btn_8:
            case R.id.btn_9:
            case R.id.left:
            case R.id.right:
                et_input.setText(str + ((Button) view).getText());
                break;
            case R.id.btn_point:
                if (str.charAt(str.length() - 1) == '.')
                    str = str.substring(0, str.length() - 1);
                et_input.setText(str + ((Button) view).getText());
                break;
            case R.id.btn_add:
            case R.id.btn_sub:
            case R.id.btn_mul:
            case R.id.btn_div:
                if (str.charAt(str.length() - 1) == '+' || str.charAt(str.length() - 1) == '-'
                        || str.charAt(str.length() - 1) == '*' || str.charAt(str.length() - 1) == '/') {
                    str = str.substring(0, str.length() - 1);
                }
                et_input.setText(str + ((Button) view).getText());
                break;
            case R.id.btn_clr:
                et_input.setText("");
                break;
            case R.id.btn_del: //判断是否为空，然后在进行删除
                if (str.length() != 0)
                    et_input.setText(str.substring(0, str.length() - 1));
                break;
                case R.id.sin:
            { double s1=Double.parseDouble(et_input.getText().toString());
              double sin = Math.sin(s1 * Math.PI /180.0);
              et_input.setText("sin"+s1+"="+sin);
              break;
            }
         case R.id.cos:
            { double s1=Double.parseDouble(et_input.getText().toString());
                double cos = Math.cos(s1 * Math.PI /180.0);
                et_input.setText("cos "+s1+"="+cos);
                break;
            }

              case R.id.square: {
                  double s1 = Double.parseDouble(et_input.getText().toString());
                  et_input.setText(s1 * s1  + "");
                  break;
              }
              case R.id.cubic: {
                  double s1 = Double.parseDouble(et_input.getText().toString());
                  et_input.setText(s1 * s1 * s1 + "");
                  break;
              }
              case R.id.factorial: {
                  int s1 = Integer.parseInt(et_input.getText().toString());
                  for (int i = s1-1; i > 0; i--)
                      s1 = s1 * i;
                  et_input.setText(s1 + "");
                  break;
              }
              case R.id.decimal: {
                  double s1 = Double.parseDouble(et_input.getText().toString());
                  et_input.setText(1 / s1 + "");
                  break;
              }
              case R.id.ln_x: {
                  double s1 = Double.parseDouble(et_input.getText().toString());
                  et_input.setText(Math.log10(s1) + "");
                  break;
              }
              case R.id.e_x: {
                  double s1 = Double.parseDouble(et_input.getText().toString());
                  et_input.setText(Math.exp(s1) + "");
                  break;
              }
          }

        }
               catch(Exception e)
               {
                   e.printStackTrace();
                   Log.e("error",Log.getStackTraceString(e));
               }

   // });
       btn_eq = (Button) findViewById(R.id.btn_equal);
    btn_eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            String str1 = et_input.getText().toString();
                Stack<Double> shu_zi = new Stack<>();
                Stack<Character> yun_suan_fu = new Stack<>();
                String str2="";
                for(int i=0;i<str1.length();i++)
                {
                    if(str1.charAt(i)>='0'&&str1.charAt(i)<='9') {
                        if(i==0)  shu_zi.push(str1.charAt(i) - 48.0);
                        if(i>0&&(str1.charAt(i-1)<'0'||str1.charAt(i-1)>'9')&&str1.charAt(i-1)!='.')
                            shu_zi.push(str1.charAt(i) - 48.0);
                        if(i>0&&str1.charAt(i-1)>='0'&&str1.charAt(i-1)<='9')
                            shu_zi.push(shu_zi.pop()*10.0+(str1.charAt(i) - 48.0));
                        if(i>0&&str1.charAt(i-1)=='.')
                            shu_zi.push(shu_zi.pop()+(str1.charAt(i) - 48.0)/10.0);
                    }
//部分闪退的原因： 栈 或数组越界 i-1<0  //先实现 1+1
                    //20:06实现不带括号的加减乘除！
                    //20：14实现 带括号的四则运算！
                    if(str1.charAt(i)=='(')
                    {
                        yun_suan_fu.push(str1.charAt(i));
                    }
                    if(str1.charAt(i)==')'){
                        while(yun_suan_fu.lastElement()!='(')
                        {
                            double d1 = shu_zi.pop();
                            double d2 = shu_zi.pop();
                            switch (yun_suan_fu.pop()) {
                                case '+':
                                    d2 = d2 + d1;
                                    break;
                                case '-':
                                    d2 = d2 - d1;
                                    break;
                                case '*':
                                    d2 = d2 * d1;
                                    break;
                                case '/':
                                    d2 = d2 / d1;
                                    break;
                            }
                            shu_zi.push(d2);
                        }
                        yun_suan_fu.pop();  //出栈左括号
                    }
                    if(str1.charAt(i)=='+'||str1.charAt(i)=='-'||str1.charAt(i)=='*'||str1.charAt(i)=='/') {
                        if (i > 0 &&!yun_suan_fu.empty() && (prio(str1.charAt(i)) <= prio(yun_suan_fu.lastElement()))) {
                            double d1 = shu_zi.pop();
                            double d2 = shu_zi.pop();
                            switch (yun_suan_fu.pop()) {
                                case '+':
                                    d2 = d2 + d1;
                                    break;
                                case '-':
                                    d2 = d2 - d1;
                                    break;
                                case '*':
                                    d2 = d2 * d1;
                                    break;
                                case '/':
                                    d2 = d2 / d1;
                                    break;
                            }
                            shu_zi.push(d2);
                        }
                        yun_suan_fu.push(str1.charAt(i));
                    }
                }
                while(!yun_suan_fu.empty()) {
                    double d1=shu_zi.pop();
                    double d2 = shu_zi.pop();
                    switch(yun_suan_fu.pop()){
                        case '+' :d2=d2+d1;break;
                        case '-' :d2=d2-d1;break;
                        case '*' :d2=d2*d1;break;
                        case '/' :d2=d2/d1;break;
                    }
                    shu_zi.push(d2);

                }
                et_input.setText(shu_zi.pop()+"");
}
    });
    }



    public int prio(char op){
        int priority=-1;
        if (op == '*' || op == '/')
            priority = 2;
        if (op == '+' || op == '-')
            priority = 1;
        if (op == '(')
            priority = 0;
        return priority;
    }

//    ActionBar actionBar = getSupportActionBar();
//    if(actionBar!=null)actionBar.hide();
   //setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
//    setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
}
