package base.multithread.single;


public class Single {

	private Single(){}

	private static Single s = new Single();

	public static Single getInstance(){
		return s;
	}
}
