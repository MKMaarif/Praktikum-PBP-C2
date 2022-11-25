package com.example.myviewandviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class BeliActivity extends AppCompatActivity implements View.OnClickListener{
    public  static final String EXTRA_NAMA = "extra_nama";
    public  static final String EXTRA_HARGA = "extra_harga";

    private TextView tvNama, tvHarga;
    private String nama, harga;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beli);

        tvNama = findViewById(R.id.tv_nama_beli);
        tvHarga = findViewById(R.id.tv_harga_beli);

        nama = getIntent().getStringExtra(EXTRA_NAMA);
        harga = getIntent().getStringExtra(EXTRA_HARGA);

        tvNama.setText(nama);
        tvHarga.setText(harga);

        Button btnKembali = findViewById(R.id.btn_kembali);
        btnKembali.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if(view.getId() ==  R.id.btn_kembali){
            Intent moveIntent = new Intent(BeliActivity.this, MainActivity.class);
            startActivity(moveIntent);
        }
    }
}
