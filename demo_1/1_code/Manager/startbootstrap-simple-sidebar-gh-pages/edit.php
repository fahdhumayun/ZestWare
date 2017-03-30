<?php  

session_start();

?>
<html>
  <head>
    <title> 
      Edit Information 
    </title>
  </head>
  <body>

    <?php
      echo "<a href='../startbootstrap-simple-sidebar-gh-pages/logout.php'> Logout</a>"; 
      echo "<a href='../startbootstrap-simple-sidebar-gh-pages/index2.php'> Back to Home</a> <br> ";

      if(!isset($_SESSION['use'])) // If session is not set then redirect to Login Page
      {
        header("Location:Login.php");  
      }

      if(isset($_POST['save']))   // it checks whether the user clicked save button or not 
      {
        if ($_POST['firstName'] || $_POST['pass'])
        {
          $newFirstName = $_POST['firstName'];
          $newPin = $_POST['pass'];
          //echo 'New first name is ' . $newFirstName . '</br>';
          //echo 'New username is ' . $newUsername . '</br>';
          //echo 'New PIN is ' . $newPIN. '</br>';
          $link = mysql_connect("localhost", "root", "somethingstupid");
          mysql_select_db("zestware");
          $result = mysql_query("SELECT * FROM employees WHERE lastName = '".$_SESSION['use']."'") or die("Failed to query database " .mysql_error());
          
          while($row = mysql_fetch_array($result))
          {
            $lastName = $row['lastName'];
          }
          mysql_query("UPDATE employees SET firstName = '$newFirstName' , pin = '$newPin' WHERE lastName = '$lastName'") or die("Failed to query database " .mysql_error());

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

    <form action="../startbootstrap-simple-sidebar-gh-pages/edit.php" method="post">
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
      <tr>
        <td> <input type="submit" name="save" value="SAVE"></td>
        <td></td>
      </tr>
    </table>
    </form>
  </body>
</html>
