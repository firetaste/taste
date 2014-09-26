package helen.love.syf.core;

import helen.love.syf.common.vo.Column;
import helen.love.syf.common.vo.Message;
import helen.love.syf.common.vo.Table;

import java.util.List;

public interface IDataBase {

	/**
	 * 测试数据库连接
	 * @param sql
	 *            测试sql
	 * @return 测试信息 Message
	 */
	public Message testSql(String sql);

	/**
	 * 获取所有的表
	 * @return List
	 *         <Table>
	 */
	public List<Table> getTables();	
	/**
	 * 获取所有的表
	 * @param tableName
	 *        表名 
	 * @return List
	 *         <Table>
	
	public List<Column> getRefTableColumns(String tableName);	
 */
	/**
	 * 获取所有的视图
	 * @return List
	 *         <Table>
	 */
	public List<Table> getViews();
	
	/**获取表的列*/
	public List<Column> getColumns(String table);
	/**获取表的约束*/
 
 
	
}
