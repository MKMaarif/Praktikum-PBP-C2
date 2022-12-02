// Nama : M. Khoirul Ma'arif
// NIM  : 24060120130116
// Praktikum PBP Lab C2

//Membuat package
package com.example.myapplication;

//Mengimport library
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//Membuat class MainActivity
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //Inisialisasi variabel
    private EditText edtWidth;
    private EditText edtHeight;
    private EditText edtLength;
    private Button btnCalculate;
    private TextView tvResult;

    //Membuat method onCreate
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Menghubungkan class MainActivity dengan layout activity_main.xml
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Menghubungkan variabel dengan komponen pada layout
        edtWidth = findViewById(R.id.edt_width);
        edtHeight = findViewById(R.id.edt_height);
        edtLength = findViewById(R.id.edt_length);
        btnCalculate = findViewById(R.id.btn_calculate);
        tvResult = findViewById(R.id.tv_result);

        //Membuat method saveInstanceState
        btnCalculate.setOnClickListener(this);

        //Membuat method saveInstanceState
        if (savedInstanceState != null) {
            String result = savedInstanceState.getString(STATE_RESULT);
            tvResult.setText(result);
        }
    }

    //Membuat method onClick
    @Override
    public void onClick(View v) {
        //Membuat kondisi jika tombol btnCalculate diklik
        if (v.getId() == R.id.btn_calculate) {
            String inputLength = edtLength.getText().toString().trim();
            String inputWidth = edtWidth.getText().toString().trim();
            String inputHeight = edtHeight.getText().toString().trim();
            boolean isEmptyFields = false;
            //Membuat kondisi jika inputan kosong
            if (TextUtils.isEmpty(inputLength)) {
                isEmptyFields = true;
                edtLength.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputWidth)) {
                isEmptyFields = true;
                edtWidth.setError("Field ini tidak boleh kosong");
            }
            if (TextUtils.isEmpty(inputHeight)) {
                isEmptyFields = true;
                edtHeight.setError("Field ini tidak boleh kosong");
            }
            //Membuat kondisi jika inputan tidak kosong, akan menghitung volume
            if (!isEmptyFields) {
                double volume = Double.valueOf(inputLength) * Double.valueOf(inputWidth) * Double.valueOf(inputHeight);
                tvResult.setText(String.valueOf(volume));
            }
        }
    }

    //Membuat private static final String STATE_RESULT
    private static final String STATE_RESULT = "state_result";
    //Membuat method onSaveInstanceState untuk menyimpan data
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(STATE_RESULT, tvResult.getText().toString());
    }

}