<?php
require'db.php';

$user = $_POST['user'];
$date = $_POST['date'];
$time =$_POST['time'];
$type =$_POST['type'];
$num =$_POST['number'];
$loc =$_POST['location'];

$sql = "Insert into `travellingdetails` VALUES ('".$user."','".$date."','".$num."','".$time."','".$loc."','".$type."') ";

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