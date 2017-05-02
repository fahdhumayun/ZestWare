<!-- Written, tested, and debugged by Raphaelle Marcial -->

<?php  

session_start();

?>  

 <html>
  <head>
  <link rel="stylesheet" type="text/css" href="login.css"> 

    <title> 
      Login 
    </title>

  </head>

  <body>

    <?php

      if(isset($_SESSION['use']))   // Checking whether the session is already there or not if true then header redirect it to the home page directly  
      {
        header("Location:../ePortal.php"); 
      }
      if(isset($_SESSION['manager']))   // Checking whether the session is already there or not if true then header redirect it to the home page directly  
      {
        header("Location:../mPortal.php"); 
      }


      if(isset($_POST['login']))   // it checks whether the user clicked login button or not 
      {
        $user = $_POST['user'];
        $pass = $_POST['pass'];

        //echo 'Hello' .$user.'!';

    $con = mysqli_connect("localhost", "id964298_zestwaredatabase", "zestware123!", "id964298_zestdatabase");
    if(!$con){
        die("Cannot connect: " . mysqli_connect_error());
    }
    
    mysqli_select_db($con, "id964298_zestdatabase");


/*
        $link = mysqli_connect("localhost", "id964298_zestwaredatabase", "zestware123!", "id964298_zestdatabase");
        mysql_select_db($link, "id964298_zestdatabase");
*/
      $result = mysqli_query($con, "SELECT * FROM employees WHERE lastName = '$user'") or die("Failed to query database " .mysqli_connect_error());
        
      while($row = mysqli_fetch_array($result))
      {
          if ($row['lastName'] == $user && $row['pin'] == $pass)
          {
            
              if ($row['type'] == 'M')
              {
                $_SESSION['manager']=$user;
                  echo '<script type="text/javascript"> window.open("../mPortal.php","_self");</script>';
              }
              else
              {
                $_SESSION['use']=$user;
                  echo '<script type="text/javascript"> window.open("../ePortal.php","_self");</script>';
              }
          }
      }
        echo '<script language="javascript">';
        echo 'alert("Invalid Username or PIN")';
        echo '</script>';
     }
      

    ?> 

    <form action="" method="post">
    <header>
    
    <a href=https://zestware123.000webhostapp.com/>
    <img border="0" alt="logo" src="buttons/zesty1.svg">
    </a>
    </header>
      <table width="400" border="0">
      <tr>
       <td>  Username: </td>
        <td> 
          <input type="text" name="user" >
         </td>
      </tr>
      <tr>
        <td> PIN: </td>
        <td><input type="password" name="pass"></td>
      </tr>
      <tr>
       
        <td> <input type="submit" name="login" value="LOGIN"></td>
        <td></td>
      </tr>
      </table>
    </form>
  </body>
</html>