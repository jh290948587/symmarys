package base.dynamic_proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * JDK的动态代理实现AOP:
 * 
 * @author 姜涛
 * 
 */
public class MyJdkProxy implements InvocationHandler {

	private UserDao userDao;

	public MyJdkProxy(UserDao userDao) {
		this.userDao = userDao;
	}

	public UserDao createProxy() {
		UserDao proxy = (UserDao) Proxy.newProxyInstance(userDao.getClass()
				.getClassLoader(), userDao.getClass().getInterfaces(), this);
		return proxy;
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if("save".equals(method.getName())){
			System.out.println("save日志记录===============");
			return method.invoke(userDao, args);
		}else{
			System.out.println("other日志记录");
			return method.invoke(userDao, args);
		}
	}
}
