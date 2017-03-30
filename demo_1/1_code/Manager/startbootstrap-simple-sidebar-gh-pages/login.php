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
        header("Location:../startbootstrap-simple-sidebar-gh-pages/index2.php"); 
      }
      if(isset($_SESSION['manager']))   // Checking whether the session is already there or not if true then header redirect it to the home page directly  
      {
        header("Location:../startbootstrap-simple-sidebar-gh-pages/index3.php"); 
      }


      if(isset($_POST['login']))   // it checks whether the user clicked login button or not 
      {
        $user = $_POST['user'];
        $pass = $_POST['pass'];

        //echo 'Hello' .$user.'!';
        $link = mysql_connect("localhost", "root", "somethingstupid");
        mysql_select_db("zestware");

        $result = mysql_query("SELECT * FROM employees WHERE lastName = '$user'") or die("Failed to query database " .mysql_error());
        
    	while($row = mysql_fetch_array($result))
    	{
        	if ($row['lastName'] == $user && $row['pin'] == $pass)
        	{
        		
            	if ($row['type'] == 'M')
            	{
            		$_SESSION['manager']=$user;
              		echo '<script type="text/javascript"> window.open("../startbootstrap-simple-sidebar-gh-pages/index3.php","_self");</script>';
            	}
            	else
            	{
            		$_SESSION['use']=$user;
              		echo '<script type="text/javascript"> window.open("../startbootstrap-simple-sidebar-gh-pages/index2.php","_self");</script>';
            	}
        	}
    	}
        echo '<script language="javascript">';
        echo 'alert("Invalid Username or PIN")';
        echo '</script>';
	   }
      

    ?> 

    <form action="" method="post">
    <header>Welcome to Zest-Ware</header>
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