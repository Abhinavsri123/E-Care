<?php
require'db.php';

$user = $_POST['user'];
$date = $_POST['date'];
$time =$_POST['time'];
$image =$_POST['image'];
$point = "0";
$status = "Under Process";

$sql = "Insert into `rule_breaking` VALUES ('','".$user."','".$date."','".$status."','".$point."','".$time."','".$image."') ";

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