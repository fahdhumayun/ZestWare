<!-- Written, tested, and debugged by Raphaelle Marcial -->

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
      Absence Report 
    </title>
  </head>
  <body>

  <div class = "logo">
   <a href=https://zestware123.000webhostapp.com/>
    <img border="0" alt="logo" src="buttons/zesty.png">
    </a>
  </div>

  <br>
  <br>
  <br>

  <div class = "table">
  <table border = "1">
  
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

    if(isset($_SESSION['manager'])) // If session is not set then redirect to Login Page
      {
          

          $con = mysqli_connect("localhost", "id964298_zestwaredatabase", "zestware123!", "id964298_zestdatabase");
          if(!$con){
            die("Cannot connect: " . mysqli_connect_error());
          }
    
          mysqli_select_db($con, "id964298_zestdatabase");
          $result = mysqli_query($con, "SELECT * FROM absence") or die("Failed to query database " .mysqli_connect_error());
      
        //echo $row['day'] . ': ' . $row['hours'] . '<br/>';
          while($row = mysqli_fetch_array($result))
        {
          print "<tr>\n";
          print "<td>" . $row['firstName'] . "\n";
          print "<td>" . $row['lastName'] . "\n";
          print "<td>" . $row['date'] . "\n";
          print "<td>" . $row['comment'] . "\n";
          print "<td>" . $row['type'] . "\n";

    
        }
      }

    // General employees do not have access
    else
    {
        echo '<script language="javascript">';
        echo 'alert("Not Allowed Access!")';
        echo '</script>';

    }
 
    
  ?>
    </table>
    </div>

    <br>
    <br>
    <br>

    <input type="image" src ="buttons/LogOut.png" alt="Submit" class = "LogOut" onclick="document.location.href='../startbootstrap-simple-sidebar-gh-pages/logout.php';">
    </body>
 </html>