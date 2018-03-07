<?php   

	$DB_server = "localhost";
	$DB_name = "graduate";
	$DB_user = "root";
	$DB_password = "";
	
	$connect = mysqli_connect($DB_server, $DB_user, $DB_password, $DB_name);
  
	mysqli_query($connect,"SET NAMES 'utf8'");
	
	


	/*$result1= mysql_query("CREATE TABLE BB(b_name text,b_ID char(10),Sex text,birth date,m_name text,m_ID text,account text,password text, vaccine1 char(1) NOT NULL default '0', vaccine2 char(1) NOT NULL default '0', vaccine3 char(1) NOT NULL default '0', vaccine4 char(1) NOT NULL default '0', vaccine5 char(1) NOT NULL default '0', vaccine6 char(1) NOT NULL default '0', vaccine7 char(1) NOT NULL default '0', vaccine8 char(1) NOT NULL default '0', vaccine9 char(1) NOT NULL default '0', vaccine10 char(1) NOT NULL default '0', vaccine11 char(1) NOT NULL default '0', vaccine12 char(1) NOT NULL default '0', vaccine13 char(1) NOT NULL default '0', vaccine14 char(1) NOT NULL default '0', vaccine15 char(1) NOT NULL default '0', vaccine16 char(1) NOT NULL default '0', vaccine17 char(1) NOT NULL default '0',
	vaccine1time date,vaccine2time date,vaccine3time date,vaccine4time date,vaccine5time date,vaccine6time date,vaccine7time date,vaccine8time date,vaccine9time date,vaccine10time date,
	vaccine11time date,vaccine12time date,vaccine13time date,vaccine14time date,vaccine15time date,vaccine16time date,vaccine17time date)default character set utf8 default collate utf8_general_ci;");*/ /*創新的工作table跟欄位*/

	
	$update = mysqli_query($connect,"UPDATE info,wsg 
						   SET info.VaTime01 = wsg.vaccine1time, info.VaTime02 = wsg.vaccine2time, info.VaTime03 = wsg.vaccine3time, info.VaTime04 = wsg.vaccine4time, info.VaTime05 = wsg.vaccine5time
							, info.VaTime06 = wsg.vaccine6time, info.VaTime07 = wsg.vaccine7time, info.VaTime08 = wsg.vaccine8time, info.VaTime09 = wsg.vaccine9time, info.VaTime10 = wsg.vaccine10time
							, info.VaTime11 = wsg.vaccine11time, info.VaTime12 = wsg.vaccine12time, info.VaTime13 = wsg.vaccine13time, info.VaTime14 = wsg.vaccine14time, info.VaTime15 = wsg.vaccine15time
							, info.VaTime16 = wsg.vaccine16time, info.VaTime17 = wsg.vaccine17time, info.BabyBirth = wsg.Birth
						   WHERE wsg.ID = info.BabyID");
						  
	/*$result3= "INSERT INTO BB(b_name,b_ID,Sex,birth,m_name,m_ID, account, password,
	vaccine1time,vaccine2time,vaccine3time,vaccine4time,vaccine5time,vaccine6time,vaccine7time,vaccine8time,vaccine9time,vaccine10time,
	vaccine11time,vaccine12time,vaccine13time,vaccine14time,vaccine15time,vaccine16time,vaccine17time)
	SELECT a.Name, a.ID, a.Sex, a.Birth, a.MomName, a.m_ID, b.account, b.password, a.vaccine1time, a.vaccine2time, a.vaccine3time, a.vaccine4time, a.vaccine5time, a.vaccine6time, a.vaccine7time, a.vaccine8time, a.vaccine9time, a.vaccine10time,
	a.vaccine11time, a.vaccine12time, a.vaccine13time, a.vaccine14time, a.vaccine15time, a.vaccine16time, a.vaccine17time FROM babyinfo b,wsg a WHERE b.b_ID = a.ID";*/

	mysqli_query($connect,"UPDATE info SET Va01 = '1' WHERE VaTime01 != '0000-00-00'");
	mysqli_query($connect,"UPDATE info SET Va02 = '1' WHERE VaTime02 != '0000-00-00'");
	mysqli_query($connect,"UPDATE info SET Va03 = '1' WHERE VaTime03 != '0000-00-00'");
	mysqli_query($connect,"UPDATE info SET Va04 = '1' WHERE VaTime04 != '0000-00-00'");
	mysqli_query($connect,"UPDATE info SET Va05 = '1' WHERE VaTime05 != '0000-00-00'");
	mysqli_query($connect,"UPDATE info SET Va06 = '1' WHERE VaTime06 != '0000-00-00'");
	mysqli_query($connect,"UPDATE info SET Va07 = '1' WHERE VaTime07 != '0000-00-00'");
	mysqli_query($connect,"UPDATE info SET Va08 = '1' WHERE VaTime08 != '0000-00-00'");
	mysqli_query($connect,"UPDATE info SET Va09 = '1' WHERE VaTime09 != '0000-00-00'");
	mysqli_query($connect,"UPDATE info SET Va10 = '1' WHERE VaTime10 != '0000-00-00'");
	mysqli_query($connect,"UPDATE info SET Va11 = '1' WHERE VaTime11 != '0000-00-00'");
	mysqli_query($connect,"UPDATE info SET Va12 = '1' WHERE VaTime12 != '0000-00-00'");
	mysqli_query($connect,"UPDATE info SET Va13 = '1' WHERE VaTime13 != '0000-00-00'");
	mysqli_query($connect,"UPDATE info SET Va14 = '1' WHERE VaTime14 != '0000-00-00'");
	mysqli_query($connect,"UPDATE info SET Va15 = '1' WHERE VaTime15 != '0000-00-00'");
	mysqli_query($connect,"UPDATE info SET Va16 = '1' WHERE VaTime16 != '0000-00-00'");
	mysqli_query($connect,"UPDATE info SET Va17 = '1' WHERE VaTime17 != '0000-00-00'");
	


	
	/*while($row = mysql_fetch_array($result))
	{
		$name = $row['Name'];
		echo $name.' ';
		echo $row['ID'].' ';
		echo $row['problem'].' ';
		echo $row['vaccine2time'].' ';
		echo "<br>";

		
		
		//$result2 = mysql_query("INSERT INTO BB (b_name)VALUES ('$name');");				
	}*/
	
	//$result3 = mysql_query("DROP TABLE BB;");/*結束後刪掉table*/
	 
?>