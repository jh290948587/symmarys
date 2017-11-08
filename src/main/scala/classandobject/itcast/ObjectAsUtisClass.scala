package classandobject.itcast

import java.util.UUID

/**
  * Created by Administrator on 2017/7/20.
  */
object ObjectAsUtisClass {
//  下面的代码相当于静态代码块
  println("静态代码块初始化的时候执行了")

  def genUUID(): String = {
    return UUID.randomUUID().toString
  }
}

object test extends App{
  val uuid = ObjectAsUtisClass.genUUID()
  println(uuid)
}
