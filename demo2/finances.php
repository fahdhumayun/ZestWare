<!-- Written, tested, and debugged by Ama Freeman -->

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
      Restaurant Finances
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
      Accounts Table 
    </caption>
    <tr>
    <th>Account Name
    <th>Account Number
    <th>Account Type
    <th>Total Amount in Account
    <!--<th>Delete-->
    </tr>

  <?php
      $con = mysqli_connect("localhost", "id964298_zestwaredatabase", "zestware123!", "id964298_zestdatabase");
        if(!$con){
            die("Cannot connect: " . mysqli_connect_error());
        }
    
      mysqli_select_db($con, "id964298_zestdatabase");
      $result = mysqli_query($con, "SELECT * FROM finances");
        //echo $row['day'] . ': ' . $row['hours'] . '<br/>';

      if(isset($_SESSION['manager'])) // If session is not set then redirect to Login Page
      { 
      
      while($row = mysqli_fetch_array($result))
        {
          print "<tr>\n";
          print "<td>" . $row['Account'] . "\n";
          print "<td>" . $row['AccountNumber'] . "\n";
          print "<td>" . $row['AccountType'] . "\n";
          print "<td>" . $row['Total'] . "\n";
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
      <br>
    <br>
    <br>

    <form action="finances.php" id = "form" method="post">
      <table width="500" border="0">
      <caption> Create New Financial Account </caption>
      
      <tr>
        <td> Select Account Type:  
        
        <select name = "period" form = "form">
          <option name ="checking" value="checking">Checking</option>
          <option name = "savings" value="savings">Savings</option>   
        </select>
        </td>
      </tr>
      <tr>
        <tr>
        <td> Enter Account Name: 
          <input type="text" placeholder = "Account Name" name = "accountName">
        </td>
      </tr>
      </tr>
      <tr>
        <td> Enter Account Amount:
          <input type="text" placeholder = "Account Amount" name = "accountAmount">
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

    if(isset($_POST['submit']))   // it checks whether the user clicked submit button or not 
        {
            if (($_POST['period'] && $_POST['accountName'] && $_POST['accountAmount'])) 
            {

              $con = mysqli_connect("localhost", "id964298_zestwaredatabase", "zestware123!", "id964298_zestdatabase");
          
              if(!$con)
              {
                die("Cannot connect: " . mysqli_connect_error());
              }
    
              mysqli_select_db($con, "id964298_zestdatabase");

              $AccountName = $_POST['accountName'];
              $AccountType = $_POST['period'];
              $AccountNumber = rand(10000, 99999);//Random number from 10000 to 99999
              $Total = $_POST['accountAmount'];

              $result = mysqli_query($con, "SELECT * FROM finances");

              while($row = mysqli_fetch_array($result))
                  {
                    $sql = "INSERT INTO finances (Account, AccountNumber, AccountType, Total) VALUES ('$AccountName', '$AccountNumber', '$AccountType', '$Total')";

                  }

              if (mysqli_query($con, $sql)) 
              {
                echo '<script language="javascript">';
                echo 'alert("New Account Created")';
                echo '</script>';
              } 
              else 
              {
                echo "Error: " . $sql . "<br>" . mysqli_error($con);
              }

            }
        }
?>