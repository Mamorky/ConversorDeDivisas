package com.example.usuario.conversor;

import android.icu.text.DecimalFormat;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * @author mamorky
 * @version 1.0
 * */

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    double cambio = 0.84636;

    Button convertirBtn;
    RadioButton dolarEuroRd;
    RadioButton euroDolarRd;
    EditText dolarTexto;
    EditText euroTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        convertirBtn = (Button) findViewById(R.id.convertirBtn);
        dolarEuroRd = (RadioButton) findViewById(R.id.dolarEuroRd);
        euroDolarRd = (RadioButton) findViewById(R.id.eurodolarRd);
        dolarTexto = (EditText) findViewById(R.id.DolaresEdit);
        euroTexto = (EditText) findViewById(R.id.EurosEdit);

        convertirBtn.setOnClickListener(this);
    }

    public String convertirADolares(String cantidad)
    {
        double valor = Double.parseDouble(cantidad)*cambio;
        return Double.toString(valor);
    }

    public String convertirAEuros(String cantidad)
    {
        double valor = Double.parseDouble(cantidad)/cambio;
        return Double.toString(valor);
    }

    @Override
    public void onClick(View view) {

        double dolares = 0;
        double euros = 0;

        if(view == convertirBtn)
        {
            if(dolarEuroRd.isChecked())
            {
                dolares = Double.parseDouble(dolarTexto.getText().toString());
                euros = Double.parseDouble(convertirAEuros(Double.toString(dolares)));
                euroTexto.setText(Double.toString((double)Math.round(euros*100d)/100d));
            }

            if(euroDolarRd.isChecked())
            {
                euros = Double.parseDouble(euroTexto.getText().toString());
                dolares = Double.parseDouble(convertirADolares(Double.toString(euros)));
                dolarTexto.setText(Double.toString((double)Math.round(dolares*100d)/100d));
            }
        }
    }
}
