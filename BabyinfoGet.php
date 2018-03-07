<?php
	$DB_server = "localhost";
	$DB_name = "graduate";
	$DB_user = "root";
	$DB_password = "";
	
	$account = $_POST['Account'];
	$name = $_POST['Bname'];
	
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
	$Ac = encrypt($account, $key, $key);
	$Bn = encrypt($name, $key, $key);
	
	$result= mysqli_query($connect, "SELECT * FROM info WHERE MomID = '$Ac' and BabyN = '$Bn'");
	
		while($row = mysqli_fetch_array($result))
	{
		$birthday = $row['BabyBirth'];
		$BabyNdeC = decrypt($row['BabyN'], $key, $key);
		echo $BabyNdeC."@";
		echo $row['BabySex']."@";
		echo $row['BabyBirth']."@";
		echo $row['BabySex']."@";
		echo $row['BabyPhoto']."@";
		$MomNdeC = decrypt($row['MomN'], $key, $key);
		echo $MomNdeC."@";
	}
	
	
	$startymd = strtotime($birthday); 
	/*starthms = strtotime(10-30-30); 
	$startdate=strtotime("2009-9-5");
	$enddate=strtotime("2009-9-18");*/
    $array_ymd = explode('-', $startymd ); 
	//$array_hms = explode('-', $starthms); 

	$endymd = strtotime(strftime("%Y-%m-%d"));
	//$endhms = strtotime(date('H-i-s'));
	$array_eymd = explode('-', $endymd ); 
	/*$array_ehms = explode('-', $endhms); 
	$startdate =mktime($array_hms[0],$array_hms[1],$array_hms[2],$array_ymd[1],$array_ymd[2],$array_ymd[0]); 
	$enddate = mktime($array_ehms[0],$array_ehms[1],$array_ehms[2],$array_eymd[1],$array_eymd[2],$array_eymd[0]); */
	$days= ($endymd-$startymd)/86400 ; 
	//echo $startymd;
	//echo $endymd;
	echo round($days); 
	
?>