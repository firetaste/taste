/**
 * 
 */
package helen.love.syf.core;

import helen.love.syf.common.enums.Enum.DataBase;
import helen.love.syf.core.db.MysqlDataBase;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author syf
 *
 */
public class DataBaseFactory {
	public static Logger log = LoggerFactory.getLogger(DataBaseFactory.class);
 
	 
	 public static IDataBase getMysqlDataBase( DataBase type  ,String host, int port,
			String dataBase, String user, String pwd){
		 log.info("getMysqlDataBase [dbtype="+type+",host="+host+",port="+port+",db="+dataBase+",user="+user+",pwd="+pwd+"] ");
		 if(type.equals(DataBase.mysql)){			
			 return new MysqlDataBase(host,port,dataBase,user,pwd);
		 }
		 return null;
	 }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		 

	}

}
