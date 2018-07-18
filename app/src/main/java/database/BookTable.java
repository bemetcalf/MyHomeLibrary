package database;

public class BookTable {
    public static final String book = "Book Table";
    public static final String itemID = "ID";
    public static final String name = "Name";
    public static final String volume = "Volume";
    public static final String author = "Author";
    public static final String genre = "Genre" ;
    public static final String shelf = "Shelf";
    public static final String series = "Series";
    public static final String type = "Type";
    public static final String format = "Format";
    public static final String people = "People";
    public static final String picture = "ImageID";

    public static final String SQL_CREATE =
          "CREATE TABLE " + book +"("+
            itemID + " INTEGER PRIMARY KEY, "+
            name + " TEXT, " +
            volume + " TEXT, " +
            author + " TEXT, " +
            genre + " TEXT, " +
            shelf + " TEXT, "+
            series + " TEXT, "+
            type + " TEXT, "+
            format + " TEXT, "+
            people + " TEXT, " +
            picture + " TEXT" + ");";

    public static final String SQL_DELETE = "DROP TABLE " + book;
}
