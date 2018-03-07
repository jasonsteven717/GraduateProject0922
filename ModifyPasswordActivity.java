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
import android.text.Editable;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
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

public class ModifyPasswordActivity extends AppCompatActivity {
    final String url = "http://192.168.2.101/AppTest/modifypassword.php";
    Button modifypassword;
    CheckBox modifycheck;
    EditText mpassword1;
    EditText mpassword2;
    String mpasswordtp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modify_password);

        final ActionBar actionbar = getSupportActionBar();
        TextView centerText = new TextView(getApplicationContext());
        RelativeLayout.LayoutParams layoutparams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        centerText.setLayoutParams(layoutparams);
        centerText.setText("修改密碼");
        centerText.setTextColor(Color.WHITE);
        centerText.setGravity(Gravity.CENTER);
        centerText.setTextSize(20);
        actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionbar.setCustomView(centerText);
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.back);

        modifypassword = (Button)findViewById(R.id.modifypassword);
        modifycheck = (CheckBox)findViewById(R.id.modifycheck);
        mpassword1 = (EditText)findViewById(R.id.mpassword1);
        mpassword2 = (EditText)findViewById(R.id.mpassword2);

        modifypassword.setEnabled(false);
        modifycheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // update your model (or other business logic) based on isChecked
                if(modifycheck.isChecked()) {
                    modifypassword.setEnabled(true);
                }
                else{
                    modifypassword.setEnabled(false);
                }
            }CompoundButton checkBox;
        });
        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(ModifyPasswordActivity.this);
                builder.setMessage("確定修改?\n"+"完成修改後需重新登入");
                builder.setCancelable(false);
                builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        if("".equals(mpassword1.getText().toString().trim())){
                            Toast.makeText(modifypassword.getContext(),"請輸入密碼!",Toast.LENGTH_SHORT).show();
                        }
                        if("".equals(mpassword2.getText().toString().trim())){
                            Toast.makeText(modifypassword.getContext(),"請再輸入密碼!",Toast.LENGTH_SHORT).show();
                        }
                        if(mpassword2.getText().toString().equals(mpassword1.getText().toString())){
                            Editable StrReportTexttp;
                            StrReportTexttp = mpassword1.getText();
                            mpasswordtp =StrReportTexttp.toString();
                            new Thread(runnable).start();
                            Intent i2 = new Intent(ModifyPasswordActivity.this , LoginActivity.class) ;
                            startActivity(i2);
                            finish();
                            Toast.makeText(modifypassword.getContext(),"修改成功!",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Toast.makeText(modifypassword.getContext(),"密碼不一致!",Toast.LENGTH_SHORT).show();
                        }
                    }
                });

                builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                    }
                });
                AlertDialog alert = builder.create();
                alert.show();}
        };
        modifypassword.setOnClickListener(listener);


    }
    Handler handler_Success = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle data = msg.getData();
            String val = data.getString("key");
            Toast.makeText(getApplicationContext(),mpasswordtp, Toast.LENGTH_LONG).show();
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
                vars.add(new BasicNameValuePair("mpassword",mpasswordtp));
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

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            default:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item) ;
    }
}
