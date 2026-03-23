<?php
$host = "localhost";
$user = "root";
$pass = "";
$db = "db_nutriscan";

$conn = new mysqli($host, $user, $pass, $db);

if ($conn->connect_error) {
    die("Koneksi gagal: " . $conn->connect_error);
}

// Ambil data yang dikirim dari aplikasi Android
$nama = $_POST['nama'];
$password = $_POST['password']; // Mengambil password asli (plain text)
$usia = $_POST['usia'];
$tinggi_badan = $_POST['tinggi_badan'];
$berat_badan = $_POST['berat_badan'];
$alergi = $_POST['alergi'];

// Cek apakah nama sudah terdaftar
$sql_check = "SELECT nama FROM tbl_user WHERE nama = ?";
$stmt_check = $conn->prepare($sql_check);
$stmt_check->bind_param("s", $nama);
$stmt_check->execute();
$result_check = $stmt_check->get_result();

if ($result_check->num_rows > 0) {
    echo "Gagal: Nama user sudah terdaftar!";
} else {
    // Jika nama belum ada, lakukan INSERT
    $sql_insert = "INSERT INTO tbl_user (nama, password, usia, tinggi_badan, berat_badan, alergi) VALUES (?, ?, ?, ?, ?, ?)";
    
    $stmt_insert = $conn->prepare($sql_insert);
    
    // Gunakan variabel $password langsung (bukan $hashed_password)
    // 'ssiiis' -> s:string, i:integer.
    $stmt_insert->bind_param("ssiiis", $nama, $password, $usia, $tinggi_badan, $berat_badan, $alergi);

    if ($stmt_insert->execute()) {
        echo "Pendaftaran Berhasil!";
    } else {
        echo "Gagal: " . $stmt_insert->error;
    }
    $stmt_insert->close();
}

$stmt_check->close();
$conn->close();
?>