/**
 * 
 */
package helen.love.syf.core.controller;

import java.io.IOException;

import helen.love.syf.common.enums.Enum.DataBase;
import helen.love.syf.core.DataBaseFactory;
import helen.love.syf.core.IDataBase;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @author syf
 *
 */
@Controller

public class BaseController {
	public static Logger log = LoggerFactory.getLogger(BaseController.class);
	 
	IDataBase db ;
	@RequestMapping("/core/index")
	public String load(){
		
		return "index";
	}
	@RequestMapping(value="/log/index",method=RequestMethod.POST )
 public void index( @RequestParam String user,@RequestParam String pwd,HttpServletResponse rs){
		log.info("index [pwd="+pwd+",user="+user+"] ");
	 db = DataBaseFactory.getMysqlDataBase(DataBase.mysql, "localhost", 3306, "mfa", user, pwd);
	 ObjectMapper o = new ObjectMapper();
 	  try {
		o.writeValue(rs.getOutputStream(), db.getTables());
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	 
	 return  ;
 }
}
