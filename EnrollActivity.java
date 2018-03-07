package net.macdidi.graduateproject;

import android.annotation.TargetApi;
import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class EnrollActivity extends AppCompatActivity {
    Button sendaccountinfo;
    EditText babyname ;
    EditText babyPID ;
    EditText mothername ;
    EditText motherPID ;
    EditText phone ;
    EditText email ;
    EditText madd ;
    TextView tvDate;
    Button btDate ;
    Spinner babysex;
    Spinner regionspinner;
    int mYear, mMonth, mDay;
    String[] sex = {"","男","女"};
    String[] region1 = {"","鳳山區","新興區","苓雅區","鼓山區","前鎮區","楠梓區","左營區","大社區","路竹區","田寮區","橋頭區","彌陀區"
            ,"湖內區","大寮區","鳥松區","大樹區","美濃區","內門區","甲仙區","那瑪夏區","茄萣區","旗山區","六龜區","杉林區","桃源區",
            "茂林區","阿蓮區","燕巢區","梓官區","永安區","前金區","林園區","鹽埕區","旗津區","三民區","小港區","仁武區","岡山區"
    };
    String Datetp;
    String Sextp;
    String PreAdrtp;
    String ErpAdrtp;
    String Adrtp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enroll);

        final ActionBar actionbar = getSupportActionBar();
        TextView centerText = new TextView(getApplicationContext());
        RelativeLayout.LayoutParams layoutparams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        centerText.setLayoutParams(layoutparams);
        centerText.setText("註冊帳號");
        centerText.setTextColor(Color.WHITE);
        centerText.setGravity(Gravity.CENTER);
        centerText.setTextSize(20);
        actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionbar.setCustomView(centerText);
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.back);

        sendaccountinfo = (Button) findViewById(R.id.sendaccountinfo) ;
        babyname = (EditText) findViewById(R.id.babyname) ;
        babyPID = (EditText) findViewById(R.id.babyPID) ;
        mothername = (EditText) findViewById(R.id.mothername) ;
        motherPID = (EditText) findViewById(R.id.motherPID) ;
        phone = (EditText) findViewById(R.id.phone) ;
        email = (EditText) findViewById(R.id.email) ;
        babysex = (Spinner)findViewById(R.id.babysex);
        regionspinner = (Spinner)findViewById(R.id.regionspinner);
        tvDate = (TextView) findViewById(R.id.tvDate);
        btDate = (Button) findViewById(R.id.btDate);

        ArrayAdapter<String> SexList = new ArrayAdapter<>(EnrollActivity.this,android.R.layout.simple_spinner_dropdown_item,sex);
        babysex.setAdapter(SexList);
        babysex.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView adapterView, View view, int position, long id){
                Sextp = adapterView.getSelectedItem().toString();
                Toast.makeText(EnrollActivity.this, "您選擇" + adapterView.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
            }
            public void onNothingSelected(AdapterView arg0) {
                Toast.makeText(EnrollActivity.this, "您沒有選擇任何項目", Toast.LENGTH_LONG).show();
            }
        });

        ArrayAdapter<String> RegionList = new ArrayAdapter<>(EnrollActivity.this,android.R.layout.simple_spinner_dropdown_item,region1);
        regionspinner.setAdapter(RegionList);
        regionspinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener(){
            public void onItemSelected(AdapterView adapterView, View view, int position, long id){
                PreAdrtp = "高雄市"+ adapterView.getSelectedItem().toString();
                Toast.makeText(EnrollActivity.this, "您選擇" + adapterView.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
            }
            public void onNothingSelected(AdapterView arg0) {
                Toast.makeText(EnrollActivity.this, "您沒有選擇任何項目", Toast.LENGTH_LONG).show();
            }
        });

        btDate.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                babyname = (EditText) findViewById(R.id.babyname) ;
                Editable Strbabynametp;
                Strbabynametp = babyname.getText();
                String babynametp =Strbabynametp.toString();
                babyPID = (EditText) findViewById(R.id.babyPID) ;
                Editable StrbabyPIDtp;
                StrbabyPIDtp = babyPID.getText();
                String babyPIDtp =StrbabyPIDtp.toString();
                mothername = (EditText) findViewById(R.id.mothername) ;
                Editable Strmothernametp;
                Strmothernametp = mothername.getText();
                String mothernametp =Strmothernametp.toString();
                motherPID = (EditText) findViewById(R.id.motherPID) ;
                Editable StrmotherPIDtp;
                StrmotherPIDtp = motherPID.getText();
                String motherPIDtp =StrmotherPIDtp.toString();
                phone = (EditText) findViewById(R.id.phone) ;
                Editable Strphonetp;
                Strphonetp = phone.getText();
                String phonetp =Strphonetp.toString();
                email = (EditText) findViewById(R.id.email) ;
                Editable Stremailtp;
                Stremailtp = email.getText();
                String emailtp =Stremailtp.toString();
                madd = (EditText) findViewById(R.id.madd) ;
                Editable Strmaddtp;
                Strmaddtp = madd.getText();
                ErpAdrtp = Strmaddtp.toString();
                Adrtp = PreAdrtp + ErpAdrtp;


                if("".equals(sendaccountinfo.getText().toString().trim())||"".equals(babyname.getText().toString().trim())||"".equals(babyPID.getText().toString().trim())||
                        "".equals(mothername.getText().toString().trim())||"".equals(motherPID.getText().toString().trim())||"".equals(phone.getText().toString().trim())||
                        "".equals(email.getText().toString().trim())||"".equals(babysex.getSelectedItem().toString())||"".equals(regionspinner.getSelectedItem().toString())){
                    Toast.makeText(sendaccountinfo.getContext(),"資料填寫不完整!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent i1 = new Intent(EnrollActivity.this , EnrollPhp.class) ;
                    Bundle bundle = new Bundle();
                    bundle.putString("babynametp",babynametp);
                    bundle.putString("babyPIDtp",babyPIDtp);
                    bundle.putString("mothernametp",mothernametp);
                    bundle.putString("motherPIDtp",motherPIDtp);
                    bundle.putString("phonetp",phonetp);
                    bundle.putString("emailtp",emailtp);
                    bundle.putString("Datetp",Datetp);
                    bundle.putString("Sextp",Sextp);
                    bundle.putString("Adrtp",Adrtp);
                    i1.putExtras(bundle);
                    startActivity(i1);
                }
            }

        };
        sendaccountinfo.setOnClickListener(listener);

    }
    @TargetApi(Build.VERSION_CODES.N)


     public void showDatePickerDialog() {
        // 設定初始日期
        final Calendar c = Calendar.getInstance();
        mYear = c.get(Calendar.YEAR);
        mMonth = c.get(Calendar.MONTH);
        mDay = c.get(Calendar.DAY_OF_MONTH);
        // 跳出日期選擇器
        DatePickerDialog dpd = new DatePickerDialog(this,new DatePickerDialog.OnDateSetListener() {
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                // 完成選擇，顯示日期
                tvDate.setText(year + "-" + (monthOfYear + 1) + "-"+ dayOfMonth);
                Datetp = year + "-" + (monthOfYear + 1) + "-"+ dayOfMonth;
                Toast.makeText(sendaccountinfo.getContext(),Datetp,Toast.LENGTH_SHORT).show();
            }
        }, mYear, mMonth, mDay);
        dpd.show();
    }


    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            default:
                finish();
                break;
        }
        return super.onOptionsItemSelected(item) ;
    }

}
