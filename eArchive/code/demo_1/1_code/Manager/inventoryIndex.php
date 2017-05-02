<html lang="en">
<head>
  <meta charset="utf-8">

  <title>Inventory</title>
  <meta name="description" content="The HTML5 Herald">
  <meta name="author" content="SitePoint">

  <link rel="stylesheet" href="css/styles.css?v=1.0">

  <!--[if lt IE 9]>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.js"></script>
  <![endif]-->
</head>

<body>
  <script src="js/scripts.js"></script>
  <h1 align="center">Restaurant Inventory</h1>
<?php
//Connect to database
$con = mysql_connect("localhost", "root", "somethingstupid");
    if(!$con){
        die("Cannot connect: " . mysql_error());
    }
    
    mysql_select_db("zestware", $con);
    
if(isset($_POST['delete'])){
    $deleteQuery = "DELETE FROM inventory WHERE itemName='$_POST[itemName]'";
    mysql_query($deleteQuery, $con);
};
    
    $sql = "SELECT itemID, itemName, itemTotal, unitMeasurement, itemCostPerUnit FROM inventory";
    $itemNames = mysql_query($sql, $con);
    
    //echo "<br>";
    echo "<table align='center' border=1 id='inventory'>
    <tr>
    
    <th>Item Name</th>
    <th>Item ID</th>
    <th>Item Total</th>
    <th>Unit Measurement</th>
    <th>Cost Per Unit</th>
    </tr>";
    
    while($record = mysql_fetch_array($itemNames)){
        echo "<tr>";
        echo "<td>" . $record['itemName'] . "</td>";
        echo "<td>" . $record['itemID'] . "</td>";
        echo "<td>" . $record['itemTotal'] . "</td>";
        echo "<td>" . $record['unitMeasurement'] . "</td>";
        echo "<td>" . $record['itemCostPerUnit'] . "</td>";   
        echo "</tr>";
    }
    
    echo "</table>";
    
    mysql_close($con);

?>

<br>
<input type='button'value='Add Item' class="btn" onclick="document.location.href='addInventoryItem.php';"/>
    

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

<p><input type='button'value='Back to Portal' class="btn" onclick="document.location.href='../startbootstrap-simple-sidebar-gh-pages/index.html';"/></p>
  

</body>
</html>