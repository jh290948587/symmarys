package scalacsdn.basetype

/**
  * Created by Administrator on 2017/7/12.
  */
object ifforwhile {
  def main(args: Array[String]): Unit = {
//    if 的使用：
    val x= if("hello"=="hell")  1 else 0
    var line = ""
//    Scala中的赋值操作返回的值是Unit，而""是String类型，不能进行比较，
//    这是函数式编程语言特有的特点
//    line赋值操作之后返回的是（）
    val h = line = "20"
    println(h)
    
//    for用法
     val filesHere = (new java.io.File(".")).listFiles
    //集合操作方式
     for (file <- filesHere)
        println(file)

    //间接调用方式(不常用）
    for (i <- 0 to filesHere.length - 1)
      println(filesHere(i))
//    需要5出现
    for(i <- 1 to 5) println("Iteration"+i)
//    不需要5出现
    for(i <- 1 until 5) println("Iteration"+i)
//    在for循环结构中还可以加入if进行过滤操作

    for (file <- filesHere if file.getName.endsWith(".scala"))
      println(file)
    //还可以加入多个过滤条件，用;隔开
    for (
      file <- filesHere
      if file.isFile
      if file.getName.endsWith(".scala")
    )
      println(file)
  }

  //    while 的使用：
  def gcdLoop(x: Long, y: Long): Long = {
    var a = x
    var b = y
    while (a != 0) {
      val temp = a
      a = b % a
      b = temp
    }
    b
  }
}
