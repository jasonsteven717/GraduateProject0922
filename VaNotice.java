package net.macdidi.graduateproject;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Timer;

/**
 * Created by Green on 2017/9/21.
 */

public class VaNotice extends AppCompatActivity {
    final String url = "http://192.168.2.101/AppTest/vaccinetime.php";
    String problemtp;
    String val = null;
    int birthyear,birthmon,birthdate,va1,va2,va3,va4,va5,va6,va7,va8,va9,va10,va11,va12,va13,va14,va15,va16,va17;
    int Vnum=0;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        new Thread(runnable).start();

        Intent i1 = new Intent(VaNotice.this , MainActivity.class) ;
        startActivity(i1);

    }

    public class TimerTaskTest extends java.util.TimerTask{

        @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
        @Override
        public void run() {
            // TODO Auto-generated method stub
            switch (Vnum) {
                case 1:
                    final int notifyID = 1; // 通知的識別號碼
                    final boolean autoCancel = true; // 點擊通知後是否要自動移除掉通知
                    final int requestCode = notifyID; // PendingIntent的Request Code
                    final Intent intent = new Intent(VaNotice.this, VaccineScheduleActivity.class); // 目前Activity的Intent
                    final int flags = PendingIntent.FLAG_CANCEL_CURRENT; // ONE_SHOT：PendingIntent只使用一次；CANCEL_CURRENT：PendingIntent執行前會先結束掉之前的；NO_CREATE：沿用先前的PendingIntent，不建立新的PendingIntent；UPDATE_CURRENT：更新先前PendingIntent所帶的額外資料，並繼續沿用
                    final PendingIntent pendingIntent = PendingIntent.getActivity(getApplicationContext(), requestCode, intent, flags); // 取得PendingIntent
                    final NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); // 取得系統的通知服務
                    final Notification notification = new Notification.Builder(getApplicationContext()).setSmallIcon(R.drawable.vaccineschedule).setContentTitle("疫苗通知!").setContentText(
                            "B型肝炎遺傳工程疫苗第一劑\n" + new Date()).setContentIntent(pendingIntent).setAutoCancel(autoCancel).build(); // 建立通知
                    notificationManager.notify(notifyID, notification); // 發送通知
                    break;
                case 2:
                    final int notifyID2 = 2; // 通知的識別號碼
                    final boolean autoCancel2 = true; // 點擊通知後是否要自動移除掉通知
                    final int requestCode2 = notifyID2; // PendingIntent的Request Code
                    final Intent intent2 = new Intent(VaNotice.this, VaccineScheduleActivity.class); // 目前Activity的Intent
                    final int flags2 = PendingIntent.FLAG_CANCEL_CURRENT; // ONE_SHOT：PendingIntent只使用一次；CANCEL_CURRENT：PendingIntent執行前會先結束掉之前的；NO_CREATE：沿用先前的PendingIntent，不建立新的PendingIntent；UPDATE_CURRENT：更新先前PendingIntent所帶的額外資料，並繼續沿用
                    final PendingIntent pendingIntent2 = PendingIntent.getActivity(getApplicationContext(), requestCode2, intent2, flags2); // 取得PendingIntent
                    final NotificationManager notificationManager2 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); // 取得系統的通知服務
                    final Notification notification2 = new Notification.Builder(getApplicationContext()).setSmallIcon(R.drawable.vaccineschedule).setContentTitle("疫苗通知!").setContentText(
                            "B型肝炎遺傳工程疫苗第二劑\n" + new Date()).setContentIntent(pendingIntent2).setAutoCancel(autoCancel2).build(); // 建立通知
                    notificationManager2.notify(notifyID2, notification2); // 發送通知
                    break;
                case 3:
                    final int notifyID3 = 3; // 通知的識別號碼
                    final boolean autoCancel3 = true; // 點擊通知後是否要自動移除掉通知
                    final int requestCode3 = notifyID3; // PendingIntent的Request Code
                    final Intent intent3 = new Intent(VaNotice.this, VaccineScheduleActivity.class); // 目前Activity的Intent
                    final int flags3 = PendingIntent.FLAG_CANCEL_CURRENT; // ONE_SHOT：PendingIntent只使用一次；CANCEL_CURRENT：PendingIntent執行前會先結束掉之前的；NO_CREATE：沿用先前的PendingIntent，不建立新的PendingIntent；UPDATE_CURRENT：更新先前PendingIntent所帶的額外資料，並繼續沿用
                    final PendingIntent pendingIntent3 = PendingIntent.getActivity(getApplicationContext(), requestCode3, intent3, flags3); // 取得PendingIntent
                    final NotificationManager notificationManager3 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); // 取得系統的通知服務
                    final Notification notification3 = new Notification.Builder(getApplicationContext()).setSmallIcon(R.drawable.vaccineschedule).setContentTitle("疫苗通知!").setContentText(
                            "五合一疫苗第一劑\n" + new Date()).setContentIntent(pendingIntent3).setAutoCancel(autoCancel3).build(); // 建立通知
                    notificationManager3.notify(notifyID3, notification3); // 發送通知
                    break;
                case 4:
                    final int notifyID4 = 4; // 通知的識別號碼
                    final boolean autoCancel4 = true; // 點擊通知後是否要自動移除掉通知
                    final int requestCode4 = notifyID4; // PendingIntent的Request Code
                    final Intent intent4 = new Intent(VaNotice.this, VaccineScheduleActivity.class); // 目前Activity的Intent
                    final int flags4 = PendingIntent.FLAG_CANCEL_CURRENT; // ONE_SHOT：PendingIntent只使用一次；CANCEL_CURRENT：PendingIntent執行前會先結束掉之前的；NO_CREATE：沿用先前的PendingIntent，不建立新的PendingIntent；UPDATE_CURRENT：更新先前PendingIntent所帶的額外資料，並繼續沿用
                    final PendingIntent pendingIntent4 = PendingIntent.getActivity(getApplicationContext(), requestCode4, intent4, flags4); // 取得PendingIntent
                    final NotificationManager notificationManager4 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); // 取得系統的通知服務
                    final Notification notification4 = new Notification.Builder(getApplicationContext()).setSmallIcon(R.drawable.vaccineschedule).setContentTitle("疫苗通知!").setContentText(
                            "13價結合型肺炎鏈球菌疫苗第一劑\n" + new Date()).setContentIntent(pendingIntent4).setAutoCancel(autoCancel4).build(); // 建立通知
                    notificationManager4.notify(notifyID4, notification4); // 發送通知
                    break;
                case 5:
                    final int notifyID5 = 5; // 通知的識別號碼
                    final boolean autoCancel5 = true; // 點擊通知後是否要自動移除掉通知
                    final int requestCode5 = notifyID5; // PendingIntent的Request Code
                    final Intent intent5 = new Intent(VaNotice.this, VaccineScheduleActivity.class); // 目前Activity的Intent
                    final int flags5 = PendingIntent.FLAG_CANCEL_CURRENT; // ONE_SHOT：PendingIntent只使用一次；CANCEL_CURRENT：PendingIntent執行前會先結束掉之前的；NO_CREATE：沿用先前的PendingIntent，不建立新的PendingIntent；UPDATE_CURRENT：更新先前PendingIntent所帶的額外資料，並繼續沿用
                    final PendingIntent pendingIntent5 = PendingIntent.getActivity(getApplicationContext(), requestCode5, intent5, flags5); // 取得PendingIntent
                    final NotificationManager notificationManager5 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); // 取得系統的通知服務
                    final Notification notification5 = new Notification.Builder(getApplicationContext()).setSmallIcon(R.drawable.vaccineschedule).setContentTitle("疫苗通知!").setContentText(
                            "五合一疫苗第二劑\n" + new Date()).setContentIntent(pendingIntent5).setAutoCancel(autoCancel5).build(); // 建立通知
                    notificationManager5.notify(notifyID5, notification5); // 發送通知
                    break;
                case 6:
                    final int notifyID6 = 6; // 通知的識別號碼
                    final boolean autoCancel6 = true; // 點擊通知後是否要自動移除掉通知
                    final int requestCode6 = notifyID6; // PendingIntent的Request Code
                    final Intent intent6 = new Intent(VaNotice.this, VaccineScheduleActivity.class); // 目前Activity的Intent
                    final int flags6 = PendingIntent.FLAG_CANCEL_CURRENT; // ONE_SHOT：PendingIntent只使用一次；CANCEL_CURRENT：PendingIntent執行前會先結束掉之前的；NO_CREATE：沿用先前的PendingIntent，不建立新的PendingIntent；UPDATE_CURRENT：更新先前PendingIntent所帶的額外資料，並繼續沿用
                    final PendingIntent pendingIntent6 = PendingIntent.getActivity(getApplicationContext(), requestCode6, intent6, flags6); // 取得PendingIntent
                    final NotificationManager notificationManager6 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); // 取得系統的通知服務
                    final Notification notification6 = new Notification.Builder(getApplicationContext()).setSmallIcon(R.drawable.vaccineschedule).setContentTitle("疫苗通知!").setContentText(
                            "13價結合型肺炎鏈球菌疫苗第二劑\n" + new Date()).setContentIntent(pendingIntent6).setAutoCancel(autoCancel6).build(); // 建立通知
                    notificationManager6.notify(notifyID6, notification6); // 發送通知
                    break;
                case 7:
                    final int notifyID7 = 2; // 通知的識別號碼
                    final boolean autoCancel7 = true; // 點擊通知後是否要自動移除掉通知
                    final int requestCode7 = notifyID7; // PendingIntent的Request Code
                    final Intent intent7 = new Intent(VaNotice.this, VaccineScheduleActivity.class); // 目前Activity的Intent
                    final int flags7 = PendingIntent.FLAG_CANCEL_CURRENT; // ONE_SHOT：PendingIntent只使用一次；CANCEL_CURRENT：PendingIntent執行前會先結束掉之前的；NO_CREATE：沿用先前的PendingIntent，不建立新的PendingIntent；UPDATE_CURRENT：更新先前PendingIntent所帶的額外資料，並繼續沿用
                    final PendingIntent pendingIntent7 = PendingIntent.getActivity(getApplicationContext(), requestCode7, intent7, flags7); // 取得PendingIntent
                    final NotificationManager notificationManager7 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); // 取得系統的通知服務
                    final Notification notification7 = new Notification.Builder(getApplicationContext()).setSmallIcon(R.drawable.vaccineschedule).setContentTitle("疫苗通知!").setContentText(
                            "卡介苗第一劑\n" + new Date()).setContentIntent(pendingIntent7).setAutoCancel(autoCancel7).build(); // 建立通知
                    notificationManager7.notify(notifyID7, notification7); // 發送通知
                    break;
                case 8:
                    final int notifyID8 = 2; // 通知的識別號碼
                    final boolean autoCancel8 = true; // 點擊通知後是否要自動移除掉通知
                    final int requestCode8 = notifyID8; // PendingIntent的Request Code
                    final Intent intent8 = new Intent(VaNotice.this, VaccineScheduleActivity.class); // 目前Activity的Intent
                    final int flags8 = PendingIntent.FLAG_CANCEL_CURRENT; // ONE_SHOT：PendingIntent只使用一次；CANCEL_CURRENT：PendingIntent執行前會先結束掉之前的；NO_CREATE：沿用先前的PendingIntent，不建立新的PendingIntent；UPDATE_CURRENT：更新先前PendingIntent所帶的額外資料，並繼續沿用
                    final PendingIntent pendingIntent8 = PendingIntent.getActivity(getApplicationContext(), requestCode8, intent8, flags8); // 取得PendingIntent
                    final NotificationManager notificationManager8 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); // 取得系統的通知服務
                    final Notification notification8 = new Notification.Builder(getApplicationContext()).setSmallIcon(R.drawable.vaccineschedule).setContentTitle("疫苗通知!").setContentText(
                            "B型肝炎遺傳工程疫苗第三劑\n" + new Date()).setContentIntent(pendingIntent8).setAutoCancel(autoCancel8).build(); // 建立通知
                    notificationManager8.notify(notifyID8, notification8); // 發送通知
                    break;
                case 9:
                    final int notifyID9 = 9; // 通知的識別號碼
                    final boolean autoCancel9 = true; // 點擊通知後是否要自動移除掉通知
                    final int requestCode9 = notifyID9;// PendingIntent的Request Code
                    final Intent intent9 = new Intent(VaNotice.this, VaccineScheduleActivity.class); // 目前Activity的Intent
                    final int flags9 = PendingIntent.FLAG_CANCEL_CURRENT; // ONE_SHOT：PendingIntent只使用一次；CANCEL_CURRENT：PendingIntent執行前會先結束掉之前的；NO_CREATE：沿用先前的PendingIntent，不建立新的PendingIntent；UPDATE_CURRENT：更新先前PendingIntent所帶的額外資料，並繼續沿用
                    final PendingIntent pendingIntent9 = PendingIntent.getActivity(getApplicationContext(), requestCode9, intent9, flags9); // 取得PendingIntent
                    final NotificationManager notificationManager9 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); // 取得系統的通知服務
                    final Notification notification9 = new Notification.Builder(getApplicationContext()).setSmallIcon(R.drawable.vaccineschedule).setContentTitle("疫苗通知!").setContentText(
                            "五合一疫苗第三劑\n" + new Date()).setContentIntent(pendingIntent9).setAutoCancel(autoCancel9).build(); // 建立通知
                    notificationManager9.notify(notifyID9, notification9); // 發送通知
                    break;
                case 10:
                    final int notifyID10 = 10; // 通知的識別號碼
                    final boolean autoCancel10 = true; // 點擊通知後是否要自動移除掉通知
                    final int requestCode10 = notifyID10; // PendingIntent的Request Code
                    final Intent intent10 = new Intent(VaNotice.this, VaccineScheduleActivity.class); // 目前Activity的Intent
                    final int flags10 = PendingIntent.FLAG_CANCEL_CURRENT; // ONE_SHOT：PendingIntent只使用一次；CANCEL_CURRENT：PendingIntent執行前會先結束掉之前的；NO_CREATE：沿用先前的PendingIntent，不建立新的PendingIntent；UPDATE_CURRENT：更新先前PendingIntent所帶的額外資料，並繼續沿用
                    final PendingIntent pendingIntent10 = PendingIntent.getActivity(getApplicationContext(), requestCode10, intent10, flags10); // 取得PendingIntent
                    final NotificationManager notificationManager10 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); // 取得系統的通知服務
                    final Notification notification10 = new Notification.Builder(getApplicationContext()).setSmallIcon(R.drawable.vaccineschedule).setContentTitle("疫苗通知!").setContentText(
                            "13價結合型肺炎鏈球菌疫苗第三劑\n" + new Date()).setContentIntent(pendingIntent10).setAutoCancel(autoCancel10).build(); // 建立通知
                    notificationManager10.notify(notifyID10, notification10); // 發送通知
                    break;
                case 11:
                    final int notifyID11 = 11; // 通知的識別號碼
                    final boolean autoCancel11 = true; // 點擊通知後是否要自動移除掉通知
                    final int requestCode11 = notifyID11; // PendingIntent的Request Code
                    final Intent intent11 = new Intent(VaNotice.this, VaccineScheduleActivity.class); // 目前Activity的Intent
                    final int flags11 = PendingIntent.FLAG_CANCEL_CURRENT; // ONE_SHOT：PendingIntent只使用一次；CANCEL_CURRENT：PendingIntent執行前會先結束掉之前的；NO_CREATE：沿用先前的PendingIntent，不建立新的PendingIntent；UPDATE_CURRENT：更新先前PendingIntent所帶的額外資料，並繼續沿用
                    final PendingIntent pendingIntent11 = PendingIntent.getActivity(getApplicationContext(), requestCode11, intent11, flags11); // 取得PendingIntent
                    final NotificationManager notificationManager11 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); // 取得系統的通知服務
                    final Notification notification11 = new Notification.Builder(getApplicationContext()).setSmallIcon(R.drawable.vaccineschedule).setContentTitle("疫苗通知!").setContentText(
                            "麻疹腮腺炎德國麻疹混合疫苗第一劑\n" + new Date()).setContentIntent(pendingIntent11).setAutoCancel(autoCancel11).build(); // 建立通知
                    notificationManager11.notify(notifyID11, notification11); // 發送通知
                    break;
                case 12:
                    final int notifyID12 = 12; // 通知的識別號碼
                    final boolean autoCancel12 = true; // 點擊通知後是否要自動移除掉通知
                    final int requestCode12 = notifyID12; // PendingIntent的Request Code
                    final Intent intent12 = new Intent(VaNotice.this, VaccineScheduleActivity.class); // 目前Activity的Intent
                    final int flags12 = PendingIntent.FLAG_CANCEL_CURRENT; // ONE_SHOT：PendingIntent只使用一次；CANCEL_CURRENT：PendingIntent執行前會先結束掉之前的；NO_CREATE：沿用先前的PendingIntent，不建立新的PendingIntent；UPDATE_CURRENT：更新先前PendingIntent所帶的額外資料，並繼續沿用
                    final PendingIntent pendingIntent12 = PendingIntent.getActivity(getApplicationContext(), requestCode12, intent12, flags12); // 取得PendingIntent
                    final NotificationManager notificationManager12 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); // 取得系統的通知服務
                    final Notification notification12 = new Notification.Builder(getApplicationContext()).setSmallIcon(R.drawable.vaccineschedule).setContentTitle("疫苗通知!").setContentText(
                            "水痘疫苗第一劑\n" + new Date()).setContentIntent(pendingIntent12).setAutoCancel(autoCancel12).build(); // 建立通知
                    notificationManager12.notify(notifyID12, notification12); // 發送通知
                    break;
                case 13:
                    final int notifyID13 = 13; // 通知的識別號碼
                    final boolean autoCancel13 = true; // 點擊通知後是否要自動移除掉通知
                    final int requestCode13 = notifyID13; // PendingIntent的Request Code
                    final Intent intent13 = new Intent(VaNotice.this, VaccineScheduleActivity.class); // 目前Activity的Intent
                    final int flags13 = PendingIntent.FLAG_CANCEL_CURRENT; // ONE_SHOT：PendingIntent只使用一次；CANCEL_CURRENT：PendingIntent執行前會先結束掉之前的；NO_CREATE：沿用先前的PendingIntent，不建立新的PendingIntent；UPDATE_CURRENT：更新先前PendingIntent所帶的額外資料，並繼續沿用
                    final PendingIntent pendingIntent13 = PendingIntent.getActivity(getApplicationContext(), requestCode13, intent13, flags13); // 取得PendingIntent
                    final NotificationManager notificationManager13 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); // 取得系統的通知服務
                    final Notification notification13 = new Notification.Builder(getApplicationContext()).setSmallIcon(R.drawable.vaccineschedule).setContentTitle("疫苗通知!").setContentText(
                            "活菌日本腦炎疫苗第一劑\n" + new Date()).setContentIntent(pendingIntent13).setAutoCancel(autoCancel13).build(); // 建立通知
                    notificationManager13.notify(notifyID13, notification13); // 發送通知
                    break;
                case 14:
                    final int notifyID14 = 14; // 通知的識別號碼
                    final boolean autoCancel14 = true; // 點擊通知後是否要自動移除掉通知
                    final int requestCode14 = notifyID14; // PendingIntent的Request Code
                    final Intent intent14 = new Intent(VaNotice.this, VaccineScheduleActivity.class); // 目前Activity的Intent
                    final int flags14 = PendingIntent.FLAG_CANCEL_CURRENT; // ONE_SHOT：PendingIntent只使用一次；CANCEL_CURRENT：PendingIntent執行前會先結束掉之前的；NO_CREATE：沿用先前的PendingIntent，不建立新的PendingIntent；UPDATE_CURRENT：更新先前PendingIntent所帶的額外資料，並繼續沿用
                    final PendingIntent pendingIntent14 = PendingIntent.getActivity(getApplicationContext(), requestCode14, intent14, flags14); // 取得PendingIntent
                    final NotificationManager notificationManager14 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); // 取得系統的通知服務
                    final Notification notification14 = new Notification.Builder(getApplicationContext()).setSmallIcon(R.drawable.vaccineschedule).setContentTitle("疫苗通知!").setContentText(
                            "五合一疫苗第四劑\n" + new Date()).setContentIntent(pendingIntent14).setAutoCancel(autoCancel14).build(); // 建立通知
                    notificationManager14.notify(notifyID14, notification14); // 發送通知
                    break;
                case 15:
                    final int notifyID15 = 15; // 通知的識別號碼
                    final boolean autoCancel15 = true; // 點擊通知後是否要自動移除掉通知
                    final int requestCode15 = notifyID15; // PendingIntent的Request Code
                    final Intent intent15 = new Intent(VaNotice.this, VaccineScheduleActivity.class); // 目前Activity的Intent
                    final int flags15 = PendingIntent.FLAG_CANCEL_CURRENT; // ONE_SHOT：PendingIntent只使用一次；CANCEL_CURRENT：PendingIntent執行前會先結束掉之前的；NO_CREATE：沿用先前的PendingIntent，不建立新的PendingIntent；UPDATE_CURRENT：更新先前PendingIntent所帶的額外資料，並繼續沿用
                    final PendingIntent pendingIntent15 = PendingIntent.getActivity(getApplicationContext(), requestCode15, intent15, flags15); // 取得PendingIntent
                    final NotificationManager notificationManager15 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); // 取得系統的通知服務
                    final Notification notification15 = new Notification.Builder(getApplicationContext()).setSmallIcon(R.drawable.vaccineschedule).setContentTitle("疫苗通知!").setContentText(
                            "活菌日本腦炎疫苗第二劑\n" + new Date()).setContentIntent(pendingIntent15).setAutoCancel(autoCancel15).build(); // 建立通知
                    notificationManager15.notify(notifyID15, notification15); // 發送通知
                    break;
                case 16:
                    final int notifyID16 = 16; // 通知的識別號碼
                    final boolean autoCancel16 = true; // 點擊通知後是否要自動移除掉通知
                    final int requestCode16 = notifyID16; // PendingIntent的Request Code
                    final Intent intent16 = new Intent(VaNotice.this, VaccineScheduleActivity.class); // 目前Activity的Intent
                    final int flags16 = PendingIntent.FLAG_CANCEL_CURRENT; // ONE_SHOT：PendingIntent只使用一次；CANCEL_CURRENT：PendingIntent執行前會先結束掉之前的；NO_CREATE：沿用先前的PendingIntent，不建立新的PendingIntent；UPDATE_CURRENT：更新先前PendingIntent所帶的額外資料，並繼續沿用
                    final PendingIntent pendingIntent16 = PendingIntent.getActivity(getApplicationContext(), requestCode16, intent16, flags16); // 取得PendingIntent
                    final NotificationManager notificationManager16 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); // 取得系統的通知服務
                    final Notification notification16 = new Notification.Builder(getApplicationContext()).setSmallIcon(R.drawable.vaccineschedule).setContentTitle("疫苗通知!").setContentText(
                            "四合一疫苗\n" + new Date()).setContentIntent(pendingIntent16).setAutoCancel(autoCancel16).build(); // 建立通知
                    notificationManager16.notify(notifyID16, notification16); // 發送通知
                    break;
                case 17:
                    final int notifyID17 = 17; // 通知的識別號碼
                    final boolean autoCancel17 = true; // 點擊通知後是否要自動移除掉通知
                    final int requestCode17 = notifyID17; // PendingIntent的Request Code
                    final Intent intent17 = new Intent(VaNotice.this, VaccineScheduleActivity.class); // 目前Activity的Intent
                    final int flags17 = PendingIntent.FLAG_CANCEL_CURRENT; // ONE_SHOT：PendingIntent只使用一次；CANCEL_CURRENT：PendingIntent執行前會先結束掉之前的；NO_CREATE：沿用先前的PendingIntent，不建立新的PendingIntent；UPDATE_CURRENT：更新先前PendingIntent所帶的額外資料，並繼續沿用
                    final PendingIntent pendingIntent17 = PendingIntent.getActivity(getApplicationContext(), requestCode17, intent17, flags17); // 取得PendingIntent
                    final NotificationManager notificationManager17 = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE); // 取得系統的通知服務
                    final Notification notification17 = new Notification.Builder(getApplicationContext()).setSmallIcon(R.drawable.vaccineschedule).setContentTitle("疫苗通知!").setContentText(
                            "麻疹腮腺炎德國麻疹混合疫苗第二劑\n" + new Date()).setContentIntent(pendingIntent17).setAutoCancel(autoCancel17).build(); // 建立通知
                    notificationManager17.notify(notifyID17, notification17); // 發送通知
                    break;

            }
        }
    }

    Handler handler_Success = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle data = msg.getData();
            String val = data.getString("key");
            Toast.makeText(getApplicationContext(),problemtp, Toast.LENGTH_LONG).show();

            String [] temp = null;
            temp = val.split("-");
            birthyear = Integer.parseInt(temp[0]);
            birthmon = Integer.parseInt(temp[1]);
            birthdate = Integer.parseInt(temp[2]);
            va1 = Integer.parseInt(temp[3]);
            va2 = Integer.parseInt(temp[4]);
            va3 = Integer.parseInt(temp[5]);
            va4 = Integer.parseInt(temp[6]);
            va5 = Integer.parseInt(temp[7]);
            va6 = Integer.parseInt(temp[8]);
            va7 = Integer.parseInt(temp[9]);
            va8 = Integer.parseInt(temp[10]);
            va9 = Integer.parseInt(temp[11]);
            va10 = Integer.parseInt(temp[12]);
            va11 = Integer.parseInt(temp[13]);
            va12 = Integer.parseInt(temp[14]);
            va13 = Integer.parseInt(temp[15]);
            va14 = Integer.parseInt(temp[16]);
            va15 = Integer.parseInt(temp[17]);
            va16 = Integer.parseInt(temp[18]);
            va17 = Integer.parseInt(temp[19]);

            int by,bm,bd;
            //B型肝炎遺傳工程疫苗第一劑
            if(va1 == 0)
            {
                Vnum = 1;
                bm = birthmon;
                by = birthyear;
                bd = birthdate;
                if(bm>12){by = by + (bm/12); bm = ((bm-1)%12)+1;}
                if(bd == 31 || bd == 30 || bd == 29 ){bd = 28;}
                Timer timer = new Timer();
                Calendar cal = new GregorianCalendar(by, bm-1, bd, 8, 0, 0);
                Date date = cal.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = sdf.format(date);
                Toast.makeText(getApplicationContext(),dateString, Toast.LENGTH_LONG).show();
                timer.schedule(new VaNotice.TimerTaskTest(),date,1000*60*60*24);
            }
            //B型肝炎遺傳工程疫苗第二劑
            if(va2 == 0 /*&& va1 == 1*/)
            {
                Vnum = 2;
                bm = birthmon+1;
                by = birthyear;
                bd = birthdate;
                if(bm>12){by = by + (bm/12); bm = ((bm-1)%12)+1;}
                if(bd == 31 || bd == 30 || bd == 29 ){bd = 28;}
                Timer timer = new Timer();
                Calendar cal = new GregorianCalendar(by, bm-1, bd, 8, 0, 0);
                Date date = cal.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = sdf.format(date);
                Toast.makeText(getApplicationContext(),dateString, Toast.LENGTH_LONG).show();
                timer.schedule(new VaNotice.TimerTaskTest(),date,1000*60*60*24);
            }
            //五合一疫苗第一劑
            if(va3 == 0)
            {
                Vnum = 3;
                bm = birthmon+2;
                by = birthyear;
                bd = birthdate;
                if(bm>12){by = by + (bm/12); bm = ((bm-1)%12)+1;}
                if(bd == 31 || bd == 30 || bd == 29 ){bd = 28;}
                Timer timer = new Timer();
                Calendar cal = new GregorianCalendar(by, bm-1, bd, 8, 0, 0);
                Date date = cal.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = sdf.format(date);
                // Toast.makeText(getApplicationContext(),dateString, Toast.LENGTH_LONG).show();
                timer.schedule(new VaNotice.TimerTaskTest(),date,1000*60*60*24);
            }
            //13價結合型肺炎鏈球菌疫苗第一劑
            if(va4 == 0)
            {
                Vnum = 4;
                bm = birthmon+2;
                by = birthyear;
                bd = birthdate;
                if(bm>12){by = by + (bm/12); bm = ((bm-1)%12)+1;}
                if(bd == 31 || bd == 30 || bd == 29 ){bd = 28;}
                Timer timer = new Timer();
                Calendar cal = new GregorianCalendar(by, bm-1, bd, 8, 0, 0);
                Date date = cal.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = sdf.format(date);
                // Toast.makeText(getApplicationContext(),dateString, Toast.LENGTH_LONG).show();
                timer.schedule(new VaNotice.TimerTaskTest(),date,1000*60*60*24);
            }
            //五合一疫苗第二劑
            if(va5 == 0 /*&& va3 == 1*/)
            {
                Vnum = 5;
                bm = birthmon+4;
                by = birthyear;
                bd = birthdate;
                if(bm>12){by = by + (bm/12); bm = ((bm-1)%12)+1;}
                if(bd == 31 || bd == 30 || bd == 29 ){bd = 28;}
                Timer timer = new Timer();
                Calendar cal = new GregorianCalendar(by, bm-1, bd, 8, 0, 0);
                Date date = cal.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = sdf.format(date);
                //Toast.makeText(getApplicationContext(),dateString, Toast.LENGTH_LONG).show();
                timer.schedule(new VaNotice.TimerTaskTest(),date,1000*60*60*24);
            }
            //13價結合型肺炎鏈球菌疫苗第二劑
            if(va6 == 0 && va4 ==1)
            {
                Vnum = 6;
                bm = birthmon+4;
                by = birthyear;
                bd = birthdate;
                if(bm>12){by = by + (bm/12); bm = ((bm-1)%12)+1;}
                if(bd == 31 || bd == 30 || bd == 29 ){bd = 28;}
                Timer timer = new Timer();
                Calendar cal = new GregorianCalendar(by, bm-1, bd, 8, 0, 0);
                Date date = cal.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = sdf.format(date);
                // Toast.makeText(getApplicationContext(),dateString, Toast.LENGTH_LONG).show();
                timer.schedule(new VaNotice.TimerTaskTest(),date,1000*60*60*24);
            }
            //卡介苗第一劑
            if(va7 == 0)
            {
                Vnum = 7;
                bm = birthmon+5;
                by = birthyear;
                bd = birthdate;
                if(bm>12){by = by + (bm/12); bm = ((bm-1)%12)+1;}
                if(bd == 31 || bd == 30 || bd == 29 ){bd = 28;}
                Timer timer = new Timer();
                Calendar cal = new GregorianCalendar(by, bm-1, bd, 8, 0, 0);
                Date date = cal.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = sdf.format(date);
                //  Toast.makeText(getApplicationContext(),dateString, Toast.LENGTH_LONG).show();
                timer.schedule(new VaNotice.TimerTaskTest(),date,1000*60*60*24);
            }
            //B型肝炎遺傳工程疫苗第三劑
            if(va8 == 0 /*&& va2 == 1*/)
            {
                Vnum = 8;
                bm = birthmon+6;
                by = birthyear;
                bd = birthdate;
                if(bm>12){by = by + (bm/12); bm = ((bm-1)%12)+1;}
                if(bd == 31 || bd == 30 || bd == 29 ){bd = 28;}
                Timer timer = new Timer();
                Calendar cal = new GregorianCalendar(by, bm-1, bd, 8, 0, 0);
                Date date = cal.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = sdf.format(date);
                //  Toast.makeText(getApplicationContext(),dateString, Toast.LENGTH_LONG).show();
                timer.schedule(new VaNotice.TimerTaskTest(),date,1000*60*60*24);
            }
            //五合一疫苗第三劑
            if(va9 == 0 /*&& va5 ==1*/)
            {
                Vnum = 9;
                bm = birthmon+6;
                by = birthyear;
                bd = birthdate;
                if(bm>12){by = by + (bm/12); bm = ((bm-1)%12)+1;}
                if(bd == 31 || bd == 30 || bd == 29 ){bd = 28;}
                Timer timer = new Timer();
                Calendar cal = new GregorianCalendar(by, bm-1, bd, 8, 0, 0);
                Date date = cal.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = sdf.format(date);
                // Toast.makeText(getApplicationContext(),dateString, Toast.LENGTH_LONG).show();
                timer.schedule(new VaNotice.TimerTaskTest(),date,1000*60*60*24);
            }
            //13價結合型肺炎鏈球菌疫苗第三劑
            if(va10 == 0 /*&& va6 ==1*/)
            {
                Vnum = 10;
                bm = birthmon+12;
                by = birthyear;
                bd = birthdate;
                if(bm>12){by = by + (bm/12); bm = ((bm-1)%12)+1;}
                if(bd == 31 || bd == 30 || bd == 29 ){bd = 28;}
                Timer timer = new Timer();
                Calendar cal = new GregorianCalendar(by, bm-1, bd, 8, 0, 0);
                Date date = cal.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = sdf.format(date);
                //Toast.makeText(getApplicationContext(),dateString, Toast.LENGTH_LONG).show();
                timer.schedule(new VaNotice.TimerTaskTest(),date,1000*60*60*24);
            }
            //麻疹腮腺炎德國麻疹混合疫苗第一劑
            if(va11 == 0)
            {
                Vnum = 11;
                bm = birthmon+12;
                by = birthyear;
                bd = birthdate;
                if(bm>12){by = by + (bm/12); bm = ((bm-1)%12)+1;}
                if(bd == 31 || bd == 30 || bd == 29 ){bd = 28;}
                Timer timer = new Timer();
                Calendar cal = new GregorianCalendar(by, bm-1, bd, 8, 0, 0);
                Date date = cal.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = sdf.format(date);
                // Toast.makeText(getApplicationContext(),dateString, Toast.LENGTH_LONG).show();
                timer.schedule(new VaNotice.TimerTaskTest(),date,1000*60*60*24);
            }
            //水痘疫苗第一劑
            if(va12 == 0)
            {
                Vnum = 12;
                bm = birthmon+12;
                by = birthyear;
                bd = birthdate;
                if(bm>12){by = by + (bm/12); bm = ((bm-1)%12)+1;}
                if(bd == 31 || bd == 30 || bd == 29 ){bd = 28;}
                Timer timer = new Timer();
                Calendar cal = new GregorianCalendar(by, bm-1, bd, 8, 0, 0);
                Date date = cal.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = sdf.format(date);
                //Toast.makeText(getApplicationContext(),dateString, Toast.LENGTH_LONG).show();
                timer.schedule(new VaNotice.TimerTaskTest(),date,1000*60*60*24);
            }
            //活菌日本腦炎疫苗第一劑
            if(va13 == 0)
            {
                Vnum = 13;
                bm = birthmon+15;
                by = birthyear;
                bd = birthdate;
                if(bm>12){by = by + (bm/12); bm = ((bm-1)%12)+1;}
                if(bd == 31 || bd == 30 || bd == 29 ){bd = 28;}
                Timer timer = new Timer();
                Calendar cal = new GregorianCalendar(by, bm-1, bd, 8, 0, 0);
                Date date = cal.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = sdf.format(date);
                // Toast.makeText(getApplicationContext(),dateString, Toast.LENGTH_LONG).show();
                timer.schedule(new VaNotice.TimerTaskTest(),date,1000*60*60*24);
            }
            //五合一疫苗第四劑
            if(va14 == 0 /*&& va9 == 1*/)
            {
                Vnum = 14;
                bm = birthmon+18;
                by = birthyear;
                bd = birthdate;
                if(bm>12){by = by + (bm/12); bm = ((bm-1)%12)+1;}
                if(bd == 31 || bd == 30 || bd == 29 ){bd = 28;}
                Timer timer = new Timer();
                Calendar cal = new GregorianCalendar(by, bm-1, bd, 8, 0, 0);
                Date date = cal.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = sdf.format(date);
                //Toast.makeText(getApplicationContext(),dateString, Toast.LENGTH_LONG).show();
                timer.schedule(new VaNotice.TimerTaskTest(),date,1000*60*60*24);
            }
            //活菌日本腦炎疫苗第二劑
            if(va15 == 0 /*&& va13 ==1*/)
            {
                Vnum = 15;
                bm = birthmon+27;
                by = birthyear;
                bd = birthdate;
                if(bm>12){by = by + (bm/12); bm = ((bm-1)%12)+1;}
                if(bd == 31 || bd == 30 || bd == 29 ){bd = 28;}
                Timer timer = new Timer();
                Calendar cal = new GregorianCalendar(by, bm-1, bd, 8, 0, 0);
                Date date = cal.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = sdf.format(date);
                // Toast.makeText(getApplicationContext(),dateString, Toast.LENGTH_LONG).show();
                timer.schedule(new VaNotice.TimerTaskTest(),date,1000*60*60*24);
            }
            //四合一疫苗
            if(va16 == 0)
            {
                Vnum = 16;
                bm = birthmon+60;
                by = birthyear;
                bd = birthdate;
                if(bm>12){by = by + (bm/12); bm = ((bm-1)%12)+1;}
                if(bd == 31 || bd == 30 || bd == 29 ){bd = 28;}
                Timer timer = new Timer();
                Calendar cal = new GregorianCalendar(by, bm-1, bd, 8, 0, 0);
                Date date = cal.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = sdf.format(date);
                //Toast.makeText(getApplicationContext(),dateString, Toast.LENGTH_LONG).show();
                timer.schedule(new VaNotice.TimerTaskTest(),date,1000*60*60*24);
            }
            //麻疹腮腺炎德國麻疹混合疫苗第二劑
            if(va17 == 0 /*&& va11 ==1*/)
            {
                Vnum = 17;
                bm = birthmon+60;
                by = birthyear;
                bd = birthdate;
                if(bm>12){by = by + (bm/12); bm = ((bm-1)%12)+1;}
                if(bd == 31 || bd == 30 || bd == 29 ){bd = 28;}
                Timer timer = new Timer();
                Calendar cal = new GregorianCalendar(by, bm-1, bd, 8, 0, 0);
                Date date = cal.getTime();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String dateString = sdf.format(date);
                //Toast.makeText(getApplicationContext(),dateString, Toast.LENGTH_LONG).show();
                timer.schedule(new VaNotice.TimerTaskTest(),date,1000*60*60*24);
            }


        }
    };

    Handler handler_Error = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle data = msg.getData();
            String val = data.getString("key");
            Toast.makeText(getApplicationContext(),"失敗QQ", Toast.LENGTH_LONG).show();
        }
    };

    Handler handler_Nodata = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle data = msg.getData();
            String val = data.getString("key");
            Toast.makeText(getApplicationContext(), val, Toast.LENGTH_LONG).show();
        }
    };

    Runnable runnable = new Runnable(){
        @Override
        public void run() {

            Message msg = new Message();
            Bundle data = new Bundle();
            msg.setData(data);
            try
            {

                HttpClient httpclient = new DefaultHttpClient();
                HttpPost method = new HttpPost(url);

                SharedPreferences shareAc = getSharedPreferences("session",MODE_PRIVATE);
                String Account = shareAc.getString("Ac","0");

                List<NameValuePair> vars=new ArrayList<NameValuePair>();
                vars.add(new BasicNameValuePair("problem",problemtp));
                vars.add(new BasicNameValuePair("Account",Account ));

                method.setEntity(new UrlEncodedFormEntity(vars, HTTP.UTF_8));


                HttpResponse response = httpclient.execute(method);
                HttpEntity entity = response.getEntity();

                if(entity != null){
                    data.putString("key", EntityUtils.toString(entity,"utf-8"));
                    handler_Success.sendMessage(msg);
                }
                else{
                    data.putString("key","無資料");
                    handler_Nodata.sendMessage(msg);
                }

            }
            catch(Exception e){
                data.putString("key","連線失敗");
                handler_Error.sendMessage(msg);
            }

        }
    };
}
