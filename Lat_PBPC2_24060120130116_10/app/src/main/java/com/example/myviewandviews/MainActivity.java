package com.example.myviewandviews;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Thread view;
    private TextView tvNama, tvHarga;
    String nama, deskripsi, harga, jumlah;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvNama = findViewById(R.id.tv_nama);
        tvHarga = findViewById(R.id.tv_harga);

        nama = tvNama.getText().toString();
        harga = tvHarga.getText().toString();

        Button btnBeli = findViewById(R.id.btn_beli);
        btnBeli.setOnClickListener(this);

        Button btnDialPhone = findViewById(R.id.btn_cp);
        btnDialPhone.setOnClickListener(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(nama);
        }
    }

    @Override
    public void onClick(View view) {
        if(view.getId() ==  R.id.btn_beli){
            Intent moveIntent = new Intent(MainActivity.this, BeliActivity.class);
            moveIntent.putExtra(BeliActivity.EXTRA_NAMA, nama);
            moveIntent.putExtra(BeliActivity.EXTRA_HARGA, harga);
            startActivity(moveIntent);
        }
        else if (view.getId()== R.id.btn_cp){
            String phoneNumber = "082264524881";
            Intent dialPhoneIntent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNumber));
            startActivity(dialPhoneIntent);
        }
    }
}