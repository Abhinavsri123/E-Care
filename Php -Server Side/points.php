<?php
require'db.php';

$user = $_POST['user'];

$sql = "SELECT * from `points` where `user` = '".$user."' ";

$result = mysqli_query($con,$sql);


if(mysqli_num_rows($result)>0)
{
while($row = mysqli_fetch_array($result))
{
$point = $row['point'];
}
}
if($result)
{
echo $point;
}
else
{
echo "Not Found";
}


?>