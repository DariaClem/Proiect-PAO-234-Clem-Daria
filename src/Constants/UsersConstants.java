package Constants;

public class UsersConstants {
    public static final String QUERY_CREATE_USER = "insert into smartcity.user (lastName, firstName, CNP, address) values (?, ?, ?, ?)";
    public static final String QUERY_GET_ALL_USERS = "select * from smartcity.user";
    public static final String QUERY_GET_USER_BY_NAME = "select * from smartcity.user where lastName =? and firstName=?";
    public static final String QUERY_GET_USER_BY_ID = "select * from smartcity.user where user.id = ?";
    public static final String QUERY_DELETE_ALL_USERS = "delete * from smartcity.user";
    public static final String QUERY_DELETE_USER_BY_NAME = "delete from smartcity.user where user.firstName = ? and user.lastName = ?";
    public static final String QUERY_DELETE_USER_BY_ID = "delete from smartcity.user where user.id = ?";
}
