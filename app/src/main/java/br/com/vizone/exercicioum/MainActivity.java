package br.com.vizone.exercicioum;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView txtValorUm;
    TextView txtValorDois;
    TextView txtValorTres;

    CheckBox chkUm;
    CheckBox chkDois;
    CheckBox chkTres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtValorUm = findViewById(R.id.txtValorUm);
        txtValorDois = findViewById(R.id.txtValorDois);
        txtValorTres = findViewById(R.id.txtValorTres);

        chkUm = findViewById(R.id.chkUm);
        chkDois = findViewById(R.id.chkDois);
        chkTres = findViewById(R.id.chkTres);

    }

    public void comprar(View view) {
        double valorTotal = 0.0;
        Double valorUm = Double.parseDouble(txtValorUm.getText().toString());
        Double valorDois = Double.parseDouble(txtValorDois.getText().toString());
        Double valorTres = Double.parseDouble(txtValorTres.getText().toString());

        if(!chkUm.isChecked())
            valorUm = 0.0;
        if(!chkDois.isChecked())
            valorDois = 0.0;
        if(!chkTres.isChecked())
            valorTres = 0.0;
        valorTotal = valorUm + valorDois + valorTres;

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.importante);
        builder.setMessage( getString(R.string.deseja_comprar) + getString(R.string.valor_foi) + valorTotal);
        builder.setPositiveButton(getString(R.string.sim), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Compra realizada", Toast.LENGTH_SHORT).show();
            }
        });
        builder.setNegativeButton(getString(R.string.nao), null);
        builder.show();
    }

    public void verLancheUm(View view) {
        Intent it = new Intent(this, Lanche01Activity.class);
        startActivity(it);
    }
    public void verLancheDois(View view) {
        Intent it = new Intent(this, Lanche02Activity.class);
        startActivity(it);
    }
    public void verLancheTres(View view) {
        Intent it = new Intent(this, Lanche03Activity.class);
        startActivity(it);
    }
}
