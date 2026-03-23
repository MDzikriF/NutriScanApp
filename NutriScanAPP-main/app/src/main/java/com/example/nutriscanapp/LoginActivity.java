package com.example.nutriscanapp;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity {

    EditText namaField, passwordField;
    Button btnLogin;
    TextView txtToSignUp;

    // ================== PUSAT PENGATURAN IP MANUAL ==================
    // HAPUS TANDA COMMENT (//) PADA BARIS YANG INGIN ANDA GUNAKAN

    // Gunakan baris ini jika Anda menjalankan di EMULATOR
    String url = "http://10.0.2.2/nutriscan/login.php";

    // Gunakan baris ini jika Anda menjalankan di HP FISIK (ganti IP sesuai USB Tethering)
//     String url = "http://192.168.201.170/nutriscan/login.php";
    // =================================================================

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_activity);

        namaField = findViewById(R.id.namaField);
        passwordField = findViewById(R.id.passwordField);
        btnLogin = findViewById(R.id.btnLogin);
        txtToSignUp = findViewById(R.id.txtToSignUp);

        btnLogin.setOnClickListener(v -> {
            String nama = namaField.getText().toString().trim();
            String password = passwordField.getText().toString().trim();

            if (nama.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Nama dan Password tidak boleh kosong", Toast.LENGTH_SHORT).show();
                return;
            }

            ProgressDialog progressDialog = new ProgressDialog(LoginActivity.this);
            progressDialog.setMessage("Logging in...");
            progressDialog.show();

            // Kode ini akan langsung menggunakan variabel 'url' yang Anda atur di atas
            StringRequest request = new StringRequest(Request.Method.POST, url,
                    response -> {
                        progressDialog.dismiss();
                        Log.d("Server_Response", "Respon dari server: [" + response + "]");

                        if (response.trim().equalsIgnoreCase("success")) {
                            Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                            Log.d("Login_Debug", "Login sukses. Mengirim nama: '" + nama + "'");
                            intent.putExtra("NAMA_USER", nama);
                            startActivity(intent);
                            finish();
                        } else {
                            Toast.makeText(LoginActivity.this, "Nama atau password salah", Toast.LENGTH_SHORT).show();
                        }
                    },
                    error -> {
                        progressDialog.dismiss();
                        Toast.makeText(LoginActivity.this, "Gagal konek ke server: " + error.getMessage(), Toast.LENGTH_LONG).show();
                    }) {
                @Override
                protected Map<String, String> getParams() {
                    Map<String, String> params = new HashMap<>();
                    params.put("nama", nama);
                    params.put("password", password);
                    return params;
                }
            };

            RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
            queue.add(request);
        });

        txtToSignUp.setOnClickListener(v -> {
            startActivity(new Intent(LoginActivity.this, SignUpActivity.class));
        });
    }
}