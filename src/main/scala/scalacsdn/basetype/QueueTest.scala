package scalacsdn.basetype

/**
  * Created by Administrator on 2017/7/12.
  */
object QueueTest {
  def main(args: Array[String]): Unit = {
    var queue=scala.collection.immutable.Queue(1,2,3)
    val deque = queue.dequeue._2.dequeue
    println(deque)
    val fun2:(Double)=>Double=1+_
    println(fun2(200))

    def m1(z: Int,ff: (Int,Int) => Int)={z+ff(z,z)}
    val h = m1(2,(x,y) => x+y)
    println(h)
  }
}
