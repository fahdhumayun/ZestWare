<html>
<head>
<title>Add Inventory Item</title>
</head>
<body>

<form action="http://localhost:1234/itemAdded.php" method="post">
    
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
<input type="submit" name="submit" value="Submit" />
</p>
    
<input type='button'value='Back to Inventory' class="btn" onclick="document.location.href='inventoryIndex.php';"/>

<p><input type='button'value='Back to Portal' class="btn" onclick="document.location.href='../startbootstrap-simple-sidebar-gh-pages/index.html';"/></p>
    
</form>
</body>
</html>