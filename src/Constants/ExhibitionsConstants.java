package Constants;

public class ExhibitionsConstants {
    public static final String QUERY_CREATE_EXHIBITION = "insert into smartcity.exhibition (name, startDate, endDate, museumId) values (?, ?, ?, ?)";
    public static final String QUERY_GET_ALL_EXHIBITIONS = "select * from smartcity.exhibition";
    public static final String QUERY_GET_EXHIBITION_BY_NAME = "select * from smartcity.exhibition where exhibition.name = ?";
    public static final String QUERY_GET_EXHIBITION_BY_ID = "select * from smartcity.exhibition where exhibition.id = ?";
    public static final String QUERY_DELETE_ALL_EXHIBITIONS = "delete * from smartcity.exhibition";
    public static final String QUERY_DELETE_EXHIBITION_BY_NAME = "delete from smartcity.exhibition where exhibition.name = ?";
    public static final String QUERY_DELETE_EXHIBITION_BY_ID = "delete from smartcity.exhibition where exhibition.id = ?";
}
