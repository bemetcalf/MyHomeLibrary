package database;

import android.content.ContentValues;

public class BookItem {


    private int itemID ;
    private String name ;
    private String volume ;
    private String author ;
    private String genre ;
    private String shelf ;
    private String series;
    private String type ;
    private String format ;
    private String people ;
    private String picture;
    public BookItem(String iName, String vol){
        String hash = iName + vol;
        itemID = hash.hashCode();
        name = iName;
        volume = vol;
        author = null;
        genre = null;
        shelf = null;
        series = null;
        type = null;
        format =null;
        people = null;
        picture = null;
    }
    public ContentValues toValues(){
        ContentValues values = new ContentValues();
        values.put(BookTable.COLUMN_ITEM_ID, itemID);
        values.put(BookTable.name, name);
        values.put(BookTable.COLUMN_VOLUME, volume);
        values.put(BookTable.COLUMN_AUTHOR, author);
        values.put(BookTable.COLUMN_GENRE, genre);
        values.put(BookTable.COLUMN_SHELF, shelf);
        values.put(BookTable.COLUMN_FORMAT, format);
        values.put(BookTable.people, people);
        values.put(BookTable.COLUMN_PICTURE, picture);

        return values;
    }
}
