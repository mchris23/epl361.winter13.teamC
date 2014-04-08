<!DOCTYPE html>

<html>

<head>
    <title>Insert - Prevention</title>
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
    <form action="userAuthNew.php" method="post" id="insertP">
        <p>Όνομα Τρόπου Πρόληψης:  <input name="pName" type="text" /></p>
        <p>Περιγραφή: </p>
        <p><textarea cols="40" rows="5" name="pDescr" wrap="virtual"></textarea></p>
        <input type="button" onclick="clearForm()" value="Καθαρισμός">
        <input name="submitPrev" type="submit" value="Αποθήκευση" /></form>
</div>
<script>
    function clearForm(){
        document.getElementById("insertP").reset();
    }
</script>
</body>

</html>