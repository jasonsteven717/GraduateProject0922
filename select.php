<?php
	$DB_server = "localhost";
	$DB_name = "graduate";
	$DB_user = "root";
	$DB_password = "";
	$i = 1;
	$account = $_POST['Account'];
	
	$connect = mysqli_connect($DB_server, $DB_user, $DB_password, $DB_name);
  
	mysqli_query($connect, "SET NAMES 'utf8'");
	
	function decrypt($content, $key, $iv)
	{
		return mcrypt_decrypt(MCRYPT_RIJNDAEL_128, $key, base64_decode($content), MCRYPT_MODE_CBC, $iv);
	}
	function encrypt($content, $key, $iv)
	{
		return base64_encode(mcrypt_encrypt(MCRYPT_RIJNDAEL_128, $key, $content, MCRYPT_MODE_CBC, $iv));
	}
	
	$key = 'asdfgqqwefsqwert';
	$encrypted = encrypt($account, $key, $key);
	
	$result= mysqli_query($connect, "SELECT * FROM info WHERE MomID = '$encrypted'");
	
	//
	
		while($row = mysqli_fetch_array($result))
	{
		$deC = decrypt($row['BabyN'], $key, $key);
		echo "第".$i."胎".$deC.":";
		$i++;
	}
	
	
?>