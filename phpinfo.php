<?php
$DB_server = "localhost";
	$DB_name = "graduate";
	$DB_user = "root";
	$DB_password = "";

	
	if(!@mysql_connect($DB_server, $DB_user, $DB_password))
	{
        die("伺服器連線失敗");
	}
	
	mysql_query("SET NAMES 'utf8'");
	mysql_select_db($DB_name);  

$sql = $_POST['query_string'];
$sql = stripslashes($sql);
$res = mysql_query($sql);
while($r = mysql_fetch_assoc($res))
    $output[] = $r;

print(json_encode($output));
echo '$res';
mysql_close();

?>