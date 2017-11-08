package base.multithread.single;

public class Single1 {
	private Single1(){}
	
	private static Single1 s = null;
	
	public static  Single1 getInstance(){
	  if(s == null){	
		synchronized(Single1.class){
		 if( s == null )
			 s = new Single1();
		 }
	  }
		 return s;
	}
}
