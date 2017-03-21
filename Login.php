<?php
    require("password.php");
    $con = mysqli_connect("my_host", "my_user", "my_password", "my_database");

    $username = $_POST["username"];
    $password = $_POST["password"];

    $statement = mysqli_prepare($con, "SELECT * FROM user WHERE username = ?");
    mysqli_stmt_bind_param($statement, "s", $username);
    mysqli_stmt_execute($statement);
    mysqli_stmt_store_result($statement);
    mysqli_stmt_bind_result($statement, $full_name, $email, $username, $colPassword, $country, $phone);

    $response = array();
    $response["success"] = false;

    while(mysqli_stmt_fetch($statement)){
        if (password_verify($password, $colPassword)) {
            $response["success"] = true;
            $response["name"] = $full_name;

        }
    }
    echo json_encode($response);
?>