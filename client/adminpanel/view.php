<!DOCTYPE html>
<html>
<head>
 <title>Table with database</title>
 <style>
  table {
   border-collapse: collapse;
   width: 100%;
   color: #588c7e;
   font-family: monospace;
   font-size: 25px;
   text-align: left;
     } 
  th {
   background-color: #588c7e;
   color: white;
    }
  tr:nth-child(even) {background-color: #f2f2f2}
 </style>
</head>
<body>
 <table>
 <tr>
  <th>Id</th> 
  <th>Product Name</th> 
  <th>Price</th>
 </tr>
 <?php
$conn = mysqli_connect("sql12.freemysqlhosting.net", "sql12286772", "qDpvgqB9k8", "sql12286772");
  // Check connection
  if ($conn->connect_error) {
   die("Connection failed: " . $conn->connect_error);
  } 
  $sql = "SELECT id, productname, price FROM products";
  $result = $conn->query($sql);
  if ($result->num_rows > 0) {
   // output data of each row
   while($row = $result->fetch_assoc()) {
    echo "<tr><td>" . $row["id"]. "</td><td>" . $row["productname"] . "</td><td>"
. $row["price"]. "</td></tr>";
}
echo "</table>";
} else { echo ""; }
$conn->close();
?>
</table>
</body>
</html>