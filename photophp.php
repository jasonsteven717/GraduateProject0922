<?php   
	$DB_server = "localhost";
	$DB_name = "graduate";
	$DB_user = "root";
	$DB_password = "";

	$Ac = $_POST['Account'];
	$BN = $_POST['Bn'];
	$uri = $_POST['uri'];

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
	$account = encrypt($Ac, $key, $key);
	$BabyN = encrypt($BN, $key, $key);
	
	
	$result= mysqli_query($connect, "SELECT * FROM info WHERE MomID = '$account' AND BabyN =  '$BabyN'");
	
	$row = mysqli_fetch_array($result);
	
	$sql = "UPDATE info SET BabyPhoto = '$uri' WHERE MomID = '$account' AND BabyN =  '$BabyN' ";
	mysqli_query($connect, $sql);
	
	echo $uri ;
	
  
?>
