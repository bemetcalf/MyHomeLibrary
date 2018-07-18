package database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

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

    public List<BookItem> getAllBooks(){
        List<BookItem> bookList = new ArrayList<BookItem>();
        Cursor cursor = mDatabase.query(BookTable.TABLE_BOOKS,BookTable.ALL_COLUMNS,
                null,null,null,null,BookTable.COLUMN_NAME);
        while(cursor.moveToNext()){
            BookItem book = new BookItem(cursor.getString(cursor.getColumnIndex(BookTable.COLUMN_NAME)),
                    cursor.getString(cursor.getColumnIndex(BookTable.COLUMN_VOLUME)));
            book.setAuthor(cursor.getString(cursor.getColumnIndex(BookTable.COLUMN_AUTHOR)));
            book.setFormat(cursor.getString(cursor.getColumnIndex(BookTable.COLUMN_FORMAT)));
            book.setGenre(cursor.getString(cursor.getColumnIndex(BookTable.COLUMN_GENRE)));
            book.setSeries(cursor.getString(cursor.getColumnIndex(BookTable.COLUMN_SERIES)));
            book.setPeople(cursor.getString(cursor.getColumnIndex(BookTable.COLUMN_PEOPLE)));
            book.setType(cursor.getString(cursor.getColumnIndex(BookTable.COLUMN_TYPE)));
            book.setShelf(cursor.getString(cursor.getColumnIndex(BookTable.COLUMN_SHELF)));
            book.setPicture(cursor.getString(cursor.getColumnIndex(BookTable.COLUMN_PICTURE)));

            bookList.add(book);
        }
        cursor.close();
        return bookList;
    }
    public List<BookItem> getBooksByName(String[] bookName){
        List<BookItem> bookList = new ArrayList<BookItem>();
        Cursor cursor = mDatabase.query(BookTable.TABLE_BOOKS,BookTable.ALL_COLUMNS,
                BookTable.COLUMN_NAME + "=?",bookName,null,null,BookTable.COLUMN_NAME);
        while(cursor.moveToNext()){
            BookItem book = new BookItem(cursor.getString(cursor.getColumnIndex(BookTable.COLUMN_NAME)),
                    cursor.getString(cursor.getColumnIndex(BookTable.COLUMN_VOLUME)));
            book.setAuthor(cursor.getString(cursor.getColumnIndex(BookTable.COLUMN_AUTHOR)));
            book.setFormat(cursor.getString(cursor.getColumnIndex(BookTable.COLUMN_FORMAT)));
            book.setGenre(cursor.getString(cursor.getColumnIndex(BookTable.COLUMN_GENRE)));
            book.setSeries(cursor.getString(cursor.getColumnIndex(BookTable.COLUMN_SERIES)));
            book.setPeople(cursor.getString(cursor.getColumnIndex(BookTable.COLUMN_PEOPLE)));
            book.setType(cursor.getString(cursor.getColumnIndex(BookTable.COLUMN_TYPE)));
            book.setShelf(cursor.getString(cursor.getColumnIndex(BookTable.COLUMN_SHELF)));
            book.setPicture(cursor.getString(cursor.getColumnIndex(BookTable.COLUMN_PICTURE)));

            bookList.add(book);
        }
        cursor.close();
        return bookList;
    }
    public List<BookItem> getBooksBySeries(String[] seriesName){
        List<BookItem> bookList = new ArrayList<BookItem>();
        Cursor cursor = mDatabase.query(BookTable.TABLE_BOOKS,BookTable.ALL_COLUMNS,
                BookTable.COLUMN_SERIES + "=?",seriesName,null,null,BookTable.COLUMN_NAME);
        while(cursor.moveToNext()){
            BookItem book = new BookItem(cursor.getString(cursor.getColumnIndex(BookTable.COLUMN_NAME)),
                    cursor.getString(cursor.getColumnIndex(BookTable.COLUMN_VOLUME)));
            book.setAuthor(cursor.getString(cursor.getColumnIndex(BookTable.COLUMN_AUTHOR)));
            book.setFormat(cursor.getString(cursor.getColumnIndex(BookTable.COLUMN_FORMAT)));
            book.setGenre(cursor.getString(cursor.getColumnIndex(BookTable.COLUMN_GENRE)));
            book.setSeries(cursor.getString(cursor.getColumnIndex(BookTable.COLUMN_SERIES)));
            book.setPeople(cursor.getString(cursor.getColumnIndex(BookTable.COLUMN_PEOPLE)));
            book.setType(cursor.getString(cursor.getColumnIndex(BookTable.COLUMN_TYPE)));
            book.setShelf(cursor.getString(cursor.getColumnIndex(BookTable.COLUMN_SHELF)));
            book.setPicture(cursor.getString(cursor.getColumnIndex(BookTable.COLUMN_PICTURE)));

            bookList.add(book);
        }
        cursor.close();
        return bookList;
    }
    public String toString(){
        String list ="";
        for(BookItem books : getAllBooks()) {
            list+= books.toString();
            list+="\n\n";
        }
        return list;
    }
    public String toNameString(String name){
        String[] search = {name};
        String list ="";
        for(BookItem books : getBooksByName(search)) {
            list+= books.toString();
            list+="\n\n";
        }
        return list;
    }
    public String toSeriesString(String series){
        String[] search = {series};
        String list ="";
        for(BookItem books : getBooksBySeries(search)) {
            list+= books.toString();
            list+="\n\n";
        }
        return list;
    }
}
