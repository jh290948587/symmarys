package scalacsdn.xiebiannibian

/**
  * Created by Administrator on 2017/7/13.
  */
class List[+T](val head: T, val tail: List[T]){
  def prepend[U>:T](newHead:U):List[U]=new List(newHead,this)

  override def toString()=""+head
}
object NonVariance {
  def main(args: Array[String]): Unit = {
//    val list:List[Any]= new List[String]("摇摆少年梦",null)
    trait Function[-Arg,+Return]{
      def apply(arg:Arg):Return
    }
    val foo = new Function[Any,String]{
      override def apply(arg:Any) :String = s"Hello ,I received a $arg"
    }
    val bar:Function[String,Any] = foo
    val h = foo("test")
    val n = bar("test")
    println(h)
    println(n)
  }
}
