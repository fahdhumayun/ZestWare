<!--
Written, tested, and debugged by: Ama Freeman
-->
<html lang="en">
<head>
  <meta charset="utf-8">

  <title>Employees</title>
  <meta name="description" content="The HTML5 Herald">
  <meta name="author" content="SitePoint">

  <link rel="stylesheet" href="startbootstrap-simple-sidebar-gh-pages/css/styles.css?v=1.0">

  <!--[if lt IE 9]>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/html5shiv/3.7.3/html5shiv.js"></script>
  <![endif]-->
</head>

<body>
  <script src="startbootstrap-simple-sidebar-gh-pages/js/scripts.js"></script>
  <h1 align="center">Employee List</h1>
<?php
//Connect to database
$con = mysqli_connect("localhost", "id964298_zestwaredatabase", "zestware123!", "id964298_zestdatabase");
    if(!$con){
        die("Cannot connect: " . mysql_connect_error());
    }
    
    mysqli_select_db($con, "id964298_zestdatabase");
    
if(isset($_POST['delete'])){
    $deleteQuery = "DELETE FROM inventory WHERE itemName='$_POST[itemName]'";
    mysqli_query($con, $deleteQuery);
};
    
    $sql = "SELECT firstName, lastName, wage, type FROM employees";
    $employees = mysqli_query($con, $sql);
    
    //echo "<br>";
    echo "<table align='center' border=1 id='employees'>
    <tr>
    
    <th>Last Name</th>
    <th>First Name</th>
    <th>Wage</th>
    <th>Employee Type</th>
    </tr>";
    
    while($record = mysqli_fetch_array($employees)){
        echo "<tr>";
        echo "<td>" . $record['firstName'] . "</td>";
        echo "<td>" . $record['lastName'] . "</td>";
        echo "<td>" . $record['wage'] . "</td>";
        echo "<td>" . $record['type'] . "</td>"; 
        echo "</tr>";
    }
    
    echo "</table>";
    
    mysqli_close($con);

?>

<br>
<input type='button'value='Add Employee' class="btn" onclick="document.location.href='../addEmployee.php';"/>
    

<!--We3schools sorting algorithm-->
<p><button onclick="sortTable()">Alphabetical Sort</button></p>

<script>
function sortTable() {
  var table, rows, switching, i, x, y, shouldSwitch;
  table = document.getElementById("employees");
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

<p><input type='button'value='Back to Portal' class="btn" onclick="document.location.href='index.html';"/></p>
  

</body>
</html>
