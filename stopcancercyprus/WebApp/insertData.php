<!DOCTYPE html>

<html>

<head>
<title>Insert - Cancer</title>
<link href="sccstyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
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
    <form action="userAuthNew.php" method="post" id="insertC">
        <p>Όνομα Καρκίνου:  <input name="cName" type="text" /></p>
        <p>Περιγραφή: </p>
        <p><textarea cols="40" rows="5" name="cDescr" wrap="virtual"></textarea></p>
        <input type="button" onclick="clearForm()" value="Καθαρισμός">
        <input name="submitCancer" type="submit" value="Αποθήκευση" /></form>
</div>
<script>
    function clearForm(){
        document.getElementById("insertC").reset();
    }
</script>
</body>

</html>