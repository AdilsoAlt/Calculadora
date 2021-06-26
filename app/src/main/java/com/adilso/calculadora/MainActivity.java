package com.adilso.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button num_zero, num_um, num_dois, num_tres,num_quatro,num_cinco,num_seis,num_sete,num_oito,num_nove, opr_soma, opr_subtracao, opr_divisao, opr_multiplicacao, opr_igual, ponto, clear;
    private TextView resultado;
    private String valor1 = "", valor2 = "", operacao = "";
    private Float valorFinal;
    private Float valor1Float;
    private Float valor2Float;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        num_zero = findViewById(R.id.num_zero);
        num_um = findViewById(R.id.num_um);
        num_dois = findViewById(R.id.num_dois);
        num_tres = findViewById(R.id.num_tres);
        num_quatro = findViewById(R.id.num_quatro);
        num_cinco = findViewById(R.id.num_cinco);
        num_seis = findViewById(R.id.num_seis);
        num_sete = findViewById(R.id.num_sete);
        num_oito = findViewById(R.id.num_oito);
        num_nove = findViewById(R.id.num_nove);
        opr_soma = findViewById(R.id.opr_soma);
        opr_subtracao = findViewById(R.id.opr_subtracao);
        opr_divisao = findViewById(R.id.opr_divisao);
        opr_multiplicacao = findViewById(R.id.opr_multiplicacao);
        opr_igual = findViewById(R.id.opr_igual);
        ponto = findViewById(R.id.ponto);
        resultado = findViewById(R.id.resultado);
        clear = findViewById(R.id.clear);

        num_zero.setOnClickListener(this);
        num_um.setOnClickListener(this);
        num_dois.setOnClickListener(this);
        num_tres.setOnClickListener(this);
        num_quatro.setOnClickListener(this);
        num_cinco.setOnClickListener(this);
        num_seis.setOnClickListener(this);
        num_sete.setOnClickListener(this);
        num_oito.setOnClickListener(this);
        num_nove.setOnClickListener(this);
        ponto.setOnClickListener(this);
        opr_divisao.setOnClickListener(this);
        opr_multiplicacao.setOnClickListener(this);
        opr_soma.setOnClickListener(this);
        opr_subtracao.setOnClickListener(this);
        opr_igual.setOnClickListener(this);
        clear.setOnClickListener(this);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.manu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.basicoActivit){
            startActivity(new Intent(MainActivity.this, MainActivity.class));
            return true;
        }

        if(id == R.id.avancadoActivit){
            startActivity(new Intent(MainActivity.this, AvancadoActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }



    public void capturarDados (String str, boolean concatena, boolean opr){

        if(concatena == true && opr == false){
            resultado.append(str);
        }else if (concatena == false ){
            if(valor1.isEmpty()){
                valor1 = String.valueOf(resultado.getText());
                operacao = str;
                resultado.setText("");
            }else if (valor2.isEmpty()){
                valor2 = String.valueOf(resultado.getText());
                valor1Float = Float.parseFloat(valor1);
                valor2Float = Float.parseFloat(valor2);
                if(operacao == "+"){
                    valorFinal = valor1Float + valor2Float;
                    String resp = valorFinal.toString();
                    resultado.setText(resp);
                }else if (operacao == "-"){
                    valorFinal = valor1Float - valor2Float;
                    String resp = valorFinal.toString();
                    resultado.setText(resp);
                }else if (operacao == "*"){
                    valorFinal = valor1Float * valor2Float;
                    String resp = valorFinal.toString();
                    resultado.setText(resp);
                }else if (operacao == "/"){
                    valorFinal = valor1Float / valor2Float;
                    String resp = valorFinal.toString();
                    resultado.setText(resp);
                }
            }
        }
    }

    public void limpaTexto(){
        valor1 = "";
        valor2 = "";
        resultado.setText("");
        operacao = "";
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.num_zero:
                capturarDados("0", true, false);
                break;
            case R.id.num_um:
                capturarDados("1", true,false);
                break;
            case R.id.num_dois:
                capturarDados("2", true,false);
                break;
            case R.id.num_tres:
                capturarDados("3", true, false);
                break;
            case R.id.num_quatro:
                capturarDados("4", true,false);
                break;
            case R.id.num_cinco:
                capturarDados("5", true,false);
                break;
            case R.id.num_seis:
                capturarDados("6", true,false);
                break;
            case R.id.num_sete:
                capturarDados("7", true,false);
                break;
            case R.id.num_oito:
                capturarDados("8", true,false);
                break;
            case R.id.num_nove:
                capturarDados("9", true,false);
                break;
            case R.id.ponto:
                capturarDados(".", true,false);
                break;
            case R.id.opr_soma:
                capturarDados("+", false, true);
                break;
            case R.id.opr_subtracao:
                capturarDados("-", false,true);
                break;
            case R.id.opr_divisao:
                capturarDados("/", false,true);
                break;
            case R.id.opr_multiplicacao:
                capturarDados("*", false,true);
                break;
            case R.id.opr_igual:
                capturarDados("=", false,true);
                break;
            case R.id.clear:
                limpaTexto();
                break;
        }
    }
}