<?php
	$DB_server = "localhost";
	$DB_name = "graduate";
	$DB_user = "root";
	$DB_password = "";
	
	$account = $_POST['Account'];
	$BN = $_POST['Bname'];
	
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
	$BNenC = encrypt($BN, $key, $key);
	
	$result= mysqli_query($connect, "SELECT * FROM info WHERE MomID = '$encrypted' AND BabyN = '$BNenC' ");

	
	//
		while($row = mysqli_fetch_array($result))
	{
		echo $row['Va01'].":";
		echo $row['Va02'].":";
		echo $row['Va03'].":";
		echo $row['Va04'].":";
		echo $row['Va05'].":";
		echo $row['Va06'].":";
		echo $row['Va07'].":";
		echo $row['Va08'].":";
		echo $row['Va09'].":";
		echo $row['Va10'].":";
		echo $row['Va11'].":";
		echo $row['Va12'].":";
		echo $row['Va13'].":";
		echo $row['Va14'].":";
		echo $row['Va15'].":";
		echo $row['Va16'].":";
		echo $row['Va17'].":";
		echo $row['VaTime01'].":";
		echo $row['VaTime02'].":";
		echo $row['VaTime03'].":";
		echo $row['VaTime04'].":";
		echo $row['VaTime05'].":";
		echo $row['VaTime06'].":";
		echo $row['VaTime07'].":";
		echo $row['VaTime08'].":";
		echo $row['VaTime09'].":";
		echo $row['VaTime10'].":";
		echo $row['VaTime11'].":";
		echo $row['VaTime12'].":";
		echo $row['VaTime13'].":";
		echo $row['VaTime14'].":";
		echo $row['VaTime15'].":";
		echo $row['VaTime16'].":";
		echo $row['VaTime17'].":";


		
	}

		
?>