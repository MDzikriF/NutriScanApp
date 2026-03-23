<?php
// File ini akan mengambil data profil berdasarkan nama dan mengembalikannya sebagai JSON

// Sambungkan ke database (asumsi Anda punya file koneksi, jika tidak, masukkan detail koneksi di sini)
$host = "localhost";
$user = "root";
$pass = "";
$db = "db_nutriscan";

$conn = new mysqli($host, $user, $pass, $db);

// Set header agar outputnya dianggap sebagai JSON oleh Android
header('Content-Type: application/json');

// Pastikan ada parameter 'nama' yang dikirim melalui URL
if (isset($_GET['nama'])) {
    $nama = $_GET['nama'];

    // KODE FINAL YANG BERSIH DAN BENAR
    $sql = "SELECT nama, usia, alergi, tinggi_badan, berat_badan FROM tbl_user WHERE nama = ?";
    $stmt = $conn->prepare($sql);
    $stmt->bind_param("s", $nama);
    $stmt->execute();
    $result = $stmt->get_result();

    if ($result && $result->num_rows > 0) {
        // Jika data ditemukan, ubah menjadi array
        $user_data = $result->fetch_assoc();
        
        // Buat response sukses
        $response = [
            'status' => 'success',
            'data' => $user_data
        ];
    } else {
        // Jika user tidak ditemukan
        $response = [
            'status' => 'error',
            'message' => 'User tidak ditemukan'
        ];
    }
    $stmt->close();
} else {
    // Jika tidak ada parameter nama yang dikirim
    $response = [
        'status' => 'error',
        'message' => 'Parameter nama tidak ditemukan'
    ];
}

// Cetak response dalam format JSON
echo json_encode($response);

$conn->close();
?>