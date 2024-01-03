package com.sist.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet Filter implementation class LoginFilter
 */
@WebFilter("/LoginFilter")
public class LoginFilter extends HttpFilter implements Filter {
       
    /**
     * @see HttpFilter#HttpFilter()
     */
    public LoginFilter() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Filter#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		//doFilter메소드의 매개변수인 ServletRequest request를 
		//GttpServletRequest로 형 변환하여 Session객체를 얻어 옵니다.
		HttpSession session = ((HttpServletRequest)request).getSession();
		
		//세션에 로그인과 관련된 값이 있는지 파악합니다
		if(session.getAttribute("session_id") != null) {
			//세션변수 session_id가 있다면 요청한 url로 보낸다.
			chain.doFilter(request, response);
		}else {
			//세션변수 session_id가 없다면 로그인페이지로 보낸다
			((HttpServletResponse)response).sendRedirect("/day0103/login.do");//그냥 login.do라고하면 
																	//member/login.do로 가기때문에 컨택스트이름을 써주어야함
			
			
		}
		
		
		
		
		
	}



	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException {
		// TODO Auto-generated method stub
	}

}
