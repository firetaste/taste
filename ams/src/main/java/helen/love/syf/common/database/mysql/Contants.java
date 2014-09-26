/**
 * 
 */
package helen.love.syf.common.database.mysql;

/**
 * @author syf
 *
 */
public interface Contants {

	/**mysql驱动类名*/
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	/** 数据库表表*/
	public static final String DATABASE_TABLES = "information_schema.tables";
	/** 数据库视图表*/
	public static final String DATABASE_VIEWS = "information_schema.views";
	/** 数据库列表*/
	public static final String TABLE_COLUMNS = "information_schema.columns";
	/** 数据库键值表*/
	public static final String KEY_COLUMNS_USAGE = "information_schema.key_column_usage";
}
