package database;

public class BookTable {
    public static final String TABLE_BOOKS = "BookTable";
    public static final String COLUMN_ITEM_ID = "ID";
    public static final String name = "Name";
    public static final String COLUMN_VOLUME = "Volume";
    public static final String COLUMN_AUTHOR = "Author";
    public static final String COLUMN_GENRE = "Genre" ;
    public static final String COLUMN_SHELF = "Shelf";
    public static final String COLUMN_SERIES = "Series";
    public static final String type = "Type";
    public static final String COLUMN_FORMAT = "Format";
    public static final String people = "People";
    public static final String COLUMN_PICTURE = "ImageID";

    public static final String[] ALL_COLUMNS= {COLUMN_ITEM_ID,name, COLUMN_VOLUME, COLUMN_AUTHOR, COLUMN_GENRE, COLUMN_SHELF, COLUMN_SERIES,type, COLUMN_FORMAT,people, COLUMN_PICTURE};

    public static final String SQL_CREATE =
          "CREATE TABLE " + TABLE_BOOKS +"("+
                  COLUMN_ITEM_ID + " INTEGER PRIMARY KEY, "+
            name + " TEXT, " +
                  COLUMN_VOLUME + " TEXT, " +
                  COLUMN_AUTHOR + " TEXT, " +
                  COLUMN_GENRE + " TEXT, " +
                  COLUMN_SHELF + " TEXT, "+
                  COLUMN_SERIES + " TEXT, "+
            type + " TEXT, "+
                  COLUMN_FORMAT + " TEXT, "+
            people + " TEXT, " +
                  COLUMN_PICTURE + " TEXT" + ");";

    public static final String SQL_DELETE = "DROP TABLE " + TABLE_BOOKS;
}
