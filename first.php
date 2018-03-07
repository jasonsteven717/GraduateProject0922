<?php   
	$DB_server = "localhost";
	$DB_name = "graduate";
	$DB_user = "root";
	$DB_password = "";

	$MomID = $_POST['Account'];
	$NP = $_POST['Npass']; 
	$Phone = $_POST['Phone'];
	$Email = $_POST['Email'];

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
	$MomIDenC = encrypt($MomID, $key, $key);
	
	
	$result= mysqli_query($connect, "SELECT * FROM info WHERE MomID = '$MomIDenC'");
	
	
	
	while($row = mysqli_fetch_array($result))
	{
		
		$key = 'asdfgqqwefsqwert';
		
		$MomID = $row['MomID'];
		$pass = encrypt($NP, $key, $key);
		
		
		echo 'before:'.$row['password'].'<br>';
		echo 'after:'.$pass.'<br>';
		
		$result4= "UPDATE info SET password ='$pass' WHERE MomID='$MomID'";
		mysqli_query($connect, $result4);	
		
	}
	
	
	
	
	
	
	
    
	
	
  
?>
