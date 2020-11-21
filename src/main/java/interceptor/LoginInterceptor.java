package interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import entity.Employee;

public class LoginInterceptor implements HandlerInterceptor {
	
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String url = request.getRequestURI();
		
		//除登录请求之外  全部拦截
		if(url.indexOf("/login")>=0 ||url.indexOf("/doLogin")>=0) {
			
			return true;
		}
		
		HttpSession session = request.getSession();
		Employee e = (Employee) session.getAttribute("loginEmployee");
		
		if(e != null) {
			return true;
		}else {
			request.setAttribute("noLoginMessage", "请先登录");
			request.getRequestDispatcher("/system/login").forward(request, response);
		}
		
		return false;
	}
	
}
