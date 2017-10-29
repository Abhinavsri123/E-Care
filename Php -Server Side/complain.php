<?php
require'db.php';

$user = $_POST['user'];
$com =$_POST['com'];
$allow =$_POST['allow'];
$loc =$_POST['loc'];

$sql = "Insert into `complain` VALUES ('".$user."','".$loc."','".$com."','".$allow."') ";

$result = mysqli_query($con,$sql);

if($result)
{
echo "1";
}	
else
{
echo "0";
}
 
?>