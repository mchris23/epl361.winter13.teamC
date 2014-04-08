<!DOCTYPE html>
<?php
session_start();
?>
<html>

<head>
<meta content="text/html; charset=utf-8" http-equiv="Content-Type" />
<title>Main</title>
<link href="sccstyle.css" rel="stylesheet" type="text/css" />
</head>

<body>
<?php
if(!isset($_SESSION['user']) || $_SESSION['user']!=1){
	header("location: index.php");
}
?>

<img alt="background image" src="images/bground.jpg" id="full-screen-background-image"/>
    <div class="top">
    <p>StopCancerCyprus - Database Management</p>
    </div>

    <div class="left">
        <ul>
            <li><a href="insertData.php">Εισαγωγή Καρκίνου</a> </li>
            <li><a href="insertPrev.php">Εισαγωγή Πρόληψης</a> </li>
            <li><a href="insertExam.php">Εισαγωγή Εξέτασης</a></li>
            <li><a href="index.php" onclick="<?php session_destroy(); ?>">Αποσύνδεση</a></li>
        </ul>
    </div>

    <div class="main">
    <p>Main Content</p>
    </div>

</body>

</html>
