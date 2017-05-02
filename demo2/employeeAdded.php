<!--
Written, tested, and debugged by: Ama Freeman
-->
<html>
<head>
<title>Add Employee</title>
</head>
<body>

<?php

if(isset($_POST['submit'])){
    
    
    $firstname = "";
    $lastname = "";
	$data_missing = array();
	
	if(empty($_POST['firstName'])){
		$data_missing[] = 'First Name';
	} else {
		$firstname = trim($_POST['firstName']);
	}
	
	if(empty($_POST['lastName'])){
		$data_missing[] = 'Last Name';
	} else {
		$lastname = trim($_POST['lastName']);
	}
	
	if(empty($_POST['wage'])){
		$data_missing[] = 'Hourly Wage';
	} else {
		$wage = $_POST['wage'];
	}
	
	
	//Chooses employee type based on selection.
    $type = $_POST["type"];
    
    if(isset($type) && $type=="manager"){
        $type = "M";
    } else if (isset($type) && $type=="waiter"){
        $type = "W";
    } else if (isset($type) && $type=="busser"){
        $type = "B";
    } else {
        $type = "C";
	}
	
	$pin = rand(1000, 9999);
	
	if(empty($data_missing)){
		require_once('mysqli_connect.php');
		
		$query = "INSERT INTO employees (firstName, lastName, pin, wage, type) VALUES (?, ?, ?, ?, ?)";
		
		$stmt = mysqli_prepare($dbc, $query);
		
		mysqli_stmt_bind_param($stmt, "sssss", $firstname, $lastname, $pin, $wage, $type);
		
		mysqli_stmt_execute($stmt);
		
		$affected_rows = mysqli_stmt_affected_rows($stmt);
		
		if($affected_rows == 1){
			echo 'Employee Entered';
            
			mysqli_stmt_close($stmt);
            
			mysqli_close($dbc);
		} else {
			echo 'Error Occured<br />';
			echo mysqli_error();
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

<form action="http://zestware123.000webhostapp.com/employeeAdded.php" method="post">

<b>Add a New Employee</b>

<p>First Name:
<input type="text" name="firstName" size="32" value="" />
</p>

<p>Last Name:
<input type="text" name="lastName" size="32" value="" />
</p>

<p>Hourly Wage:
<input type="text" name="wage" size="32" value="" />
</p>

<p>Employee Type:</p>
<br>
<div id="employeeType">
<input type="radio" name="type" value="manager" checked> Manager<br>
<input type="radio" name="type" value="waiter"> Waiter/Waitress<br>
<input type="radio" name="type" value="busser"> Busser<br>
<input type="radio" name="type" value="chef"> Chef    
</div>

<p>
<input type="submit" name="submit" value="Send" />
</p>
<p><input type='button'value='Back to Portal' class="btn" onclick="document.location.href='index.html';"/></p>
</form>
</body>
</html>
