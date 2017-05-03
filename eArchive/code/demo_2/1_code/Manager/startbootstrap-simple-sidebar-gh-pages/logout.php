<!-- Written, tested, and debuged by Raphaelle Marcial -->

<?php

  session_start();

  echo "Logout Successfully ";
  session_destroy();   // function that Destroys Session 
  header("Location: ../startbootstrap-simple-sidebar-gh-pages/login.php");
?>

