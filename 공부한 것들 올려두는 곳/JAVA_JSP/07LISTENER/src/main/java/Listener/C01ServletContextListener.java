package Listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

//@WebListener
public class C01ServletContextListener implements ServletContextListener{

	@Override // 애플리케이션이 처음 시작할때 내가 미리 넣을께 있으면 여기에 넣으면 된다.
	public void contextInitialized(ServletContextEvent sce) {
		// --
		System.out.println("[LISTENER] C01ServletContextListener start");
	}
	
	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("[LISTENER] C01ServletContextListener end");
	}

	
	
}
