package base.dynamic_proxy;
/**
 * 用户持久层的实现类:
 * 
 * @author 姜涛
 *
 */
public class UserDaoImpl implements UserDao {

	@Override
	public void save() {
		System.out.println("添加用户...");
	}

	@Override
	public void update() {
		System.out.println("修改用户...");
	}

	@Override
	public void delete() {
		System.out.println("删除用户...");
	}

	@Override
	public void find() {
		System.out.println("查询用户...");
	}
	
}
