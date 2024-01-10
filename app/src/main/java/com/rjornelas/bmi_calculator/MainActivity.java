package com.rjornelas.bmi_calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;

import com.rjornelas.bmi_calculator.databinding.ActivityMainBinding;

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


    }

    private void initUiValues() {
        binding.sbHeight.setProgress(0);
        binding.edHeight.setText("60");
        binding.edWeight.setText("30");
        binding.edAge.setText("10");
    }
}