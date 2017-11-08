package casedemo

import scala.util.Random

/**
  * Created by Administrator on 2017/7/11.
  */
object CaseDemoType extends App{
  case class CaseDemo(){}
  //val v = if(x >= 5) 1 else if(x < 2) 2.0 else "hello"
  val arr = Array("hello", 1, 2.0, CaseDemo)
  val v = arr(Random.nextInt(4))
  println(v)
  v match {
    case x: Int => println("Int " + x)
//      模式匹配可以添加守卫条件 y >= 0
    case y: Double if(y >= 0) => println("Double "+ y)
    case z: String => println("String " + z)
    case _ => throw new Exception("not match exception")
  }
}
