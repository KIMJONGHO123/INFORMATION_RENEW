package Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

//@WebFilter("/index.do") /* web.xml에서 필터등록을 직접한다. */
public class C01Filter_Test implements Filter{

	@Override
	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {
		// REQUEST 전 처리코드
		System.out.println("[Filter] Index Filter Start...");
		chain.doFilter(req, resp);
		
		// REQUEST 후 처리코드
		System.out.println("[Filter] Index Filter End...");
		
		
	}
	
}
