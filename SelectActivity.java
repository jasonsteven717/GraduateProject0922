package net.macdidi.graduateproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
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

public class SelectActivity extends AppCompatActivity {
    final String url = "http://192.168.2.101/AppTest/select.php";

    ListView listview2;
    ArrayAdapter<String> listAdapter;
    Button newbaby;
    Button modifypassword;
    String bnametp;
    String [] bname = null ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_select);

        final ActionBar actionbar = getSupportActionBar();
        TextView centerText = new TextView(getApplicationContext());
        RelativeLayout.LayoutParams layoutparams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        centerText.setLayoutParams(layoutparams);
        centerText.setText("選擇胎次");
        centerText.setTextColor(Color.WHITE);
        centerText.setGravity(Gravity.CENTER);
        centerText.setTextSize(20);
        actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionbar.setCustomView(centerText);
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.logout);

        SharedPreferences shareAc = getSharedPreferences("session",MODE_PRIVATE);
        String bnametp = shareAc.getString("bnametp","0");
        bname = bnametp.split(":");

        listview2 = (ListView) findViewById(R.id.listview2);
        listAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,bname);
        //使用ListAdapter來顯示你輸入的文字
        listview2.setAdapter(listAdapter);
        listview2.setOnItemClickListener(onClickListView);       //指定事件 Method

        newbaby = (Button) findViewById(R.id.newbaby) ;
        modifypassword = (Button) findViewById(R.id.modifypassword) ;
        View.OnClickListener listener = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.newbaby:
                        Intent i1 = new Intent(SelectActivity.this, NewbabyActivity.class);
                        startActivity(i1);
                        break;
                    case R.id.modifypassword:
                        Intent i2 = new Intent(SelectActivity.this, ModifyPasswordActivity.class);
                        startActivity(i2);
                        break;
                }
            }
        };
        newbaby.setOnClickListener(listener);
        modifypassword.setOnClickListener(listener);
    }

    private AdapterView.OnItemClickListener onClickListView = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            SharedPreferences sp = getSharedPreferences("session",MODE_PRIVATE);
            sp.edit().putString("Bn",bname[position] ).apply();
            Intent i3 = new Intent(SelectActivity.this , VaNotice.class) ;
            startActivity(i3);
        }

    };

    public boolean onKeyDown(int keyCode, KeyEvent event) {//捕捉返回鍵
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("確定要登出?");
            builder.setCancelable(false);
            builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    Intent i6 = new Intent(SelectActivity.this , LoginActivity.class) ;
                    startActivity(i6);
                    finish();
                }
            });

            builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });
            AlertDialog alert = builder.create();
            alert.show();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            default:
                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setMessage("確定要登出?");
                builder.setCancelable(false);
                builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        Intent i6 = new Intent(SelectActivity.this , LoginActivity.class) ;
                        startActivity(i6);
                        finish();
                    }
                });

                builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });

                AlertDialog alert = builder.create();
                alert.show();
                break;
        }
        return super.onOptionsItemSelected(item) ;
    }

    Handler handler_Success = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle data = msg.getData();
            String val = data.getString("key");//取出key中的字串存入val\

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
