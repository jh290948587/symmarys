package base

/**
  * Created by Administrator on 2017/7/24.
  */
object FormatOutput {
  def main(args: Array[String]): Unit = {
    val name = "wusong"
    val my = s"hello $name"
    println(my)

    val l = List(2,3,4,5)
    val header = "Spark Executor Command: %s\n%s\n%d\n%f".format(
      l.mkString("n", "\" \"", "\""), "=" * 100,1,1.0)
    println(header)
  }
}
