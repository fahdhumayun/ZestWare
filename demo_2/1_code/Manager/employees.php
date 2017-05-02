<!--
Written, tested, and debugged by: Raphaelle Marcial
-->

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
  }
	table caption { 
    padding: 10px;
    background: #FA6568;
    color: white;
	font-size: 25px;
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
      Employee Table 
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
      Employee Table 
    </caption>
    <tr>
    <th>First Name
    <th>Last Name
    <th>Pin
    <th>Hourly Wage
    <th>Type
    <th>Total Wage
    </tr>

  <?php
      $con = mysqli_connect("localhost", "id964298_zestwaredatabase", "zestware123!", "id964298_zestdatabase");
        if(!$con){
            die("Cannot connect: " . mysqli_connect_error());
        }
    
      mysqli_select_db($con, "id964298_zestdatabase");
      $result = mysqli_query($con, "SELECT * FROM employees");
        //echo $row['day'] . ': ' . $row['hours'] . '<br/>';

      if(isset($_SESSION['manager'])) // If session is not set then redirect to Login Page
      { 
      
      while($row = mysqli_fetch_array($result))
        {
          print "<tr>\n";
          print "<td>" . $row['first'] . "\n";
          print "<td>" . $row['lastName'] . "\n";
          print "<td>" . $row['pin'] . "\n";
          print "<td>" . $row['hourlyWage'] . "\n";
          print "<td>" . $row['type'] . "\n";
          print "<td>" . $row['totalWage'] . "\n"; //
        }
      }

      else
      {
        echo '<script language="javascript">';
        echo 'alert("Not Allowed Access!")';
        echo '</script>';

      }
    

  ?>
    </table>

    <br>
    <br>
    <br>


  <?php
        if(isset($_POST['submit']))   // Action that occurs when submit button is pressed under "Calculate Total Wage" form
        {
          
          
            if ($_POST['date'] && $_POST['period'] && $_POST['first'])
            {

              $con = mysqli_connect("localhost", "id964298_zestwaredatabase", "zestware123!", "id964298_zestdatabase");
          
              if(!$con)
              {
                die("Cannot connect: " . mysqli_connect_error());
              }
    
              mysqli_select_db($con, "id964298_zestdatabase");

              $date = $_POST['date'];
              //echo $date;
              $first = $_POST['first'];
              //echo $date;
              //echo 'first';
              //---------DAILY---------

             
                

                if ($_POST['period'] == 'daily')
                {
                   $result = mysqli_query($con, "SELECT * FROM shifts WHERE date = '$date' AND firstName = '$first'"); //AND firstName = '$first'

                   while($row = mysqli_fetch_array($result))
                  {
                    //$first = $row['firstName'];
                    $calculatedWage = $row['calculatedWage'];
                    $sql = "UPDATE employees SET totalWage = '$calculatedWage' WHERE first = '$first'";

                  }

                  if (mysqli_query($con, $sql)) 
                    {
                      echo '<script language="javascript">';
                      echo 'alert("Finished Daily Calculation")';
                      echo '</script>';
                    } 
                    else 
                    {
                      echo "Error: " . $sql . "<br>" . mysqli_error($con);
                    }


                 
                }//end Daily

                    

              //---------WEEKLY---------
              if ($_POST['period'] == 'weekly')
                  {
                    $totalWage = 0;
                    $originalDate = $date;
                    $end = date("Y-m-d",strtotime("+7days",strtotime($date)));
                    for ($i = 0; $date < $end; $i++)
                    {
                    
                      $date = date("Y-m-d",strtotime("+".$i."days",strtotime($originalDate)));
                      $result = mysqli_query($con, "SELECT * FROM shifts WHERE date = '$date' AND firstName = '$first'");
                      while($row = mysqli_fetch_array($result))
                      {
                        $totalWage = $row['calculatedWage'] + $totalWage;
                        $sql = "UPDATE employees SET totalWage = '$totalWage' WHERE first = '$first'";
                      }
                        
                    }
                    if (mysqli_query($con, $sql)) 
                    {
                      echo '<script language="javascript">';
                      echo 'alert("Finished Weekly Calculation")';
                      echo '</script>';
                    } 
                    else 
                    {
                      echo "Error: " . $sql . "<br>" . mysqli_error($con);
                    }
                        
                  }
    
              //---------MONTHLY--------
              if ($_POST['period'] == 'monthly')
                  {
                    $totalWage = 0;
                    $originalDate = $date;
                    $end = date("Y-m-d",strtotime("+30days",strtotime($date)));
                    for ($i = 0; $date < $end; $i++)
                    {
                    
                      $date = date("Y-m-d",strtotime("+".$i."days",strtotime($originalDate)));
                      $result = mysqli_query($con, "SELECT * FROM shifts WHERE date = '$date' AND firstName = '$first'");
                      while($row = mysqli_fetch_array($result))
                      {
                        $totalWage = $row['calculatedWage'] + $totalWage;
                        $sql = "UPDATE employees SET totalWage = '$totalWage' WHERE first = '$first'";
                      }
                        
                    }
                    if (mysqli_query($con, $sql)) 
                    {
                      echo '<script language="javascript">';
                      echo 'alert("Finished Monthly Calculation")';
                      echo '</script>';
                    } 
                    else 
                    {
                      echo "Error: " . $sql . "<br>" . mysqli_error($con);
                    }
                        
                  }
            
          }
          

          if($_POST['date'] && $_POST['period']) //else
          {
           $con = mysqli_connect("localhost", "id964298_zestwaredatabase", "zestware123!", "id964298_zestdatabase");
          
              if(!$con)
              {
                die("Cannot connect: " . mysqli_connect_error());
              }
    
              mysqli_select_db($con, "id964298_zestdatabase");

              $date = $_POST['date'];
              //echo $date;
              $first = $_POST['first'];
              //echo $date;
              //echo 'first';
              //---------DAILY---------

             
                if ($_POST['period'] == 'daily')
                {
                   $result = mysqli_query($con, "SELECT * FROM shifts WHERE date = '$date'"); //AND firstName = '$first'

                   while($row = mysqli_fetch_array($result))
                  {
                    $first = $row['firstName'];
                    $calculatedWage = $row['calculatedWage'];
                    $sql = "UPDATE employees SET totalWage = '$calculatedWage' WHERE first = '$first'";

                  }
                  //echo "<tr><td> Total Wage for Daily: ";
                  //echo $calculatedWage;
                  //echo "</td></tr>";

                  if (mysqli_query($con, $sql)) 


                    {
                      
                      echo '<script language="javascript">';
                      echo 'alert("Finished Daily Calculation")';
                      echo '</script>';
                    } 
                    else 
                    {
                      echo "Error: " . $sql . "<br>" . mysqli_error($con);
                    }


                 
                }// end Daily


                //---------WEEKLY---------
              if ($_POST['period'] == 'weekly')
                  {
                    $totalWage = 0;
                    $originalDate = $date;
                    $end = date("Y-m-d",strtotime("+7days",strtotime($date)));
                    for ($i = 0; $date < $end; $i++)
                    {
                    
                      $date = date("Y-m-d",strtotime("+".$i."days",strtotime($originalDate)));
                      $result = mysqli_query($con, "SELECT * FROM shifts WHERE date = '$date'");
                      while($row = mysqli_fetch_array($result))
                      {
                        $first = $row['firstName'];
                        if ($first = $row['firstName'])
                        {
                          $totalWage = $row['calculatedWage'] + $totalWage;
                          
                        }
                        $sql = "UPDATE employees SET totalWage = '$totalWage' WHERE first = '$first'";
                      }
                        
                    }
                    if (mysqli_query($con, $sql)) 
                    {
                      echo '<script language="javascript">';
                      echo 'alert("Finished Weekly Calculation")';
                      echo '</script>';
                    } 
                    else 
                    {
                      echo "Error: " . $sql . "<br>" . mysqli_error($con);
                    }
                        
                  }

                  //--------MONTHLY-------
              if ($_POST['period'] == 'monthly')
                  {
                    
                    $totalWage = 0;
                    $originalDate = $date;
                    $end = date("Y-m-d",strtotime("+30days",strtotime($date)));
                    for ($i = 0; $date < $end; $i++)
                    {
                    
                      $date = date("Y-m-d",strtotime("+".$i."days",strtotime($originalDate)));
                      $result = mysqli_query($con, "SELECT * FROM shifts WHERE date = '$date'");
                      while($row = mysqli_fetch_array($result))
                      {
                        $first = $row['firstName'];
                        if ($first = $row['firstName'])
                        {
                          $totalWage = $row['calculatedWage'] + $totalWage;
                          //echo $first;
                          //echo $totalWage;
                          
                        }
                        $sql = "UPDATE employees SET totalWage = '$totalWage' WHERE first = '$first'";
                      }
                     
                    }
                    if (mysqli_query($con, $sql)) 
                    {
                      echo '<script language="javascript">';
                      echo 'alert("Finished Monthly Calculation")';
                      echo '</script>';
                    } 
                    else 
                    {
                      echo "Error: " . $sql . "<br>" . mysqli_error($con);
                    }
                        
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

    <br>
    <br>
    <br>

    <!--Calculating Wage

      Either enter the first two fields, or all three fields

    -->

    <form action="employees.php" id = "form" method="post">
      <table width="500" border="0">
      <caption> Calculate Total Wage </caption>
      
      <tr>
        <td> Select Period:  
        
        <select name = "period" form = "form">
          <option name ="daily" value="daily">Daily</option>
          <option name = "weekly" value="weekly">Weekly</option>
          <option name = "monthly" value="monthly">Monthly</option>      
        </select>
        </td>
      </tr>
      <tr>
        <tr>
        <td> Select Date: 
        
        <input type="date" name = "date"/>
        </td>
      </tr>
      </tr>
      <tr>
        <td> Enter Employee First Name:
          <input type="text" placeholder = "First Name" name = "first">
        </td>
      </tr>
      
      
      </table>
      <input type="hidden" name="submit" value="submit">
                            <input type="image" src="buttons/Submit.png"></td>
    </form>
    
    </div>
    <br>
    <br>
    <br>

    <?php

    if(isset($_POST['submit2']))   // If submit is clicked for "Create New Shift" form
        {
          
          
            if ($_POST['date2'] && $_POST['clockIn'] && $_POST['first2'] && $_POST['workTime'])
            {

              $con = mysqli_connect("localhost", "id964298_zestwaredatabase", "zestware123!", "id964298_zestdatabase");
          
              if(!$con)
              {
                die("Cannot connect: " . mysqli_connect_error());
              }
    
              mysqli_select_db($con, "id964298_zestdatabase");

              $date = $_POST['date2'];
              $workTime = $_POST['workTime'];
              $first = $_POST['first2'];
              $clockIn = $_POST['clockIn'];

              $result = mysqli_query($con, "SELECT * FROM shifts");

              while($row = mysqli_fetch_array($result))
                  {
                    $sql = "INSERT INTO shifts (firstName, date, clockIn, workTime) VALUES ('$first', '$date', '$clockIn', '$workTime')";

                  }

              if (mysqli_query($con, $sql)) 
              {
                echo '<script language="javascript">';
                echo 'alert("New Shift Created")';
                echo '</script>';
              } 
              else 
              {
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

    <!--Create New Shift-->

    <div class = "table">

    <form action="employees.php" id = "form" method="post">
      <table width="500" border="0">
      <caption> New Shift </caption>
      
      <tr>
        <td> Select Date: 
        
        <input type="date" name = "date2"/>
        </td>
      </tr>
      <tr>
        <td> Enter Employee First Name:
          <input type="text" placeholder = "First Name" name = "first2">
        </td>
      </tr>

      <tr>
        <td> Enter Expected Clock In Time:
          <input type="text" placeholder = "Enter Clock In Time" name = "clockIn">
        </td>
      </tr>
      <tr>
        <td> Enter Work Time:
          <input type="text" placeholder = "Work Time" name = "workTime">
        </td>
      </tr>
      
      </table>
      <input type="hidden" name="submit2" value="submit2">
      <input type="image" src="buttons/Submit.png"></td>
    </form>

    </div>

    <input type="image" src ="buttons/LogOut.png" alt="Submit" class = "LogOut" onclick="document.location.href='../startbootstrap-simple-sidebar-gh-pages/logout.php';">
    </body>
</html>