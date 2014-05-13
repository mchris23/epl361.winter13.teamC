<!DOCTYPE html>
<?php
session_start();
include("glob.html");
?>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert - Cancer</title>
    <link href="sccstyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
<?php
if(!isset($_SESSION['user']) || $_SESSION['user']!=1){
    header("location: index.php");
}
?>
<div class="main">
    <form accept-charset="utf-8" action="" method="post" id="changeP">
        <p>Παλιός κωδικός:  <input name="oldP" type="password" /></p>
        <p>Νέος κωδικός:  <input name="newP1" type="password" /></p>
        <p>Επιβεβαίωση νέου κωδικού:  <input name="newP2" type="password" /></p>
        <input type="button" onclick="clearForm()" value="Καθαρισμός">
        <input name="submitPass" type="submit" value="Αλλαγή Κωδικού"  /></form>
</div>
<script>
    function clearForm(){
        document.getElementById("changeP").reset();
    }
</script>
<?php
if(isset($_POST['oldP']) && isset($_POST['newP1']) && isset($_POST['newP2']))
{
    if($_POST['newP1']==$_POST['newP2']){
        $con = mysql_connect("localhost","stopcancercyprus","zx&w&tin");
        if(!$con)
        {
            echo '<script type="text/javascript">alert("Πρόβλημα σύνδεσης με τη βάση δεδομένων. Παρακαλώ δοκιμάστε ξανά αργότερα.");window.location.href="main.php";</script>';
        }
        else
        {
            mysql_select_db("stopcancercyprus", $con);
            mysql_set_charset('utf8', $con);
            $select_query = "SELECT * FROM WPASS";
            $res = mysql_query($select_query, $con);
            if($res)
            {
                $old=$res{'wpassword'};
                if($_POST['oldP']==$old)
                {
                    $query = "UPDATE WPASS SET wpassword='".$_POST['newP1']."' WHERE wuser='admin'";
                    $res2 = mysql_query($select_query, $con);
                    if($res2)
                    {
                        mysql_close($con);
                        echo '<script type="text/javascript">alert("Ο κωδικός έχει αλλάξει με επιτυχία!");window.location.href="main.php";</script>';
                    }
                    else
                    {
                        mysql_close($con);
                        echo '<script type="text/javascript">alert("Πρόβλημα σύνδεσης με τη βάση δεδομένων. Παρακαλώ δοκιμάστε ξανά αργότερα.");window.location.href="main.php";</script>';
                    }
                }
                else
                {
                    mysql_close($con);
                    echo '<script type="text/javascript">alert("Έχετε εισάγει λανθασμένο κωδικό πρόσβασης. Παρακαλώ ξαναδοκιμάστε.");</script>';
                }
            }
            else
            {
                echo '<script type="text/javascript">alert("Πρόβλημα σύνδεσης με τη βάση δεδομένων. Παρακαλώ δοκιμάστε ξανά αργότερα.");window.location.href="main.php";</script>';
                mysql_close($con);
            }
        }
    }
    else
        echo '<script type="text/javascript">alert("Ο νέος κωδικός και ο επιβεβαιωμένος νέος κωδικός δεν ταιριάζουν! Παρακαλώ ξαναδοκιμάστε.");</script>';
}
?>
</body>

</html>