package net.macdidi.graduateproject;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class ReportActivity extends AppCompatActivity {
    Spinner Vaccinelate ;
    Button SendReport ;
    CheckBox Reportcheck ;
    EditText ReportText ;
    String[] Accine = {""," B型肝炎遺傳工程疫苗第一劑","B型肝炎遺傳工程疫苗第二劑","五合一疫苗第一劑","13價結合型肺炎鏈球菌疫苗第一劑","五合一疫苗第二劑",
            "13價結合型肺炎鏈球菌疫苗第二劑","卡介苗第一劑","B型肝炎遺傳工程疫苗第三劑","五合一疫苗第三劑","13價結合型肺炎鏈球菌疫苗第三劑",
            "麻疹腮腺炎德國麻疹混合疫苗第一劑","水痘疫苗第一劑","活菌日本腦炎疫苗第一劑","五合一疫苗第四劑","活菌日本腦炎疫苗第二劑","四合一疫苗",
            "麻疹腮腺炎德國麻疹混合疫苗第二劑"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        final ActionBar actionbar = getSupportActionBar();
        TextView centerText = new TextView(getApplicationContext());
        RelativeLayout.LayoutParams layoutparams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        centerText.setLayoutParams(layoutparams);
        centerText.setText("未施打回報");
        centerText.setTextColor(Color.WHITE);
        centerText.setGravity(Gravity.CENTER);
        centerText.setTextSize(20);
        actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionbar.setCustomView(centerText);
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.back);

        SendReport = (Button) findViewById(R.id.SendReport) ;
        Vaccinelate = (Spinner)findViewById(R.id.Vaccinelate);
        Reportcheck = (CheckBox)findViewById(R.id.Reportcheck);
        ReportText = (EditText) findViewById(R.id.ReportText);

        ArrayAdapter<String> AccineList = new ArrayAdapter<>(ReportActivity.this,android.R.layout.simple_spinner_dropdown_item,Accine);
        Vaccinelate.setAdapter(AccineList);

        Vaccinelate.setOnItemSelectedListener(new Spinner.OnItemSelectedListener()
        {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (Vaccinelate.getSelectedItemPosition())
                {
                    case 1:
                        View.OnClickListener listener = new View.OnClickListener(){
                            @Override
                            public void onClick(View v) {
                                ReportText = (EditText) findViewById(R.id.ReportText) ;
                                Editable StrReportTexttp;
                                StrReportTexttp = ReportText.getText();
                                String problemtp =StrReportTexttp.toString();

                                Intent i1 = new Intent(ReportActivity.this , va_problem1.class) ;
                                Bundle bundle = new Bundle();
                                bundle.putString("problemtp",problemtp);
                                i1.putExtras(bundle);
                                startActivity(i1);
                                Toast.makeText(SendReport.getContext(),"回報成功!",Toast.LENGTH_SHORT).show();
                            }

                        };
                        SendReport.setOnClickListener(listener);
                        break;

                    case 2:
                        View.OnClickListener listener2 = new View.OnClickListener(){
                            @Override
                            public void onClick(View v) {
                                ReportText = (EditText) findViewById(R.id.ReportText) ;
                                Editable StrReportTexttp;
                                StrReportTexttp = ReportText.getText();
                                String problemtp =StrReportTexttp.toString();

                                Intent i1 = new Intent(ReportActivity.this , va_problem2.class) ;
                                Bundle bundle = new Bundle();
                                bundle.putString("problemtp",problemtp);
                                i1.putExtras(bundle);
                                startActivity(i1);
                                Toast.makeText(SendReport.getContext(),"回報成功!",Toast.LENGTH_SHORT).show();
                            }

                        };
                        SendReport.setOnClickListener(listener2);
                        break;

                    case 3:
                        View.OnClickListener listener3 = new View.OnClickListener(){
                            @Override
                            public void onClick(View v) {
                                ReportText = (EditText) findViewById(R.id.ReportText) ;
                                Editable StrReportTexttp;
                                StrReportTexttp = ReportText.getText();
                                String problemtp =StrReportTexttp.toString();

                                Intent i1 = new Intent(ReportActivity.this , va_problem3.class) ;
                                Bundle bundle = new Bundle();
                                bundle.putString("problemtp",problemtp);
                                i1.putExtras(bundle);
                                startActivity(i1);
                                Toast.makeText(SendReport.getContext(),"回報成功!",Toast.LENGTH_SHORT).show();
                            }

                        };
                        SendReport.setOnClickListener(listener3);
                        break;

                    case 4:
                        View.OnClickListener listener4 = new View.OnClickListener(){
                            @Override
                            public void onClick(View v) {
                                ReportText = (EditText) findViewById(R.id.ReportText) ;
                                Editable StrReportTexttp;
                                StrReportTexttp = ReportText.getText();
                                String problemtp =StrReportTexttp.toString();

                                Intent i1 = new Intent(ReportActivity.this , va_problem4.class) ;
                                Bundle bundle = new Bundle();
                                bundle.putString("problemtp",problemtp);
                                i1.putExtras(bundle);
                                startActivity(i1);
                                Toast.makeText(SendReport.getContext(),"回報成功!",Toast.LENGTH_SHORT).show();
                            }

                        };
                        SendReport.setOnClickListener(listener4);
                        break;

                    case 5:
                        View.OnClickListener listener5 = new View.OnClickListener(){
                            @Override
                            public void onClick(View v) {
                                ReportText = (EditText) findViewById(R.id.ReportText) ;
                                Editable StrReportTexttp;
                                StrReportTexttp = ReportText.getText();
                                String problemtp =StrReportTexttp.toString();

                                Intent i1 = new Intent(ReportActivity.this , va_problem5.class) ;
                                Bundle bundle = new Bundle();
                                bundle.putString("problemtp",problemtp);
                                i1.putExtras(bundle);
                                startActivity(i1);
                                Toast.makeText(SendReport.getContext(),"回報成功!",Toast.LENGTH_SHORT).show();
                            }

                        };
                        SendReport.setOnClickListener(listener5);
                        break;

                    case 6:
                        View.OnClickListener listener6 = new View.OnClickListener(){
                            @Override
                            public void onClick(View v) {
                                ReportText = (EditText) findViewById(R.id.ReportText) ;
                                Editable StrReportTexttp;
                                StrReportTexttp = ReportText.getText();
                                String problemtp =StrReportTexttp.toString();

                                Intent i1 = new Intent(ReportActivity.this , va_problem6.class) ;
                                Bundle bundle = new Bundle();
                                bundle.putString("problemtp",problemtp);
                                i1.putExtras(bundle);
                                startActivity(i1);
                                Toast.makeText(SendReport.getContext(),"回報成功!",Toast.LENGTH_SHORT).show();
                            }

                        };
                        SendReport.setOnClickListener(listener6);
                        break;

                    case 7:
                        View.OnClickListener listener7 = new View.OnClickListener(){
                            @Override
                            public void onClick(View v) {
                                ReportText = (EditText) findViewById(R.id.ReportText) ;
                                Editable StrReportTexttp;
                                StrReportTexttp = ReportText.getText();
                                String problemtp =StrReportTexttp.toString();

                                Intent i1 = new Intent(ReportActivity.this , va_problem7.class) ;
                                Bundle bundle = new Bundle();
                                bundle.putString("problemtp",problemtp);
                                i1.putExtras(bundle);
                                startActivity(i1);
                                Toast.makeText(SendReport.getContext(),"回報成功!",Toast.LENGTH_SHORT).show();
                            }

                        };
                        SendReport.setOnClickListener(listener7);
                        break;

                    case 8:
                        View.OnClickListener listener8 = new View.OnClickListener(){
                            @Override
                            public void onClick(View v) {
                                ReportText = (EditText) findViewById(R.id.ReportText) ;
                                Editable StrReportTexttp;
                                StrReportTexttp = ReportText.getText();
                                String problemtp =StrReportTexttp.toString();

                                Intent i1 = new Intent(ReportActivity.this , va_problem8.class) ;
                                Bundle bundle = new Bundle();
                                bundle.putString("problemtp",problemtp);
                                i1.putExtras(bundle);
                                startActivity(i1);
                                Toast.makeText(SendReport.getContext(),"回報成功!",Toast.LENGTH_SHORT).show();
                            }

                        };
                        SendReport.setOnClickListener(listener8);
                        break;

                    case 9:
                        View.OnClickListener listener9 = new View.OnClickListener(){
                            @Override
                            public void onClick(View v) {
                                ReportText = (EditText) findViewById(R.id.ReportText) ;
                                Editable StrReportTexttp;
                                StrReportTexttp = ReportText.getText();
                                String problemtp =StrReportTexttp.toString();

                                Intent i1 = new Intent(ReportActivity.this , va_problem9.class) ;
                                Bundle bundle = new Bundle();
                                bundle.putString("problemtp",problemtp);
                                i1.putExtras(bundle);
                                startActivity(i1);
                                Toast.makeText(SendReport.getContext(),"回報成功!",Toast.LENGTH_SHORT).show();
                            }

                        };
                        SendReport.setOnClickListener(listener9);
                        break;

                    case 10:
                        View.OnClickListener listener10 = new View.OnClickListener(){
                            @Override
                            public void onClick(View v) {
                                ReportText = (EditText) findViewById(R.id.ReportText) ;
                                Editable StrReportTexttp;
                                StrReportTexttp = ReportText.getText();
                                String problemtp =StrReportTexttp.toString();

                                Intent i1 = new Intent(ReportActivity.this , va_problem10.class) ;
                                Bundle bundle = new Bundle();
                                bundle.putString("problemtp",problemtp);
                                i1.putExtras(bundle);
                                startActivity(i1);
                                Toast.makeText(SendReport.getContext(),"回報成功!",Toast.LENGTH_SHORT).show();
                            }

                        };
                        SendReport.setOnClickListener(listener10);
                        break;

                    case 11:
                        View.OnClickListener listener11 = new View.OnClickListener(){
                            @Override
                            public void onClick(View v) {
                                ReportText = (EditText) findViewById(R.id.ReportText) ;
                                Editable StrReportTexttp;
                                StrReportTexttp = ReportText.getText();
                                String problemtp =StrReportTexttp.toString();

                                Intent i1 = new Intent(ReportActivity.this , va_problem11.class) ;
                                Bundle bundle = new Bundle();
                                bundle.putString("problemtp",problemtp);
                                i1.putExtras(bundle);
                                startActivity(i1);
                                Toast.makeText(SendReport.getContext(),"回報成功!",Toast.LENGTH_SHORT).show();
                            }

                        };
                        SendReport.setOnClickListener(listener11);
                        break;

                    case 12:
                        View.OnClickListener listener12 = new View.OnClickListener(){
                            @Override
                            public void onClick(View v) {
                                ReportText = (EditText) findViewById(R.id.ReportText) ;
                                Editable StrReportTexttp;
                                StrReportTexttp = ReportText.getText();
                                String problemtp =StrReportTexttp.toString();

                                Intent i1 = new Intent(ReportActivity.this , va_problem12.class) ;
                                Bundle bundle = new Bundle();
                                bundle.putString("problemtp",problemtp);
                                i1.putExtras(bundle);
                                startActivity(i1);
                                Toast.makeText(SendReport.getContext(),"回報成功!",Toast.LENGTH_SHORT).show();
                            }

                        };
                        SendReport.setOnClickListener(listener12);
                        break;

                    case 13:
                        View.OnClickListener listener13 = new View.OnClickListener(){
                            @Override
                            public void onClick(View v) {
                                ReportText = (EditText) findViewById(R.id.ReportText) ;
                                Editable StrReportTexttp;
                                StrReportTexttp = ReportText.getText();
                                String problemtp =StrReportTexttp.toString();

                                Intent i1 = new Intent(ReportActivity.this , va_problem13.class) ;
                                Bundle bundle = new Bundle();
                                bundle.putString("problemtp",problemtp);
                                i1.putExtras(bundle);
                                startActivity(i1);
                                Toast.makeText(SendReport.getContext(),"回報成功!",Toast.LENGTH_SHORT).show();
                            }

                        };
                        SendReport.setOnClickListener(listener13);
                        break;

                    case 14:
                        View.OnClickListener listener14 = new View.OnClickListener(){
                            @Override
                            public void onClick(View v) {
                                ReportText = (EditText) findViewById(R.id.ReportText) ;
                                Editable StrReportTexttp;
                                StrReportTexttp = ReportText.getText();
                                String problemtp =StrReportTexttp.toString();

                                Intent i1 = new Intent(ReportActivity.this , va_problem14.class) ;
                                Bundle bundle = new Bundle();
                                bundle.putString("problemtp",problemtp);
                                i1.putExtras(bundle);
                                startActivity(i1);
                                Toast.makeText(SendReport.getContext(),"回報成功!",Toast.LENGTH_SHORT).show();
                            }

                        };
                        SendReport.setOnClickListener(listener14);
                        break;

                    case 15:
                        View.OnClickListener listener15 = new View.OnClickListener(){
                            @Override
                            public void onClick(View v) {
                                ReportText = (EditText) findViewById(R.id.ReportText) ;
                                Editable StrReportTexttp;
                                StrReportTexttp = ReportText.getText();
                                String problemtp =StrReportTexttp.toString();

                                Intent i1 = new Intent(ReportActivity.this , va_problem15.class) ;
                                Bundle bundle = new Bundle();
                                bundle.putString("problemtp",problemtp);
                                i1.putExtras(bundle);
                                startActivity(i1);
                                Toast.makeText(SendReport.getContext(),"回報成功!",Toast.LENGTH_SHORT).show();
                            }

                        };
                        SendReport.setOnClickListener(listener15);
                        break;

                    case 16:
                        View.OnClickListener listener16 = new View.OnClickListener(){
                            @Override
                            public void onClick(View v) {
                                ReportText = (EditText) findViewById(R.id.ReportText) ;
                                Editable StrReportTexttp;
                                StrReportTexttp = ReportText.getText();
                                String problemtp =StrReportTexttp.toString();

                                Intent i1 = new Intent(ReportActivity.this , va_problem16.class) ;
                                Bundle bundle = new Bundle();
                                bundle.putString("problemtp",problemtp);
                                i1.putExtras(bundle);
                                startActivity(i1);
                                Toast.makeText(SendReport.getContext(),"回報成功!",Toast.LENGTH_SHORT).show();
                            }

                        };
                        SendReport.setOnClickListener(listener16);
                        break;

                    case 17:
                        View.OnClickListener listener17 = new View.OnClickListener(){
                            @Override
                            public void onClick(View v) {
                                ReportText = (EditText) findViewById(R.id.ReportText) ;
                                Editable StrReportTexttp;
                                StrReportTexttp = ReportText.getText();
                                String problemtp =StrReportTexttp.toString();

                                Intent i1 = new Intent(ReportActivity.this , va_problem17.class) ;
                                Bundle bundle = new Bundle();
                                bundle.putString("problemtp",problemtp);
                                i1.putExtras(bundle);
                                startActivity(i1);
                                Toast.makeText(SendReport.getContext(),"回報成功!",Toast.LENGTH_SHORT).show();
                            }

                        };
                        SendReport.setOnClickListener(listener17);
                        break;



                }
                Toast.makeText(ReportActivity.this, "您選擇" + Vaccinelate.getSelectedItem().toString(), Toast.LENGTH_LONG).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                Toast.makeText(ReportActivity.this, " 您沒有選擇任何項目", Toast.LENGTH_LONG).show();
            }



        });

        SendReport.setEnabled(false);

        Reportcheck.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                // update your model (or other business logic) based on isChecked
                if(Reportcheck.isChecked()) {
                    SendReport.setEnabled(true);
                }
                else{
                    SendReport.setEnabled(false);
                }
            }CompoundButton checkBox;
        });

        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                if("".equals(ReportText.getText().toString().trim())){
                    Toast.makeText(SendReport.getContext(),"請輸入回報內容!",Toast.LENGTH_SHORT).show();
                }
                else{
                    Intent i1 = new Intent(ReportActivity.this, MainActivity.class);
                    startActivity(i1);
                    Toast.makeText(SendReport.getContext(),"回報成功!",Toast.LENGTH_SHORT).show();
                }
            }
        };
        SendReport.setOnClickListener(listener);
    }
    public boolean onKeyDown(int keyCode, KeyEvent event) {//捕捉返回鍵
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Intent i2 = new Intent(ReportActivity.this , MainActivity.class) ;
            startActivity(i2);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            default:
                Intent i2 = new Intent(ReportActivity.this , MainActivity.class) ;
                startActivity(i2);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item) ;
    }

}
