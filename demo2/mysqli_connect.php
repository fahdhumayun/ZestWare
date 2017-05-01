<!-- Written, debugged, and tested by Ama Freeman -->

<?php
//Make a connection to the database
DEFINE('DB_USER', 'id964298_zestwaredatabase');
DEFINE('DB_PASSWORD', 'zestware123!');
DEFINE('DB_HOST', 'localhost');
DEFINE('DB_NAME', 'id964298_zestdatabase');

$dbc = @mysqli_connect(DB_HOST, DB_USER, DB_PASSWORD, DB_NAME)
OR die('Could not connect to MYSQL: '.
	mysqli_connect_error());
?>