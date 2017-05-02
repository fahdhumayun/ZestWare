<!--
Written, tested, and debugged by: Ama Freeman
-->
<html>
<head>
<title>Add Inventory Item</title>
</head>
<body>

<form action="itemAdded.php" method="post">
    
<b>Add a New Invetory Item</b>

<p>Item Name (Name of the Ingredient or Item Purchased):
<input type="text" name="itemName" size="32" value="" />
</p>

<p>Item Total (Total Amount in Unit Measurement):
<input type="text" name="itemTotal" size="32" value="" />
</p>

<p>Unit Measurement:
<input type="text" name="unitMeasurement" size="32" value="" />
</p>
    
<p>Total Cost Per Unit:
<input type="text" name="itemCostPerUnit" size="32" value="" />
</p>
    
<p>
<input type="submit" name="submit" value="Submit" />
</p>
    
<input type='button'value='Back to Inventory' class="btn" onclick="document.location.href='inventoryIndex.php';"/>

<p><input type='button'value='Back to Portal' class="btn" onclick="document.location.href='index.html';"/></p>
    
</form>
</body>
</html>
