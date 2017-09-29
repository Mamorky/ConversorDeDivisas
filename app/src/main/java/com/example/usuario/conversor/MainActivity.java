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

    @Override
    public void onClick(View view) {
        Conversor.TipoCambio cambio;

        if(view == convertirBtn)
        {
            try{
            if(dolarEuroRd.isChecked())
            {
                cambio = Conversor.TipoCambio.dolarEuro;
                Conversor conver = new Conversor(Double.parseDouble(dolarTexto.getText().toString()),cambio);
                euroTexto.setText(String.valueOf(conver.getEuros()));
            }

            if(euroDolarRd.isChecked())
            {
                cambio = Conversor.TipoCambio.euroDolar;
                Conversor conver = new Conversor(Double.parseDouble(euroTexto.getText().toString()),cambio);
                dolarTexto.setText(String.valueOf(conver.getDolares()));
            }}catch (Exception e){};
        }
    }
}
