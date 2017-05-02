<!-- Written, tested, and debugged by Raphaelle Marcial
REFERENCE: https://github.com/lets-learn/spotify-playlist-generator
-->

<?php
session_start();
?>

<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <title>Spotify</title>
  <link rel="stylesheet" href="style.css">
</head>
<body>
  
  <main class="main-container">
    <a href=https://zestware123.000webhostapp.com/>
    <img border="0" alt="logo" src="buttons/zesty.png">
    </a>
    <section>
      <div class="form">
        <img src="note.svg" alt="">
        <form action="">
          <input type="search" value="">
          <input type="submit" value="Create">
        </form>
        <p>Icon created by unlimicon from the Noun Project</p>
      </div>
      <div class="playlist">
        <div class="loader">
          <div class="inner-circle"></div>
        </div>
      </div>
    </section>
    <input type='button'value='Log Out' class="btn" onclick="document.location.href='../startbootstrap-simple-sidebar-gh-pages/logout.php';"/>
  </main>
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
  <script src="script-complete.js"></script>


</body>
</html>