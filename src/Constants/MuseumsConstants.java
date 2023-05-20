package Constants;

public class MuseumsConstants {
    public static final String QUERY_CREATE_MUSEUM = "insert into smartcity.museum (name, address) values (?, ?)";
    public static final String QUERY_GET_ALL_MUSEUMS = "select * from smartcity.museum";
    public static final String QUERY_GET_MUSEUM_BY_NAME = "select * from smartcity.museum where museum.name = ?";
    public static final String QUERY_GET_MUSEUM_BY_ID = "select * from smartcity.museum where museum.id = ?";
    public static final String QUERY_DELETE_ALL_MUSEUMS = "delete * from smartcity.museum";
    public static final String QUERY_DELETE_MUSEUM_BY_NAME = "delete from smartcity.museum where museum.name = ?";
    public static final String QUERY_DELETE_MUSEUM_BY_ID = "delete from smartcity.museum where museum.id = ?";
}
