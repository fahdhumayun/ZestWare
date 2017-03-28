<?php
//Make a connection to the database
DEFINE('DB_USER', 'root');
DEFINE('DB_PASSWORD', 'somethingstupid');
DEFINE('DB_HOST', 'localhost');
DEFINE('DB_NAME', 'zestware');

$dbc = @mysqli_connect(DB_HOST, DB_USER, DB_PASSWORD, DB_NAME)
OR die('Could not connect to MYSQL: '.
	mysqli_connect_error());
?>