package set

import scala.collection.mutable

/**
  * Created by Administrator on 2017/7/11.
  */
object MutMapDemo extends App{
  val map1 = new mutable.HashMap[String, Int]()
  //向map中添加数据
  map1("spark") = 1
  map1 += (("hadoop", 2))
  map1.put("storm", 3)
  println(map1)

  //从map中移除元素
  map1 -= "spark"
  map1.remove("hadoop")
  println(map1)

}
