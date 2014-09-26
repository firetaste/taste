/**
 * 
 */
package helen.love.syf.common.vo;

import java.io.Serializable;

/**
 * @author syf
 *
 */
@SuppressWarnings("serial")
public class Table implements Serializable {

	/**
	 * 
	 */
	public Table() {		 
	}
     /**数据库名  */
	private String dbName;
	 /**表名  */
	private String tableName;
	 /**类型：表或视图  */
	private String tableType;
	 /**表注释  */
	private String tableComment;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		 
		return  "{\"dbName\":\""+dbName+"\",\"tableName\":\""+tableName+"\",\"tableType\":\""+tableType+"\",\"tableConmment\":\""+tableComment+"\"}";
	}
	/**
	 * @return the dbName
	 */
	public String getDbName() {
		return dbName;
	}
	/**
	 * @param dbName the dbName to set
	 */
	public void setDbName(String dbName) {
		this.dbName = dbName;
	}
	/**
	 * @return the tableName
	 */
	public String getTableName() {
		return tableName;
	}
	/**
	 * @param tableName the tableName to set
	 */
	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	/**
	 * @return the tableType
	 */
	public String getTableType() {
		return tableType;
	}
	/**
	 * @param tableType the tableType to set
	 */
	public void setTableType(String tableType) {
		this.tableType = tableType;
	}
	/**
	 * @return the tableComment
	 */
	public String getTableComment() {
		return tableComment;
	}
	/**
	 * @param tableComment the tableComment to set
	 */
	public void setTableComment(String tableComment) {
		this.tableComment = tableComment;
	}
  
 
	 
}
