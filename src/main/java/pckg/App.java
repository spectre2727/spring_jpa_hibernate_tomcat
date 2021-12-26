package pckg;

import java.io.File;

import org.apache.catalina.LifecycleException;
import org.apache.catalina.startup.Tomcat;

public class App {
	
	private static Tomcat tomcat = new Tomcat();
	private static String contextPath = "/cp";
	private static String docBase = new File(".").getAbsolutePath();
	
	public static void main(String[] args) throws LifecycleException {
		tomcat.setPort(8080);
		tomcat.getConnector();
		tomcat.addWebapp(contextPath, docBase);
		tomcat.start();
	}
	
}
