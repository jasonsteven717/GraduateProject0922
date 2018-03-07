package net.macdidi.graduateproject;

/**
 * Created by Green on 2017/7/19.
 */

import android.content.Intent;
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

public class EnrollPhp extends AppCompatActivity {

   final String url = "http://192.168.2.101/AppTest/Enroll.php";
    TextView text;
    String babynametp;
    String babyPIDtp;
    String mothernametp;
    String motherPIDtp;
    String phonetp;
    String emailtp;
    String Datetp;
    String Sextp;
    String Adrtp;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enrollphp);

        Bundle EnrollPhp =this.getIntent().getExtras();

        babynametp = EnrollPhp.getString("babynametp");
        babyPIDtp = EnrollPhp.getString("babyPIDtp");
        mothernametp = EnrollPhp.getString("mothernametp");
        motherPIDtp = EnrollPhp.getString("motherPIDtp");
        phonetp = EnrollPhp.getString("phonetp");
        emailtp = EnrollPhp.getString("emailtp");
        Datetp = EnrollPhp.getString("Datetp");
        Sextp = EnrollPhp.getString("Sextp");
        Adrtp = EnrollPhp.getString("Adrtp");
        text =  (TextView)findViewById(R.id.textView23);


        new Thread(runnable).start();

        Intent i1 = new Intent(EnrollPhp.this , LoginActivity.class) ;
        startActivity(i1);
        finish();
    }
    Handler handler_Success = new Handler(){
                @Override
                public void handleMessage(Message msg) {
                    super.handleMessage(msg);
                    Bundle data = msg.getData();
                    String val = data.getString("key");
                    Toast.makeText(getApplicationContext(),"註冊成功!!!", Toast.LENGTH_LONG).show();
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

                        List<NameValuePair> vars=new ArrayList<NameValuePair>();
                        vars.add(new BasicNameValuePair("BabyN",babynametp));
                        vars.add(new BasicNameValuePair("BabyP",babyPIDtp));
                        vars.add(new BasicNameValuePair("MoN",mothernametp));
                        vars.add(new BasicNameValuePair("MoP",motherPIDtp));
                        vars.add(new BasicNameValuePair("Phone",phonetp));
                        vars.add(new BasicNameValuePair("Email",emailtp));
                        vars.add(new BasicNameValuePair("Birth",Datetp));
                        vars.add(new BasicNameValuePair("Sex",Sextp));
                        vars.add(new BasicNameValuePair("Adr",Adrtp));
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
