package net.macdidi.graduateproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class BabyInfoActivity extends AppCompatActivity {
    Button modify_babyinfo;
    String showUri = "http://192.168.2.101/AppTest/BabyinfoGet.php";
    com.android.volley.RequestQueue requestQueue;
    TextView text ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_baby_info);

        final ActionBar actionbar = getSupportActionBar();
        TextView centerText = new TextView(getApplicationContext());
        RelativeLayout.LayoutParams layoutparams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        centerText.setLayoutParams(layoutparams);
        centerText.setText("新生兒資訊");
        centerText.setTextColor(Color.WHITE);
        centerText.setGravity(Gravity.CENTER);
        centerText.setTextSize(20);
        actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionbar.setCustomView(centerText);
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.back);

        modify_babyinfo = (Button) findViewById(R.id.modify_babyinfo) ;
        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i1 = new Intent(BabyInfoActivity.this, BabyinfomodifyActivity.class);
                startActivity(i1);
                finish();
            }

        };
        modify_babyinfo.setOnClickListener(listener);
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {//捕捉返回鍵
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Intent i2 = new Intent(BabyInfoActivity.this , MainActivity.class) ;
            startActivity(i2);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            default:
                Intent i2 = new Intent(BabyInfoActivity.this , MainActivity.class) ;
                startActivity(i2);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item) ;
    }

}
