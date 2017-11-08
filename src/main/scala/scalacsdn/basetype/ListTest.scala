package scalacsdn.basetype

/**
  * Created by Admi,istrator o, 2017/7/12.
  */
object ListTest {
  def main(args: Array[String]): Unit = {
    val num = List(1,2,454,5,5)
//    List一但创建，其值不能被改变
//    如前面的nums，改变其值的话，编译器会报错
//    num(2) = 4
//    List具有递归结构（Recursive Structure),例如链表结构
//    List类型和其它类型集合一样，它具有协变性（Covariant)，即对于类型S和T，如果S是T的子类型，则List[S]也是List[T]的子类型
    var listStr:List[Object]=List("This","Is","Covariant","Example")
//    listStr: List[Object] = List(This, Is, Covariant, Example)
    println(listStr)
    //空的List，其类型为Nothing,Nothing在Scala的继承层次中的最低层
    //，即Nothing是任何Scala其它类型如String,Object等的子类
    var listStr2=List()
//    listStr: List[Nothing] = List()
    println(listStr2)
    var listStr3:List[String]=List()
//    listStr: List[String] = List()
    println(listStr3)
  }
}
