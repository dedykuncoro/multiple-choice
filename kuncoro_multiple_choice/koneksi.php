<?php
	$server		= "localhost"; //sesuaikan dengan nama server
	$user		= "root"; //sesuaikan username
	$password	= "enter"; //sesuaikan password
	$database	= "kuncoro_multiple_choice"; //sesuaikan target databese
	
	$connect = mysql_connect($server, $user, $password) or die ("Koneksi gagal!");
	mysql_select_db($database) or die ("Database belum siap!");
?>