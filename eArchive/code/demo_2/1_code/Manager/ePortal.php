<!--
Written, tested, and debugged by: Raphaelle Marcial
-->

<?php
session_start();

?>

<html>
  <head>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  


    <style>
    body{
      font-family: georgia, sans-serif;
      font-size: 30px;
    }

    </style>
    <link rel="stylesheet" type="text/css" href="temp2.css"> 
    <title>
      Employee Portal
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

    $con = mysqli_connect("localhost", "id964298_zestwaredatabase", "zestware123!", "id964298_zestdatabase");
      if(!$con){
          die("Cannot connect: " . mysqli_connect_error());
      }
    
      mysqli_select_db($con, "id964298_zestdatabase");
      $result = mysqli_query($con, "SELECT * FROM employees WHERE lastName = '".$_SESSION['use']."'") or die("Failed to query database " .mysqli_connect_error());

      while($row = mysqli_fetch_array($result))
        {
          echo 'Welcome ' . $row['first'] . '</br>';
        }

  ?>

  <br>

  <?php

        $con = mysqli_connect("localhost", "id964298_zestwaredatabase", "zestware123!", "id964298_zestdatabase");
      if(!$con){
          die("Cannot connect: " . mysqli_connect_error());
      }
    
      mysqli_select_db($con, "id964298_zestdatabase");
        $result = mysqli_query($con, "SELECT * FROM employees WHERE lastName = '".$_SESSION['use']."'") or die("Failed to query database " .mysql_error());
        while($row = mysqli_fetch_array($result))
        {
            echo 'Wage: $' . $row['hourlyWage'] . '</br>';
            echo 'Type: ' . $row['type'] . '</br>';
                                
            //$lastName = $row['lastName'];
            //$type = $row['type'];       
        
                          
        }
    ?>

  </div>
  
  <br>
  
  <!-- Buttons for employee to pick next action -->
  <div class = "table">
    <TABLE BORDER="0">
    <TR>

      <TD><FORM METHOD="LINK" ACTION="https://zestware123.000webhostapp.com/startbootstrap-simple-sidebar-gh-pages/shifts.php">
      <input type="image" src ="buttons/ShiftTable.png" alt="Submit" class = "ShiftTable">
      </FORM></TD>

      <TD><FORM METHOD="LINK" ACTION="https://zestware123.000webhostapp.com/startbootstrap-simple-sidebar-gh-pages/edit.php">
      <input type="image" src ="buttons/EditInformation.png" alt="Submit" class="EditInformation">
      </FORM></TD>
    </TR>
    <TR>

      <TD><FORM METHOD="LINK" ACTION="https://zestware123.000webhostapp.com/report.php">
      <input type="image" src ="buttons/AbsenceReport.png" alt="Submit" class = "AbsenceReport">
      </FORM></TD>

      <TD><FORM METHOD="LINK" ACTION="https://zestware123.000webhostapp.com/startbootstrap-simple-sidebar-gh-pages/survey.php">
      <input type="image" src ="buttons/Survey.png" alt="Submit" class = "Survey">
      </FORM></TD>
     </TR>

   

    
    </TABLE>

  </div>

   <input type="image" src ="buttons/LogOut.png" alt="Submit" class = "LogOut" onclick="document.location.href='../startbootstrap-simple-sidebar-gh-pages/logout.php';">
  

  </body>

</html>