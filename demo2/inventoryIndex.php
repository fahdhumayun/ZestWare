<!-- Written, tested, and debugged by Ama Freeman -->

<?php

session_start();

?>

<html lang="en">
<head>

  <style>
  table {
    font-family: georgia, sans-serif;
    border-collapse: collapse;
    font-size:20px;
    /*width: 100% */
  }
table caption { 
    padding: 10px;
    background: #FA6568;
    color: white;
    font-size: 30px;
  }

  td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
  }

  tr:nth-child(even) {
    background-color: #dddddd;
  }
  </style>
  <link rel="stylesheet" type="text/css" href="temp2.css"> 
  <meta charset="utf-8">


  <title>Inventory</title>
  <meta name="description" content="The HTML5 Herald">
  <meta name="author" content="SitePoint">

  
</head>

<body>

<?php

    if(!isset($_SESSION['manager'])) // If session is not set then redirect to Login Page
            {
                header("Location:https://zestware123.000webhostapp.com/startbootstrap-simple-sidebar-gh-pages/login.php");  
            }
?>
  

 <div class = "logo">
<a href="https://zestware123.000webhostapp.com/">
<img border="0" alt="logo" src="buttons/zesty.png"></a>
</div>

  <br>
  <br>
  <!--<h1 align="left">Restaurant Inventory</h1>-->
  <div class = "table">

<?php
//Connect to database
$con = mysqli_connect("localhost", "id964298_zestwaredatabase", "zestware123!", "id964298_zestdatabase");
    if(!$con){
        die("Cannot connect: " . mysqli_connect_error());
    }
    
    mysqli_select_db($con, "id964298_zestdatabase");
    
if(isset($_POST['delete'])){
    $deleteQuery = "DELETE FROM inventory WHERE itemName='$_POST[itemName]'";
    mysqli_query($con, $deleteQuery);
};
    
    $sql = "SELECT itemID, itemName, itemTotal, unitMeasurement, itemCostPerUnit FROM inventory";
    $itemNames = mysqli_query($con, $sql);
    
    echo "<br>";
    echo "<table align='center' border=1 id='inventory'>
    <caption>Restaurant Inventory</caption>
    <tr>
    
    <th>Item Name</th>
    <th>Item ID</th>
    <th>Item Total</th>
    <th>Unit Measurement</th>
    <th>Cost Per Unit</th>
    </tr>";
    
    while($record = mysqli_fetch_array($itemNames)){
        echo "<tr>";
        echo "<td>" . $record['itemName'] . "</td>";
        echo "<td>" . $record['itemID'] . "</td>";
        echo "<td>" . $record['itemTotal'] . "</td>";
        echo "<td>" . $record['unitMeasurement'] . "</td>";
        echo "<td>" . $record['itemCostPerUnit'] . "</td>";   

    }
    
    echo "</table>";
    
    mysqli_close($con);

?>
</div>

<br>
<br>
<input type='button'value='Add Item' class="btn" onclick="document.location.href='https://zestware123.000webhostapp.com/addInventoryItem.php';"/>

<!--We3schools sorting algorithm-->
<p><button onclick="sortTable()">Alphabetical Sort</button></p>

<script>
function sortTable() {
  var table, rows, switching, i, x, y, shouldSwitch;
  table = document.getElementById("inventory");
  switching = true;
  /*Make a loop that will continue until
  no switching has been done:*/
  while (switching) {
    //start by saying: no switching is done:
    switching = false;
    rows = table.getElementsByTagName("TR");
    /*Loop through all table rows (except the
    first, which contains table headers):*/
    for (i = 1; i < (rows.length - 1); i++) {
      //start by saying there should be no switching:
      shouldSwitch = false;
      /*Get the two elements you want to compare,
      one from current row and one from the next:*/
      x = rows[i].getElementsByTagName("TD")[0];
      y = rows[i + 1].getElementsByTagName("TD")[0];
      //check if the two rows should switch place:
      if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {
        //if so, mark as a switch and break the loop:
        shouldSwitch= true;
        break;
      }
    }
    if (shouldSwitch) {
      /*If a switch has been marked, make the switch
      and mark that a switch has been done:*/
      rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
      switching = true;
    }
  }
}
</script>

  <br>
  <br>
  <br>

  <input type="image" src ="buttons/LogOut.png" alt="Submit" class = "LogOut" onclick="document.location.href='../startbootstrap-simple-sidebar-gh-pages/logout.php';">
  

</body>
