package com.example.dbrey.calculus;

    import android.content.Intent;
    import android.os.Bundle;
    import android.support.v7.app.AppCompatActivity;
    import android.support.v7.widget.Toolbar;
    import android.util.Log;
    import android.view.Menu;
    import android.view.MenuItem;
    import android.view.View;
    import android.webkit.WebView;
    import android.widget.AdapterView;
    import android.widget.ArrayAdapter;
    import android.widget.Button;
    import android.widget.ImageButton;
    import android.widget.Spinner;
    import android.widget.TextView;

    import java.io.IOException;
    import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton button = (ImageButton) findViewById(R.id.dev_image);
        ImageButton button1 = (ImageButton) findViewById(R.id.integral);
        button.setOnClickListener(this);
        button1.setOnClickListener(this);
        String [] Spinner_Options = new String[]
                {
                  "Derviative", "Integral"
                };
        Spinner S = (Spinner)findViewById(R.id.equations);
        ArrayAdapter<String> Addapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, Spinner_Options);
        S.setAdapter(Addapter);
        S.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
            {
                ImageButton D_Button =  (ImageButton) findViewById(R.id.dev_image);
                ImageButton I_Button =  (ImageButton) findViewById(R.id.integral);
                if (id == 0)
                {
                    D_Button.setVisibility(View.VISIBLE);
                    I_Button.setVisibility(View.INVISIBLE);

                }else
                {
                    I_Button.setVisibility(View.VISIBLE);
                    D_Button.setVisibility(View.INVISIBLE);
                }


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
    public void onClick(View v)
    {
        if (v.getId()==R.id.dev_image)
        {
            Intent div_equation = new Intent(this, div_equations.class);
            startActivity(div_equation);

        }else
        {
            Intent integral = new Intent(this, Integual.class);
            startActivity(integral);
        }





    }



}

