<!DOCTYPE html>
<?php
session_start();
include("glob.html");
?>
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Insert - Exam</title>
    <link href="sccstyle.css" rel="stylesheet" type="text/css" />
</head>
<body>
<?php
if(!isset($_SESSION['user']) || $_SESSION['user']!=1){
    header("location: index.php");
}
?>

<div class="main">
    <form action="" method="post" id="insertE" enctype="multipart/form-data">
        <p>Όνομα Εξέτασης:  <input name="eName" type="text" value="<?php newtext('eName')?>" /></p>
        <p>Περιγραφή: <br />
        <textarea cols="40" rows="5" name="eDescr" wrap="virtual" value="<?php newtext('eDescr')?>"></textarea></p>
        <p>Συχνότητα διεκπεραίωσης (σε μήνες): <input name="eFreq" type="text"  value="<?php newtext('eName')?>"/></p>
        <p>Αφορά:<br />
            <table style="width:1000px" >
            <tr>
                <td><input name="eGender" id="g" type="radio" value="Άντρες" <?php newradio('eGender',0)?>/>Άντρες</td>
                <td><input name="eSmoker" id="s" type="radio" value="Μη Καπνιστές" <?php newradio('eSmoker',2)?>/>Μη Καπνιστές</td>
                <td><input name="eAlcohol" type="radio" value="Αλκοολικούς" <?php newradio('eAlcohol',0)?>/>Αλκοολικούς</td>
                <td><input name="eHistory" type="radio" value="Με οικογενειακό ιστορικό" <?php newradio('eHistory',0)?>/>Με οικογενειακό ιστορικό</td>
                <td><input name="eSex" type="radio" value="Σεξουαλικά ενεργούς" <?php newradio('eSex',0)?>/>Σεξουαλικά Ενεργούς</td>
                <td><input name="eExam" type="radio" value="Εξέταση" <?php newradio('eExam',0)?>/>Εξέταση</td>
            </tr>
            <tr>
                <td><input name="eGender" type="radio" value="Γυναίκες" <?php newradio('eGender',1)?>/>Γυναίκες</td>
                <td><input name="eSmoker" type="radio" value="Καπνιστές" <?php newradio('eSmoker',0)?>/>Καπνιστές</td>
                <td><input name="eAlcohol" type="radio" value="Μη Αλκοολικούς" <?php newradio('eAlcohol',1)?>/>Μη Αλκοολικούς</td>
                <td><input name="eHistory" type="radio" value="Χωρίς οικογενειακό ιστορικό" <?php newradio('eHistory',1)?>/>Χωρίς οικογενειακό ιστορικό</td>
                <td><input name="eSex" type="radio" value="Μη σεξουαλικά ενεργούς" <?php newradio('eSex',1)?>/>Μη σεξουαλικά Ενεργούς</td>
                <td><input name="eExam" type="radio" value="Τρόπος Πρόληψης" <?php newradio('eExam',1)?>/>Τρόπος Πρόληψης</td>
            </tr>
            <tr>
                <td><input name="eGender" type="radio" value="Και τα δυο" <?php newradio('eGender',2)?>/>Και τα δυο</td>
                <td><input name="eSmoker" type="radio" value="Πρώην Καπνιστές" <?php newradio('eSmoker',2)?>/>Πρώην Καπνιστές</td>
                <td><input name="eAlcohol" type="radio" value="Και τα δυο" <?php newradio('eAlcohol',2)?>/>Και τα δυο</td>
                <td><input name="eHistory" type="radio" value="Και τα δυο" <?php newradio('eHistory',2)?>/>Και τα δυο</td>
                <td><input name="eSex" type="radio" value="Και τα δυο" <?php newradio('eSex',2)?>/>Και τα δυο</td>
                <td><input name="eExam" type="radio" value="Και τα δυο" <?php newradio('eExam',2)?>/>Και τα δυο</td>
            </tr>
            <tr>
                <td></td>
                <td><input name="eSmoker" type="radio" value="Και τα τρια" <?php newradio('eSmoker',3)?>/>Και τα τρια</td>
                <td></td>
            </tr>
           </table></p>
        <p><table style="width:700px">
            <tr>
                <td>Ηλικίες:</td>
                <td>Από:</td>
                <td><input name="eAgeFrom" type="text" value="<?php newtext('eAgeFrom')?>"/></td>
                <td>Μέχρι:</td>
                <td><input name="eAgeTo" type="text" value="<?php newtext('eAgeTo')?>"/></td>
            </tr>
            <tr>
                <td>Δείκτης μάζας σώματος:</td>
                <td>Από:</td>
                <td><input name="eDMSFrom" type="text" value="<?php newtext('eDMSFrom')?>"/></td>
                <td>Μέχρι:</td>
                <td><input name="eDMSTo" type="text" value="<?php newtext('eDMSTo')?>"/></td>
            </tr>
        </table></p>
        <p>Εικόνα:
        <input type="file" name="ePicture" accept="image/*" value="<?php newtext('ePicture')?>" /></p>
        <br />
        <input type="button" onclick="clearForm()" value="Καθαρισμός">
        <input name="submitExam" type="submit" value="Αποθήκευση" /></form>
</div>
<script type="text/javascript">
    function clearForm(){
        document.getElementById("insertE").reset();
    }
</script>
<?php
if(isset($_POST['eName']) && isset($_POST['eDescr']) && isset($_POST['eFreq']) && isset($_POST['eGender']) && isset($_POST['eSmoker']) && isset($_POST['eAlcohol']) && isset($_POST['eHistory']) && isset($_POST['eExam']) && isset($_POST['eAgeFrom']) && isset($_POST['eAgeTo']) && isset($_POST['eDMSFrom']) && isset($_POST['eDMSTo']) && isset($_POST['ePicture']) && (!isset($_POST['eUpdate']) || ($_POST['eUpdate'==0])))
{
    if(($_POST['eName']!="") && ($_POST['eDescr']!="") && ($_POST['eFreq']!="") && ($_POST['eGender']!="") && ($_POST['eSmoker']!="") && ($_POST['eAlcohol']!="") && ($_POST['eHistory']!="") && ($_POST['eExam']!="") && ($_POST['eAgeFrom']!="") && ($_POST['eAgeTo']!="") && ($_POST['eDMSFrom']!="") && ($_POST['eDMSTo']!="") && ($_POST['ePicture']!=""))
    {
        $con = mysql_connect("localhost","stopcancercyprus","zx&w&tin");
        if(!$con)
        {
            echo '<script type="text/javascript">alert("Πρόβλημα σύνδεσης με τη βάση δεδομένων. Παρακαλώ δοκιμάστε ξανά αργότερα.");window.location.href="main.php";</script>';
        }
        else
        {
            $gen = $_POST['eGender'];
            if($gen=="Άντρες")          $gen=0;
            elseif($gen=="Γυναίκες")    $gen=1;
            else                        $gen=2;

            $smo = $_POST['eSmoker'];
            if($smo=="Μη Καπνιστές")            $smo=2;
            elseif($smo=="Καπνιστές")           $smo=0;
            elseif($smo=="Πρώην Καπνιστές")     $smo=1;
            else                                $smo=3;

            $alc = $_POST['eAlcohol'];
            if($alc=="Αλκοολικούς")             $alc=0;
            elseif($alc=="Μη Αλκοολικούς")      $alc=1;
            else                                $alc=2;

            $his = $_POST['eHistory'];
            if($his=="Με οικογενειακό ιστορικό")           $his=0;
            elseif($his=="Χωρίς οικογενειακό ιστορικό")    $his=1;
            else                                           $his=2;

            $exa = $_POST['eExam'];
            if($exa=="Εξέταση")                 $exa=0;
            elseif($exa=="Τρόπος Πρόληψης")     $exa=1;
            else                                $exa=2;

            $sex = $_POST['eSex'];
            if($sex=="Σεξουαλικά ενεργούς")            $sex=0;
            elseif($sex=="Μη σεξουαλικά ενεργούς")     $sex=1;
            else                                       $sex=2;

            $age = $_POST['eAgeFrom']."-".$_POST['eAgeTo'];
            $dms = $_POST['eDMSFrom']."-".$_POST['eDMSTo'];

            if ($_FILES["ePicture"]["error"] > 0)
            {
                echo "Error: " . $_FILES["ePicture"]["error"] . "<br>";
            }
            else
            {
                if (file_exists("images/" . $_FILES["file"]["name"]))
                {
                    echo $_FILES["ePicture"]["name"]." ήδη υπάρχει. Παρακαλώ χρησιμοποιήστε διαφορετικό όνομα. ";
                } else
                {
                    move_uploaded_file($_FILES["ePicture"]["tmp_name"],"images/" . $_FILES["ePicture"]["name"]);
                }
            }

            mysql_select_db("stopcancercyprus", $con);
            mysql_set_charset('utf8', $con);
            $select_query = "INSERT INTO EXAMINATION(exam_name,exam_description,exam_frequency,exam_sex,exam_agerange,exam_dms,exam_smoker,exam_familyhistory,exam_alcohol,exam_gender,exam_link,is_exam)) VALUES ('".$_POST['cName']."','".$_POST['cDescr']."',".$_POST['eFreq'].",".$sex.",".$age.",".$dms.",".$smo.",".$his.",".$alc.",".$gen.",'"."https://dione.in.cs.ucy.ac.cy/assignments/stopcancercyprus/images/".$_FILES["ePicture"]["name"]."',".$exa.")";
            $res = mysql_query($select_query, $con);
            if($res)
            {
                echo '<script type="text/javascript">alert("Τα στοιχεία υποβλήθηκαν επιτυχώς!");window.location.href="main.php";</script>';
            }
            else
            {
                echo '<script type="text/javascript">alert("Πρόβλημα εισαγωγής. Παρακαλώ δοκιμάστε ξανά αργότερα.");window.location.href="main.php";</script>';
            }
            mysql_close($con);
            header("location:main.php");
        }
    }
    else
        echo '<script type="text/javascript">alert("Πρέπει να συμπληρώσετε όλα τα πεδία για να προχωρήσετε!");</script>';
}
elseif (isset($_POST['eName']) && isset($_POST['eDescr']) && isset($_POST['eFreq']) && isset($_POST['eGender']) && isset($_POST['eSmoker']) && isset($_POST['eAlcohol']) && isset($_POST['eHistory']) && isset($_POST['eExam']) && isset($_POST['eAgeFrom']) && isset($_POST['eAgeTo']) && isset($_POST['eDMSFrom']) && isset($_POST['eDMSTo']) && isset($_POST['ePicture']) && isset($_POST['eUpdate']) && ($_POST['eUpdate'==1]))
{
    unset($_POST['eUpdate']);
    if(($_POST['eName']!="") && ($_POST['eDescr']!="") && ($_POST['eFreq']!="") && ($_POST['eGender']!="") && ($_POST['eSmoker']!="") && ($_POST['eAlcohol']!="") && ($_POST['eHistory']!="") && ($_POST['eExam']!="") && ($_POST['eAgeFrom']!="") && ($_POST['eAgeTo']!="") && ($_POST['eDMSFrom']!="") && ($_POST['eDMSTo']!="") && ($_POST['ePicture']!=""))
    {
        $con = mysql_connect("localhost","stopcancercyprus","zx&w&tin");
        if(!$con)
        {
            echo '<script type="text/javascript">alert("Πρόβλημα σύνδεσης με τη βάση δεδομένων. Παρακαλώ δοκιμάστε ξανά αργότερα.");window.location.href="main.php";</script>';
        }
        else
        {
            $gen = $_POST['eGender'];
            if($gen=="Άντρες")          $gen=0;
            elseif($gen=="Γυναίκες")    $gen=1;
            else                        $gen=2;

            $smo = $_POST['eSmoker'];
            if($smo=="Μη Καπνιστές")            $smo=2;
            elseif($smo=="Καπνιστές")           $smo=0;
            elseif($smo=="Πρώην Καπνιστές")     $smo=1;
            else                                $smo=3;

            $alc = $_POST['eAlcohol'];
            if($alc=="Αλκοολικούς")             $alc=0;
            elseif($alc=="Μη Αλκοολικούς")      $alc=1;
            else                                $alc=2;

            $his = $_POST['eHistory'];
            if($his=="Με οικογενειακό ιστορικό")           $his=0;
            elseif($his=="Χωρίς οικογενειακό ιστορικό")    $his=1;
            else                                           $his=2;

            $exa = $_POST['eExam'];
            if($exa=="Εξέταση")                 $exa=0;
            elseif($exa=="Τρόπος Πρόληψης")     $exa=1;
            else                                $exa=2;

            $sex = $_POST['eSex'];
            if($sex=="Σεξουαλικά ενεργούς")            $sex=0;
            elseif($sex=="Μη σεξουαλικά ενεργούς")     $sex=1;
            else                                       $sex=2;

            $age = $_POST['eAgeFrom']."-".$_POST['eAgeTo'];
            $dms = $_POST['eDMSFrom']."-".$_POST['eDMSTo'];

            if ($_FILES["ePicture"]["error"] > 0)
            {
                echo "Error: " . $_FILES["ePicture"]["error"] . "<br>";
            }
            else
            {
                if (file_exists("images/" . $_FILES["file"]["name"]))
                {
                    echo $_FILES["ePicture"]["name"]." ήδη υπάρχει. Παρακαλώ χρησιμοποιήστε διαφορετικό όνομα. ";
                } else
                {
                    move_uploaded_file($_FILES["ePicture"]["tmp_name"],"images/" . $_FILES["ePicture"]["name"]);
                }
            }
            mysql_select_db("stopcancercyprus", $con);
            mysql_set_charset('utf8', $con);
            $select_query = "UPDATE EXAMINATION SET exam_name='".$_POST['eName']."', exam_description='".$_POST['eDescr']."', exam_frequency=".$_POST['eFreq'].", exam_sex=".$sex.", exam_agerange=".$age.", exam_dms=".$dms.", exam_smoker=".$smo.",exam_familyhistory=".$his.", exam_alcohol=".$alc.", exam_gender=".$gen.",exam_link='"."https://dione.in.cs.ucy.ac.cy/assignments/stopcancercyprus/images/".$_FILES["ePicture"]["name"]."',is_exam=".$exa." WHERE ID_cancer=".$_SESSION['eID'];
            $res = mysql_query($select_query, $con);
            if($res)
            {
                echo '<script type="text/javascript">alert("Τα στοιχεία ενημερώθηκαν επιτυχώς!");window.location.href="main.php";</script>';
                mysql_close($con);
            }
            else
            {
                echo '<script type="text/javascript">alert("Πρόβλημα ενημέρωσης. Παρακαλώ δοκιμάστε ξανά αργότερα.");window.location.href="main.php";</script>';
                mysql_close($con);
            }
        }
    }
    else
        echo '<script type="text/javascript">alert("Πρέπει να συμπληρώσετε όλα τα πεδία για να προχωρήσετε!");</script>';
}

function newtext($name)
{
    if(isset($_POST['eUpdate']) && ($_POST['eUpdate']==1))
        echo $_SESSION[$name];
    else
        echo "";
}

function newradio($name, $order)
{
    if(isset($_POST['eUpdate']) && ($_POST['eUpdate']==1))
    {
        if($order==$_SESSION[$name])
            echo 'checked="checked"';
        else
            echo '';
    }
    else
        echo '';
}
?>

</body>
</html>