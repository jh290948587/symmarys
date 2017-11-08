package set

/**
  * Created by Administrator on 2017/7/11.
  */
object MapDemo {
  def main(args: Array[String]) = {
    // 创建一个不可变的Map
    var ages1 = Map("Leo" -> 30, "Jen" -> 25, "Jack" -> 23)

//    不可变Map没有更新操作
//    ages1("Leo") = 31
    // 创建一个可变的Map
    val ages2 = scala.collection.mutable.Map("Leo" -> 30, "Jen" -> 25, "Jack" -> 23)
    ages2("Leo") = 31
    // 增加多个元素
    ages2 += ("Mike" -> 35, "Tom" -> 40)
    // 移除元素
    ages2 -= "Mike"


    // 使用另外一种方式定义Map元素
    val ages3 = Map[String,Int](("Leo", 30),("ee", 30),("tt", 30))
    println(ages3)
    // 创建一个空的HashMap
    val ages4 = new scala.collection.mutable.HashMap[String, Int]

    // 获取指定key对应的value，如果key不存在，会报错
    val leoAge1 = ages1("Leo")
    val leoAge2 = ages1("leo")

    // 使用contains函数检查key是否存在
    val leoAge3 = if (ages1.contains("leo")) ages1("leo") else 0

    // getOrElse函数
    val leoAge4 = ages1.getOrElse("leo", 0)



  }
}
