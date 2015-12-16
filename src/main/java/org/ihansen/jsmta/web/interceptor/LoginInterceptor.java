package org.ihansen.jsmta.web.interceptor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.ihansen.jsmta.utils.DateUtils;
import org.ihansen.jsmta.utils.JsonUtil;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class LoginInterceptor extends HandlerInterceptorAdapter {
	private static transient Log log = LogFactory.getLog(LoginInterceptor.class);

	/**
	 * 在业务处理器处理请求之前被调用 如果返回false 从当前的拦截器往回执行所有拦截器的afterCompletion(),再退出拦截器链
	 * 如果返回true 执行下一个拦截器,直到所有的拦截器都执行完毕 再执行被拦截的Controller 然后进入拦截器链,
	 * 从最后一个拦截器往回执行所有的postHandle() 接着再从最后一个拦截器往回执行所有的afterCompletion()
	 */
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		boolean hasLogin = false;
		// 1.登录拦截
		log.info("检查是否登录======================");
		HttpSession session = request.getSession();
		if (session.getAttribute("online-user") == null) {
			if (request.getHeader("x-requested-with") != null && request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {// ajax请求
				Map<String, Object> map = new HashMap<String, Object>();
				map.put("flag", "N");
				map.put("msg", "会话已过期,请重新登录");
				map.put("total", "0");// 为了兼容easyui datagrid数据加载请求
				map.put("rows", new ArrayList());// 为了兼容easyui datagrid数据加载请求
				String jsonStr = JsonUtil.toJson(map, DateUtils.yyyyMMddHHmmss);
				log.info("没有登录不能访问受保护资源");
				response.getWriter().print(jsonStr.toString());
				response.getWriter().flush();
				response.getWriter().close();
			}
			else {// 其他请求资源
				log.info("没有登录不能访问受保护资源,跳转到首页！");
				request.setAttribute("errMsg", "请先登录");
				String url = request.getRequestURL().toString().split(request.getRequestURI())[0];
				response.getWriter().print("<script type='text/javascript'>window.parent.location.href='" + url + "';</script>");
			}
		}
		else {
			log.info("用户已登录======================");
			hasLogin = true;
		}
		return hasLogin;
	}

	/**
	 * 在业务处理器处理请求执行完成后,生成视图之前执行的动作 可在modelAndView中加入数据，比如当前时间
	 */
	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

	}

	/**
	 * 在DispatcherServlet完全处理完请求后被调用,可用于清理资源等
	 * 
	 * 当有拦截器抛出异常时,会从当前拦截器往回执行所有的拦截器的afterCompletion()
	 */
	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

	}
}
