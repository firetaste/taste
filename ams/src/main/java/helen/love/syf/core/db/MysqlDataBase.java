/**
 * 
 */
package helen.love.syf.core.db;

import helen.love.syf.common.vo.Column;
import helen.love.syf.common.vo.Message;
import helen.love.syf.common.vo.Table;
import helen.love.syf.core.IDataBase;
import helen.love.syf.util.DataBaseUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jolbox.bonecp.BoneCP;

/**
 * @author syf
 *
 */
public class MysqlDataBase implements IDataBase {
	public static Logger log = LoggerFactory.getLogger(MysqlDataBase.class);

	/** mysql驱动类名 */
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	/** 数据库表表 */
	public static final String DATABASE_TABLES = "information_schema.tables";
	/** 数据库视图表 */
	public static final String DATABASE_VIEWS = "information_schema.views";
	/** 数据库列表 */
	public static final String TABLE_COLUMNS = "information_schema.columns";
	/** 数据库键值表 */
	public static final String KEY_COLUMNS_USAGE = "information_schema.key_column_usage";
	private BoneCP pool;
	private Message load;
	private String dataBase;

	public MysqlDataBase(String host, int port, String dataBase, String user,
			String pwd) {
		this.dataBase = dataBase;
		load = DataBaseUtils.loadDriver(DRIVER);
		if (load.isSuccess()) {
			String url = "jdbc:mysql://" + host + ":" + port + "/" + dataBase;
			try {
				pool = DataBaseUtils.initConnectionPool(url, user, pwd);
			} catch (SQLException e) {
				log.error(e.getMessage());
				e.printStackTrace();
				pool = null;
				load.setSuccess(false);
				load.setMsg(e.getMessage());
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see helen.love.syf.core.IDataBase#testConnection(java.lang.String, int,
	 * java.lang.String, java.lang.String, java.lang.String, java.lang.String)
	 */
	public Message testSql(String sql) {
		Message result = null;
		if (load.isSuccess()) {
			result = new Message("info", "", true);
			try {

				Connection con = pool.getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while(rs.next()){
					result.setMsg("result: [ "+rs.getInt("result") + " ]  return!");
				}
				

			} catch (SQLException e) {
				result.setMsg(e.getMessage());
				result.setSuccess(false);
				log.error(e.getMessage(), e);
			}
		} else {
			result = load;
		}

		return result;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see helen.love.syf.core.IDataBase#getTables()
	 */
	public List<Table> getTables() {
		List<Table> tables = new ArrayList<Table>();
		String sql = " select table_name tableName,table_type tableType, table_comment tableComment from "
				+ DATABASE_TABLES + "  where table_schema=?";
		if(log.isDebugEnabled()){
			log.debug(sql);
		}
		if (load.isSuccess()) {
			try {
				Connection con = pool.getConnection();
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, this.getDataBase());
				ResultSet rs = st.executeQuery();
				Table table = new Table();
				while (rs.next()) {
					table.setDbName(dataBase);
					table.setTableName(rs.getString("tableName"));
					table.setTableType(rs.getString("tableType"));
					table.setTableComment(rs.getString("tableComment"));
					tables.add(table);
				}
			} catch (SQLException e) {
				log.error(e.getMessage());
				e.printStackTrace();
			}
		}
		return tables;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see helen.love.syf.core.IDataBase#getViews()
	 */
	public List<Table> getViews() {

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see helen.love.syf.core.IDataBase#getColumns(java.lang.String)
	 */
	public List<Column> getColumns(String table) {
		String sql = "	select	c.table_name tableName,	c.column_name columnName,c.column_type dataType,c.is_nullable nullAble,	c.column_default defaultValue,c.column_comment columnComment,c.ordinal_position columnNo from "+TABLE_COLUMNS+"  c  where c.table_name=?";
		List<Column> columns = new ArrayList<Column>();
		if (load.isSuccess()) {
			try {
				Connection con = pool.getConnection();
				PreparedStatement st = con.prepareStatement(sql);
				st.setString(1, table);
				ResultSet rs = st.executeQuery();
				Column col = new Column();
				while (rs.next()) {
					 col.setColumnComment(rs.getString("columnComment"));
					 col.setColumnName(rs.getString("columnName"));
					 col.setColumnNo(rs.getInt("columnNo"));
					 col.setDataType(rs.getString("dataType"));
					 col.setDefaultValue(rs.getString("defaultValue"));
					 col.setNullAble(rs.getString("nullAble")); 
					 col.setTableName(rs.getString("tableName"));
					 columns.add(col);
				}
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}
		return columns;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

	}

	/**
	 * @return the pool
	 */
	public BoneCP getPool() {
		return pool;
	}

	/**
	 * @param pool
	 *            the pool to set
	 */
	public void setPool(BoneCP pool) {
		this.pool = pool;
	}

	/**
	 * @return the load
	 */
	public Message getLoad() {
		return load;
	}

	/**
	 * @param load
	 *            the load to set
	 */
	public void setLoad(Message load) {
		this.load = load;
	}

	/**
	 * @return the dataBase
	 */
	public String getDataBase() {
		return dataBase;
	}

	/**
	 * @param dataBase
	 *            the dataBase to set
	 */
	public void setDataBase(String dataBase) {
		this.dataBase = dataBase;
	}

	public List<Table> getRefTables(String tableName) {
		// TODO Auto-generated method stub
		return null;
	}

}
