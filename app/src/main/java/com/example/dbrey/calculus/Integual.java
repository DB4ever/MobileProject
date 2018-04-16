package com.example.dbrey.calculus;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dbrey.calculus.R;

/*
 * Created by Daniel on 4/24/2017.
*/

public class Integual extends AppCompatActivity implements View.OnClickListener
{
    String Text_I= "";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.integual);
        Button button1 = (Button) findViewById(R.id.submit_int);

        button1.setOnClickListener(this);

    }
    public void onClick(View v)
    {
        TextView display_int = (TextView) findViewById(R.id.edit_functionintegral);
        TextView output_integral = (TextView) findViewById(R.id.equation_integral);
        TextView Output_integral2 = (TextView) findViewById(R.id.submit_int);
        TextView Output_integral3 = (TextView) findViewById(R.id.output_integralstep);
        output_integral.setText((Integral(display_int.getText().toString())));
        Output_integral3.setText(Text_I);

    }
    public String Integral(String Integral) {
        try {


            Text_I = "";
            Integral = Integral.toLowerCase().trim();
            int index = 0;
            while (index < Integral.length()) {
                int space = Integral.indexOf(' ', index);
                if (space < 0) {
                    break;

                }
                Integral = Integral.substring(0, space) + Integral.substring(space + 1);
                index = space - 1;
            }
            int curIndex = 0;
            String r = "";
            while (curIndex < Integral.length())

            {
                int d = Integral.indexOf('+', curIndex + 1);
                int s = Integral.indexOf('-', curIndex + 1);
                if (d == -1) {
                    d = Integral.length();
                }
                if (s == -1) {
                    s = Integral.length();
                }
                if (s < d) {
                    d = s;
                }

                int div = Integral.indexOf('^', curIndex);
                int X = Integral.indexOf('x', curIndex);
                if (div == -1) {

                    if (X != -1) {
                        int n = Integer.parseInt(Integral.substring(curIndex, X));
                        int new_n = n/2;
                        if (n > 0 && r.length() > 0) {
                            r += "+";
                            Text_I += "+";
                        }
                        if (n != 0) {
                            r += Integer.toString(new_n) + "X^2+C";
                            Text_I += Integer.toString(n) + "X^(1+1)/2+C";
                        }

                    }else
                    {
                        int n = Integer.parseInt(Integral.substring(curIndex, curIndex+1));

                        if (n > 0 && r.length() > 0) {
                            r += "+";
                            Text_I += "+";
                        }
                        if (n != 0) {
                            r += Integer.toString(n) + "X+C";
                            Text_I += Integer.toString(n) + "X^(0+1)+C";
                        }
                    }
                    curIndex = d;
                    continue;
                }



                int n_old = Integer.parseInt(Integral.substring(curIndex, X));
                int exponent_old = Integer.parseInt(Integral.substring(div + 1, d));
                int exponent = exponent_old + 1;
                double n = (double) n_old / (double) exponent;



                if (n > 0 && r.length() > 0) {
                    r += "+";

                }
                if (r.length() > 0) {

                    Text_I += "+";
                }
                if (n != 0) {
                    if (exponent == 0) {
                        r += Double.toString(n);
                        Text_I += "(" + Integer.toString(n_old)  + ")X^(-1+1)/(1 +" + Integer.toString(exponent_old)+ ")";
                    } else if (exponent == 1) {
                        r += Double.toString(n) + "X";
                        Text_I += "(" + Integer.toString(n_old)  + ")X^(0+1)/(1 +" + Integer.toString(exponent_old)+ ")";
                    } else {
                        r += Double.toString(n) + "X^" + Integer.toString(exponent);
                        Text_I += "(" + Integer.toString(n_old) +  ")X^(" + Integer.toString(exponent_old) + "+1)/(1+ " + Integer.toString(exponent_old)+ ")";

                    }
                }


                curIndex = d;

            }


            return r;
        } catch (Exception E) {
            return E.getMessage();
        }
    }
}
