package net.macdidi.graduateproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
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

public class VaccineScheduleActivity extends AppCompatActivity {
    final String url = "http://192.168.2.101/AppTest/va_sch.php";
    EditText Va01;
    EditText Va02;
    EditText Va03;
    EditText Va04;
    EditText Va05;
    EditText Va06;
    EditText Va07;
    EditText Va08;
    EditText Va09;
    EditText Va10;
    EditText Va11;
    EditText Va12;
    EditText Va13;
    EditText Va14;
    EditText Va15;
    EditText Va16;
    EditText Va17;
    EditText Vprecent;
    int Vcount;
    Button Vaccine0info;
    Button Vaccine1info;
    Button Vaccine2info;
    Button Vaccine3info;
    Button Vaccine4info;
    Button Vaccine5info;
    Button Vaccine6info;
    Button Vaccine7info;
    Button Vaccine8info;
    Button Vaccine9info;
    Button Vaccine10info;
    Button Vaccine11info;
    Button Vaccine12info;
    Button Vaccine13info;
    Button Vaccine14info;
    Button Vaccine15info;
    Button Vaccine16info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_schedule);

        final ActionBar actionbar = getSupportActionBar();
        TextView centerText = new TextView(getApplicationContext());
        RelativeLayout.LayoutParams layoutparams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        centerText.setLayoutParams(layoutparams);
        centerText.setText("疫苗施打進度");
        centerText.setTextColor(Color.WHITE);
        centerText.setGravity(Gravity.CENTER);
        centerText.setTextSize(20);
        actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionbar.setCustomView(centerText);
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.back);


        Va01 = (EditText) findViewById(R.id.Va01) ;
        Va02 = (EditText) findViewById(R.id.Va02) ;
        Va03 = (EditText) findViewById(R.id.Va03) ;
        Va04 = (EditText) findViewById(R.id.Va04) ;
        Va05 = (EditText) findViewById(R.id.Va05) ;
        Va06 = (EditText) findViewById(R.id.Va06) ;
        Va07 = (EditText) findViewById(R.id.Va07) ;
        Va08 = (EditText) findViewById(R.id.Va08) ;
        Va09 = (EditText) findViewById(R.id.Va09) ;
        Va10 = (EditText) findViewById(R.id.Va10) ;
        Va11 = (EditText) findViewById(R.id.Va11) ;
        Va12 = (EditText) findViewById(R.id.Va12) ;
        Va13 = (EditText) findViewById(R.id.Va13) ;
        Va14 = (EditText) findViewById(R.id.Va14) ;
        Va15 = (EditText) findViewById(R.id.Va15) ;
        Va16 = (EditText) findViewById(R.id.Va16) ;
        Va17 = (EditText) findViewById(R.id.Va17) ;
        Vprecent = (EditText) findViewById(R.id.precent) ;

        Va01.setEnabled(false);
        Va02.setEnabled(false);
        Va03.setEnabled(false);
        Va04.setEnabled(false);
        Va05.setEnabled(false);
        Va06.setEnabled(false);
        Va07.setEnabled(false);
        Va08.setEnabled(false);
        Va09.setEnabled(false);
        Va10.setEnabled(false);
        Va11.setEnabled(false);
        Va12.setEnabled(false);
        Va13.setEnabled(false);
        Va14.setEnabled(false);
        Va15.setEnabled(false);
        Va16.setEnabled(false);
        Va17.setEnabled(false);
        Vprecent.setEnabled(false);


        new Thread(runnable).start();//啟動執行序runnable

    }

    Handler handler_Success = new Handler(){
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle data = msg.getData();
            String val = data.getString("key");//取出key中的字串存入val\
            String [] temp = null;
            temp = val.split(":");
            if (temp[0].equals("1")) {Va01.setText("已施打");Va01.setTextColor(Color.GREEN);Vcount++;}
            if (temp[1].equals("1")) {Va02.setText("已施打");Va02.setTextColor(Color.GREEN);Vcount++;}
            if (temp[2].equals("1")) {Va03.setText("已施打");Va03.setTextColor(Color.GREEN);Vcount++;}
            if (temp[3].equals("1")) {Va04.setText("已施打");Va04.setTextColor(Color.GREEN);Vcount++;}
            if (temp[4].equals("1")) {Va05.setText("已施打");Va05.setTextColor(Color.GREEN);Vcount++;}
            if (temp[5].equals("1")) {Va06.setText("已施打");Va06.setTextColor(Color.GREEN);Vcount++;}
            if (temp[6].equals("1")) {Va07.setText("已施打");Va07.setTextColor(Color.GREEN);Vcount++;}
            if (temp[7].equals("1")) {Va08.setText("已施打");Va08.setTextColor(Color.GREEN);Vcount++;}
            if (temp[8].equals("1")) {Va09.setText("已施打");Va09.setTextColor(Color.GREEN);Vcount++;}
            if (temp[9].equals("1")) {Va10.setText("已施打");Va10.setTextColor(Color.GREEN);Vcount++;}
            if (temp[10].equals("1")) {Va11.setText("已施打");Va11.setTextColor(Color.GREEN);Vcount++;}
            if (temp[11].equals("1")) {Va12.setText("已施打");Va12.setTextColor(Color.GREEN);Vcount++;}
            if (temp[12].equals("1")) {Va13.setText("已施打");Va13.setTextColor(Color.GREEN);Vcount++;}
            if (temp[13].equals("1")) {Va14.setText("已施打");Va14.setTextColor(Color.GREEN);Vcount++;}
            if (temp[14].equals("1")) {Va15.setText("已施打");Va15.setTextColor(Color.GREEN);Vcount++;}
            if (temp[15].equals("1")) {Va16.setText("已施打");Va16.setTextColor(Color.GREEN);Vcount++;}
            if (temp[16].equals("1")) {Va17.setText("已施打");Va17.setTextColor(Color.GREEN);Vcount++;}

            final ProgressBar bar = (ProgressBar) findViewById(R.id.progressBar2);
            boolean flag = bar.isIndeterminate();
            if(!flag){
                bar.setMax(100);
                bar.setProgress(0);
            }
            bar.incrementProgressBy(Vcount*100 / 17);
            Vprecent.setText(Vcount*100/17 + "%");
            Vaccine0info = (Button) findViewById(R.id.Vaccine0info) ;
            Vaccine1info = (Button) findViewById(R.id.Vaccine1info) ;
            Vaccine2info = (Button) findViewById(R.id.Vaccine2info) ;
            Vaccine3info = (Button) findViewById(R.id.Vaccine3info) ;
            Vaccine4info = (Button) findViewById(R.id.Vaccine4info) ;
            Vaccine5info = (Button) findViewById(R.id.Vaccine5info) ;
            Vaccine6info = (Button) findViewById(R.id.Vaccine6info) ;
            Vaccine7info = (Button) findViewById(R.id.Vaccine7info) ;
            Vaccine8info = (Button) findViewById(R.id.Vaccine8info) ;
            Vaccine9info = (Button) findViewById(R.id.Vaccine9info) ;
            Vaccine10info = (Button) findViewById(R.id.Vaccine10info) ;
            Vaccine11info = (Button) findViewById(R.id.Vaccine11info) ;
            Vaccine12info = (Button) findViewById(R.id.Vaccine12info) ;
            Vaccine13info = (Button) findViewById(R.id.Vaccine13info) ;
            Vaccine14info = (Button) findViewById(R.id.Vaccine14info) ;
            Vaccine15info = (Button) findViewById(R.id.Vaccine15info) ;
            Vaccine16info = (Button) findViewById(R.id.Vaccine16info) ;
            final String[] finalTemp = temp;
            View.OnClickListener listener = new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    switch (v.getId()){
                        case R.id.Vaccine0info :
                            AlertDialog.Builder dialog0 = new AlertDialog.Builder(VaccineScheduleActivity.this);
                            dialog0.setTitle("B型肝炎遺傳工程疫苗第一劑 ");
                            dialog0.setMessage("接種年齡 : 出生 24小時內儘速接種\n施打日期 : "+ finalTemp[17]);
                            dialog0.show();
                            break;
                        case R.id.Vaccine1info :
                            AlertDialog.Builder dialog1 = new AlertDialog.Builder(VaccineScheduleActivity.this);
                            dialog1.setTitle("B型肝炎遺傳工程疫苗第二劑 ");
                            dialog1.setMessage("接種年齡 : 出生滿 1個月\n施打日期 : "+ finalTemp[18]);
                            dialog1.show();
                            break;
                        case R.id.Vaccine2info :
                            AlertDialog.Builder dialog2 = new AlertDialog.Builder(VaccineScheduleActivity.this);
                            dialog2.setTitle("五合一疫苗第一劑");
                            dialog2.setMessage("接種年齡 : 出生滿 2個月\n施打日期 : "+ finalTemp[19]);
                            dialog2.show();
                            break;
                        case R.id.Vaccine3info :
                            AlertDialog.Builder dialog3 = new AlertDialog.Builder(VaccineScheduleActivity.this);
                            dialog3.setTitle("13價結合型肺炎鏈球菌疫苗第一劑 ");
                            dialog3.setMessage("接種年齡 : 出生滿 2個月\n施打日期 : "+ finalTemp[20]);
                            dialog3.show();
                            break;
                        case R.id.Vaccine4info :
                            AlertDialog.Builder dialog4 = new AlertDialog.Builder(VaccineScheduleActivity.this);
                            dialog4.setTitle("五合一疫苗第二劑 ");
                            dialog4.setMessage("接種年齡 : 出生滿 4個月\n施打日期 : "+ finalTemp[21]);
                            dialog4.show();
                            break;
                        case R.id.Vaccine5info :
                            AlertDialog.Builder dialog5 = new AlertDialog.Builder(VaccineScheduleActivity.this);
                            dialog5.setTitle("13價結合型肺炎鏈球菌疫苗第二劑 ");
                            dialog5.setMessage("接種年齡 : 出生滿 4個月\n施打日期 : "+ finalTemp[22]);
                            dialog5.show();
                            break;
                        case R.id.Vaccine6info :
                            AlertDialog.Builder dialog6 = new AlertDialog.Builder(VaccineScheduleActivity.this);
                            dialog6.setTitle("卡介苗第一劑 ");
                            dialog6.setMessage("接種年齡 : 出生滿 5個月\n施打日期 : "+ finalTemp[23]);
                            dialog6.show();
                            break;
                        case R.id.Vaccine7info :
                            AlertDialog.Builder dialog7 = new AlertDialog.Builder(VaccineScheduleActivity.this);
                            dialog7.setTitle("B型肝炎遺傳工程疫苗第三劑 ");
                            dialog7.setMessage("接種年齡 : 出生滿 6個月\n施打日期 : "+ finalTemp[24]);
                            dialog7.show();
                            break;
                        case R.id.Vaccine8info :
                            AlertDialog.Builder dialog8 = new AlertDialog.Builder(VaccineScheduleActivity.this);
                            dialog8.setTitle("五合一疫苗第三劑 ");
                            dialog8.setMessage("接種年齡 : 出生滿 6個月\n施打日期 : "+ finalTemp[25]);
                            dialog8.show();
                            break;
                        case R.id.Vaccine9info :
                            AlertDialog.Builder dialog9 = new AlertDialog.Builder(VaccineScheduleActivity.this);
                            dialog9.setTitle("13價結合型肺炎鏈球菌疫苗第三劑 ");
                            dialog9.setMessage("接種年齡 : 出生滿 12~15個月\n施打日期 : "+ finalTemp[26]);
                            dialog9.show();
                            break;
                        case R.id.Vaccine10info :
                            AlertDialog.Builder dialog10 = new AlertDialog.Builder(VaccineScheduleActivity.this);
                            dialog10.setTitle("麻疹腮腺炎德國麻疹混合疫苗第一劑 ");
                            dialog10.setMessage("接種年齡 : 出生滿 12個月\n施打日期 : "+ finalTemp[27]);
                            dialog10.show();
                            break;
                        case R.id.Vaccine11info :
                            AlertDialog.Builder dialog11 = new AlertDialog.Builder(VaccineScheduleActivity.this);
                            dialog11.setTitle("水痘疫苗第一劑 ");
                            dialog11.setMessage("接種年齡 : 出生滿 12個月\n施打日期 : "+ finalTemp[28]);
                            dialog11.show();
                            break;
                        case R.id.Vaccine12info :
                            AlertDialog.Builder dialog12 = new AlertDialog.Builder(VaccineScheduleActivity.this);
                            dialog12.setTitle("活菌日本腦炎疫苗第一劑 ");
                            dialog12.setMessage("接種年齡 : 出生滿 15個月\n施打日期 : "+ finalTemp[29]);
                            dialog12.show();
                            break;
                        case R.id.Vaccine13info :
                            AlertDialog.Builder dialog13 = new AlertDialog.Builder(VaccineScheduleActivity.this);
                            dialog13.setTitle("五合一疫苗第四劑 ");
                            dialog13.setMessage("接種年齡 : 出生滿 18個月\n施打日期 : "+ finalTemp[30]);
                            dialog13.show();
                            break;
                        case R.id.Vaccine14info :
                            AlertDialog.Builder dialog14 = new AlertDialog.Builder(VaccineScheduleActivity.this);
                            dialog14.setTitle("活菌日本腦炎疫苗第二劑 ");
                            dialog14.setMessage("接種年齡 : 出生滿 27個月\n施打日期 : "+ finalTemp[31]);
                            dialog14.show();
                            break;
                        case R.id.Vaccine15info :
                            AlertDialog.Builder dialog15 = new AlertDialog.Builder(VaccineScheduleActivity.this);
                            dialog15.setTitle("四合一疫苗 ");
                            dialog15.setMessage("接種年齡 : 出生滿5歲\n施打日期 : "+ finalTemp[32]);
                            dialog15.show();
                            break;
                        case R.id.Vaccine16info :
                            AlertDialog.Builder dialog16 = new AlertDialog.Builder(VaccineScheduleActivity.this);
                            dialog16.setTitle("麻疹腮腺炎德國麻疹混合疫苗第二劑 ");
                            dialog16.setMessage("接種年齡 : 出生滿5歲\n施打日期 : "+ finalTemp[33]);
                            dialog16.show();
                            break;
                    }
                }
            };

            Vaccine0info.setOnClickListener(listener);
            Vaccine1info.setOnClickListener(listener);
            Vaccine2info.setOnClickListener(listener);
            Vaccine3info.setOnClickListener(listener);
            Vaccine4info.setOnClickListener(listener);
            Vaccine5info.setOnClickListener(listener);
            Vaccine6info.setOnClickListener(listener);
            Vaccine7info.setOnClickListener(listener);
            Vaccine8info.setOnClickListener(listener);
            Vaccine9info.setOnClickListener(listener);
            Vaccine10info.setOnClickListener(listener);
            Vaccine11info.setOnClickListener(listener);
            Vaccine12info.setOnClickListener(listener);
            Vaccine13info.setOnClickListener(listener);
            Vaccine14info.setOnClickListener(listener);
            Vaccine15info.setOnClickListener(listener);
            Vaccine16info.setOnClickListener(listener);
        }
    };

    Handler handler_Error = new Handler(){
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle data = msg.getData();
            String val = data.getString("key");
            Toast.makeText(getApplicationContext(), val, Toast.LENGTH_LONG).show();
        }
    };

    Handler handler_Nodata = new Handler(){

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle data = msg.getData();
            String val = data.getString("key");
            Toast.makeText(getApplicationContext(), val, Toast.LENGTH_LONG).show();
        }
    };

    Runnable runnable = new Runnable(){

        public void run() {
            //
            // TODO: http request.
            //
            Message msg = new Message();
            Bundle data = new Bundle();
            msg.setData(data);
            try
            {
                HttpClient httpclient = new DefaultHttpClient();
                HttpPost method = new HttpPost(url);//連線到 url網址


                SharedPreferences shareAc = getSharedPreferences("session",MODE_PRIVATE);
                String Account = shareAc.getString("Ac","0");

                List<NameValuePair> vars=new ArrayList<NameValuePair>();
                vars.add(new BasicNameValuePair("Account",Account ));

                method.setEntity(new UrlEncodedFormEntity(vars, HTTP.UTF_8));
                HttpResponse response = httpclient.execute(method);
                HttpEntity entity = response.getEntity();

                if(entity != null){
                    data.putString("key", EntityUtils.toString(entity));//如果成功將網頁內容存入key
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
    public boolean onKeyDown(int keyCode, KeyEvent event) {//捕捉返回鍵
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Intent i2 = new Intent(VaccineScheduleActivity.this , MainActivity.class) ;
            startActivity(i2);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            default:
                Intent i2 = new Intent(VaccineScheduleActivity.this , MainActivity.class) ;
                startActivity(i2);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item) ;
    }

}
