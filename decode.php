<?php   
	$DB_server = "localhost";
	$DB_name = "graduate";
	$DB_user = "root";
	$DB_password = "";

	function decrypt($content, $key, $iv)
	{
		return mcrypt_decrypt(MCRYPT_RIJNDAEL_128, $key, base64_decode($content), MCRYPT_MODE_CBC, $iv);
	}

	$connect = mysqli_connect($DB_server, $DB_user, $DB_password, $DB_name);
  
	mysqli_query($connect ,"SET NAMES 'utf8'");
	

	$result= mysqli_query($connect ,"SELECT * FROM info");/*join比對資料*/
	
	
	
	
	function encrypt($content, $key, $iv)
{
	return base64_encode(mcrypt_encrypt(MCRYPT_RIJNDAEL_128, $key, $content, MCRYPT_MODE_CBC, $iv));
}
	mysqli_query($connect,"SET NAMES 'utf8'");
	
	$key = 'asdfgqqwefsqwert';
	
	echo decrypt('WPqQcbJWppPNyRWaSYlMyA==', $key, $key);	
	
	
	
?>