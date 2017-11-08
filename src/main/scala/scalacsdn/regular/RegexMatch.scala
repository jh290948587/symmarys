package scalacsdn.regular

/**
  * Created by Administrator on 2017/7/12.
  */
object RegexMatch {
  def main(args: Array[String]): Unit = {
    val ipRegex="(\\d+)\\.(\\d+)\\.(\\d+)\\.(\\d+)".r
    for(ipRegex(one,two,three,four) <- ipRegex.findAllIn("192.168.1.1"))
    {
      println("IP子段1:"+one)
      println("IP子段2:"+two)
      println("IP子段3:"+three)
      println("IP子段4:"+four)
    }

    Array(1,2,4,3,5).foldLeft(0)((x:Int,y:Int)=>{println(x,y);x+y})
  }
}
