<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">

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
if(isset($_SESSION['auth'])){
	if($_SESSION['auth']==1){
		if($_POST['user']=='scc' && $_POST['pass']=='epl363'){
			$_SESSION['user']=1;
			$_SESSION['auth']=0;
			header("location: main.php");
		}
		else{
			$_SESSION['wrong']=1;
			$_SESSION['auth']=0;
			header("location: login.php");
		}
	}
} 
?>
</html>
