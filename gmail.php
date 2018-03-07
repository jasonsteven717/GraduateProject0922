<?php	
	header('conten-type:text/html;charset=utf-8');
	
	$DB_server = "localhost";
	$DB_name = "graduate";
	$DB_user = "root";
	$DB_password = "";
	
	$email = $_POST['email'];
	$Vcode = $_POST['Vcode'];
	
	$connect = mysqli_connect($DB_server, $DB_user, $DB_password, $DB_name);
  
	mysqli_query($connect,"SET NAMES 'utf8'");
	
	
	require("../PHPMailer-master/PHPMailerAutoload.php");
date_default_timezone_set('Etc/UTC');
$mail = new PHPMailer;
$mail->isSMTP();
$mail->SMTPDebug = 2;
$mail->Debugoutput = 'html';
$mail->Host = 'smtp.gmail.com';
$mail->isHTML(true); 

//Set the SMTP port number - 587 for authenticated TLS, a.k.a. RFC4409 SMTP submission
$mail->Port = 587;

//Set the encryption system to use - ssl (deprecated) or tls
$mail->SMTPSecure = 'tls';

//Whether to use SMTP authentication
$mail->SMTPAuth = true;

//Username to use for SMTP authentication - use full email address for gmail
$mail->Username = "jungle0717@gmail.com";

//Password to use for SMTP authentication
$mail->Password = "jasonsteven717";

//Set who the message is to be sent from
$mail->setFrom('jungle0717@gmail.com', "BB");

//Set an alternative reply-to address
$mail->addReplyTo('jasonsteven717@gmail.com', "管理員");
	
	
		$mail->addAddress($email);
	$mail->Subject = "baby code";//發信主題

//Read an HTML message body from an external file, convert referenced images to embedded,
//convert HTML into a basic plain-text alternative body
//$mail->msgHTML(file_get_contents('contents.html'), dirname(__FILE__));//內文來源

 	
	
		$mail->Body = "<br>
		baby驗證碼:$Vcode<br>";

//Replace the plain text body with one created manually
//$mail->AltBody = 'This is a plain-text message body';//如果使用純文字

//Attach an image file
//$mail->addAttachment('images/phpmailer_mini.png');//夾帶圖片

if (!$mail->send()) {
    echo "發送錯誤: " . $mail->ErrorInfo;
} else {
    echo "成功發送邀請!";
}

?>
 