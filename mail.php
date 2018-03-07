<?php 
if(@$_POST['nickname']!=''){
$nickname=$_POST['nickname'];
$email=$_POST['email'];
$sub=$_POST['subject'];
$content=$_POST['content'];

mb_internal_encoding("utf-8");
$to="z052766399@gmail.com";//填入自己的電子信箱
$subject=mb_encode_mimeheader("PHP自動發信","utf-8");
$message="YAYA";
$headers="MIME-Version: 1.0\r\n";
$headers.="Content-type: text/html; charset=utf-8\r\n";
$headers.="From:".mb_encode_mimeheader("777","utf-8")."<z052766399@gmail>\r\n";
mail($to,$subject,$message,$headers);
}
?>