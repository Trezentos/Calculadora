package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText numero1;
    EditText numero2;
    TextView resultado;
    TextView historico;
    int histContador = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        numero1 = findViewById(R.id.etNum1);
        numero2 = findViewById(R.id.etNum2);
        resultado = findViewById(R.id.Visao);
        historico = findViewById(R.id.historico);

    }

    public void limparHistorico(View v){

        historico.setText("Histórico");
        histContador=0;

    }

    public void historicoSistema(TextView historico, float res){

        String limpar = historico.toString();

        if(limpar == "Limpa isso"){
            histContador=0;
            historico.setText("Histórico\n");
            return;
        }


        if( histContador < 5 ){
            historico.append("\n"+res);
            histContador++;
        }else{
            histContador=0;
            historico.setText("Histórico\n"+res);
        }

    }



    public void adicaoResultado (View v ){
        //Trimm ele limpa os espaços

        String num1St = numero1.getText().toString().trim();
        String num2St = numero2.getText().toString().trim();

        if(num1St.equals("") || num2St.equals("") ){
            Toast.makeText(this, "Por favor informar os dois numeros", Toast.LENGTH_SHORT).show();
        }else{
            float res = Float.valueOf(num1St) + Float.valueOf(num2St);
            resultado.setText("Resultado: " + res);

            historicoSistema(historico, res);


        }
    }

    public void subtracaoResultado(View v){
        String num1St = numero1.getText().toString().trim();
        String num2St = numero2.getText().toString().trim();

        if(num1St.equals("") || num2St.equals("") ){
            Toast.makeText(this, "Por favor informar os dois numeros", Toast.LENGTH_SHORT).show();
        }else{
            float res = Float.valueOf(num1St) - Float.valueOf(num2St);
            resultado.setText("Resultado: " + res);
            historicoSistema(historico, res);
        }

    }

    public void multiplicacaoResultado(View view){
        String num1St = numero1.getText().toString().trim();
        String num2St = numero2.getText().toString().trim();

        if(num1St.equals("") || num2St.equals("") ){
            Toast.makeText(this,"Por favor informar os dois numeros", Toast.LENGTH_SHORT).show();
        }else{
            float res = Float.valueOf(num1St)*Float.valueOf(num2St);
            resultado.setText("Resultado: "+res);
            historicoSistema(historico, res);
        }

    }

    public void divisaoResultado(View view){
        String num1St = numero1.getText().toString().trim();
        String num2St = numero2.getText().toString().trim();

        if(num1St.equals("") || num2St.equals("")){
            Toast.makeText(this, "Por favor informar os dois numero", Toast.LENGTH_SHORT);
        }else{
            float res = Float.valueOf(num1St)/Float.valueOf(num2St);
            resultado.setText("Resultado "+res);
            historicoSistema(historico, res);
        }
    }




}
