package com.example.nutriscanapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class ChatAiActivity extends AppCompatActivity {

    private EditText messageInput;
    private ImageButton sendButton;
    private ImageView homeIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chatai_activity);

        messageInput = findViewById(R.id.messageInput);
        sendButton = findViewById(R.id.sendButton);
        homeIcon = findViewById(R.id.homeIcon); // ⬅ tombol home dari layout

        // Tombol kirim
        sendButton.setOnClickListener(v -> {
            String message = messageInput.getText().toString().trim();
            if (!message.isEmpty()) {
                Toast.makeText(this, "Mengirim: " + message, Toast.LENGTH_SHORT).show();
                messageInput.setText("");
            }
        });

        // Tombol home
        homeIcon.setOnClickListener(v -> {
            Intent intent = new Intent(ChatAiActivity.this, HomeActivity.class);
            // optional: hapus activity dari backstack agar tidak bisa balik ke ChatAiActivity saat tekan back
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
}