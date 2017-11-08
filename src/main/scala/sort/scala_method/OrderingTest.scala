package sort.scala_method

/**
  * Created by Administrator on 2017/7/21.
  */

case class MyGirl(val name: String,val faceValue: Int,val age: Int) extends Serializable {
  override def toString: String = s"[name:$name,fv:$faceValue,age:$age]"
}

object Context {
  implicit object GirlOrdering extends Ordering[MyGirl] {
    override def compare(x: MyGirl, y: MyGirl): Int = {
      if(x.faceValue > y.faceValue) 1
      else if(x.faceValue == y.faceValue){
        if(x.age > y.age) -1 else 1
      }else -1
    }
  }
}

object OrderingTest {
  def main(args: Array[String]): Unit = {
    val l = List(("xuyi",60,28),("lixiang",70,22),("liuzhihao",70,25))
    import Context.GirlOrdering
    val ll = l.sortBy(t => MyGirl(t._1,t._2,t._3)).reverse
    println(ll.toBuffer)
  }
}
