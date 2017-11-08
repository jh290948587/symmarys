package scalacsdn.function

/**
  * Created by Administrator on 2017/7/12.
  */
object ValueFunction {
  def main(args: Array[String]): Unit = {
//    如果参数右边只出现一次，最简化写法
    Array(1,2,3,4) map{_+1} mkString(",")

    val fun = (x: Double) => 1 + x
    //值函数简化方式（正确方式）
    val fun1 = 1+ (_:Double)
//    val fun2 = (x: Int,y: Int) => Int

//    值函数简化方式（正确方式2）
    val fun2:(Double)=>Double=1 + _
  }
}
