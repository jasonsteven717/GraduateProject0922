<?php 

	$DB_server = "localhost";
	$DB_name = "graduate";
	$DB_user = "root";
	$DB_password = "";
	
	//$account = "I100366999"; //$_POST['account'];
	
	if(!@mysql_connect($DB_server, $DB_user, $DB_password))
	{
        die("伺服器連線失敗");
	}
  
	mysql_query("SET NAMES 'utf8'");
	mysql_select_db($DB_name);  

	
	
$startymd = strtotime("2017-07-21"); 
//$starthms = strtotime(10-30-30); 

//$startdate=strtotime("2009-9-5");
//$enddate=strtotime("2009-9-18");
$array_ymd = explode('-', $startymd ); 
//$array_hms = explode('-', $starthms); 

$endymd = strtotime(strftime("%Y-%m-%d"));
//$endhms = strtotime(date('H-i-s'));
$array_eymd = explode('-', $endymd ); 
//$array_ehms = explode('-', $endhms); 
//$startdate =mktime($array_hms[0],$array_hms[1],$array_hms[2],$array_ymd[1],$array_ymd[2],$array_ymd[0]); 
//$enddate = mktime($array_ehms[0],$array_ehms[1],$array_ehms[2],$array_eymd[1],$array_eymd[2],$array_eymd[0]); 
$days= ($endymd-$startymd)/86400 ; 
//echo $startymd;
//echo $endymd;
//echo $enddate;
//echo $startdate;
echo round($days); 
?>