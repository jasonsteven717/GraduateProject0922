<?php   
	$DB_server = "localhost";
	$DB_name = "graduate";
	$DB_user = "root";
	$DB_password = "";


	$connect = mysqli_connect($DB_server, $DB_user, $DB_password, $DB_name);
  
	mysqli_query($connect ,"SET NAMES 'utf8'");
	

	$result= mysqli_query($connect ,"SELECT * FROM info");/*join比對資料*/
	
	
	function encrypt($content, $key, $iv)
{
	return base64_encode(mcrypt_encrypt(MCRYPT_RIJNDAEL_128, $key, $content, MCRYPT_MODE_CBC, $iv));
}
	while($row = mysqli_fetch_array($result))
	{
		$MomID = "3456";
		
		$key = 'asdfgqqwefsqwert';
		$encrypted = encrypt($MomID, $key, $key);
		
		echo 'before:'.$MomID.'<br>';
		echo 'after:'.$encrypted.'<br>';
		
		mysqli_query($connect, $result4);	
		
	}
?>