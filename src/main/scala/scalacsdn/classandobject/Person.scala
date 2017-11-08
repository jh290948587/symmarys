package scalacsdn.classandobject

/**
  * Created by Administrator on 2017/7/12.
  */
class Person {
  //类成员必须初始化，否则会报错
  //这里定义的是一个公有成员
  var name:String=null
}

object Person {
  def main(args: Array[String]): Unit = {
    val p = new Person
    println(p.name)
    p.name = "hah"
    println(p.name)
  }

}
