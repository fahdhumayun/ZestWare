<?php  

session_start();

?>

<html>
	<head>
		<title> 
			Survey Table 
		</title>
	</head>
	<body>

	<table border="1">
		<caption> 
			Surveys
		</caption>
  	<tr>
  	<th>Survey ID
    <th>Rating
    <th>Time
    <th>Comment
    <th>Manager Reponse
  	</tr>
	<?php
		echo "<a href='../startbootstrap-simple-sidebar-gh-pages/logout.php'> Logout</a>"; 
		echo "<a href='../startbootstrap-simple-sidebar-gh-pages/index3.php'> Back to Home</a> <br> "; 
		
		$link = mysql_connect("localhost", "root", "somethingstupid");
    	mysql_select_db("zestware");
    	$result = mysql_query("SELECT * FROM survey") or die("Failed to query database " .mysql_error());
  			//echo $row['day'] . ': ' . $row['hours'] . '<br/>';
    	while($row = mysql_fetch_array($result))
      	{
 			print "<tr>\n";
 			print "<td>" . $row['surveyID'] . "\n";
 			print "<td>" . $row['rating'] . "\n";
 			print "<td>" . $row['time'] . "\n";
 			print "<td>" . $row['comment'] . "\n";
 			print "<td>" . $row['managerResponse'] . "\n";
 		
		}
		//mysql_close();

		if(isset($_POST['submit']))

		{	
			$surveyID = $_POST['surveyID'];
			$link = mysql_connect("localhost", "root", "somethingstupid");
    		mysql_select_db("zestware");
			$result = mysql_query("SELECT * FROM survey WHERE surveyID = '$surveyID'") or die("Failed to query database " .mysql_error());

			//echo 'hey' . $surveyID . '</br>';
			$managerResponse = $_POST['managerResponse'];

  			//echo $row['day'] . ': ' . $row['hours'] . '<br/>';
			while($row = mysql_fetch_array($result))
  			{
  				if ($row['surveyID'] == $surveyID)
      			{
 					mysql_query("UPDATE survey SET managerResponse = '$managerResponse' WHERE surveyID = '$surveyID'") or die("Failed to query database " .mysql_error());

 					echo '<script language="javascript">';
                	echo 'alert("Response Sent")';
                	echo '</script>';


 				}	

 				else
        		{
         			echo '<script language="javascript">';
          			echo 'alert("No Information Was Entered")';
          			echo '</script>';
        		}
  				
  			}
    		
 		
		}
	?>
  	</table>

  	<form action="../startbootstrap-simple-sidebar-gh-pages/surveyTable.php" method="post">
      <table width="500" border="0">
      <tr>
        <td>  Respond: </td>
      </tr>
      <tr>
        <td> Enter Survey ID:  </td>
        <td><input type="text" placeholder = "ID #" name="surveyID"></td>
      </tr>
      <tr>
      	<td> Respond Here: </td>
        <td><textarea name="managerResponse" rows="5" cols="40"></textarea>
        </tr>
      <tr>
        <td> <input type="submit" name="submit" value="SUBMIT"></td>
        <td></td>
      </tr>
      </table>
    </form>
  	</body>
 </html>
