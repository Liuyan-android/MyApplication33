package cn.edu.sdwu.android02.classroom.sn170507180102;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class ly14Activity extends AppCompatActivity {
private MyOpenHelper myOpenHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_ly14);
        myOpenHelper=new MyOpenHelper(this);
        //以可写方式打开数据库

        //使用完毕，将数据库关闭

    }
    public void insert(View view){
        SQLiteDatabase sqLiteDatabase=myOpenHelper.getWritableDatabase();
        try{
            //将插入的数据放置在contentvalues里面
            //事务的处理
            sqLiteDatabase.beginTransaction();//开启事务
            ContentValues contentValues=new ContentValues();
            contentValues.put("stuname","tom");
            contentValues.put("stutel","13888888888");
            sqLiteDatabase.insert("student",null,contentValues);
            sqLiteDatabase.setTransactionSuccessful();//所有操作结束后调用这个方法才会将数据真正保存到数据库中

        }catch (Exception e){
            Log.e(ly14Activity.class.toString(),e.toString());
        }finally {

            sqLiteDatabase.endTransaction();//结束事务
            sqLiteDatabase.close();
        }

    }
    public void query(View view){
        SQLiteDatabase sqLiteDatabase=myOpenHelper.getReadableDatabase();
        try{
          Cursor cursor= sqLiteDatabase.rawQuery("select *from student where stuname=?",new String[]{"Tom"});
       while (cursor.moveToNext()){
          int id= cursor.getInt(cursor.getColumnIndex("id"));
           String stuname=cursor.getString(cursor.getColumnIndex("stuname"));
           String stutel=cursor.getString(cursor.getColumnIndex("stutel"));
           Log.i(ly14Activity.class.toString(),"id:"+id+",stuname:"+stuname+",stutel:"+stutel);
       }
       cursor.close();
        }catch (Exception e){
            Log.e(ly14Activity.class.toString(),e.toString());
        }finally {


            sqLiteDatabase.close();
        }

    }
    public  void delete(View view){
        SQLiteDatabase sqLiteDatabase=myOpenHelper.getWritableDatabase();
        try{
            //将插入的数据放置在contentvalues里面
            //事务的处理
            sqLiteDatabase.beginTransaction();//开启事务


            sqLiteDatabase.delete("student","id=?",new  String[]{"1"});
            sqLiteDatabase.setTransactionSuccessful();//所有操作结束后调用这个方法才会将数据真正保存到数据库中

        }catch (Exception e){
            Log.e(ly14Activity.class.toString(),e.toString());
        }finally {

            sqLiteDatabase.endTransaction();//结束事务
            sqLiteDatabase.close();
        }

    }
    public  void  modify(View view){
        SQLiteDatabase sqLiteDatabase=myOpenHelper.getWritableDatabase();
        try{
            //将插入的数据放置在contentvalues里面
            //事务的处理
            sqLiteDatabase.beginTransaction();//开启事务
            ContentValues contentValues=new ContentValues();

            contentValues.put("stutel","13999999999");
            sqLiteDatabase.update("student",contentValues,"id=?",new String[]{"2"});
            sqLiteDatabase.setTransactionSuccessful();//所有操作结束后调用这个方法才会将数据真正保存到数据库中

        }catch (Exception e){
            Log.e(ly14Activity.class.toString(),e.toString());
        }finally {

            sqLiteDatabase.endTransaction();//结束事务
            sqLiteDatabase.close();
        }

    }

    }

