<!--
Written, tested, and debugged by: Ama Freeman
-->
<html>
<head>
    <title>Add Item</title>
</head>
<body>

<?php

if(isset($_POST['submit'])){
    
    $itemname = "";
    $itemtotal = "";
    $unitmeasure = "";
    $costperunit = "";
	$data_missing = array();
	
	if(empty($_POST['itemName'])){
		$data_missing[] = 'Item Name';
	} else {
		$itemname = trim($_POST['itemName']);
	}
	
	if(empty($_POST['itemTotal'])){
		$data_missing[] = 'Item Total';
	} else {
		$itemtotal = trim($_POST['itemTotal']);
	}
	
	if(empty($_POST['unitMeasurement'])){
		$data_missing[] = 'Unit Measurement';
	} else {
		$unitmeasure = $_POST['unitMeasurement'];
	}
    
    if(empty($_POST['itemCostPerUnit'])){
		$data_missing[] = 'Cost Per Unit';
	} else {
		$costperunit = $_POST['itemCostPerUnit'];
	}

	if(empty($data_missing)){
		require_once('mysqli_connect.php');
		
		$query = "INSERT INTO inventory (itemName, itemTotal, unitMeasurement, itemCostPerUnit) VALUES (?, ?, ?, ?)";
		
		$stmt = mysqli_prepare($dbc, $query);
		
		mysqli_stmt_bind_param($stmt, "ssss", $itemname, $itemtotal, $unitmeasure, $costperunit);
		
		mysqli_stmt_execute($stmt);
		
		$affected_rows = mysqli_stmt_affected_rows($stmt);
		
		if($affected_rows == 1){
			echo 'Item Added to Inventory';
            
			mysqli_stmt_close($stmt);
            
			mysqli_close($dbc);
		} else {
			echo 'Error Occured. Could not update database.<br />';
			echo mysqli_connect_error();
			mysqli_stmt_close($stmt);
			mysqli_close($dbc);
		}
	} else {
		echo 'You need to enter the following data<br>';
		
		foreach($data_missing as $missing){
			echo '$missing<br />';
		}
	}
}
?>

<form action="http://zestware123.000webhostapp.com/itemAdded.php" method="post">

<b>Add a New Invetory Item</b>

<p>Item Name:
<input type="text" name="itemName" size="32" value="" />
</p>

<p>Item Total:
<input type="text" name="itemTotal" size="32" value="" />
</p>

<p>Unit Measurement:
<input type="text" name="unitMeasurement" size="32" value="" />
</p>
    
<p>Cost Per Unit:
<input type="text" name="itemCostPerUnit" size="32" value="" />
</p>
    
<p>
<input type="submit" name="submit" value="Send" />
</p>
    
<input type='button'value='Back to Inventory' class="btn" onclick="document.location.href='http://zestware123.000webhostapp.com/inventoryIndex.php';"/>

</form>
</body>
</html>
