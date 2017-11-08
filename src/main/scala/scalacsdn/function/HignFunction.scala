package scalacsdn.function

/**
  * Created by Administrator on 2017/7/12.
  */
object HignFunction {
  def main(args: Array[String]): Unit = {
    //函数参数(高阶函数）
    //((Int)=>String)=>String
    def convertIntToString(f:(Int)=>String)=f(4)
    convertIntToString((x:Int)=>x+" s")

    //高阶函数可以产生新的函数
    //(Double)=>((Double)=>Double)
    def multiplyBy(factor:Double)=(x:Double)=>factor*x + ""
    val x=multiplyBy(10)
    x(50)
  }
}
