# NutriScan App 🍎🔍

NutriScan App adalah aplikasi Android berbasis **Full Stack** yang dirancang untuk membantu pengguna memantau asupan gizi harian melalui fitur pemindaian nutrisi. Proyek ini mengintegrasikan aplikasi mobile sebagai frontend dan layanan API berbasis web sebagai backend.

---

## 🛠️ Teknologi yang Digunakan

- **Frontend (Mobile):** Android Studio (Java)
- **Backend (API):** PHP (Native/REST)
- **Database:** MySQL
- **Networking:** Volley / Retrofit (tergantung library yang digunakan di kode)

---

## 📂 Struktur Proyek

Repositori ini menyatukan dua komponen utama agar sistem dapat berjalan secara utuh:

- `/app`: Folder utama proyek Android (Java & XML).
- `/backend_api`: Berisi file API PHP dan skema database SQL.
    - `db_nutriscan.sql`: Struktur tabel database.
    - `login.php`: Autentikasi pengguna.
    - `signup.php`: Registrasi pengguna baru.
    - `get_profile.php`: Pengambilan data profil pengguna.

---

## 🚀 Fitur Utama

- **User Authentication:** Login dan registrasi akun.
- **Profile Management:** Mengatur data fisik pengguna untuk perhitungan nutrisi.
- **Nutrition Scanning:** Memindai data nutrisi makanan (Frontend-to-Backend integration).
- **Real-time Database:** Data tersimpan secara permanen di server MySQL.

---

## ⚙️ Cara Instalasi & Konfigurasi

### 1. Persiapan Backend (API)
1. Salin folder `backend_api` ke folder `htdocs` di server lokal (XAMPP).
2. Buka `phpMyAdmin` dan buat database baru bernama `db_nutriscan`.
3. Import file `db_nutriscan.sql` ke database tersebut.
4. Pastikan konfigurasi koneksi database di file PHP sudah sesuai dengan settingan MySQL kamu.

### 2. Persiapan Frontend (Android)
1. Buka folder `app` menggunakan Android Studio.
2. Cari variabel `BASE_URL` atau string URL di dalam kode Java (misalnya di `ProfileActivity.java`).
3. Sesuaikan alamat IP dengan IP komputer kamu atau gunakan `http://10.0.2.2/` jika menggunakan emulator Android bawaan.
4. *Build* dan jalankan aplikasi.

---

## 💡 Catatan Pengembangan
Proyek ini dikembangkan sebagai bagian dari portofolio pengembangan aplikasi mobile dan integrasi sistem backend menggunakan arsitektur Client-Server.

---
**Developed by [MDzikriF](https://github.com/MDzikriF)** *Informatics Student - Universitas Mercu Buana*
