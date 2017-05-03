<!--
Written, tested, and debugged by: Ama Freeman
-->
<?php
//Connect to database to delete item
$con = mysqli_connect("localhost", "id964298_zestwaredatabase", "zestware123!", "id964298_zestdatabase");
    if(!$con){
        die("Cannot connect: " . mysqli_connect_error());
    }
    
    mysqli_select_db($con, "id964298_zestdatabase");
    //$id = "";
    $id = $_GET['id'];

    mysqli_query($con, "DELETE FROM inventory WHERE itemID = 
    '".$id."'");

    mysqli_close($con);
    header("Location: https://zestware123.000webhostapp.com/inventoryIndex.php");
?>
