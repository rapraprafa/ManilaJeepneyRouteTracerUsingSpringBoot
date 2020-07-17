<?php

$productname = $_POST['productname'];

if (!empty($productname) || !empty($price))
{
    $host = "sql12.freemysqlhosting.net";
    $dbUsername = "sql12286772";
    $dbPassword = "qDpvgqB9k8";
    $dbname = "sql12286772"; //insert database name here

    //creating the connection
    $conn = new mysqli($host, $dbUsername, $dbPassword, $dbname);

    if (mysqli_connect_error()){
        die('Connect Error('.mysqli_connect_errno().')'. mysqli_connect_error());
    }
    else{
        $SELECT = "SELECT productname From products Where productname = ? Limit 1";
        $DELETE = "DELETE from products where productname='$productname'";
        
        $stmt = $conn->prepare($SELECT);
        $stmt->bind_param("s", $productname);
        $stmt->execute();
        $stmt->bind_result($productname);
        $stmt->store_result();
        $rnum = $stmt->num_rows;

        if($rnum!=0){
            $stmt->close();
            $stmt = $conn->prepare($DELETE);
            $stmt->bind_param("s", $productname);
            $stmt->execute();
            echo "Record deleted successfully";
        }
        else {
            echo "Product not in database!";
        }
    
        $stmt->close();
        $conn->close();
}
}
else
{
    echo "All field are required";
    die();
 }   
?>