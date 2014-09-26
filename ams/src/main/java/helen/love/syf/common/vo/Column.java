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
public class Column implements Serializable {
     /**表名 */
	private String tableName;
	/**列名 */
	private String columnName;
	/**数据类型 */
	private String dataType;
	/**是否为空YES ,ON */
	private String nullAble;
	/**默认值 */
	private String defaultValue;
	/**列注释 */
	private String columnComment;
	/**列位置 */
	private int columnNo;
	
	
	
	/**
	 * 
	 */
	public Column() {
		 
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
	 * @return the columnName
	 */
	public String getColumnName() {
		return columnName;
	}


	/**
	 * @param columnName the columnName to set
	 */
	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}


	/**
	 * @return the dataType
	 */
	public String getDataType() {
		return dataType;
	}


	/**
	 * @param dataType the dataType to set
	 */
	public void setDataType(String dataType) {
		this.dataType = dataType;
	}


	/**
	 * @return the nullAble
	 */
	public String getNullAble() {
		return nullAble;
	}


	/**
	 * @param nullAble the nullAble to set
	 */
	public void setNullAble(String nullAble) {
		this.nullAble = nullAble;
	}


	/**
	 * @return the defaultValue
	 */
	public String getDefaultValue() {
		return defaultValue;
	}


	/**
	 * @param defaultValue the defaultValue to set
	 */
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}


	/**
	 * @return the columnComment
	 */
	public String getColumnComment() {
		return columnComment;
	}


	/**
	 * @param columnComment the columnComment to set
	 */
	public void setColumnComment(String columnComment) {
		this.columnComment = columnComment;
	}


	/**
	 * @return the columnNo
	 */
	public int getColumnNo() {
		return columnNo;
	}


	/**
	 * @param columnNo the columnNo to set
	 */
	public void setColumnNo(int columnNo) {
		this.columnNo = columnNo;
	}

 

 

}
