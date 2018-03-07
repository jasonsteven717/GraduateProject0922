<?php   
	$DB_server = "localhost";
	$DB_name = "graduate";
	$DB_user = "root";
	$DB_password = "";

	$mpassword = "Q222333456";//$_POST['mpassword'];
	$account = "123456";//$_POST['Account'] ;
	

	$connect = mysqli_connect($DB_server, $DB_user, $DB_password, $DB_name);
  
	mysqli_query($connect,"SET NAMES 'utf8'");
  
	
	function encrypt($content, $key, $iv)
	{
		return base64_encode(mcrypt_encrypt(MCRYPT_RIJNDAEL_128, $key, $content, MCRYPT_MODE_CBC, $iv));
	}
	function decrypt($content, $key, $iv)
	{
		return mcrypt_decrypt(MCRYPT_RIJNDAEL_128, $key, base64_decode($content), MCRYPT_MODE_CBC, $iv);
	}
	$key = 'asdfgqqwefsqwert';
	$MP = encrypt($mpassword, $key, $key);
	$AC = encrypt($account, $key, $key);
	$qq = encrypt("3456", $key, $key);

	echo $qq;
	$pp = decrypt("RFIAHcttTGsnYojpe04mUw==", $key, $key);
	$ww = decrypt("YMY4OddUvkOaWMUqJXfONw==", $key, $key);
	echo $ww;
	//echo $mpassword."1".$MP."1".$account."1".$AC."1".$pp;
	//$sql = "insert into babyinfo (problem) values ('$problem')";
	$sql = "UPDATE info SET password = '$MP' WHERE MomID = '$AC'";
	mysqli_query($connect, $sql)or die('MySQL query error');;
	
	
	
	//$sql = "select * from number where class = ".$number;
	

  

?>