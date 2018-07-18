package database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class DataSource {
    private Context mContext;
    private SQLiteDatabase mDatabase;
    SQLiteOpenHelper mDbHelper ;

    public DataSource (Context cont){
        this.mContext = cont;
        mDbHelper = new DBHelper(mContext);
        mDatabase = mDbHelper.getWritableDatabase();
    }
    public void open(){
        mDatabase = mDbHelper.getWritableDatabase();
    }
    public void close(){
        mDatabase.close();
    }
}
