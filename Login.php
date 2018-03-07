<?php
header("Content-Type:text/html; charset=utf-8");
?>
<?php   
	$DB_server = "localhost";
	$DB_name = "graduate";
	$DB_user = "root";
	$DB_password = "";

	$account = addslashes($_POST['account']);
	$pass = addslashes($_POST['pass']); 
	
	$connect = mysqli_connect($DB_server, $DB_user, $DB_password, $DB_name);
	
	/*if(!mysql_connect($DB_server, $DB_user, $DB_password))
	{
        die("伺服器連線失敗");
	}*/
	
	mysqli_query($connect, "SET NAMES 'utf8_bin'");
	
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
	$PassdeC = encrypt($pass, $key, $key);
	
	
	$sql = "select MomID from info where MomID  ='$encrypted'  AND password = '$PassdeC'";
	
	$result = mysqli_query($connect,$sql) or die('MySQL query error');
	$values = mysqli_fetch_array($result);

	$key = 'asdfgqqwefsqwert';
		
	
	
	$deC = decrypt($values['MomID'], $key, $key);
	
	$AcdeC = decrypt($encrypted, $key, $key);
	
	$IDF =  str_split($deC, 10);
	$IDFA = str_split($IDF[0], 6);
	
	$PassenC = encrypt($pass, $key, $key);
	
	$PassdeC = decrypt($PassenC, $key, $key);
	
	
	
	if( $AcdeC == $deC )
	{
		if( $pass == $IDFA[1])
		{
			echo '2-';
		}
		else
		{
			echo "1-" ;
		
		}
		
		$result= mysqli_query($connect,"SELECT * FROM info WHERE MomID = '$encrypted'");
			//$result1= mysql_query("SELECT * FROM mominfo WHERE m_ID = '$account'");
	
	
			$i = 1;
			while($row = mysqli_fetch_array($result))
			{
				
				echo decrypt($row['BabyN'], $key, $key)."@";
				$i++;
				//echo $row['name'].":";
			}	
		
		
	}
	else
	{
		echo '0';
	}
?>
