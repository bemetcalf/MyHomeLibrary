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


    //setters
    public void setItemID(int itemID) {
        this.itemID = itemID;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setVolume(String volume) {
        this.volume = volume;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public void setGenre(String genre) {
        this.genre = genre;
    }
    public void setShelf(String shelf) {
        this.shelf = shelf;
    }
    public void setSeries(String series) {
        this.series = series;
    }
    public void setType(String type) {
        this.type = type;
    }
    public void setFormat(String format) {
        this.format = format;
    }
    public void setPeople(String people) {
        this.people = people;
    }
    public void setPicture(String picture) {
        this.picture = picture;
    }

    public BookItem(String iName, String vol){
        String hash = iName + vol;
        itemID = hash.hashCode();
        name = iName;
        volume = vol;

    }
    public ContentValues toValues(){
        ContentValues values = new ContentValues();
        values.put(BookTable.COLUMN_ITEM_ID, itemID);
        values.put(BookTable.COLUMN_NAME, name);
        values.put(BookTable.COLUMN_VOLUME, volume);
        values.put(BookTable.COLUMN_AUTHOR, author);
        values.put(BookTable.COLUMN_GENRE, genre);
        values.put(BookTable.COLUMN_SHELF, shelf);
        values.put(BookTable.COLUMN_FORMAT, format);
        values.put(BookTable.COLUMN_PEOPLE, people);
        values.put(BookTable.COLUMN_PICTURE, picture);

        return values;
    }
    public String toString(){
        String book ="";
        book+= "Title: "+name+"  ";
        book+= "Volume: "+volume+"  ";
        if(author!= null && author.length()>0){
            book+="Author: " +author+"  ";
        }
        if(series != null && series.length()>0){
            book+="Series: "+ series+"  ";
        }

        return book;
    }
}
