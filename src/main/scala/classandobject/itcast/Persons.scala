package classandobject.itcast

/**
  * Created by Administrator on 2017/7/20.
  */
//主构造器和类交织在一起
//high这个属性，没有加val或者var，则只能在构造器中访问，也不可以在object中访问。相当于private[this]
class Persons(val name: String,var age: Int,high: Double) {

  val fv: Double = 22.0
  println("主构造器")


  println(high)
  def this(name: String,age: Int,high: Double,fv: Double){
//    辅助构造器第一行必须调用主构造器
    this(name,age,high)
    println("辅助构造器")
  }

}

object Persons {
  def main(args: Array[String]): Unit = {
    val p = new Persons("lixiang",70,90)
    println(p.age)

  }
}
