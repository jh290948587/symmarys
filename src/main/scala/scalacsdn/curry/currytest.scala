package scalacsdn.curry

import java.util

/**
  * Created by Administrator on 2017/7/12.
  */
object currytest {
  def main(args: Array[String]): Unit = {
    def multiplyBy1(factor:Double)=(x:Double)=>factor*x
    def multiplyBy2(factor:Double)(x:Double)=x*factor
    println(multiplyBy2(3)(4))
  }
}
