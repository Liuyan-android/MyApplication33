package cn.edu.sdwu.android02.classroom.sn170507180102;

import android.content.ComponentName;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class lyActivity4 extends AppCompatActivity {
    private ServiceConnection serviceConnection;
    private  MyService2 myService2;
    private  boolean bindSucc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_4);
        bindSucc=false;
        serviceConnection = new ServiceConnection() {
            @Override
            public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
                //当调用者与服务建立起连接后会自动调用该方法
                //第二个参数，是service中onBind的返回值
                MyService2.MyBinder myBinder=(MyService2.MyBinder) iBinder;
                myService2=myBinder.getRandomService();
                bindSucc=true;
            }

            @Override
            public void onServiceDisconnected(ComponentName componentName) {
                //断开连接后会自动调用该方法
                bindSucc=false;

            }
        };

    }
//可见,绑定
    @Override
    protected void onStart() {
        super.onStart();
        Intent intent=new Intent(this,MyService2.class);
        bindService(intent,serviceConnection,BIND_AUTO_CREATE);
    }
//不可见，解绑
    @Override
    protected void onStop() {
        super.onStop();
        //断开连接解绑
        unbindService(serviceConnection);
    }

    public  void start_service(View view){
        Intent intent=new Intent(this,MyService.class);
        //使用startservice一启动方式启动服务
        startService(intent);
    }
    public void stop_service(View view){
        Intent intent=new Intent(this,MyService.class);

        stopService(intent);
    }
    public  void  getRandom(View view){
        if(bindSucc){
            int ran=myService2.getRandom();
            Toast.makeText(this,ran+ "", Toast.LENGTH_LONG).show();
        }
    }
}
