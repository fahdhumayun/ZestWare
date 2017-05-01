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
      Edit Information 
    </title>
  </head>
  <body>
    <div class = "logo">
     <a href="https://zestware123.000webhostapp.com"/>
    <img border="0" alt="logo" src="buttons/zesty.png">
    </a>
    </div>
    <br>
    <br>
    <br>

    <div class = "table">
    <?php

      if(!isset($_SESSION['use'])) // If session is not set then redirect to Login Page
      {
        header("Location:https://zestware123.000webhostapp.com/");  
      }

      if(isset($_POST['submit']))   // it checks whether the user clicked submit button or not 
      {
        if ($_POST['firstName'] || $_POST['pass'])
        {
          $newFirstName = $_POST['firstName'];
          $newPin = $_POST['pass'];
          //echo 'New first name is ' . $newFirstName . '</br>';
          //echo 'New username is ' . $newUsername . '</br>';
          //echo 'New PIN is ' . $newPIN. '</br>';
          $con = mysqli_connect("localhost", "id964298_zestwaredatabase", "zestware123!", "id964298_zestdatabase");
          if(!$con){
            die("Cannot connect: " . mysqli_connect_error());
          }
    
          mysqli_select_db($con, "id964298_zestdatabase");
          $result = mysqli_query($con, "SELECT * FROM employees WHERE lastName = '".$_SESSION['use']."'");

  
          while($row = mysqli_fetch_array($result))
          {
            $lastName = $row['lastName'];
          }
          mysqli_query($con, "UPDATE employees SET first = '$newFirstName' , pin = '$newPin' WHERE lastName = '$lastName'");

          echo '<script language="javascript">';
          echo 'alert("Updated Information")';
          echo '</script>';

          
         }
        else
        {
          echo '<script language="javascript">';
          echo 'alert("No Information Was Entered")';
          echo '</script>';
        }
        
      }

      //unset($db);
    ?>

    <form action="edit.php" method="post">
    <table width="200" border="0">
      <caption> 
        Please Fill All Boxes 
      </caption>
      <tr>
        <td>  Name: </td>
        <td> <input type="text" name="firstName" placeholder="Enter New First Name" ></td>
      </tr>
      <tr>
        <td> PIN: </td>
        <td><input type="text" name="pass" placeholder="Enter New PIN"></td>
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