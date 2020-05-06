package cn.edu.sdwu.android02.classroom.sn170507180102;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by mi on 2020/4/29.
 */

public class MyOpenHelper extends SQLiteOpenHelper {
    private  String STUDENT_TB_SQL="create table student(id integer primary key autoincrement,stuname text,stutel text)";
    public  MyOpenHelper(Context context){
        //Context context上下文, String name数据库名称, CursorFactory factory传入NULL, int version数据库版本) {

        super(context,"stud.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //当打开数据库时发现数据库并不存在，此时会自动创建数据库，然后调用本方法
        //在本方法完成数据库对象（表，视图，索引等）的创建
        sqLiteDatabase.execSQL(STUDENT_TB_SQL);
        Log.i(MyOpenHelper.class.toString(),"onCreate");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
//当构造方法中指定的版本号与手机已有数据版本号更新的时候，调用本方法
        sqLiteDatabase.execSQL("alter table student column stuadd text");
    }
}
