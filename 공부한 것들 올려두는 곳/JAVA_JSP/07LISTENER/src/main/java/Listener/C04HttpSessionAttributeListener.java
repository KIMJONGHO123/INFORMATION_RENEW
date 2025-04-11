package Listener;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

@WebListener
public class C04HttpSessionAttributeListener implements HttpSessionAttributeListener{

	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		System.out.println("add");
	}

	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		System.out.println("remove");
	}

	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		System.out.println("replace");
	}
	
}
