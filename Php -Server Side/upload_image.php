<?php
 
$image = $_POST['image'];
$name = $_POST['filename'];
$path = $_SERVER['DOCUMENT_ROOT'].'/ecare/upload_user_image/'.$name.'.jpg';

if(file_put_contents($path,base64_decode($image)))
{
echo "1";
}
else
{
echo "0";
}
 
?>