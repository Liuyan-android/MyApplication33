package cn.edu.sdwu.android02.classroom.sn170507180102;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class lyActivity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ly3);
    }
    public void ok(View view){
        //设置子activity的返回值
        EditText editText=(EditText)findViewById(R.id.ly3_name);
        String content=editText.getText().toString();
        //将数据放在intent里面
        Intent intent=new Intent();
        intent.putExtra("name",content);
        setResult(RESULT_OK,intent);//设置返回值
        finish();//关闭当前界面
    }
    public void  cancel(View view){
        setResult(RESULT_CANCELED);//  取消
        finish();
    }
}
