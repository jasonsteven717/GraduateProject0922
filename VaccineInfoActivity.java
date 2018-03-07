package net.macdidi.graduateproject;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class VaccineInfoActivity extends AppCompatActivity {
    ListView listView ;
    String[] title = new String[]{"B型肝炎遺傳工程疫苗","五合一疫苗","13價結合型肺炎鏈球菌疫苗","卡介苗","麻疹腮腺炎德國麻疹混合疫苗",
            "水痘疫苗","活菌日本腦炎疫苗","四合一疫苗"};
    ImageView dialog_image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vaccine_info);

        final ActionBar actionbar = getSupportActionBar();
        TextView centerText = new TextView(getApplicationContext());
        RelativeLayout.LayoutParams layoutparams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        centerText.setLayoutParams(layoutparams);
        centerText.setText("疫苗知識");
        centerText.setTextColor(Color.WHITE);
        centerText.setGravity(Gravity.CENTER);
        centerText.setTextSize(20);
        actionbar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionbar.setCustomView(centerText);
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.back);

        listView = (ListView) findViewById(R.id.listView);
        List<HashMap<String , String>> list = new ArrayList<>();
        //使用List存入HashMap，用來顯示ListView上面的文字。

                String[] text  = new String[]{"","","","","","","",""};
        for(int i = 0 ; i < title.length ; i++){
            HashMap<String , String> hashMap = new HashMap<>();
            hashMap.put("title" , title[i]);
            hashMap.put("text" , text[i]);
            //把title , text存入HashMap之中
            list.add(hashMap);
            //把HashMap存入list之中
        }
        ListAdapter listAdapter = new SimpleAdapter(this,list,android.R.layout.simple_list_item_2 ,new String[]{"title" , "text"} ,new int[]{android.R.id.text1 , android.R.id.text2});
        // 5個參數 : context , List , layout , key1 & key2 , text1 & text2
        listView.setAdapter(listAdapter);
        listView.setOnItemClickListener(onClickListView);       //指定事件 Method


    }
    private AdapterView.OnItemClickListener onClickListView = new AdapterView.OnItemClickListener(){
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            switch (title[position]){
                case  "B型肝炎遺傳工程疫苗":
                    AlertDialog.Builder builder = new AlertDialog.Builder(VaccineInfoActivity.this);
                    builder.setMessage("臺灣地區為Ｂ型肝炎高感染地區，成人之帶原率達百分之20，年幼時期的感染易演變成慢性帶原者，按時完成預防接種能有效預防型肝炎的感染。\n" +
                            "\n◎ 接種時程\n" +
                            "＊第1劑：出生24小內儘速接種，愈早愈好\n" +
                            "＊第2劑：出生滿1個月\n" +
                            "＊第3劑：出生滿6個月\n" +
                            "\n◎ 注意事項\n" +
                            "＊發燒或正患有急性中重度疾病者，宜待病情穩定後再接種。\n" +
                            "＊母親非Ｂ型肝炎帶原者之低出生體重兒（＜2,000公克），其第1劑Ｂ肝疫苗，於體重超過2,000公克或出生滿1個月後接種。");
                    builder.setCancelable(false);
                    builder.setNegativeButton("我知道了", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });
                    AlertDialog alert = builder.create();
                    alert.show();
                    break;
                case  "五合一疫苗":
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(VaccineInfoActivity.this);
                    builder1.setMessage("五合一疫苗是一種注射式的不活化疫苗，可以同時預防白喉、破傷風、百日咳、小兒麻痺以及ｂ型嗜血桿菌等五種傳染病，" +
                                    "此疫苗將舊型三合一疫苗中的全細胞性百日咳成分，改為非細胞性百日咳，可大幅減少接種後發生注射部位紅腫、疼痛或發燒等不良反應的機率，" +
                            "另外也用不活化小兒麻痺疫苗(IPV)取代口服小兒麻痺疫苗(OPV)，以避免發生機率極低的因疫苗引致小兒麻痺症(VAPP)的發生。\n" +
                            "\n◎ 接種時程\n" +
                            "＊第1劑 : 出生滿2個月\n" +
                            "＊第2劑 : 出生滿4個月\n" +
                            "＊第3劑 : 出生滿6個月\n" +
                            "＊第4劑 : 出生1歲6個月\n" +
                            "\n◎ 注意事項\n" +
                            "＊發燒或正患有急性中重度疾病者，宜待病情穩定後再接種。\n" +
                            "＊患有進行性痙攣症或神經系統疾病者，宜於醫師判斷病情已經穩定後才注射疫苗。\n" +
                            "＊先前接種含破傷風疫苗後6週內曾發生過GBS者。\n" +
                            "＊曾接種含破傷風類毒素疫苗後，發生Arthus過敏反應者，與次劑含破傷風類毒素疫苗應間隔10年以上再接種。\n" +
                            "＊不適宜接種含百日咳疫苗之6歲以下幼兒，可改接種白喉破傷風混合疫苗（DT）及不活化小兒麻痺疫苗（IPV）。\n" +
                            "＊滿7歲以上不適用。\n");
                    builder1.setCancelable(false);
                    builder1.setNegativeButton("我知道了", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });
                    AlertDialog alert1 = builder1.create();
                    alert1.show();
                    break;
                case  "13價結合型肺炎鏈球菌疫苗":
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(VaccineInfoActivity.this);
                    builder2.setMessage("13價結合型肺炎鏈球菌疫(PCV13)是一種相當安全的不活化疫苗，內含13種血清型(1、3、4、5、6A、6B、7F、9V、14、18C、19A、19F、23F)，" +
                            "接種後少數的人可能發生注射部位疼痛、紅腫的反應，一般於接種2天內恢復。發燒、倦怠等嚴重副作用則極少發生，" +
                            "接種後如有持續發燒、嚴重過敏反應，如呼吸困難、氣喘、眩昏、心跳加速等不適症狀，應儘速就醫，請醫師做進一步的判斷與處理。\n" +
                            "\n◎ 接種時程\n" +
                            "＊第1劑：出生滿2個月\n" +
                            "＊第2劑：出生滿4個月\n" +
                            "＊第3劑：出生滿12-15個月\n" +
                            "\n◎ 注意事項\n" +
                            "＊先前接種本疫苗或對本疫苗任何成分過敏(包括白喉類毒素)曾發生嚴重過敏反應者。\n" +
                            "發燒或正患急性中重度疾病者，宜待病情穩定後再接種。\n" +
                            "出生未滿6週。\n" +
                            "其他經醫師評估不適合接種者。\n");
                    builder2.setCancelable(false);
                    builder2.setNegativeButton("我知道了", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });
                    AlertDialog alert2 = builder2.create();
                    alert2.show();
                    break;
                case  "卡介苗":
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(VaccineInfoActivity.this);
                    builder3.setMessage("卡介苗是一種牛的分枝桿菌所製成的活性疫苗，經減毒後注入人體，可產生對結核病的抵抗力，" +
                            "一般對初期症候的預防效果約85％，主要可避免造成結核性腦膜炎等嚴重併發症。\n" +
                            "\n◎ 接種時程\n" +
                            "＊第1劑：出生滿5個月(建議接種時間為出生滿5-8個月)\n" +
                            "＊長住高發生率地區或即將前往結核病高盛行國家，可建議家屬考慮提早接種卡介苗。\n" +
                            "\n◎ 注意事項\n" +
                            "＊發燒或正患有急性中重度疾病者，宜待病情穩定後再接種。\n" +
                            "＊疑似結核病人及疑似被結核菌感染者，勿直接接種卡介苗。\n" +
                            "＊麻疹及水痘感染，宜待復原期(6週)後再接種。\n" +
                            "＊請父母確認父母雙方家人沒有疑似先天性免疫不全疾病之家族史，例如幼年因嚴重感染死亡。\n" +
                            "＊母親為愛滋病毒感染者，其嬰幼兒應追蹤至少6個月，確定未得到感染再接種卡介苗。\n" +
                            "＊新生兒提早接種者，體重應達2500公克以上。");
                    builder3.setCancelable(false);
                    builder3.setNegativeButton("我知道了", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });
                    AlertDialog alert3 = builder3.create();
                    alert3.show();
                    break;
                case  "麻疹腮腺炎德國麻疹混合疫苗":
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(VaccineInfoActivity.this);

                    builder4.setMessage("MMR疫苗是用來預防麻疹、腮腺炎、德國麻疹的活性減毒疫苗，其預防效果平均可達95％以上，並可獲長期免疫。\n" +
                            "\n◎ 接種時程\n" +
                            "＊第1劑：出生滿 12 個月\n" +
                            "＊第2劑 : 滿5歲至入國小前\n" +
                            "\n◎ 注意事項\n" +
                            "＊發燒或正患有急性中重度疾病者，宜待病情穩定後再接種。\n" +
                            "＊最近曾輸血或接受其他血液製劑者（如免疫球蛋白），應詢問原診治醫師何時可接種MMR。\n" +
                            "＊曾有血小板低下症或血小板缺乏紫斑症的疾病史者，宜請醫師評估。\n" +
                            "＊接受結核菌素測驗者，如未於接種前或接種當天接受測驗，應於接種一個月後再進行測驗。\n" +
                            "＊女性接種後4週內應避免懷孕。但疫苗施打後4週內發現懷孕，不應被視為中止懷孕之適應症。\n");
                    builder4.setCancelable(false);
                    builder4.setNegativeButton("我知道了", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });
                    AlertDialog alert4 = builder4.create();
                    alert4.show();
                    break;
                case  "水痘疫苗":
                    AlertDialog.Builder builder5 = new AlertDialog.Builder(VaccineInfoActivity.this);
                    builder5.setMessage("水痘疫苗是一種活性減毒疫苗，可有效避免嚴重之水痘症狀，接種水痘疫苗後若仍感染水痘，其症狀亦較輕微，" +
                                    "可能會產生較少的水痘，且較不會發燒，復原較快。\n" +
                            "\n◎ 接種時程\n" +
                            "＊第1劑：出生滿12個月（針對92年1月1日以後出生幼兒實施）\n" +
                            "\n◎ 注意事項\n" +
                            "＊發燒或正患有急性中重度疾病者，宜待病情穩定後再接種。\n" +
                            "＊最近曾輸血或接受其他血液製劑者（如免疫球蛋白），應詢問原診治醫師何時可接種水痘疫苗。\n" +
                            "＊接種前24小時內曾接受特定抗病毒藥物者（如：acyclovir、famciclovir或valacyclovir），於接種後間隔14天以後再重新開始服用這些藥物。\n" +
                            "＊女性接種後4週內應避免懷孕。\n" +
                            "＊接種後皮膚出現紅疹者，應避免接觸嚴重免疫不全者。\n" +
                            "＊18歲以下兒童接種水痘疫苗後6週內宜避免使用水楊酸類藥品(salicylates)。\n");
                    builder5.setCancelable(false);
                    builder5.setNegativeButton("我知道了", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });
                    AlertDialog alert5 = builder5.create();
                    alert5.show();
                    break;
                case  "活菌日本腦炎疫苗":
                    AlertDialog.Builder builder6 = new AlertDialog.Builder(VaccineInfoActivity.this);
                    builder6.setMessage("國內長期使用不活化日本腦炎疫苗，接種效益及防治成效顯見。為順應疫苗產製技術轉變趨勢，" +
                            "自本（106）年5月22日起改採用細胞培養之日本腦炎活性減毒疫苗。\n" +
                            "\n◎ 接種時程\n" +
                            "＊第1劑 : 出生滿15個月\n" +
                            "＊第2劑 : 間隔12個月後接種\n" +
                            "\n◎ 注意事項\n" +
                            "下列狀況者，宜待病情穩定後或經醫師評估後再接種：\n" +
                            "＊發燒或正患有急性中重度疾病者，宜待病情穩定後再接種。\n" +
                            "＊使用≧14 天高劑量全身性皮質類固醇者，可於停止類固醇≧28 天之後接種疫苗。\n" +
                            "＊最近三個月曾輸血或接受其他血液製劑者（如免疫球蛋白），應詢問原診治醫師何時可接種日本腦炎疫苗（請見「各項預防接種間隔時間一覽表」）。\n" +
                            "＊育齡婦女在接種疫苗後4週內宜避免懷孕。");
                    builder6.setCancelable(false);
                    builder6.setNegativeButton("我知道了", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });
                    AlertDialog alert6 = builder6.create();
                    alert6.show();
                    break;
                case  "四合一疫苗":
                    AlertDialog.Builder builder7 = new AlertDialog.Builder(VaccineInfoActivity.this);
                    builder7.setMessage("破傷風、減量白喉混合疫苗 (Td)、減量破傷風白喉非細胞性百日咳混合疫苗 (Tdap)、減量破傷風白喉非細胞性百日咳及不活化小兒麻痺混合疫苗 (Tdap-IPV)\n" +
                            "\n◎ 接種時程\n" +
                            "＊第1劑 : 滿5歲至入小學前完成\n" +
                            "\n◎ 注意事項\n" +
                            "＊患有進行性痙攣症或神經系統疾病者，宜於醫師判斷病情已經穩定後才注射疫苗。\n" +
                            "＊發燒或正患有急性中重度疾病者，宜待病情穩定後再接種。\n" +
                            "＊先前接種含破傷風疫苗後6週內曾發生過GBS者。\n" +
                            "＊曾接種含破傷風類毒素疫苗後，發生Arthus過敏反應者，與次劑含破傷風類毒素疫苗應間隔10年以上再接種。\n" +
                            "＊不適宜接種含百日咳疫苗者，可改接種破傷風減量白喉混合疫苗（Td）。\n");
                    builder7.setCancelable(false);
                    builder7.setNegativeButton("我知道了", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {

                        }
                    });
                    AlertDialog alert7 = builder7.create();
                    alert7.show();
                    break;
            }
        }

    };
    public boolean onKeyDown(int keyCode, KeyEvent event) {//捕捉返回鍵
        if ((keyCode == KeyEvent.KEYCODE_BACK)) {
            Intent i2 = new Intent(VaccineInfoActivity.this , MainActivity.class) ;
            startActivity(i2);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            default:
                Intent i2 = new Intent(VaccineInfoActivity.this , MainActivity.class) ;
                startActivity(i2);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item) ;
    }

}
