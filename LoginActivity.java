package net.macdidi.graduateproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    Button login ;
    Button enroll ;
    EditText account ;
    EditText password ;
    boolean ENTER ;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ENTER = false;

        final ActionBar actionbar = getSupportActionBar();
        TextView centerText = new TextView(getApplicationContext());
        RelativeLayout.LayoutParams layoutparams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        centerText.setLayoutParams(layoutparams);
        centerText.setText("登入");
        centerText.setTextColor(Color.WHITE);
        centerText.setGravity(Gravity.CENTER);
        centerText.setTextSize(20);
        actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionbar.setCustomView(centerText);
        actionbar.setDisplayHomeAsUpEnabled(true);



        login = (Button) findViewById(R.id.login) ;
        enroll = (Button) findViewById(R.id.enroll) ;


        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                account = (EditText) findViewById(R.id.account) ;
                Editable Straccounttp;
                Straccounttp = account.getText();
                String accounttp =Straccounttp.toString();
                password = (EditText) findViewById(R.id.password) ;
                Editable Strpasswordtp;
                Strpasswordtp = password.getText();
                String passwordtp =Strpasswordtp.toString();
                switch(v.getId())
                {
                    case R.id.login:
                        if("".equals(account.getText().toString().trim())||"".equals(password.getText().toString().trim())){
                            Toast.makeText(login.getContext(),"請輸入帳號密碼!",Toast.LENGTH_SHORT).show();
                        }
                        else{
                            Intent i1 = new Intent(LoginActivity.this , LoginPhp.class) ;
                            Bundle bundle = new Bundle();
                            bundle.putString("accounttp",accounttp);
                            bundle.putString("passwordtp",passwordtp);
                            i1.putExtras(bundle);
                            startActivity(i1);
                            finish();

                            ENTER = true ;
                        }
                        break;
                    case R.id.enroll:
                        Intent i2 = new Intent(LoginActivity.this , EnrollActivity.class) ;
                        startActivity(i2);
                        break;
                }

            }

        };
        login.setOnClickListener(listener);
        enroll.setOnClickListener(listener);
    }

}
