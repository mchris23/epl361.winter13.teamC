<!DOCTYPE html>
<?php
session_start();
include("glob.html");
?>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Update Entry</title>
    <link href="sccstyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
<?php
if(!isset($_SESSION['user']) || $_SESSION['user']!=1){
    header("location: index.php");
}
?>
<div class="main">
    <form accept-charset="utf-8" action="" method="post" id="updateC">
        Ενημέρωση Καρκίνου:<br/>
        <select name='CANCER'>
            <?php
            include 'connection.php';
            getCancers();
            ?>
        </select>
        <input type="submit" value="Ενημέρωση" name="updateCancer"/>
    </form>
    <form accept-charset="utf-8" action="" method="post" id="updateE">
        Ενημέρωση Εξέτασης:<br/>
        <select name='ΕΧΑΜΙΝΑΤΙΟΝ'>
            <?php
            include 'connection.php';
            getExams();
            ?>
        </select>
        <input type="submit" value="Ενημέρωση" name="updateExam"/>
    </form>
</div>
<?php
if(isset($_POST['CANCER']))
{
    $con = mysql_connect("localhost","stopcancercyprus","zx&w&tin");
    if(!$con)
    {
        echo '<script type="text/javascript">alert("Πρόβλημα σύνδεσης με τη βάση δεδομένων. Παρακαλώ δοκιμάστε ξανά αργότερα.");window.location.href="main.php";</script>';
    }
    else
    {
        $split = explode(".",$_POST['CANCER'],2);
        mysql_select_db("stopcancercyprus", $con);
        mysql_set_charset('utf8', $con);
        $select_query = "SELECT * FROM CANCER WHERE ID_cancer=".$split[0]." AND Deleted=0";
        $res = mysql_query($select_query, $con);
        if($res)
        {
            $_SESSION['cUpdate']=1;
            $_SESSION['cID']=$res{'ID_cancer'};
            $_SESSION['cName']=$res{'cancer_name'};
            $_SESSION['cDescr']=$res{'cancer_description'};
            mysql_close($con);
            unset($_POST['CANCER']);
            header("location:insertCancer.php");
        }
        else
        {
            mysql_close($con);
            unset($_POST['CANCER']);
            echo '<script type="text/javascript">alert("Πρόβλημα σύνδεσης με τη βάση δεδομένων. Παρακαλώ δοκιμάστε ξανά αργότερα.");window.location.href="main.php";</script>';
        }
    }
}
if(isset($_POST['EXAMINATION']))
{
    $con = mysql_connect("localhost","stopcancercyprus","zx&w&tin");
    if(!$con)
    {
        echo '<script type="text/javascript">alert("Πρόβλημα σύνδεσης με τη βάση δεδομένων. Παρακαλώ δοκιμάστε ξανά αργότερα.");window.location.href="main.php";</script>';
    }
    else
    {
        $split = explode(".",$_POST['EXAMINATION'],2);
        mysql_select_db("stopcancercyprus", $con);
        mysql_set_charset('utf8', $con);
        $select_query = "SELECT * FROM EXAMINATION WHERE ID_exam=".$split[0]." AND Deleted=0";
        $res = mysql_query($select_query, $con);
        if($res)
        {
            $_SESSION['eUpdate']=1;
            $_SESSION['eID']=$res{'ID_exam'};
            $_SESSION['eName']=$res{'exam_name'};
            $_SESSION['eDescr']=$res{'exam_description'};
            $_SESSION['eFreq']=$res{'exam_frequency'};
            $_SESSION['eGender']=$res{'exam_gender'};
            $_SESSION['eSmoker']=$res{'exam_smoker'};
            $_SESSION['eAlcohol']=$res{'exam_alcohol'};
            $_SESSION['eHistory']=$res{'exam_history'};
            $_SESSION['eExam']=$res{'is_exam'};
            $_SESSION['eFreq']=$res{'exam_frequency'};
            $agedb=explode("-",$res{'exam_agerange'});
            $_SESSION['eAgeFrom']=$agedb[0];
            $_SESSION['eAgeTo']=$agedb[1];
            $dmsdb=explode("-",$res{'exam_dms'});
            $_SESSION['eDMSFrom']=$dmsdb[0];
            $_SESSION['eDMSTo']=$dmsdb[1];
            $_SESSION['ePicture']=$res{'exam_link'};
            mysql_close($con);
            unset($_POST['EXAMINATION']);
            header("location:insertExam.php");
        }
        else
        {
            mysql_close($con);
            unset($_POST['EXAMINATION']);
            echo '<script type="text/javascript">alert("Πρόβλημα σύνδεσης με τη βάση δεδομένων. Παρακαλώ δοκιμάστε ξανά αργότερα.");window.location.href="main.php";</script>';
        }
    }
}
?>
</body>
</html>