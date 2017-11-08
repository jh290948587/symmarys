package base

/**
  * Created by Administrator on 2017/7/11.
  */
object FunctionAndDef {
  def main(args: Array[String]): Unit = {
    val f1 = (x: Int,y: Int) => x+y
    m1(2,3,(x,y) => x + y)
  }

  def m1(x: Int,y: Int,ff: (Int,Int) => Int) = {
    x + y + ff(2,4)
  }



}
