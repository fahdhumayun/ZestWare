<html>
    <head>
        <link rel="stylesheet" type="text/css" href="survey.css">
    </head>
    <body>

        <?php

        if(isset($_POST['submit']))   // it checks whether the user clicked login button or not 
        {
            if ($_POST['rating'] && $_POST['comment'])
            {
                $currentDateTime = new \DateTime();
                $currentDateTime->setTimezone(new \DateTimeZone('America/New_York'));
                $dateTime = $currentDateTime->format('l-j-M-Y H:i:s A');

                $link = mysql_connect("localhost", "root", "somethingstupid");
                mysql_select_db("zestware");

                $rating = $_POST['rating'];
                $comment = $_POST['comment'];
                $managerResponse = 'N/A';
                //echo 'RATING = ' . $rating . '</br>';

                mysql_query("INSERT INTO survey (rating, time, comment, managerResponse) VALUES ('$rating','$dateTime', '$comment', 'managerResponse'") or die("Failed to query database " .mysql_error());
                
                echo '<script language="javascript">';
                echo 'alert("Thank You for Your Response!")';
                echo '</script>';

                /*if (!mysql_query($sql)) 
                {
                    die('Error: ' . mysql_error());
                }*/
                
            }

            else 
            {
                echo '<script language="javascript">';
                echo 'alert("No Information Was Entered")';
                echo '</script>';
                

            }
            
        }
        ?>
        <h1>We Would Love to Hear From You!</h1>
        <form action="../startbootstrap-simple-sidebar-gh-pages/survey.php" method="post">
        <table width="500" border="0">
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
        <td><textarea name="comment" placeholder = "Please enter comment" rows="5" cols="40"></textarea>
        </tr>
        <tr>
        <td> <input type="submit" name="submit" value="Submit"></td>
        <td></td>
        </tr>
        </table>
        </form>
        
    </body>

</html>