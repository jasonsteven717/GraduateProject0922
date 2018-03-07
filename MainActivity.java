package net.macdidi.graduateproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText birthday ;
    ImageButton Baby_info ;
    ImageButton Vaccine_info ;
    ImageButton Vaccine_schedule ;
    ImageButton report ;
    ImageButton Nearby_hospital ;


    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        birthday = (EditText) findViewById(R.id.birthday) ;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ActionBar actionbar = getSupportActionBar();
        TextView centerText = new TextView(getApplicationContext());
        LayoutParams layoutparams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
        centerText.setLayoutParams(layoutparams);
        centerText.setText("寶貝疫苗管家");
        centerText.setTextColor(Color.WHITE);
        centerText.setGravity(Gravity.CENTER);
        centerText.setTextSize(20);
        actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionbar.setCustomView(centerText);
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.back);

        Baby_info = (ImageButton) findViewById(R.id.Baby_info) ;
        Vaccine_info = (ImageButton) findViewById(R.id.Vaccine_info) ;
        Vaccine_schedule = (ImageButton) findViewById(R.id.Vaccine_schedule) ;
        report = (ImageButton) findViewById(R.id.report) ;
        Nearby_hospital = (ImageButton) findViewById(R.id.Nearby_hospital) ;

       // new Thread(runnable).start();//啟動執行序runnable

        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                        case R.id.Baby_info :
                        Intent i1 = new Intent(MainActivity.this , BabyinfomodifyActivity.class) ;
                        startActivity(i1);
                        finish();
                        break;
                    case R.id.Vaccine_info :
                        Intent i2 = new Intent(MainActivity.this , VaccineInfoActivity.class) ;
                        startActivity(i2);
                        finish();
                        break;
                    case R.id.Vaccine_schedule :
                        Intent i3 = new Intent(MainActivity.this , VaccineScheduleActivity.class) ;
                        startActivity(i3);
                        finish();
                        break;
                    case R.id.report :
                        Intent i4 = new Intent(MainActivity.this , ReportActivity.class) ;
                        startActivity(i4);
                        finish();
                        break;
                    case R.id.Nearby_hospital :
                        Intent i5 = new Intent(MainActivity.this , NearbyActivity.class) ;
                        startActivity(i5);
                        finish();
                        break;
                }
            }
        };
        Baby_info.setOnClickListener(listener);
        Vaccine_info.setOnClickListener(listener);
        Vaccine_schedule.setOnClickListener(listener);
        report.setOnClickListener(listener);
        Nearby_hospital.setOnClickListener(listener);


    }


    public boolean onKeyDown(int keyCode, KeyEvent event) {//捕捉返回鍵
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("切換小孩帳號?");
            builder.setCancelable(false);
            builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    SharedPreferences sp = getSharedPreferences("session",MODE_PRIVATE);
                    sp.edit().remove("Bn");
                    Intent i6 = new Intent(MainActivity.this , SelectActivity.class) ;
                    startActivity(i6);
                    finish();
                }
            });

            builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                }
            });
            AlertDialog alert = builder.create();
            alert.show();            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    public boolean onOptionsItemSelected(MenuItem item){
            switch (item.getItemId()) {
                default:
                    AlertDialog.Builder builder = new AlertDialog.Builder(this);
                    builder.setMessage("切換小孩帳號?");
                    builder.setCancelable(false);
                    builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            SharedPreferences sp = getSharedPreferences("session",MODE_PRIVATE);
                            sp.edit().remove("Bn");
                            Intent i9 = new Intent(MainActivity.this , SelectActivity.class) ;
                            startActivity(i9);
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


}
