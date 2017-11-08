package test

import scala.collection.mutable.HashSet

/**
  * Created by Administrator on 2017/7/20.
  */
object SubjectTest {
  def main(args: Array[String]): Unit = {
//    val t1,t2,(a,b,c) = {
//      println("abc")
//      (1,2,3)
//    }
//    println(a)


//    val name = "wusong"
//    val my = s"hello $name"
//    println(my)
//
//    val l = List(2,3,4,5)
//    val header = "Spark Executor Command: %s\n%s\n%d\n%f".format(
//      l.mkString("n", "\" \"", "\""), "=" * 100,1,1.0)
//    println(header)


    val visited = new HashSet[String]
    val newh = visited + "hello"
    val h = newh("helo")
    println(h)


  }

}
