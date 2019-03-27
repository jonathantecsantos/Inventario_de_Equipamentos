package com.example.inventario_layoutalternativo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    Spinner processadores;
    private SeekBar seekBar;
    private TextView textSeekbar;
    private String memoriaRAM;

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

    }
}
