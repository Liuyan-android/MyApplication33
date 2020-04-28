package cn.edu.sdwu.android02.classroom.sn170507180102;

import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.os.Build;
import android.os.Environment;
import android.os.FileObserver;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.jar.Manifest;

public class ly13Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_13_1);
    }

    public void write(View view) {
        EditText editText = (EditText) findViewById(R.id.ch13_1_et);
        String content = editText.getText().toString();
        try {
            FileOutputStream fileOutputStream = openFileOutput("android02.txt", MODE_PRIVATE);
            fileOutputStream.write(content.getBytes());
            fileOutputStream.flush();
            fileOutputStream.close();

        }catch (Exception e){

        }


    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode==101){
            if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                //如果用户同意则进行下一步的操作写入sd卡
                EditText editText = (EditText) findViewById(R.id.ch13_1_et);
                String content = editText.getText().toString();
                writeExternal(content);
            }

            }
        if (requestCode==102){
            if (grantResults[0]==PackageManager.PERMISSION_GRANTED){
                readExternal();
            }

        }
        }


    public  void  writeSd(View view) {
        EditText editText = (EditText) findViewById(R.id.ch13_1_et);
        String content = editText.getText().toString();
        //1、判断用户是否已经授权过
        //判断当前手机系统版本，是否是6.0之后的
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //判断当前用户是否授权过
            int result = checkSelfPermission(android.Manifest.permission.WRITE_EXTERNAL_STORAGE);
            if (result == PackageManager.PERMISSION_GRANTED) {
                writeExternal(content);

            } else {
                requestPermissions(new String[]{android.Manifest.permission.WRITE_EXTERNAL_STORAGE}, 101);
            }
        } else {


            writeExternal(content);

        }
    }

    private  void writeExternal(String content){
        //写入外部存储
        //得到fileoutputstream的方法与内部存储不同
        FileOutputStream fileOutputStream=null;
        //创建file对象
        File file=new File(Environment.getExternalStorageDirectory(),"abcde.txt");//构造方法中提供文件所在的目录名文件名
        try {
            //使用创建文件
            file.createNewFile();
            //判断文件是否存在是否可写
            if (file.exists()&&file.canWrite()){
                fileOutputStream=new FileOutputStream(file);
                fileOutputStream.write(content.getBytes());
            }
        }catch (Exception e){
            Log.e(ly13Activity.class.toString(),e.toString());

        }
        if (fileOutputStream!=null){
            try {
                fileOutputStream.flush();
                fileOutputStream.close();
            }catch (Exception e){
                Log.e(ly13Activity.class.toString(),e.toString());
            }
        }
    }
    public  void readRaw(View view){
        Resources resources=getResources();
        InputStream inputStream=resources.openRawResource(R.raw.read);
        try{
            int size= inputStream.available();
            byte[] bytes=new  byte[size];
            inputStream.read(bytes);
            String content=new String(bytes);
            Toast.makeText(this,content,Toast.LENGTH_LONG).show();

        }catch (Exception e){
            Log.e(ly13Activity.class.toString(),e.toString());
        }finally {
            try{
                inputStream.close();
            }catch (Exception e){
                Log.e(ly13Activity.class.toString(),e.toString());


            }
        }
    }
    public  void readSd(View view  ){
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            //判断当前用户是否授权过
            int result = checkSelfPermission(android.Manifest.permission.READ_EXTERNAL_STORAGE);
            if (result == PackageManager.PERMISSION_GRANTED) {
                readExternal();

            } else {
                requestPermissions(new String[]{android.Manifest.permission.READ_EXTERNAL_STORAGE}, 102);
            }
        } else {


         readExternal();

        }

    }
    private void readExternal(){
        File file=new File(Environment.getExternalStorageDirectory(),"abcde.txt");
        FileInputStream fileInputStream=null;
        try {
            if (file.exists()&&file.canRead()) {
                fileInputStream = new FileInputStream(file);
                int size= fileInputStream.available();
                byte[] bytes=new  byte[size];
                fileInputStream.read(bytes);
                Toast.makeText(this,new String(bytes),Toast.LENGTH_LONG).show();
            }
        }catch (Exception e){
            Log.e(ly13Activity.class.toString(),e.toString());

        }finally {
            try {
                fileInputStream.close();

            }catch (Exception ee){
                Log.e(ly13Activity.class.toString(), ee.toString());

            }

        }
    }
}
