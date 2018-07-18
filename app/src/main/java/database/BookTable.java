package database;

public class BookTable {
    public static final String COLUMN_BOOK_TABLE = "BookTable";
    public static final String COLUMN_ITEM_ID = "ID";
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

    public static final String[] ALL_COLUMNS= {COLUMN_ITEM_ID,name,volume,author,genre,shelf,series,type,format,people,picture};

    public static final String SQL_CREATE =
          "CREATE TABLE " + COLUMN_BOOK_TABLE +"("+
                  COLUMN_ITEM_ID + " INTEGER PRIMARY KEY, "+
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

    public static final String SQL_DELETE = "DROP TABLE " + COLUMN_BOOK_TABLE;
}
