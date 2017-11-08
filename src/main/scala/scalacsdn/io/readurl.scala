package scalacsdn.io

import java.net.URL

import scala.io.Source

/**
  * Created by Administrator on 2017/7/12.
  */
object readurl {
  def main(args: Array[String]): Unit = {
    print(Source.fromURL(new URL("https://www.baidu.com/")).mkString)
  }
}
