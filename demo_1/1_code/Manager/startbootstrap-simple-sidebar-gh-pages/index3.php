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

    <title>Manager Portal</title>

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
                        Manager Portal
                    </a>
                </li>
                <li>
                    <a href="../startbootstrap-simple-sidebar-gh-pages/shifts.php">Employee Shift Table</a>
                </li>
                <li>
                    <a href="../startbootstrap-simple-sidebar-gh-pages/absence.php">Absence Reports</a>
                </li>
                <li>
                    <a href="../getEmployeeInfo.php">View Employee Table</a>
                </li>
                <li>
                    <a href="../inventoryIndex.php">Inventory</a>
                </li>
                <li>
                    <a href="../addEmployee.php">Add Employees</a>
                </li>
                <li>
                    <a href="../startbootstrap-simple-sidebar-gh-pages/surveyTable.php">Survey Results</a>
                </li>
            </ul>
        </div>
        <!-- /#sidebar-wrapper -->

        <!-- Page Content -->
        <div id="page-content-wrapper">
            <div class="container-fluid">
                <div class="row">
                    <div class="col-lg-12">
                        <h1>Manager Portal</h1>

                        <h3>
                        <?php
                        if(!isset($_SESSION['manager'])) // If session is not set then redirect to Login Page
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
                        $result = mysql_query("SELECT * FROM employees WHERE lastName = '".$_SESSION['manager']."'") or die("Failed to query database " .mysql_error());
        
                        while($row = mysql_fetch_array($result))
                        {
                          echo 'Welcome ' . $row['firstName'] . '</br>';
        
                          //$firstName = $row['firstName'];
                          //$lastName = $row['lastName'];
                          //$type = $row['type'];
                        }

    
       
  ?>

                        <p></p>

                       
                        <a href="#menu-toggle" class="btn btn-default" id="menu-toggle">Toggle Menu</a>
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