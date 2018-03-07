<?php   
	$DB_server = "localhost";
	$DB_name = "graduate";
	$DB_user = "root";
	$DB_password = "";

	$BabyN = $_POST['BabyN'];
	$BabyP = $_POST['BabyP']; 	
	$MoN = $_POST['MoN'];
	$MoP = $_POST['MoP']; 
	$Phone = $_POST['Phone'];
	$Email = $_POST['Email'];
	$Birth = $_POST['Birth'];
	$Sex = $_POST['Sex'];
	$Adr = $_POST['Adr'];

	if(!@mysql_connect($DB_server, $DB_user, $DB_password))
	{
        die("伺服器連線失敗");
	}
  
	mysql_query("SET NAMES 'utf8'");
	mysql_select_db($DB_name);   
	
	
	$result= mysql_query("SELECT * FROM mominfo WHERE m_ID = '$MoP'");
	
	$row = mysql_fetch_array($result);
	
		$ID = $row['m_ID'];
		
		if ($MoP == $ID )
		{
			echo '身分證重複註冊!!';
		}
		else
		{
			echo '註冊成功!!!';
			$sql = "insert into babyinfo (b_mID, name, birth, sex, account, password, b_ID) values ('$MoP','$BabyN','$Birth','$Sex','$MoP','$Phone','$BabyP')";
			mysql_query($sql);
	
			$sql = "insert into mominfo (m_ID, m_name, m_phone, m_email, m_account , m_address, m_password) values ('$MoP','$MoN','$Phone','$Email','$MoP','$Adr','$Phone')";
			mysql_query($sql);
		}
	
	
	
	
	
	
    
	
	
  
?>
