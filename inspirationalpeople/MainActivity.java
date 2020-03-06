package com.example.inspirationalpeople;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String[] Records = {
            "Veldin Karić je u 1. HNL postigao je 75 pogodaka te je na jedanaestom mjestu liste najboljih strijelaca u povijesti 1. HNL.",
            "C. Ronaldo ima najviše pogodaka u Ligi prvaka - 120.",
            "Luka Modrić je najbolji europski razigravač: 2008./09."
    };

    private void displayToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    ImageView ivVeldinKaric;
    ImageView ivCRonaldo;
    ImageView ivModric;

    Button btnInspiration;
    Button btnEnter;

    EditText etDescription;

    RadioButton rbVeldin;
    RadioButton rbCRonaldo;
    RadioButton rbModric;

    TextView tvVeldinDescription;
    TextView tvCRDescription;
    TextView tvModricDescription;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeUI();
    }

    private void initializeUI(){
        this.ivVeldinKaric = (ImageView) findViewById(R.id.ivVeldinKaric);
        this.ivCRonaldo = (ImageView) findViewById(R.id.ivCRonaldo);
        this.ivModric = (ImageView) findViewById(R.id.ivModric);
        this.tvVeldinDescription = (TextView) findViewById(R.id.tvVeldinDescription);
        this.tvCRDescription = (TextView) findViewById(R.id.tvCRDescription);
        this.tvModricDescription = (TextView) findViewById(R.id.tvModricDescription);
        this.btnEnter = (Button) findViewById(R.id.btnEnter);
        this.btnInspiration = (Button) findViewById(R.id.btnInspiration);
        this.etDescription = (EditText) findViewById(R.id.etDescription);

        this.rbVeldin = (RadioButton) findViewById(R.id.rbVeldin);
        this.rbCRonaldo = (RadioButton) findViewById(R.id.rbCRonaldo);
        this.rbModric = (RadioButton) findViewById(R.id.rbModric);

        this.ivVeldinKaric.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                ivVeldinKaric.setVisibility(View.INVISIBLE);
            }
        });

        this.ivCRonaldo.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                ivCRonaldo.setVisibility(View.INVISIBLE);
            }
        });

        this.ivModric.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                ivModric.setVisibility(View.INVISIBLE);
            }
        });
        this.btnEnter.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                String description = etDescription.getText().toString();

                if(rbVeldin.isChecked()){
                    tvVeldinDescription.setText(description);
                    rbVeldin.setChecked(false);
                }
                else if(rbCRonaldo.isChecked()){
                    tvCRDescription.setText(description);
                    rbCRonaldo.setChecked(false);
                }
                else if(rbModric.isChecked()){
                    tvModricDescription.setText(description);
                    rbModric.setChecked(false);
                }
                else if(rbVeldin.isChecked() && rbCRonaldo.isChecked()){
                    tvVeldinDescription.setText(description);
                    tvCRDescription.setText(description);
                    rbVeldin.setChecked(false);
                    rbCRonaldo.setChecked(false);
                }
                else if(rbVeldin.isChecked() && rbModric.isChecked()){
                    tvVeldinDescription.setText(description);
                    tvModricDescription.setText(description);
                    rbVeldin.setChecked(false);
                    rbModric.setChecked(false);
                }
                else if(rbCRonaldo.isChecked() && rbModric.isChecked()){
                    tvCRDescription.setText(description);
                    tvModricDescription.setText(description);
                    rbCRonaldo.setChecked(false);
                    rbModric.setChecked(false);
                }
                else if(rbVeldin.isChecked() && rbCRonaldo.isChecked() && rbModric.isChecked()){
                    tvVeldinDescription.setText(description);
                    tvCRDescription.setText(description);
                    tvModricDescription.setText(description);
                    rbVeldin.setChecked(false);
                    rbCRonaldo.setChecked(false);
                    rbModric.setChecked(false);
                }
            }
        });
        this.btnInspiration.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Random randomGenerator = new Random();
                int number = randomGenerator.nextInt(3);
                if (number == 0){
                    displayToast(Records[0]);
                }
                else if(number == 1) {
                    displayToast(Records[1]);
                }
                else if(number == 2) {
                    displayToast(Records[2]);
                }
            }
        });
    }


}
