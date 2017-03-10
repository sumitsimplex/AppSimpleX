<?php

    $response = array();
    $response["success"] = false;
    $connect = mysqli_connect("localhost", "id1004610_simplexudb", "SimplexUDB@123", "id1004610_usersdb");
/* check connection */
if (!$connect ) {
    printf("Connect failed: %s\n", mysqli_connect_error());
    exit();
}
    $full_name = $_POST["full_name"];
    $email = $_POST["email"];
    $username = $_POST["username"];
    $password = $_POST["password"];
    $country = $_POST["country"];
    $phone = $_POST["phone"];

     function registerUser() {
        global $connect, $full_name, $email, $username, $password, $country, $phone;

        $statement = mysqli_prepare($connect, "INSERT INTO user_data (full_name, email, username, password, country, phone) VALUES (?,?, ?, ?, ?, ?)");
        mysqli_stmt_bind_param($statement, "ssssss", $full_name, $email, $username, $password, $country, $phone);
        mysqli_stmt_execute($statement);
        mysqli_stmt_close($statement);
    }
    function usernameAvailable() {
        global $connect, $username;
        $statement = mysqli_prepare($connect, "SELECT * FROM user_data WHERE username = ?");
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

    if (usernameAvailable()){
        registerUser();
        $response["success"] = true;
    }

    echo json_encode($response);
?>