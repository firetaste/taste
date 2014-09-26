/**
 * 
 */
package helen.love.syf.util;

import java.io.File;

import javax.servlet.ServletException;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.core.AprLifecycleListener;
import org.apache.catalina.core.StandardServer;
import org.apache.catalina.startup.Tomcat;

/**
 * @author syf
 *
 */
public class Tomcat7 {

	private Tomcat tomcat;
	private int port=80;

	public void start() {
		tomcat = new Tomcat();
		tomcat.setPort(port);
		String appBase = System.getProperty("user.dir") + File.separator
				+ "target" + File.separator + "ams";
		tomcat.setBaseDir(".");
		tomcat.getHost().setAppBase(appBase);

		String contextPath = "/ams";

		// Add AprLifecycleListener
		StandardServer server = (StandardServer) tomcat.getServer();
		AprLifecycleListener listener = new AprLifecycleListener();
		server.addLifecycleListener(listener);

		try {
			tomcat.addWebapp(contextPath, appBase);
			tomcat.start();
			tomcat.getServer().await();
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (LifecycleException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
 public void stop(){
	 try {
		tomcat.stop();
	} catch (LifecycleException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
 }
	public Tomcat7() {

	}

	public static void main(String[] args){
	 
		 
			Tomcat7 server = new Tomcat7( );
			 server.start();
		 
		
	}
}
