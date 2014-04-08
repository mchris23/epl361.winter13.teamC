<!DOCTYPE html>
<?php
session_start();
?>
<html>

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>userAuth - page should not appear in browser</title>
</head>

<body>
<!--error reporting for debugging-->
<?php
error_reporting(E_ALL);
ini_set('display_errors','1');
?>

</body>
<?php
		if($_POST['user']=='stopcancercyprus' && $_POST['pass']=='epl363'){
			$_SESSION['user']=1;
			header("location: main.php");
		}
		else{
            $_SESSION['user']=0;
			header("location: index.php");
		}
	

?>
</html>
