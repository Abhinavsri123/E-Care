<?php
require'db.php';

$username = json_decode(file_get_contents('php://input'));
$user = $username->user;

$sql = "SELECT * from `challan` where `user` = '".$user."'";

$result = mysqli_query($con,$sql);

$data = "";
$response = array();

if(mysqli_num_rows($result)>0)
{
while($row = mysqli_fetch_array($result))
{
array_push($response,array("ch"=>$row[0],"date"=>$row[2],"vehical"=>$row[3],"resone"=>$row[4],"fine"=>$row[5]));
}
}

echo json_encode(array("server_response"=>$response));

?>