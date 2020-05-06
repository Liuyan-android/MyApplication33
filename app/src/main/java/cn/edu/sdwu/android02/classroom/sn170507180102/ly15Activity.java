package cn.edu.sdwu.android02.classroom.sn170507180102;

import android.content.ContentResolver;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class ly15Activity extends AppCompatActivity {
    private ContentResolver contentResolver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_15);
        contentResolver=getContentResolver();
    }
    public  void query(View view){

    }
}
