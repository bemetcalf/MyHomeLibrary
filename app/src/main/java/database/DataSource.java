package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
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
    public BookItem createItem(BookItem item){
        ContentValues values = item.toValues();
        mDatabase.insert(BookTable.TABLE_BOOKS,null,values);
        return item;
    }
    public long getBookCount(){
        return DatabaseUtils.queryNumEntries(mDatabase, BookTable.TABLE_BOOKS);
    }
    public void testDB(){
        if(getBookCount() >0) {
            try {
               createItem(new BookItem("test", "test"));


            } catch (SQLiteException e) {

            } Toast.makeText(mContext, "test inserted",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(mContext, "test already inserted",Toast.LENGTH_SHORT).show();

        }
    }
}
