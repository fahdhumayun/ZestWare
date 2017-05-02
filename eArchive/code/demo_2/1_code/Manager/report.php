<!--Written, tested, and debugged by Raphaelle Marcial -->

<?php

session_start();

?>

<html>
	<head>
  <style>

  table {
    font-family: georgia, sans-serif;
    border-collapse: collapse;
    font-size:20px;
    /*width: 100% */
  }
table caption { 
    padding: 10px;
    background: #FA6568;
    color: white;
    font-size: 30px;
  }

  td, th {
    border: 1px solid #dddddd;
    text-align: left;
    padding: 8px;
  }

  tr:nth-child(even) {
    background-color: #dddddd;
  }
  </style>
		<link rel="stylesheet" type="text/css" href="temp3.css"> 
		<title>
			Report Absence
		</title>
	</head>

	<body>

	<?php

		if(!isset($_SESSION['use'])) // If session is not set then redirect to Login Page
            {
                header("Location:https://zestware123.000webhostapp.com/startbootstrap-simple-sidebar-gh-pages/login.php");  
            }

	?>

	<div class = "logo">
		<a href=https://zestware123.000webhostapp.com/>
    <img border="0" alt="logo" src="buttons/zesty.png">
    </a>
	</div>

	
	<br>

	<div class = "content">
	<?php

        if(isset($_POST['submit']))   // it checks whether the user clicked submit button or not 
    	{
     
      		$con = mysqli_connect("localhost", "id964298_zestwaredatabase", "zestware123!", "id964298_zestdatabase");
    		if(!$con){
        		die("Cannot connect: " . mysqli_connect_error());
    		}
    
    		mysqli_select_db($con, "id964298_zestdatabase");
    		$result = mysqli_query($con, "SELECT * FROM employees WHERE lastName = '".$_SESSION['use']."'");
     

      
      		while($row = mysqli_fetch_array($result))
      		{
        		$firstName = $row['first'];
        		$lastName = $row['lastName'];
        		$type = $row['type'];
      		}
      
      		if ($_POST['date'] && $_POST['comment'])
      		{
        		$date = $_POST['date'];
        		$comment = $_POST['comment'];

        		$sql = "INSERT INTO absence (firstName, lastName, date, comment, type) VALUES ('$firstName', '$lastName', '$date', '$comment', '$type')";


			if (mysqli_query($con, $sql)) {
    			echo '<script language="javascript">';
        		echo 'alert("Request Sent")';
        		echo '</script>';
			} else {
    			echo "Error: " . $sql . "<br>" . mysqli_error($con);
			}
     		}
     		else
      		{
          		echo '<script language="javascript">';
          		echo 'alert("Enter All Fields")';
          		echo '</script>';
      		}
     	}

      

	?>


	</div>
	
	<br>
	<br>
	<br>
	
	<div class = "table">
		<form action="../report.php" method="post">
                            
                            <table width="200" border="0">
                            <caption>Report Absence</caption>
                            <tr>
    
                                <td> Date: </td>
                                <td><input type="date" name = "date"/></td>
                            </tr>
                            <tr>
                                <td> Comments: </td>
                                <td><textarea name="comment" rows="5" cols="40"></textarea>
                            </tr>
                            
                            </table>
                             <input type="hidden" name="submit" value="submit">
                            <input type="image" src="buttons/Submit.png"></td>
                            </form>

	</div>

	<br>
	<br>
	<br>

	<input type="image" src ="buttons/LogOut.png" alt="Submit" class = "LogOut" onclick="document.location.href='../startbootstrap-simple-sidebar-gh-pages/logout.php';">
	

	</body>

</html>