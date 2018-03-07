<?php   
	$DB_server = "localhost";
	$DB_name = "graduate";
	$DB_user = "root";
	$DB_password = "";

	$problem = $_POST['problem'];
	$account = $_POST['Account'];
	$Bname = $_POST['Bn'];

	$connect = mysqli_connect($DB_server, $DB_user, $DB_password, $DB_name);
  
	mysqli_query($connect,"SET NAMES 'utf8'");
	
	function decrypt($content, $key, $iv)
	{
		return mcrypt_decrypt(MCRYPT_RIJNDAEL_128, $key, base64_decode($content), MCRYPT_MODE_CBC, $iv);
	}
	function encrypt($content, $key, $iv)
	{
		return base64_encode(mcrypt_encrypt(MCRYPT_RIJNDAEL_128, $key, $content, MCRYPT_MODE_CBC, $iv));
	}
	
	$key = 'asdfgqqwefsqwert';
	$AC = encrypt($account, $key, $key);
	$BabyN = encrypt($Bname, $key, $key);
	
	echo $AC."+".$BabyN;
	
	//$sql = "insert into babyinfo (problem) values ('$problem')";
	$sql = "UPDATE info SET VaProb06 = '$problem' WHERE MomID = '$AC' AND BabyN =  '$BabyN'";
	mysqli_query($connect,$sql);
	
?>