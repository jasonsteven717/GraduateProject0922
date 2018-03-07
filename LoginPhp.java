package net.macdidi.graduateproject;

/**
 * Created by Green on 2017/7/19.
 */

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
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

import java.util.ArrayList;
import java.util.List;

public class LoginPhp extends AppCompatActivity {
    final String url = "http://192.168.2.101/AppTest/Login.php";
    TextView text;
    String accounttp;
    String passwordtp;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        Bundle LoginPhp =this.getIntent().getExtras();

        accounttp = LoginPhp.getString("accounttp");
        passwordtp = LoginPhp.getString("passwordtp");


        new Thread(runnable).start();



    }
    Handler handler_Success = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle data = msg.getData();
            String val = data.getString("key");
            String [] temp = null;
            temp = val.split("-");
            if(temp[0].equals("1"))
            {
                Intent i1 = new Intent(LoginPhp.this , SelectActivity.class) ;
                Bundle bundle = new Bundle();
                bundle.putString("accounttp",accounttp);

                i1.putExtras(bundle);
                SharedPreferences sp = getSharedPreferences("session",MODE_PRIVATE);
                sp.edit().putString("Ac",accounttp ).apply();
                sp.edit().putString("bnametp",temp[1] ).apply();
                Toast.makeText(getApplicationContext(), "登入成功!!!", Toast.LENGTH_LONG).show();
                startActivity(i1);

            }
            else
            {
                Toast.makeText(getApplicationContext(), "帳號密碼錯誤!!!", Toast.LENGTH_LONG).show();
                Intent i1 = new Intent(LoginPhp.this , LoginActivity.class) ;
                startActivity(i1);
            }
        }
    };

    Handler handler_Error = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle data = msg.getData();
            String val = data.getString("key");
            Toast.makeText(getApplicationContext(), val, Toast.LENGTH_LONG).show();
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

                List<NameValuePair> vars=new ArrayList<NameValuePair>();
                vars.add(new BasicNameValuePair("account",accounttp));
                vars.add(new BasicNameValuePair("pass",passwordtp));

                method.setEntity(new UrlEncodedFormEntity(vars, HTTP.UTF_8));


                HttpResponse response = httpclient.execute(method);
                HttpEntity entity = response.getEntity();

                data.putString("key", EntityUtils.toString(entity,"utf-8"));
                handler_Success.sendMessage(msg);


            }
            catch(Exception e){
                data.putString("key","連線失敗");
                handler_Error.sendMessage(msg);
            }

        }
    };




}

