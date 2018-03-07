package net.macdidi.graduateproject;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.DataSetObservable;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("NewApi")

public class NearbyActivity extends AppCompatActivity {
    ListView listView1;

    Button SearchButton;
    EditText SearcheditText;
    ListAdapter adapter;
    String[] region = {"高雄市衛生醫療查詢系統","鳳山區衛生所","新興區衛生所","苓雅區衛生所","鼓山區衛生所","前鎮區衛生所","楠梓區衛生所","左營區衛生所","大社區衛生所","路竹區衛生所",
            "田寮區衛生所","橋頭區衛生所","彌陀區衛生所","湖內區衛生所","大寮區衛生所","鳥松區衛生所","大樹區衛生所","美濃區衛生所","內門區衛生所","甲仙區衛生所",
            "那瑪夏區衛生所","茄萣區衛生所","旗山區衛生所","六龜區衛生所","杉林區衛生所","桃源區衛生所","茂林區衛生所","阿蓮區衛生所","燕巢區衛生所","梓官區衛生所",
            "永安區衛生所","林園區衛生所","旗津區衛生所","三民區衛生所","小港區衛生所","仁武區衛生所",""};
    private final DataSetObservable mDataSetObservable = new DataSetObservable();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nearby);
        final ActionBar actionbar = getSupportActionBar();
        TextView centerText = new TextView(getApplicationContext());
        RelativeLayout.LayoutParams layoutparams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        centerText.setLayoutParams(layoutparams);
        centerText.setText("附近衛生所醫院");
        centerText.setTextColor(Color.WHITE);
        centerText.setGravity(Gravity.CENTER);
        centerText.setTextSize(20);
        actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionbar.setCustomView(centerText);
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.back);

        SearcheditText = (EditText)findViewById(R.id.SearcheditText);
        SearchButton =(Button) findViewById(R.id.SearchButton);

        listView1 = (ListView) findViewById(R.id.listView1);
        final ListAdapter adapter = new ArrayAdapter<>(this , android.R.layout.simple_list_item_1 ,region);
        //使用ListAdapter來顯示你輸入的文字
        listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(onClickListView);       //指定事件 Method*/
        listView1.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, region));
        listView1.setTextFilterEnabled(true);
        //sv = (SearchView) findViewById(R.id.sv1);
        final String[] temp = new String[1];
        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                for(int i=0;i<37;i++) {
                    if (region[i].contains(SearcheditText.getText().toString()) == true) {
                        temp[0] = region[i];
                        region[i] = region[0];
                        region[0] = temp[0];
                        listView1.setAdapter(adapter);
                        listView1.setOnItemClickListener(onClickListView);       //指定事件 Method*/
                        listView1.setTextFilterEnabled(true);
                        onResume();
                        break;
                    } else {
                        if(i == 36)
                        {
                            Toast.makeText(getApplicationContext(), "搜尋不到目標", Toast.LENGTH_LONG).show();
                        }
                    }
                }
            }

        };
        SearchButton.setOnClickListener(listener);

    }


    private AdapterView.OnItemClickListener onClickListView = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (region[position]){
                case  "鳳山區衛生所":
                    Uri uri= Uri.parse("http://fes.kcg.gov.tw/cp.aspx?n=1506A993CC72B6B3");
                    Intent i=new Intent(Intent.ACTION_VIEW,uri);
                    startActivity(i);
                    break;
                case  "彌陀區衛生所":
                    Uri uri1= Uri.parse("http://mit.kcg.gov.tw/cp.aspx?n=E641F7FF2AE058A1");
                    Intent i1=new Intent(Intent.ACTION_VIEW,uri1);
                    startActivity(i1);
                    break;
                case  "新興區衛生所":
                    Uri uri2= Uri.parse("http://sis.kcg.gov.tw/cp.aspx?n=3B5CF278333EAB11");
                    Intent i2=new Intent(Intent.ACTION_VIEW,uri2);
                    startActivity(i2);
                    break;
                case  "苓雅區衛生所":
                    Uri uri3= Uri.parse("http://lya.kcg.gov.tw/cp.aspx?n=C004B2532BED667D");
                    Intent i3=new Intent(Intent.ACTION_VIEW,uri3);
                    startActivity(i3);
                    break;
                case  "鼓山區衛生所":
                    Uri uri4= Uri.parse("http://gus.kcg.gov.tw/cp.aspx?n=60D8F3E4BF17F129");
                    Intent i4=new Intent(Intent.ACTION_VIEW,uri4);
                    startActivity(i4);
                    break;
                case  "前鎮區衛生所":
                    Uri uri5= Uri.parse("http://cjh.kcg.gov.tw/cp.aspx?n=A17442EBC7A79156");
                    Intent i5=new Intent(Intent.ACTION_VIEW,uri5);
                    startActivity(i5);
                    break;
                case  "楠梓區衛生所":
                    Uri uri6= Uri.parse("http://naz.kcg.gov.tw/cp.aspx?n=EBD0F13103083A0C");
                    Intent i6=new Intent(Intent.ACTION_VIEW,uri6);
                    startActivity(i6);
                    break;
                case  "左營區衛生所":
                    Uri uri7= Uri.parse("http://zuy.kcg.gov.tw/cp.aspx?n=49BD830E1B3453BE");
                    Intent i7=new Intent(Intent.ACTION_VIEW,uri7);
                    startActivity(i7);
                    break;
                case  "大社區衛生所":
                    Uri uri8= Uri.parse("http://das.kcg.gov.tw/cp.aspx?n=472031E66621EA40");
                    Intent i8=new Intent(Intent.ACTION_VIEW,uri8);
                    startActivity(i8);
                    break;
                case  "路竹區衛生所":
                    Uri uri9= Uri.parse("http://lju.kcg.gov.tw/cp.aspx?n=602D9CE3DD72F51C");
                    Intent i9=new Intent(Intent.ACTION_VIEW,uri9);
                    startActivity(i9);
                    break;
                case  "田寮區衛生所":
                    Uri uri10= Uri.parse("http://til.kcg.gov.tw/cp.aspx?n=4C969FD9D64F4185");
                    Intent i10=new Intent(Intent.ACTION_VIEW,uri10);
                    startActivity(i10);
                    break;
                case  "橋頭區衛生所":
                    Uri uri11= Uri.parse("http://cht.kcg.gov.tw/cp.aspx?n=8E347E3D3181B686");
                    Intent i11=new Intent(Intent.ACTION_VIEW,uri11);
                    startActivity(i11);
                    break;
                case  "湖內區衛生所":
                    Uri uri12= Uri.parse("http://hun.kcg.gov.tw/cp.aspx?n=CEC9EA66D8B619C3");
                    Intent i12=new Intent(Intent.ACTION_VIEW,uri12);
                    startActivity(i12);
                    break;
                case  "大寮區衛生所":
                    Uri uri13= Uri.parse("http://dlu.kcg.gov.tw/cp.aspx?n=865E97E00D069AB4");
                    Intent i13=new Intent(Intent.ACTION_VIEW,uri13);
                    startActivity(i13);
                    break;
                case  "鳥松區衛生所":
                    Uri uri14= Uri.parse("http://nis.kcg.gov.tw/cp.aspx?n=63F5AB3D02A8BBAC");
                    Intent i14=new Intent(Intent.ACTION_VIEW,uri14);
                    startActivity(i14);
                    break;
                case  "大樹區衛生所":
                    Uri uri15= Uri.parse("http://dsu.kcg.gov.tw/cp.aspx?n=572D33E74DC7ED66");
                    Intent i15=new Intent(Intent.ACTION_VIEW,uri15);
                    startActivity(i15);
                    break;
                case  "美濃區衛生所":
                    Uri uri16= Uri.parse("http://mei.kcg.gov.tw/cp.aspx?n=BDA7850FA1FE40E1");
                    Intent i16=new Intent(Intent.ACTION_VIEW,uri16);
                    startActivity(i16);
                    break;
                case  "內門區衛生所":
                    Uri uri17= Uri.parse("http://nem.kcg.gov.tw/cp.aspx?n=EDEFA227B1B62714");
                    Intent i17=new Intent(Intent.ACTION_VIEW,uri17);
                    startActivity(i17);
                    break;
                case  "甲仙區衛生所":
                    Uri uri18= Uri.parse("http://jis.kcg.gov.tw/cp.aspx?n=77054B15FD1F5128");
                    Intent i18=new Intent(Intent.ACTION_VIEW,uri18);
                    startActivity(i18);
                    break;
                case  "那瑪夏區衛生所":
                    Uri uri19= Uri.parse("http://nms.kcg.gov.tw/cp.aspx?n=A4E731B5D0B08607");
                    Intent i19=new Intent(Intent.ACTION_VIEW,uri19);
                    startActivity(i19);
                    break;
                case  "茄萣區衛生所":
                    Uri uri20= Uri.parse("http://chd.kcg.gov.tw/cp.aspx?n=5829ACD1CAF6E5C1");
                    Intent i20=new Intent(Intent.ACTION_VIEW,uri20);
                    startActivity(i20);
                    break;
                case  "旗山區衛生所":
                    Uri uri21= Uri.parse("http://chs.kcg.gov.tw/cp.aspx?n=179CA77619917468");
                    Intent i21=new Intent(Intent.ACTION_VIEW,uri21);
                    startActivity(i21);
                    break;
                case  "六龜區衛生所":
                    Uri uri22= Uri.parse("http://lig.kcg.gov.tw/cp.aspx?n=3082A2EAA9122D4B");
                    Intent i22=new Intent(Intent.ACTION_VIEW,uri22);
                    startActivity(i22);
                    break;
                case  "杉林區衛生所":
                    Uri uri23= Uri.parse("http://sli.kcg.gov.tw/cp.aspx?n=4EEC28A30D578C87");
                    Intent i23=new Intent(Intent.ACTION_VIEW,uri23);
                    startActivity(i23);
                    break;
                case  "桃源區衛生所":
                    Uri uri24= Uri.parse("http://tay.kcg.gov.tw/cp.aspx?n=4969B31AB4F62677");
                    Intent i24=new Intent(Intent.ACTION_VIEW,uri24);
                    startActivity(i24);
                    break;
                case  "茂林區衛生所":
                    Uri uri25= Uri.parse("http://mli.kcg.gov.tw/cp.aspx?n=4719E7B09677A75F");
                    Intent i25=new Intent(Intent.ACTION_VIEW,uri25);
                    startActivity(i25);
                    break;
                case  "阿蓮區衛生所":
                    Uri uri26= Uri.parse("http://ali.kcg.gov.tw/cp.aspx?n=22269F94152D1D51");
                    Intent i26=new Intent(Intent.ACTION_VIEW,uri26);
                    startActivity(i26);
                    break;
                case  "燕巢區衛生所":
                    Uri uri27= Uri.parse("http://yac.kcg.gov.tw/cp.aspx?n=66360DBE1F9DFA41");
                    Intent i27=new Intent(Intent.ACTION_VIEW,uri27);
                    startActivity(i27);
                    break;
                case  "梓官區衛生所":
                    Uri uri28= Uri.parse("http://tzg.kcg.gov.tw/cp.aspx?n=949874E4899E18ED");
                    Intent i28=new Intent(Intent.ACTION_VIEW,uri28);
                    startActivity(i28);
                    break;
                case  "永安區衛生所":
                    Uri uri29= Uri.parse("http://yua.kcg.gov.tw/cp.aspx?n=9A55A37F350EF86A");
                    Intent i29=new Intent(Intent.ACTION_VIEW,uri29);
                    startActivity(i29);
                    break;
                case  "林園區衛生所":
                    Uri uri30= Uri.parse("http://liy.kcg.gov.tw/cp.aspx?n=1BF789210A041C9F");
                    Intent i30=new Intent(Intent.ACTION_VIEW,uri30);
                    startActivity(i30);
                    break;
                case  "旗津區衛生所":
                    Uri uri31= Uri.parse("http://cji.kcg.gov.tw/cp.aspx?n=4D833E26864BB926");
                    Intent i31=new Intent(Intent.ACTION_VIEW,uri31);
                    startActivity(i31);
                    break;
                case  "三民區衛生所":
                    Uri uri32= Uri.parse("http://sam1.kcg.gov.tw/cp.aspx?n=4155355575096510");
                    Intent i32=new Intent(Intent.ACTION_VIEW,uri32);
                    startActivity(i32);
                    break;
                case  "小港區衛生所":
                    Uri uri33= Uri.parse("http://sig.kcg.gov.tw/cp.aspx?n=33DE8745316D5A90");
                    Intent i33=new Intent(Intent.ACTION_VIEW,uri33);
                    startActivity(i33);
                    break;
                case  "仁武區衛生所":
                    Uri uri34= Uri.parse("http://rew.kcg.gov.tw/cp.aspx?n=A7CDA77AF6289418");
                    Intent i34=new Intent(Intent.ACTION_VIEW,uri34);
                    startActivity(i34);
                    break;
                case  "岡山區衛生所":
                    Uri uri35= Uri.parse("http://gan.kcg.gov.tw/cp.aspx?n=04D50237E37C9779");
                    Intent i35=new Intent(Intent.ACTION_VIEW,uri35);
                    startActivity(i35);
                    break;
                case  "高雄市衛生醫療查詢系統":
                    Uri uri36= Uri.parse("http://khd.kcg.gov.tw/Main.aspx?sn=986");
                    Intent i36=new Intent(Intent.ACTION_VIEW,uri36);
                    startActivity(i36);
                    break;
            }
        }

    };
    public boolean onKeyDown(int keyCode, KeyEvent event) {//捕捉返回鍵
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Intent i2 = new Intent(NearbyActivity.this , MainActivity.class) ;
            startActivity(i2);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            default:
                Intent i2 = new Intent(NearbyActivity.this , MainActivity.class) ;
                startActivity(i2);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item) ;
    }

}
