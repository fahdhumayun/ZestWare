<!-- Written, tested, and debugged by Raphaelle Marcial 

Reference: https://codepen.io/jamesbarnett/pen/vlpkh

-->

<html>
    <head>
    <style>
      body {
        background: #cefdce;
        margin: 20px
        font-family: georgia;
  
      }

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
        <link rel="stylesheet" type="text/css" href="survey.css">
        <link rel="stylesheet" type="text/css" href="temp3.css">
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
        </div>

      
          <div class = "table">
        <?php

        if(isset($_POST['submit']))   // it checks whether the user clicked login button or not 
        {
            if ($_POST['rating'] && $_POST['comment'])
            {
                $currentDateTime = new \DateTime();
                $currentDateTime->setTimezone(new \DateTimeZone('America/New_York'));
                $dateTime = $currentDateTime->format('l-j-M-Y H:i:s A');

                $con = mysqli_connect("localhost", "id964298_zestwaredatabase", "zestware123!", "id964298_zestdatabase");
                if(!$con){
                  die("Cannot connect: " . mysqli_connect_error());
                }
                mysqli_select_db($con, "id964298_zestdatabase");
                $rating = $_POST['rating'];
                $comment = $_POST['comment'];
                
                //echo $comment;
                $managerResponse = 'N/A';
               
                //echo 'RATING = ' . $rating . '</br>';

                //$sql = "INSERT INTO absence (firstName, lastName, date, comment, type) VALUES ('$firstName', '$lastName', '$date', '$comment', '$type')";
                $sql = "INSERT INTO survey (rating, time, comment) VALUES ('$rating', '$dateTime', '$comment')";
              
                
                if (mysqli_query($con, $sql)) {
                echo '<script language="javascript">';
                echo 'alert("Thank You for Your Response!")';
                echo '</script>';
                }
                else {
                echo "Error: " . $sql . "<br>" . mysqli_error($con);
                }

                
                
            }

            else 
            {
                echo '<script language="javascript">';
                echo 'alert("No Information Was Entered")';
                echo '</script>';
                

            }
            
        }
        ?>
        
        <form action="../startbootstrap-simple-sidebar-gh-pages/survey.php" method="post">
        <table width="500" border="0">
        <caption> We'd Love to Hear From You! </caption>
        <tr>
            <fieldset class="rating">
            <input type="radio" id="star5" name="rating" value="5" /><label class = "full" for="star5" title="Awesome - 5 stars"></label>
            <input type="radio" id="star4half" name="rating" value="4.5" /><label class="half" for="star4half" title="Pretty good - 4.5 stars"></label>
            <input type="radio" id="star4" name="rating" value="4" /><label class = "full" for="star4" title="Pretty good - 4 stars"></label>
            <input type="radio" id="star3half" name="rating" value="3.5" /><label class="half" for="star3half" title="Meh - 3.5 stars"></label>
            <input type="radio" id="star3" name="rating" value="3" /><label class = "full" for="star3" title="Meh - 3 stars"></label>
            <input type="radio" id="star2half" name="rating" value="2.5" /><label class="half" for="star2half" title="Kinda bad - 2.5 stars"></label>
            <input type="radio" id="star2" name="rating" value="2" /><label class = "full" for="star2" title="Kinda bad - 2 stars"></label>
            <input type="radio" id="star1half" name="rating" value="1.5" /><label class="half" for="star1half" title="Oh no - 1.5 stars"></label>
            <input type="radio" id="star1" name="rating" value="1" /><label class = "full" for="star1" title="Sucks big time - 1 star"></label>
            <input type="radio" id="starhalf" name="rating" value="0.5" /><label class="half" for="starhalf" title="Sucks big time - 0.5 stars"></label>
            </fieldset>
        
        </tr>
        <tr>
        <td><textarea name="comment" placeholder = "Please enter comment" rows="5" cols="45"></textarea>
        </tr>
        
        </table>
        <input type="hidden" name="submit" value="submit">
                            <input type="image" src="buttons/Submit.png"></td>
        </form>
        </div>
        
    </body>

</html>