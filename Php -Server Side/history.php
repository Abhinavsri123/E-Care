<?php
require'db.php';

$username = json_decode(file_get_contents('php://input'));
$user = $username->user;

$user = "shubham";
$sql = "SELECT * from `rule_breaking` where `user` = '".$user."'";

$result = mysqli_query($con,$sql);

$data = "";
$response = array();

if(mysqli_num_rows($result)>0)
{
while($row = mysqli_fetch_array($result))
{
array_push($response,array("sn"=>$row[0],"date"=>$row[2],"status"=>$row[3],"point"=>$row[4]));
}
}

echo json_encode(array("server_response"=>$response));

?>