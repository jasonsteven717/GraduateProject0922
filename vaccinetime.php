<?php
	$DB_server = "localhost";
	$DB_name = "graduate";
	$DB_user = "root";
	$DB_password = "";
	
	$account = $_POST['Account'];
	$BN = $_POST['Bn'];
	
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
	
	$result= mysqli_query($connect, "SELECT * FROM info WHERE MomID = '$encrypted' and BabyN = '$BNenC'");
	
	//
		while($row = mysqli_fetch_array($result))
	{
		
		echo $row['BabyBirth']."-";
		echo $row['Va01']."-";
		echo $row['Va02']."-";
		echo $row['Va03']."-";
		echo $row['Va04']."-";
		echo $row['Va05']."-";
		echo $row['Va06']."-";
		echo $row['Va07']."-";
		echo $row['Va08']."-";
		echo $row['Va09']."-";
		echo $row['Va10']."-";
		echo $row['Va11']."-";
		echo $row['Va12']."-";
		echo $row['Va13']."-";
		echo $row['Va14']."-";
		echo $row['Va15']."-";
		echo $row['Va16']."-";
		echo $row['Va17']."-";
		/*echo $row['vaccine1time']."-";
		echo $row['vaccine2time']."-";
		echo $row['vaccine3time']."-";
		echo $row['vaccine4time']."-";
		echo $row['vaccine5time']."-";
		echo $row['vaccine6time']."-";
		echo $row['vaccine7time']."-";
		echo $row['vaccine8time']."-";
		echo $row['vaccine9time']."-";
		echo $row['vaccine10time']."-";
		echo $row['vaccine11time']."-";
		echo $row['vaccine12time']."-";
		echo $row['vaccine13time']."-";
		echo $row['vaccine14time']."-";
		echo $row['vaccine15time']."-";
		echo $row['vaccine16time']."-";
		echo $row['vaccine17time']."-";*/
		$deC = decrypt($row['BabyN'], $key, $key);
		echo $deC."-";
		
	}

	
?>