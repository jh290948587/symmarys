package scalacsdn.traittest

import java.io.PrintWriter

/**
  * Created by Administrator on 2017/7/12.
  */
trait Logger {
  println("Logger")
  def log(msg:String):Unit
}

trait FileLogger extends Logger{
  println("FilgeLogger")
  val fileOutput=new PrintWriter("file.log")
  fileOutput.println("#")

  def log(msg:String):Unit={
    fileOutput.print(msg)
    fileOutput.flush()
  }
}
object TraitDemo{
  def main(args: Array[String]): Unit = {
    //匿名类
    new FileLogger{
    }.log("trat demo")
  }
}
