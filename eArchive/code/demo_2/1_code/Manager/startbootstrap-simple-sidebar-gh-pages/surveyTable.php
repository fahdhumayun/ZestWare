<!--Written, tested, and debugged by Raphaelle Marcial 
REFERENCE: http://stackoverflow.com/questions/11698065/create-a-button-that-will-sort-a-mysql-query-ascending-and-descending
-->

<?php  

session_start();

?>

<!DOCTYPE html>
<html>
    <head>
        <title> 
          Survey Table 
        </title>
  <style>
  table {
    font-family: georgia, sans-serif;
    border-collapse: collapse;
    font-size:25px;
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


    <link rel="stylesheet" type="text/css" href="temp2.css"> 
    </head>
    <body>

    <?php

    if(!isset($_SESSION['manager'])) // If session is not set then redirect to Login Page
            {
                header("Location:https://zestware123.000webhostapp.com");  
            }

  ?>


    <div class = "logo">
    <a href=https://zestware123.000webhostapp.com/>
    <img border="0" alt="logo" src="buttons/zesty.png">
    </a>
    </div>

    <br>
    <br>
    <br>

<?php


// Ascending Order
if(isset($_POST['ASC']))
{
    $asc_query = "SELECT * FROM survey ORDER BY rating ASC";
    $result = executeQuery($asc_query);
}

// Descending Order
elseif (isset ($_POST['DESC'])) 
    {
          $desc_query = "SELECT * FROM survey ORDER BY rating DESC";
          $result = executeQuery($desc_query);
    }
    
    // Default Order
 else {
        $default_query = "SELECT * FROM survey";
        $result = executeQuery($default_query);
}

function executeQuery($query)
{
    $con = mysqli_connect("localhost", "id964298_zestwaredatabase", "zestware123!", "id964298_zestdatabase");
      if(!$con){
          die("Cannot connect: " . mysqli_connect_error());
      }
    
    mysqli_select_db($con, "id964298_zestdatabase");
    $result = mysqli_query($con, $query);
    
    return $result;
}

?>
        <div class = "table">
      
        <form action="surveyTable.php" method="post">
          
            
          
            <table>
            <caption> Surveys </caption>
                <tr>
                    <th>Survey ID</th>
                    <th>Rating</th>
                    <th>Time</th>
                    <th>Comment</th>
                </tr>
                <!-- populate table from mysql database -->
                <?php while ($row = mysqli_fetch_array($result)):?>
                <tr>
                    <td><?php echo $row['surveyID'];?></td>
                    <td><?php echo $row['rating'];?></td>
                    <td><?php echo $row['time'];?></td>
                    <td><?php echo $row['comment'];?></td>
                </tr>
                <?php endwhile;?>

                
                
        <form action="surveyTable.php" method="post">
          <input type="hidden" name="ASC" value="submit">
          <input type="image" src="buttons/RatingLH.png">
        </form>
        <form action="surveyTable.php" method="post">
          <input type="hidden" name="DESC" value="submit">
          <input type="image" src="buttons/RatingHL.png">
        </form>
           
        </table>
        
        </form>

        </div>
      
      <input type="image" src ="buttons/LogOut.png" alt="Submit" class = "LogOut" onclick="document.location.href='../startbootstrap-simple-sidebar-gh-pages/logout.php';">
    </body>
</html>