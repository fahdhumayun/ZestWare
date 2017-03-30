<?php  

session_start();

?>
<html>
	<head>
		<title> 
			Shift Table 
		</title>
	</head>
	<body>

	<table border="1">
		<caption> 
			Employee Shift Table 
		</caption>
  	<tr>
  	<th>Employee
    <th>Day
    <th>Hours
    <th>Check In Time
  	</tr>
	<?php
		echo "<a href='../startbootstrap-simple-sidebar-gh-pages/logout.php'> Logout</a>"; 
		if(isset($_SESSION['manager'])) // If session is not set then redirect to Login Page
    	{
      		echo "<a href='../startbootstrap-simple-sidebar-gh-pages/index3.php'> Back to Home</a> <br> "; 
    	}
    	if(isset($_SESSION['use'])) // If session is not set then redirect to Login Page
    	{
      		echo "<a href='../startbootstrap-simple-sidebar-gh-pages/index3.php'> Back to Home</a> <br> "; 
    	}
		$link = mysql_connect("localhost", "root", "somethingstupid");
    	mysql_select_db("zestware");
    	$result = mysql_query("SELECT * FROM shifts") or die("Failed to query database " .mysql_error());
  			//echo $row['day'] . ': ' . $row['hours'] . '<br/>';
    	while($row = mysql_fetch_array($result))
      	{
 			print "<tr>\n";
 			print "<td>" . $row['firstName'] . "\n";
 			print "<td>" . $row['date'] . "\n";
 			print "<td>" . $row['hours'] . "\n";
 			print "<td>" . $row['clockIn'] . "\n";

 		
		}
		mysql_close();
	?>
  	</table>
  	</body>
 </html>
