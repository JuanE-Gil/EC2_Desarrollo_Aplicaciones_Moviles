package com.juanegil.evaluacioncontinua02.UI;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.juanegil.evaluacioncontinua02.databinding.ActivityConsultarPlatosBinding;

public class ConsultarPlatosActivity extends AppCompatActivity {

    private ActivityConsultarPlatosBinding binding;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityConsultarPlatosBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        initListener();
    }

    private void initListener() {

    }
}