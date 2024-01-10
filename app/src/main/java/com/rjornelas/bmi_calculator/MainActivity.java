package com.rjornelas.bmi_calculator;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import com.rjornelas.bmi_calculator.databinding.ActivityMainBinding;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private String type;
    private String height;
    private String weight;
    private String age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        initUiValues();

        binding.ivMale.setOnClickListener(v -> {
            type = "Male";
            binding.clMale.setBackgroundColor(Color.GRAY); //TODO
        });
        binding.ivFemale.setOnClickListener(v -> {
            type = "Female";
            binding.clFemale.setBackgroundColor(Color.GRAY); //TODO
        });
        binding.sbHeight.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                binding.edHeight.setText(String.valueOf(progress));
            }
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
        binding.ivMinusBtnAge.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!binding.edAge.getText().toString().isEmpty()){
                    int age = Integer.parseInt(binding.edAge.getText().toString());
                    if(age > 0){
                        binding.edAge.setText(String.valueOf(age - 1));
                    }
                }
            }
        });
        binding.ivPlusBtnAge.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!binding.edAge.getText().toString().isEmpty()){
                    int age = Integer.parseInt(binding.edAge.getText().toString());
                    if(age >= 0 && age < 999){
                        binding.edAge.setText(String.valueOf(age + 1));
                    }
                }
            }
        });
        binding.ivPlusBtnWeight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!binding.edWeight.getText().toString().isEmpty()){
                    int age = Integer.parseInt(binding.edWeight.getText().toString());
                    if(age >= 0 && age < 999){
                        binding.edWeight.setText(String.valueOf(age + 1));
                    }
                }
            }
        });
        binding.ivMinusBtnWeight.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(!binding.edWeight.getText().toString().isEmpty()){
                    int age = Integer.parseInt(binding.edWeight.getText().toString());
                    if(age > 0){
                        binding.edWeight.setText(String.valueOf(age - 1));
                    }
                }
            }
        });

        binding.btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showBmiResult();
            }
        });
    }

    private void showBmiResult() {
        String resultText = String.format("Your BMI is: %.2f", calculateBmi());

        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setTitle("BMI");
        alertDialogBuilder.setMessage(resultText);
        alertDialogBuilder.setPositiveButton("DONE", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                binding.edHeight.setText("60");
                binding.edWeight.setText("30");
            }
        });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    private double calculateBmi() {
        double weight = Integer.parseInt(binding.edWeight.getText().toString());
        double height = Integer.parseInt(binding.edHeight.getText().toString());
        return (weight/((height/100)*(height/100)));
    }

    private void initUiValues() {
        binding.sbHeight.setProgress(0);
        binding.edHeight.setText("60");
        binding.edWeight.setText("30");
        binding.edAge.setText("10");
    }
}