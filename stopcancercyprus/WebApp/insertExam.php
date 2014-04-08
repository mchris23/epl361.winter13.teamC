<!DOCTYPE html>

<html xmlns="http://www.w3.org/1999/html">

<head>
    <title>Insert - Exam</title>
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
    <form action="userAuthNew.php" method="post" id="insertE">
        <p>Όνομα Εξέτασης:  <input name="eName" type="text" /></p>
        <p>Περιγραφή: <br />
        <textarea cols="40" rows="5" name="eDescr" wrap="virtual"></textarea></p>
        <p>Συχνότητα διεκπεραίωσης (σε μήνες): <input name="eFreq" type="text" /></p>
        <p>Αφορά:<br />
            <table style="width:400px">
            <tr>
                <td><input name="eGender" type="radio" value="Άντρες" />Άντρες</td>
                <td><input name="eSmoker" type="radio" value="Μη Καπνιστές" />Μη Καπνιστές</td>
                <td><input name="eAlcohol" type="radio" value="Αλκοολικούς" />Αλκοολικούς</td>
            </tr>
            <tr>
                <td><input name="eGender" type="radio" value="Γυναίκες"/>Γυναίκες</td>
                <td><input name="eSmoker" type="radio" value="Καπνιστές" />Καπνιστές</td>
                <td><input name="eAlcohol" type="radio" value="Μη Αλκοολικούς" />Μη Αλκοολικούς</td>
            </tr>
            <tr>
                <td><input name="eGender" type="radio" value="Και τα δυο"/>Γυναίκες</td>
                <td><input name="eSmoker" type="radio" value="Πρώην Καπνιστές" />Πρώην Καπνιστές</td>
                <td><input name="eAlcohol" type="radio" value="Και τα δυο" />Και τα δυο</td>
            </tr>
            <tr>
                <td></td>
                <td><input name="eSmoker" type="radio" value="Και τα τρια" />Και τα τρια</td>
                <td></td>
            </tr>
           </table></p>
        <input type="button" onclick="clearForm()" value="Καθαρισμός">
        <input name="submitExam" type="submit" value="Αποθήκευση" /></form>
</div>
<script>
    function clearForm(){
        document.getElementById("insertE").reset();
    }
</script>
</body>

</html>