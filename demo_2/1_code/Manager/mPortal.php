<!-- Written, tested, and debugged by Raphaelle Marcial -->

<?php

session_start();

?>

<html>
  <head>
  <style>
  body{
    font-family: georgia, sans-serif;
    font-size: 30px;
  }
  </style>
    <link rel="stylesheet" type="text/css" href="temp.css"> 
    <title>
      Manager Portal
    </title>
  </head>

  <body>

  <?php

    if(!isset($_SESSION['manager'])) // If session is not set then redirect to Login Page
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
      $result = mysqli_query($con, "SELECT * FROM employees WHERE lastName = '".$_SESSION['manager']."'") or die("Failed to query database " .mysqli_connect_error());

      while($row = mysqli_fetch_array($result))
        {
          echo 'Welcome ' . $row['first'] . '</br>';
  
        }

  ?>
  </div>
  
  <br>
  
  
  <div class = "table">
    <TABLE BORDER="0">
    <TR>

      <TD><FORM METHOD="LINK" ACTION="https://zestware123.000webhostapp.com/startbootstrap-simple-sidebar-gh-pages/absence.php">
      <input type="image" src ="buttons/AbsenceReport.png" alt="Submit" class = "AbsenceReport">
      </FORM></TD>

      <TD><FORM METHOD="LINK" ACTION="https://zestware123.000webhostapp.com/startbootstrap-simple-sidebar-gh-pages/surveyTable.php">
      <input type="image" src ="buttons/SurveyResults.png" alt="Submit" class="SurveyResults">
      </FORM></TD>

      <TD><FORM METHOD="LINK" ACTION="employees.php">
      <input type="image" src ="buttons/EmployeeTable.png" alt="Submit" class = "EmployeeTable">
      </FORM></TD>

    </TR>

    <TR>

      <TD><FORM METHOD="LINK" ACTION="https://zestware123.000webhostapp.com/inventoryIndex.php">
      <input type="image" src ="buttons/Inventory.png" alt="Submit" class = "Inventory">
      </FORM></TD>


      <TD><FORM METHOD="LINK" ACTION="music.php">
      <input type="image" src ="buttons/Music.png" alt="Submit" class = "Music">
      </FORM></TD>

      <TD><FORM METHOD="LINK" ACTION="https://zestware123.000webhostapp.com/startbootstrap-simple-sidebar-gh-pages/shifts.php">
      <input type="image" src ="buttons/ShiftTable.png" alt="Submit" class = "ShiftTable">
      </FORM></TD>

    </TR>

    <TR>
      
      <TD></TD>
      <TD>
      <FORM METHOD="LINK" ACTION="https://zestware123.000webhostapp.com/finances.php">
      <input type="image" src ="buttons/Finances.png" alt="Submit" class = "Finances">
      </FORM></TD>

    </TR>

    </TABLE>
  </div>

  <br>
  
  <input type="image" src ="buttons/LogOut.png" alt="Submit" class = "LogOut" onclick="document.location.href='../startbootstrap-simple-sidebar-gh-pages/logout.php';">

  </body>

</html>