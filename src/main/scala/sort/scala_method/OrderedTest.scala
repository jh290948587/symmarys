package sort.scala_method

/**
  * Created by Administrator on 2017/7/21.
  */

case class Girl(val name: String,val faceValue: Int,val age: Int) extends Ordered[Girl] with Serializable {
  override def compare(that: Girl): Int = {
    val num = this.faceValue - that.faceValue
    if(num == 0){
      that.age - this.age
    }else{
      num
    }

  }
}

object OrderedTest extends App{
//  val g1 = Girl("lixiang",60,28)
//  val g2 = Girl("xuyi",70,22)
//  val g3 = Girl("liuzhihao",70,25)
  val l = List(("xuyi",60,28),("lixiang",70,22),("liuzhihao",70,25))
  val ll = l.sortBy(t => Girl(t._1,t._2,t._3)).reverse
  println(ll.toBuffer)

}
