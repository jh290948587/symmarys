package classandobject.itcast

/**
  * Created by Administrator on 2017/7/20.
  */
//private[classandobject]代表了包访问权限，只有classandobject这个包中的其他类可以访问
private[classandobject] class MyGirl {
//  val：只有get方法，没有set方法
    val id = "1000"
//  var：既有get方法，又有set方法
    var name: String = _
    var age = 18
//  类私有字段，只能在类的内部使用,object可以访问
    private var faceValue: Double = _
//  对象私有字段，object也不可以访问
    private[this] var high = 177

}



object MyGirl {
  def main(args: Array[String]): Unit = {
    val g = new MyGirl()
    println(g.id)
    println(g.name)
    g.name = "lixiang"
    println(g.name)
    println(g.faceValue)

  }

}
