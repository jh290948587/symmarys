package base.dynamic_proxy;

/**
 * 用户的持久层接口.
 * 
 * @author 姜涛
 * 
 */
public interface UserDao {
	public void save();

	public void update();

	public void delete();

	public void find();
}
