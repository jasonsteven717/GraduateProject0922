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

public class va_problem16 extends AppCompatActivity {

    final String url = "http://140.127.208.88:81/AppTest/va_problem16.php";
    String problemtp;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle vaccinePhp =this.getIntent().getExtras();
        problemtp = vaccinePhp.getString("problemtp");

        new Thread(runnable).start();

        Intent i1 = new Intent(va_problem16.this , MainActivity.class) ;
        startActivity(i1);

    }
    Handler handler_Success = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle data = msg.getData();
            String val = data.getString("key");
            Toast.makeText(getApplicationContext(),problemtp, Toast.LENGTH_LONG).show();
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
