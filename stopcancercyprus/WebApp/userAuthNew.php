
<?php
session_start();

		if($_POST['user']=='admin' && $_POST['pass']=='pasykaf-scc'){
			$_SESSION['user']=1;
			header("location: main.php");
		}
		else{
            $_SESSION['user']=0;
			header("location: index.php");
		}

