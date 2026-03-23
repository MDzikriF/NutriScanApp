package com.example.nutriscanapp;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import java.util.HashMap;
import java.util.Map;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

public class SignUpActivity extends AppCompatActivity {

    EditText edtNama, edtPassword, edtUsia, edtTinggi, edtBerat;
    Spinner spinnerAlergi;
    Button btnMulai;
    TextView txtToLogin;

    String URL = "http://10.0.2.2/nutriscan/signup.php"; // Ganti dengan IP kamu jika pakai HP asli
//    String URL = "http://192.168.201.170/nutriscan/signup.php"; // Pastikan usb tetring nyala

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_activity);

        // Inisialisasi komponen
        edtNama = findViewById(R.id.editNama);
        edtPassword = findViewById(R.id.passwordField);
        edtUsia = findViewById(R.id.editUsia);
        edtTinggi = findViewById(R.id.editTinggi);
        edtBerat = findViewById(R.id.editBerat);
        spinnerAlergi = findViewById(R.id.spinnerAlergi);
        btnMulai = findViewById(R.id.btnMulai);
        txtToLogin = findViewById(R.id.txtToLogin);

        // Spinner Alergi
        String[] daftarAlergi = {
                "Pilih Alergi", "Kacang", "Susu", "Telur", "Seafood", "Gandum", "Lainnya"
        };
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, daftarAlergi);
        spinnerAlergi.setAdapter(adapter);

        // Pindah ke Login
        txtToLogin.setOnClickListener(v -> {
            startActivity(new Intent(SignUpActivity.this, LoginActivity.class));
            finish();
        });

        // Ketika tombol sign up ditekan
        btnMulai.setOnClickListener(v -> {
            final String nama = edtNama.getText().toString().trim();
            final String password = edtPassword.getText().toString().trim();
            final String usia = edtUsia.getText().toString().trim();
            final String tinggi = edtTinggi.getText().toString().trim();
            final String berat = edtBerat.getText().toString().trim();
            final String alergi = spinnerAlergi.getSelectedItem().toString();

            // Validasi
            if (nama.isEmpty() || password.isEmpty() || usia.isEmpty() || tinggi.isEmpty() || berat.isEmpty()) {
                Toast.makeText(SignUpActivity.this, "Semua field harus diisi", Toast.LENGTH_SHORT).show();
                return;
            }

            if (alergi.equals("Pilih Alergi")) {
                Toast.makeText(SignUpActivity.this, "Silakan pilih alergi", Toast.LENGTH_SHORT).show();
                return;
            }

            // Kirim ke server
            ProgressDialog progressDialog = new ProgressDialog(SignUpActivity.this);
            progressDialog.setMessage("Mendaftarkan...");
            progressDialog.show();

            StringRequest stringRequest = new StringRequest(Request.Method.POST, URL,
                    response -> {
                        progressDialog.dismiss();
                        Toast.makeText(SignUpActivity.this, response, Toast.LENGTH_LONG).show();
                    },
                    error -> {
                        progressDialog.dismiss();
                        Toast.makeText(SignUpActivity.this, "Gagal konek ke server", Toast.LENGTH_SHORT).show();
                        Log.e("VOLLEY_ERROR", error.toString());  // <-- Tambahkan ini
                    }) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<>();
                    params.put("nama", nama);
                    params.put("password", password);
                    params.put("usia", usia);
                    params.put("tinggi_badan", tinggi);
                    params.put("berat_badan", berat);
                    params.put("alergi", alergi);
                    return params;
                }
            };

            // Tambahkan ke antrean request
            VolleySingleton.getInstance(SignUpActivity.this).addToRequestQueue(stringRequest);
        });
    }
}
