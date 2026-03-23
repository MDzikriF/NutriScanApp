package com.example.nutriscanapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView; // Kita butuh TextView untuk nama
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class ProfileActivity extends AppCompatActivity {

    EditText etUsia, etAlergi, etTinggi, etBerat;
    TextView tvNamaUser; // TextView untuk menampilkan nama user
    Button btnLogout;

//    String url = "http://192.168.201.170/nutriscan/get_profile.php"; // URL ke API baru kita
    String url = "http://10.0.2.2/nutriscan/get_profile.php"; // URL ke API baru kita

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);

        etUsia = findViewById(R.id.etUsia);
        etAlergi = findViewById(R.id.etAlergi);
        etTinggi = findViewById(R.id.etTinggi);
        etBerat = findViewById(R.id.etBerat);
        btnLogout = findViewById(R.id.btnLogout);
        tvNamaUser = findViewById(R.id.tvNamaUser); // Pastikan ID ini ada di XML Anda untuk TextView "Nama User"

        // 1. Ambil nama user yang dikirim dari LoginActivity
        String namaUser = getIntent().getStringExtra("NAMA_USER");

        // Jika nama user ada, ambil data profilnya
        if (namaUser != null && !namaUser.isEmpty()) {
            fetchProfileData(namaUser);
        } else {
            Toast.makeText(this, "Tidak bisa mendapatkan data user.", Toast.LENGTH_SHORT).show();
        }

        btnLogout.setOnClickListener(v -> {
            Intent intent = new Intent(ProfileActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }

    private void fetchProfileData(String nama) {
        // Buat URL lengkap dengan parameter nama
        String url_get_data = url + "?nama=" + nama;

        StringRequest request = new StringRequest(Request.Method.GET, url_get_data,
                response -> {
                    try {
                        // 2. Parse response JSON dari server
                        JSONObject jsonObject = new JSONObject(response);
                        String status = jsonObject.getString("status");

                        if (status.equals("success")) {
                            // 3. Jika sukses, ambil data object
                            JSONObject data = jsonObject.getJSONObject("data");

                            String namaDariDb = data.getString("nama");
                            int usia = data.optInt("usia", 0); // optInt jika data bisa null
                            String alergi = data.optString("alergi", "-");
                            int tinggi = data.optInt("tinggi_badan", 0);
                            int berat = data.optInt("berat_badan", 0);

                            // 4. Tampilkan data ke UI
                            tvNamaUser.setText(namaDariDb);
                            etUsia.setText(String.valueOf(usia)); // konversi int ke String
                            etAlergi.setText(alergi);
                            etTinggi.setText(String.valueOf(tinggi));
                            etBerat.setText(String.valueOf(berat));

                        } else {
                            // Jika status dari server adalah "error"
                            String message = jsonObject.getString("message");
                            Toast.makeText(ProfileActivity.this, message, Toast.LENGTH_SHORT).show();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(ProfileActivity.this, "Error parsing data!", Toast.LENGTH_SHORT).show();
                    }
                },
                error -> {
                    error.printStackTrace();
                    Toast.makeText(ProfileActivity.this, "Gagal konek ke server: " + error.getMessage(), Toast.LENGTH_LONG).show();
                });

        RequestQueue queue = Volley.newRequestQueue(this);
        queue.add(request);
    }
}