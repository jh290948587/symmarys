package base.multithread.single;

public class SingleTest {
	public static void main(String[] args) {

		Single s = Single.getInstance();
		System.out.println(s);
		
		Single s1 = Single.getInstance();
		System.out.println(s1);
		
		Single1 s2 = Single1.getInstance();
		System.out.println(s2);
		
		Single1 s3 = Single1.getInstance();
		System.out.println(s3);
	}
}
