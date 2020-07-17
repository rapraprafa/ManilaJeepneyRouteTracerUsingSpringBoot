<?php

$report = $_POST['report'];

if (!empty($report))
{
    $host = "localhost";
    $dbUsername = "root";
    $dbPassword = "";
    $dbname = "productsystem"; //insert database name here

    //creating the connection
    $conn = new mysqli($host, $dbUsername, $dbPassword, $dbname);

    if (mysqli_connect_error()){
        die('Connect Error('.mysqli_connect_errno().')'. mysqli_connect_error());
    }
    else{
        $SELECT = "SELECT reportlog From reports";
        $INSERT = "INSERT Into products(reportlog) values (?)";
        
        $stmt = $conn->prepare($SELECT);
        $stmt->execute();
        $stmt->store_result();
        $stmt->close();
        $stmt = $conn->prepare($INSERT);
        $stmt->execute();
        echo "Record added successfully";
        }
    
        $stmt->close();
        $conn->close();
    }
else
{
    echo "All field are required";
    die();
 }   
?>