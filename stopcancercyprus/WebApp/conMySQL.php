<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>Untitled 1</title>
</head>

<body>
<!--error reporting for debugging-->
<?php
error_reporting(E_ALL);
ini_set('display_errors','1');
?>

<?php
	$con = mysql_connect("localhost","stopcancercyprus","zx&w&tin");
	if (!$con)
		echo "".mysql_error();
	else
		echo "Connection successful";
?>

</body>

</html>
