package base.dynamic_proxy;

import org.junit.Test;

public class DynamicProxyTest {
	public static void main(String[] args) {
		UserDao userDao = new MyJdkProxy(new UserDaoImpl()).createProxy();

		userDao.save();
		userDao.update();
		userDao.delete();
		userDao.find();
	}

}
