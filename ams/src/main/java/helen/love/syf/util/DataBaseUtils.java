/**
 * 
 */
package helen.love.syf.util;

import helen.love.syf.common.database.mysql.Contants;
import helen.love.syf.common.vo.Message;

import java.sql.SQLException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jolbox.bonecp.BoneCP;
import com.jolbox.bonecp.BoneCPConfig;

/**
 * @author syf
 *
 */
public class DataBaseUtils {
	public static Logger log = LoggerFactory.getLogger(DataBaseUtils.class);

	public static Message loadDriver(String driverClass) {
		Message result = new Message("info", "加载成功", true);
		try {
			Class.forName(Contants.DRIVER);
		} catch (ClassNotFoundException e) {

			log.error(e.getMessage());
			e.printStackTrace();
			result.setMsg(e.getMessage());
			result.setSuccess(false);
		}
		return result;
	}

	public static BoneCP initConnectionPool(String url, String name, String pwd)
			throws SQLException {
		BoneCP connectionPool = null;
		BoneCPConfig config = new BoneCPConfig();
		config.setJdbcUrl(url); // jdbc url specific to your database, eg
								// jdbc:mysql://127.0.0.1/yourdb
		config.setUsername(name);
		config.setPassword(pwd);
		// 设置每60秒检查数据库中的空闲连接数
		config.setIdleConnectionTestPeriodInMinutes(240);
		// 设置连接空闲时间
		config.setIdleMaxAgeInMinutes(4);
		// 设置每个分区中的最大连接数 30
		config.setMaxConnectionsPerPartition(30);
		// 设置每个分区中的最小连接数 10
		config.setMinConnectionsPerPartition(5);
		// 当连接池中的连接耗尽的时候 BoneCP一次同时获取的连接数
		config.setAcquireIncrement(5);
		// 设置分区 分区数为3
		config.setPartitionCount(3);

		connectionPool = new BoneCP(config);

		return connectionPool;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
