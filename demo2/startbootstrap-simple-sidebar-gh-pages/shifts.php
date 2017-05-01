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
font-size: 20px;
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
    <link rel="stylesheet" type="text/css" href="temp2.css"> 
    <title> 
      Shift Table 
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
  <table border="1">
    <caption> 
      Employee Shift Table 
    </caption>
    <tr>
    <th>Employee
    <th>Date
    <th>Expected Clock In
    <th>Hours
    <!--<th>Calculated Wage -->
    </tr>

  <?php


    //---------------Print data----------------

      $con = mysqli_connect("localhost", "id964298_zestwaredatabase", "zestware123!", "id964298_zestdatabase");
        if(!$con){
            die("Cannot connect: " . mysqli_connect_error());
        }
    
      mysqli_select_db($con, "id964298_zestdatabase");
      $result = mysqli_query($con, "SELECT * FROM shifts");


      if(isset($_SESSION['manager'])) // If session is not set then redirect to Login Page
      { 
      
      while($row = mysqli_fetch_array($result))
        {
          //$firstName = $row['firstName'];
          print "<tr>\n";
          print "<td>" . $row['firstName'] . "\n";
          print "<td>" . $row['date'] . "\n";
          print "<td>" . $row['clockIn'] . "\n";
          print "<td>" . $row['workTime'] . "\n";
          //print "<td>" . $row['calculatedWage'] . "\n";
        }
      }

      if(isset($_SESSION['use'])) // If session is not set then redirect to Login Page
      {
        while($row = mysqli_fetch_array($result))
        {
          print "<tr>\n";
          print "<td>" . $row['firstName'] . "\n";
          print "<td>" . $row['date'] . "\n";
          print "<td>" . $row['clockIn'] . "\n";
          print "<td>" . $row['workTime'] . "\n";
          //print "<td>" . "N/A\n";
        }
      }

    ?>
    </table>

    
    <table border="1">
    <caption> 
      Calculated Wage
    </caption>
    <tr>
    <th>Calculated Wage
    </tr>
    <?php
    //-------------Get calculated wage---------- 
      $con = mysqli_connect("localhost", "id964298_zestwaredatabase", "zestware123!", "id964298_zestdatabase");
        if(!$con){
            die("Cannot connect: " . mysqli_connect_error());
        }
    
      mysqli_select_db($con, "id964298_zestdatabase");
      $result = mysqli_query($con, "SELECT * FROM shifts, employees");
      
      while($row = mysqli_fetch_array($result))
        {
        
              if(isset($_SESSION['manager']))
              {
              //print "<tr>\n";
              // PROBLEM: Calculating each entry of $workTime by $hourlyWage instead of just across the row 
              $time = $row['workTime'];
              $wage = $row['hourlyWage'];
              $product = $time * $wage;
              $date = $row['date'];

              if ($row['firstName'] == $row['first'])
              {
                  print "<tr>\n";
                  print "<td>" . $product . "\n";
                  //echo $product;
              
            
              //print "<td>" . $row['workTime'] * $row['hourlyWage'] . "\n";
              $firstName = $row['firstName'];

              mysqli_query($con, "UPDATE shifts SET calculatedWage = '$product' WHERE firstName = '$firstName' AND date = '$date'");
              }
          //$calculatedWage = $row['workTime'] * $row['hourlyWage'];  
              }
              if(isset($_SESSION['use'])) // If session is not set then redirect to Login Page
              {
                 if ($row['firstName'] == $row['first'])
                {
                  print "<tr>\n";
                  print "<td>" . "N/A\n";
                
                }
                
              }
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