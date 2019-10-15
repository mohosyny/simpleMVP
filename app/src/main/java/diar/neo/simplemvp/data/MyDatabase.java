package diar.neo.simplemvp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class MyDatabase extends SQLiteOpenHelper {

    private static final String DB_NAME="mohosyny";
    private static final int DB_VERSION=1;
    private static final String TBL_NAME="news";
    private static final String COL_ID="id";
    private static final String COL_TITLE="title";
    private static final String COL_DESC="description";
    private static final String COL_IMG="image";
    private static final String COL_DATE="date";

    private static final String QUERY="CREATE TABLE IF NOT EXISTS "+TBL_NAME+"("+
            COL_ID+" INTEGER PRIMARY KEY AUTOINCREMENT, "+
            COL_TITLE+" TEXT,"+
            COL_DESC+" TEXT,"+
            COL_IMG+" TEXT,"+
            COL_DATE+" TEXT);";

    private Context context;

    public MyDatabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context=context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        try{
            db.execSQL(QUERY);
        }catch (SQLException e){
            e.printStackTrace();
        }

    }


    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }



    public long addInfo(String title, String desc,String img, String date){
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_TITLE,title);
        contentValues.put(COL_DESC,desc);
        contentValues.put(COL_IMG,img);
        contentValues.put(COL_DATE,date);

        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();

        return sqLiteDatabase.insert(TBL_NAME,null,contentValues);
        /*  if(result>0){
           return result;
        }else{
            return result;
        }*/
    }

    public Cursor getInfos(){
        String query="SELECT * FROM "+TBL_NAME;
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        return sqLiteDatabase.rawQuery(query,null);
    }

    public Cursor getSomeData(){
        String name="mahla";
        String query="SELECT * FROM "+TBL_NAME+" WHERE "+COL_ID+" = ?";
        SQLiteDatabase sqLiteDatabase=this.getReadableDatabase();
        return sqLiteDatabase.rawQuery(query,new String[]{String.valueOf(name)});
    }

    public void updateRow(){
        int age=222;
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(COL_DATE,age);
        sqLiteDatabase.update(TBL_NAME,contentValues,COL_DATE+" = ?",new String[]{String.valueOf(12)});
    }

    public void deleteRow(){
        SQLiteDatabase sqLiteDatabase=this.getWritableDatabase();
        sqLiteDatabase.delete(TBL_NAME,COL_DATE+" = ?",new String[]{String.valueOf(20)});
    }



}
