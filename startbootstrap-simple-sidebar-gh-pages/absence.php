<?php  

session_start();

?>
<html>
	<head>
		<title> 
			Absence Report 
		</title>
	</head>
	<body>

	<table border="1">
		<caption> 
			Absence Report
		</caption>
  	<tr>
  	<th>First Name
    <th>Last Name
    <th>Date
    <th>Comment
    <th>Type
  	</tr>
	<?php
		echo "<a href='../startbootstrap-simple-sidebar-gh-pages/logout.php'> Logout</a>"; 
		if(isset($_SESSION['manager'])) // If session is not set then redirect to Login Page
    	{
      		echo "<a href='../startbootstrap-simple-sidebar-gh-pages/index3.php'> Back to Home</a> <br> "; 

          $link = mysql_connect("localhost", "root", "somethingstupid");
      mysql_select_db("zestware");
      $result = mysql_query("SELECT * FROM absence") or die("Failed to query database " .mysql_error());
        //echo $row['day'] . ': ' . $row['hours'] . '<br/>';
      while($row = mysql_fetch_array($result))
        {
      print "<tr>\n";
      print "<td>" . $row['firstName'] . "\n";
      print "<td>" . $row['lastName'] . "\n";
      print "<td>" . $row['date'] . "\n";
      print "<td>" . $row['comment'] . "\n";
      print "<td>" . $row['type'] . "\n";

    
        }
        mysql_close();
    	}

    else
    {
        echo '<script language="javascript">';
        echo 'alert("Not Allowed Access!")';
        echo '</script>';

    }

    
		
		
	?>
  	</table>
  	</body>
 </html>
