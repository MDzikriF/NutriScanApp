<?php
$host = "localhost";
$user = "root";
$pass = "";
$db = "db_nutriscan";

$conn = new mysqli($host, $user, $pass, $db);

if ($_SERVER['REQUEST_METHOD'] == 'POST') {
    $nama = $_POST['nama'];
    $password = $_POST['password'];

    $sql = "SELECT * FROM tbl_user WHERE nama='$nama' AND password='$password'";
    $result = $conn->query($sql);

    if ($result && $result->num_rows > 0) {
        echo "success";
    } else {
        echo "invalid";
    }
}
?>
