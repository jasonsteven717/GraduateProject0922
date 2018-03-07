package net.macdidi.graduateproject;

import android.content.ContentResolver;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
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

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.List;

public class BabyinfomodifyActivity extends AppCompatActivity {
    final String url = "http://192.168.2.101/AppTest/BabyinfoGet.php";
    private ImageView babyphoto;
    private DisplayMetrics mPhone;
    private final static int PHOTO = 99 ;
    String stringUri;
    Button modify ;
    ImageButton photo ;
    EditText babyname ;
    EditText birthday ;
    EditText heigh ;
    EditText weight ;
    EditText mothername ;
    EditText fathername ;
    EditText sex ;
    EditText blood ;
    EditText dayCounter;
    int mod = 0;
    String imagepath;
    String upLoadServerUri;
    int serverResponseCode = 0;
    private static final String Babyinfo = "Babyinfo";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_babyinfomodify);

        String upLoadServerUri = "http://192.168.2.101/AppTest/UploadToServer.php";


        babyname = (EditText) findViewById(R.id.babyname) ;
        birthday = (EditText) findViewById(R.id.birthday) ;
        heigh = (EditText) findViewById(R.id.heigh) ;
        weight = (EditText) findViewById(R.id.weight) ;
        mothername = (EditText) findViewById(R.id.mothername) ;
        fathername = (EditText) findViewById(R.id.fathername) ;
        sex = (EditText)findViewById(R.id.sex) ;
        blood = (EditText)findViewById(R.id.blood) ;
        dayCounter = (EditText)findViewById(R.id.editText3);


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

        mPhone = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(mPhone);

        babyphoto = (ImageView) findViewById(R.id.babyphoto);
        ImageButton mPhoto = (ImageButton) findViewById(R.id.photo);

        /*if(checkSDCard())
        {
            //帶入SDCard內的圖片路徑(SDCard: DCIM資料夾/100MEDIA資料夾/001圖片)
            //Toast.makeText(BabyinfomodifyActivity.this,"111",Toast.LENGTH_SHORT).show();
            babyphoto.setImageBitmap(getBitmapFromSDCard("/sdcard/demo/111.jpg"));
        }
        else{
            Toast.makeText(BabyinfomodifyActivity.this,"尚未插入SDCard",Toast.LENGTH_SHORT).show();
        }*/

        SharedPreferences sharedFile = getSharedPreferences(Babyinfo, MODE_PRIVATE);
        heigh.setText(sharedFile.getString("babyheigh", "heigh")) ;
        weight.setText(sharedFile.getString("babyweight", "weight")) ;
        fathername.setText(sharedFile.getString("fathername", "fathername")) ;

        babyname.setEnabled(false);
        birthday.setEnabled(false);
        heigh.setEnabled(false);
        weight.setEnabled(false);
        mothername.setEnabled(false);
        fathername.setEnabled(false);
        sex.setEnabled(false);
        blood.setEnabled(false);
        dayCounter.setEnabled(false);

        modify = (Button) findViewById(R.id.modify) ;
        photo = (ImageButton) findViewById(R.id.photo) ;


        View.OnClickListener listener = new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.modify:
                        if (mod == 0) {
                            heigh.setEnabled(true);
                            weight.setEnabled(true);
                            fathername.setEnabled(true);
                            mod = 1;
                        } else if (mod == 1) {
                            SharedPreferences sharedPreferences = getSharedPreferences(Babyinfo, MODE_PRIVATE);

                            SharedPreferences.Editor editor = sharedPreferences.edit();

                            editor.putString("babyheigh", heigh.getText().toString());
                            editor.putString("babyweight", weight.getText().toString());
                            editor.putString("fathername ", fathername.getText().toString());
                            editor.commit();
                            Toast.makeText(modify.getContext(), "編輯成功!", Toast.LENGTH_SHORT).show();
                            mod = 0;
                            heigh.setEnabled(false);
                            weight.setEnabled(false);
                            fathername.setEnabled(false);
                        }
                        break;
                    case R.id.photo:
                        Intent intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(intent, PHOTO);
                     break;
                }
            }

        };
        modify.setOnClickListener(listener);
        photo.setOnClickListener(listener);
        new Thread(runnable).start();//啟動執行序runnable
    }

    
    protected void onActivityResult(int requestCode, int resultCode,Intent data)
    {
        if (requestCode == PHOTO  && data != null)
        {
            //取得照片路徑uri
            Uri uri = data.getData();
            stringUri = uri.toString();
            ContentResolver cr = this.getContentResolver();
            try
            {
                //讀取照片，型態為Bitmap
                Bitmap bitmap = BitmapFactory.decodeStream(cr.openInputStream(uri));
                saveBitmap(bitmap);
                //判斷照片為橫向或者為直向，並進入ScalePic判斷圖片是否要進行縮放
                if(bitmap.getWidth()>bitmap.getHeight())ScalePic(bitmap,
                        mPhone.heightPixels);
                else ScalePic(bitmap,mPhone.widthPixels);
            }
            catch (FileNotFoundException e)
            {
            }
        }

        super.onActivityResult(requestCode, resultCode, data);
    }
    private void ScalePic(Bitmap bitmap,int phone)
    {
        //縮放比例預設為1
        float mScale = 1 ;

        //如果圖片寬度大於手機寬度則進行縮放，否則直接將圖片放入ImageView內
        if(bitmap.getWidth() > phone )
        {
            //判斷縮放比例
            mScale = (float)phone/(float)bitmap.getWidth();
            Matrix mMat = new Matrix() ;
            mMat.setScale(mScale, mScale);

            Bitmap mScaleBitmap = Bitmap.createBitmap(bitmap,0,0,bitmap.getWidth(),bitmap.getHeight(),mMat,false);
            babyphoto.setImageBitmap(mScaleBitmap);
        }
        else babyphoto.setImageBitmap(bitmap);
    }
    public void saveBitmap(Bitmap bitmap) {
        FileOutputStream fOut = null;
        try {
            File dir = new File("/sdcard/demo/");
            if (!dir.exists()) {
                dir.mkdir();
                Toast.makeText(BabyinfomodifyActivity.this,"666",Toast.LENGTH_SHORT).show();
                fOut = new FileOutputStream("/sdcard/demo/111.jpg");
                Toast.makeText(BabyinfomodifyActivity.this,"777",Toast.LENGTH_SHORT).show();
                bitmap.compress(Bitmap.CompressFormat.JPEG, 100,fOut);
                Toast.makeText(BabyinfomodifyActivity.this,"333",Toast.LENGTH_SHORT).show();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            Toast.makeText(BabyinfomodifyActivity.this,"555",Toast.LENGTH_SHORT).show();
        }
    }
    private static boolean checkSDCard()
    {
        if(Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED))
        {
            return true;
        }
        return false;
    }
    private static Bitmap getBitmapFromSDCard(String file)
    {
        try
        {
            String sd = Environment.getExternalStorageDirectory().toString();
            Bitmap bitmap = BitmapFactory.decodeFile(sd + "/" + file);
            return bitmap;
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    Handler handler_Success = new Handler(){

        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            Bundle data = msg.getData();
            String val = data.getString("key");//取出key中的字串存入val\
            String [] temp = null;
            temp = val.split(":");
            babyname.setText(temp[0]);
            sex.setText(temp[1]);
            birthday.setText(temp[2]);
            blood.setText(temp[3]);
            mothername.setText(temp[4]);
            dayCounter.setText(temp[5]);
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
                String Bname = shareAc.getString("Bn","0");

                List<NameValuePair> vars=new ArrayList<NameValuePair>();
                vars.add(new BasicNameValuePair("Account",Account ));
                vars.add(new BasicNameValuePair("Bname",Bname ));

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
            Intent i2 = new Intent(BabyinfomodifyActivity.this , MainActivity.class) ;
            startActivity(i2);
            finish();
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()) {
            default:
                Intent i2 = new Intent(BabyinfomodifyActivity.this, MainActivity.class);
                startActivity(i2);
                finish();
                break;
        }
        return super.onOptionsItemSelected(item) ;
    }


}
