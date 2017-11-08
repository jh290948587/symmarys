package spark_code_skill

import java.net.URL

import scala.collection.mutable

/**
  * Created by Administrator on 2017/7/24.
  */
object CaseDemo {
  def main(args: Array[String]): Unit = {
    var driverUrl: String = null
    var executorId: String = null
    var hostname: String = null
    var cores: Int = 0
    var appId: String = null
    var workerUrl: Option[String] = None
    val userClassPath = new mutable.ListBuffer[URL]()

//    args：--driver-url 192.168.1.1:9000/xx --executor-id 544547454
    var argv = args.toList
    while (!argv.isEmpty) {
      argv match {
//          匹配到--driver-url，则value指的是192.168.1.1:9000/xx，tail指的是剩余所有
        case ("--driver-url") :: value :: tail =>
          println(value)
          println(tail)
          driverUrl = value
          argv = tail
        case ("--executor-id") :: value :: tail =>
          executorId = value
          argv = tail
        case ("--hostname") :: value :: tail =>
          hostname = value
          argv = tail
        case ("--cores") :: value :: tail =>
          cores = value.toInt
          argv = tail
        case ("--app-id") :: value :: tail =>
          appId = value
          argv = tail
        case ("--worker-url") :: value :: tail =>
          // Worker url is used in spark standalone mode to enforce fate-sharing with worker
          workerUrl = Some(value)
          argv = tail
        case ("--user-class-path") :: value :: tail =>
          userClassPath += new URL(value)
          argv = tail
        case Nil =>
        case tail =>
          System.err.println(s"Unrecognized options: ${tail.mkString(" ")}")
      }
    }
  }
}
