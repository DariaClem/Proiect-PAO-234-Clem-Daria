package Constants;

public class ExhibitsConstants {
    public static final String QUERY_CREATE_EXHIBIT = "insert into smartcity.exhibit (name, description, originCountry, originDate, exhibitionId) values (?, ?, ?, ?, ?)";
    public static final String QUERY_GET_ALL_EXHIBITS = "select * from smartcity.exhibit";
    public static final String QUERY_GET_EXHIBIT_BY_NAME = "select * from smartcity.exhibit where exhibit.name = ?";
    public static final String QUERY_GET_EXHIBIT_BY_ID = "select * from smartcity.exhibit where exhibit.id = ?";
    public static final String QUERY_DELETE_ALL_EXHIBITS = "delete from smartcity.exhibit";
    public static final String QUERY_DELETE_EXHIBIT_BY_NAME = "delete from smartcity.exhibit where exhibit.name = ?";
    public static final String QUERY_DELETE_EXHIBIT_BY_ID = "delete from smartcity.exhibit where exhibit.id = ?";
}
