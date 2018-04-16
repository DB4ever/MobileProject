package com.example.dbrey.calculus;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IntDef;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.Scanner;

/**
 * Created by dbrey on 4/18/2017.
 */

public class div_equations extends AppCompatActivity implements View.OnClickListener{
    String Text = "";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.div_equations);
        Button button = (Button) findViewById(R.id.calculate_derviative);

        button.setOnClickListener(this);

    }
    public void onClick(View v)
    {


        TextView UserInput = (TextView) findViewById(R.id.edit_divequation);
        TextView Output = (TextView) findViewById(R.id.Basic_Div);
        TextView Output2 = (TextView) findViewById(R.id.out_steps);
        Output.setText(Derviative(UserInput.getText().toString()));
        Output2.setText(Text);

    }

    public String Derviative(String derviative) {
        try {


            Text = "";
            derviative = derviative.toLowerCase().trim();
            int index = 0;
            while (index < derviative.length()) {
                int space = derviative.indexOf(' ', index);
                if (space < 0) {
                    break;

                }
                derviative = derviative.substring(0, space) + derviative.substring(space + 1);
                index = space - 1;
            }
            int curIndex = 0;
            String r = "";
            while (curIndex < derviative.length())

            {
                int d = derviative.indexOf('+', curIndex + 1);
                int s = derviative.indexOf('-', curIndex + 1);
                if (d == -1) {
                    d = derviative.length();
                }
                if (s == -1) {
                    s = derviative.length();
                }
                if (s < d) {
                    d = s;
                }

                int div = derviative.indexOf('^', curIndex);
                int X = derviative.indexOf('x', curIndex);
                if (div == -1) {
                    if (X != -1) {
                        int n = Integer.parseInt(derviative.substring(curIndex, X));
                        if (n > 0 && r.length() > 0) {
                            r += "+";
                            Text += "+";
                        }
                        if (n != 0) {
                            r += Integer.toString(n);
                            Text += Integer.toString(n) + "X^(1-1)";
                        }

                    }
                    curIndex = d;
                    continue;
                }


                int n_old = Integer.parseInt(derviative.substring(curIndex, X));
                int exponent_old = Integer.parseInt(derviative.substring(div + 1, d));
                int n = n_old * exponent_old;
                int exponent = exponent_old - 1;
                if (n > 0 && r.length() > 0) {
                    r += "+";

                }
                if (r.length() > 0) {

                    Text += "+";
                }
                if (n != 0) {
                    if (exponent == 0) {
                        r += Integer.toString(n);
                        Text += "(" + Integer.toString(n_old) + "*" + Integer.toString(exponent_old) + ")X^(1-1)";
                    } else if (exponent == 1) {
                        r += Integer.toString(n) + "X";
                        Text += "(" + Integer.toString(n_old) + "*" + Integer.toString(exponent_old) + ")X^(2-1)";
                    } else {
                        r += Integer.toString(n) + "X^" + Integer.toString(exponent);
                        Text += "(" + Integer.toString(n_old) + "*" + Integer.toString(exponent_old) + ")X^(" + Integer.toString(exponent_old) + "-1)";
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

