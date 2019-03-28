package com.example.inventario_layoutalternativo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity {


    Spinner processadores;
    private SeekBar seekBar;
    private TextView textSeekbar;
    private String memoriaRAM;
    private int incrementador = 0;

    private DatabaseReference referencia = FirebaseDatabase.getInstance().getReference();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        processadores = findViewById(R.id.spinner_processadores);
        seekBar = findViewById(R.id.seekBar);
        textSeekbar = findViewById(R.id.textSeekbar);


        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.spinner_processadores, android.R.layout.simple_spinner_item);
        processadores.setAdapter(adapter);


        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textSeekbar.setText(seekBar.getProgress() + " GB");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        DatabaseReference dados = referencia.child("dados");

        Equipamento equipamento2 = new Equipamento();
        equipamento2.setUsuario("Lourena");
        equipamento2.setLocal("Tesouraria");
        dados.child(String.valueOf(incrementador)).setValue(equipamento2);
        incrementador ++;

        Equipamento equipamento3 = new Equipamento();
        equipamento3.setUsuario("Danielly");
        equipamento3.setLocal("Tesouraria");
        dados.child(String.valueOf(incrementador)).setValue(equipamento3);

    }
}

