<?php  

session_start();

?>

<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, shrink-to-fit=no, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Employee Portal</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/simple-sidebar.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

    <div id="wrapper">

        <!-- Sidebar -->
        <div id="sidebar-wrapper">
            <ul class="sidebar-nav">
                <li class="sidebar-brand">
                    <a href="#">
                        Employee Portal
                    </a>
                </li>
                <li>
                    <a href="../startbootstrap-simple-sidebar-gh-pages/shifts.php">Employee Shift Table</a>
                </li>
                <li>
                    <a href="../startbootstrap-simple-sidebar-gh-pages/edit.php">Edit Information</a>
                </li>
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1>Employee Portal</h1>

                        <h3>
                        <?php
                        if(!isset($_SESSION['use'])) // If session is not set then redirect to Login Page
                        {
                          header("Location:Login.php");  
                        }
    //echo "<a href='logout.php'> Logout</a> <br> "; 
    //echo "<a href='surveyTable.php'> Survey Table </a> <br> ";
    //echo "<a href='shifts.php'> Shift Table</a> <br> ";
    //echo $_SESSION['use'];
    //echo "Welcome {$_SESSION['use']} <br>";
                        $link = mysql_connect("localhost", "root", "somethingstupid");
                        mysql_select_db("zestware");
                        $result = mysql_query("SELECT * FROM employees WHERE lastName = '".$_SESSION['use']."'") or die("Failed to query database " .mysql_error());
        
                        while($row = mysql_fetch_array($result))
                        {
                          echo 'Welcome ' . $row['firstName'] . '</br>';
                          $firstName = $row['firstName'];
        
                          //$firstName = $row['firstName'];
                          //$lastName = $row['lastName'];
                          //$type = $row['type'];
                        }

    
       
  ?>

                        <p>
                            <?php

                            $link = mysql_connect("localhost", "root", "somethingstupid");
                            mysql_select_db("zestware");
                            $result = mysql_query("SELECT * FROM employees WHERE lastName = '".$_SESSION['use']."'") or die("Failed to query database " .mysql_error());
                            while($row = mysql_fetch_array($result))
                            {
                                echo 'Wage: $' . $row['wage'] . '</br>';
                                echo 'Type: ' . $row['type'] . '</br>';
                                
                                $lastName = $row['lastName'];
                                $type = $row['type'];       
        
                          
                            }
                            ?>
                        </p>

                       
                        <a href="#menu-toggle" class="btn btn-default" id="menu-toggle">Toggle Menu</a>
                        <br><br>
                        <?php 
                        if(isset($_POST['submit']))   // it checks whether the user clicked submit button or not 
    {
     
      $link = mysql_connect("localhost", "root", "somethingstupid");

      if (!$link) 
      {
      die('Could not connect: ' . mysql_error());
      }

      $db_selected = mysql_select_db("zestware", $link);

      if (!$db_selected)
      {
        die('Can\'t use ' . zestware . ': ' . mysql_error());
      }

      $result = mysql_query("SELECT * FROM employees WHERE lastName = '".$_SESSION['use']."'") or die("Failed to query database " .mysql_error());
        
      while($row = mysql_fetch_array($result))
      {
        $firstName = $row['firstName'];
        $lastName = $row['lastName'];
        $type = $row['type'];
      }
      if ($_POST['date'] && $_POST['comment'])
      {
        $date = $_POST['date'];
        $comment = $_POST['comment'];

        $sql = "INSERT INTO absence (firstName, lastName, date, comment, type) VALUES ('$firstName', '$lastName', '$date', '$comment', '$type')";

        echo '<script language="javascript">';
        echo 'alert("Request Sent")';
        echo '</script>';

        if (!mysql_query($sql)) {
        die('Error: ' . mysql_error());
      }
      }
      else
      {
          echo '<script language="javascript">';
          echo 'alert("Enter All Fields")';
          echo '</script>';
      }
      

      mysql_close();

    }




                        if(isset($_POST['clockIn']))   // it checks whether the user clicked login button or not 
                        {
                            $currentDateTime = new \DateTime();
                            $currentDateTime->setTimezone(new \DateTimeZone('America/New_York'));
                            $dateTime = $currentDateTime->format(' H:i:s ');

                            $result = mysql_query("SELECT * FROM employees WHERE lastName = '".$_SESSION['use']."'") or die("Failed to query database " .mysql_error());
          
                            while($row = mysql_fetch_array($result))
                            {
                                $firstName = $row['firstName'];
                            }
                            //echo "Time the button was clicked: " . $dateTime . "<br>";
                             mysql_query("UPDATE shifts SET clockIn = '$dateTime' WHERE firstName = '$firstName'") or die("Failed to query database " .mysql_error());
                            echo '<script language="javascript">';
                            echo 'alert("Successfully Clocked In")';
                            echo '</script>';
                            }
       
                        ?>

                        <form action="../startbootstrap-simple-sidebar-gh-pages/index2.php" method="post">
                            <header>Report Absence</header>
                            <table width="200" border="0">
                            <tr>
    
                                <td> Date: </td>
                                <td><input type="date" name = "date"/></td>
                            </tr>
                            <tr>
                                <td> Comments: </td>
                                <td><textarea name="comment" rows="5" cols="40"></textarea>
                            </tr>
                            <tr>
                                <td> <input type="submit" name="submit" value="Submit"></td>
                                <td></td>
                            </tr>
                            </table>
                            </form>

                        <br><br>

                        <form action="" method="post">
                        <table width="200" border="0">
                        <tr>
                            <td> <input type="submit" name="clockIn" value="Clock In"></td>
                            <td></td>
                            </tr>
                        </table>
                        </form>
                        <br><br>





                        <input type='button'value='Log Out' class="btn" onclick="document.location.href='../startbootstrap-simple-sidebar-gh-pages/logout.php';"/>
                    </div>
                </div>
            </div>
        </div>
        <!-- /#page-content-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Menu Toggle Script -->
    <script>
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#wrapper").toggleClass("toggled");
    });
    </script>

</body>

</html>