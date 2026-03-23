package com.example.nutriscanapp;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log; // Pastikan import ini sudah ada
import android.view.View;
import android.widget.ImageView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

public class HomeActivity extends AppCompatActivity {

    TextView txtGreeting;
    Button btnLogout;
    ImageView btnChatAI, btnScan;
    LinearLayout layoutProfile, layoutBottomScan, layoutHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home_activity);

        // Inisialisasi komponen UI dari layout home_activity.xml
        txtGreeting = findViewById(R.id.txtGreeting);
        btnLogout = findViewById(R.id.btnLogout);
        btnChatAI = findViewById(R.id.btnChatAI);
        btnScan = findViewById(R.id.btnScan);
        layoutProfile = findViewById(R.id.layoutProfile);
        layoutBottomScan = findViewById(R.id.layoutBottomScan);
        layoutHistory = findViewById(R.id.layoutHistory);

        // Mengambil nama user yang diteruskan dari LoginActivity
        String namaUser = getIntent().getStringExtra("NAMA_USER");

        // --> TAMBAHKAN LOG 1: Untuk melihat apa yang diterima dari Intent <--
        Log.d("Home_Debug", "Menerima intent. Nilai NAMA_USER: '" + namaUser + "'");

        // Mengatur teks salam berdasarkan nama user yang diterima
        if (namaUser != null && namaUser.equalsIgnoreCase("admin")) {
            txtGreeting.setText("Halo, Admin Selamat Datang");
        } else if (namaUser != null && !namaUser.isEmpty()) {
            // --> TAMBAHKAN LOG 2: Untuk konfirmasi kondisi ini berjalan <--
            Log.d("Home_Debug", "Kondisi IF terpenuhi. Menampilkan nama.");
            txtGreeting.setText("Halo, " + namaUser + " Selamat Datang");
        } else {
            // --> TAMBAHKAN LOG 3: Untuk konfirmasi jika kondisi gagal <--
            Log.d("Home_Debug", "Kondisi IF GAGAL. Menampilkan teks default.");
            txtGreeting.setText("Halo, Selamat Datang");
        }

        // Menambahkan OnClickListener untuk tombol utama
        btnChatAI.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ChatAiActivity.class);
            startActivity(intent);
        });

        btnScan.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ScanActivity.class);
            startActivity(intent);
        });

        btnLogout.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, LoginActivity.class);
            startActivity(intent);
            finish();
        });

        layoutProfile.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
            intent.putExtra("NAMA_USER", namaUser);
            startActivity(intent);
        });

        layoutBottomScan.setOnClickListener(v -> {
            Intent intent = new Intent(HomeActivity.this, ScanActivity.class);
            startActivity(intent);
        });

        layoutHistory.setOnClickListener(v -> {
            // TODO: Tambahkan logika untuk membuka halaman Riwayat di sini
        });
    }
}