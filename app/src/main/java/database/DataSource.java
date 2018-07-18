package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

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
    public BookItem createItem(BookItem item){
        ContentValues values = item.toValues();
        mDatabase.insert(BookTable.COLUMN_BOOK_TABLE,null,values);
        return item;
    }
    public long getBookCount(){
        return DatabaseUtils.queryNumEntries(mDatabase, BookTable.COLUMN_BOOK_TABLE);
    }
}
