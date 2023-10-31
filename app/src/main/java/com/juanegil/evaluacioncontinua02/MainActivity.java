package com.juanegil.evaluacioncontinua02;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.juanegil.evaluacioncontinua02.UI.NuevoPlatoActivity;
import com.juanegil.evaluacioncontinua02.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        initListener();
    }

    private void initListener() {
        binding.btnPlatosNuevos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), NuevoPlatoActivity.class);
                startActivity(intent);
            }
        });
    }
}