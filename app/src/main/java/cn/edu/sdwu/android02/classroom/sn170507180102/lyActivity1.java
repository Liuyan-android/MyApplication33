package cn.edu.sdwu.android02.classroom.sn170507180102;

import android.content.Intent;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class lyActivity1 extends AppCompatActivity {
    private  Integer count;//点击按键的计数器
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        Log.i(lyActivity1.class.toString(),"onCreat");
        setContentView(R.layout.layout_1);
        count=0;
        //接收数据
        Intent intent=getIntent();
        String text=intent.getStringExtra("text");
        TextView textView=(TextView)findViewById(R.id.ly1_tv);
        textView.setText(text);

    }
    public  void  finishClick(View view){
        finish();//关闭界面
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(lyActivity1.class.toString(),"onStart");
    }
    //计数的方法
    public  void counter(View view){
        count++;
        Log.i(lyActivity1.class.toString(),"counter:"+count);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //数据保存到Bundle里面
        outState.putInt("counter",count);
        super.onSaveInstanceState(outState);
        Log.i(lyActivity1.class.toString(),"onSaveInstanceState");

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        //恢复之前保存的状态信息
       count= savedInstanceState.getInt("counter");
        Log.i(lyActivity1.class.toString(),"onRestoreInstanceState");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(lyActivity1.class.toString(),"onDestory");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.i(lyActivity1.class.toString(),"onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(lyActivity1.class.toString(),"onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(lyActivity1.class.toString(),"onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(lyActivity1.class.toString(),"onRestart");
    }


}
