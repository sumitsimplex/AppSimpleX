<?php
    require("password.php");
    $connect = mysqli_connect("my_host", "my_user", "my_password", "my_database");

    $full_name = $_POST["full_name"];
    $email = $_POST["email"];
    $username = $_POST["username"];
    $password = $_POST["password"];
    $country = $_POST["country"];
    $phone = $_POST["phone"];

     function registerUser() {
        global $connect, $name, $age, $username, $password;
        $passwordHash = password_hash($password, PASSWORD_DEFAULT);
        $statement = mysqli_prepare($connect, "INSERT INTO user (full_name, email, username, password, country, phone) VALUES (?,?, ?, ?, ?, ?)");
        mysqli_stmt_bind_param($statement, "ssssss", $full_name, $email, $username, $passwordHash, $country, $phone);
        mysqli_stmt_execute($statement);
        mysqli_stmt_close($statement);
    }
    function usernameAvailable() {
        global $connect, $username;
        $statement = mysqli_prepare($connect, "SELECT * FROM user WHERE username = ?");
        mysqli_stmt_bind_param($statement, "s", $username);
        mysqli_stmt_execute($statement);
        mysqli_stmt_store_result($statement);
        $count = mysqli_stmt_num_rows($statement);
        mysqli_stmt_close($statement);
        if ($count < 1){
            return true;
        }else {
            return false;
        }
    }
    $response = array();
    $response["success"] = false;
    if (usernameAvailable()){
        registerUser();
        $response["success"] = true;
    }

    echo json_encode($response);
?>