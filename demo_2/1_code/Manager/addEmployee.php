<!--
Written, tested, and debugged by: Ama Freeman
-->
<html>
<head>
<title>Add Employee</title>
</head>
<body>

<form action="https://zestware123.000webhostapp.com/employeeAdded.php" method="post">

<?php
$type = "";
$firstname = "";
$lastname = "";
?>
    
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
    
<br>
Employee Type:<br>
<input type="radio" name="type" value="manager" checked> Manager<br>
<input type="radio" name="type" value="waiter"> Waiter/Waitress<br>
<input type="radio" name="type" value="busser"> Busser<br>
<input type="radio" name="type" value="chef"> Chef    


<p>
<input type="submit" name="submit" value="Send" />
</p>

<input type='button'value='Employee Shift Table' class="btn" onclick="document.location.href='getEmployeeInfo.php';"/>

<p><input type='button'value='Back to Portal' class="btn" onclick="document.location.href='index.html';"/></p>
</form>
</body>
</html>
