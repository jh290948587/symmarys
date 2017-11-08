package spark_code_skill

import akka.actor.{ActorSelection, ActorSystem}
import akka.pattern.Patterns

import scala.concurrent.Await
import scala.concurrent.duration.Duration

/**
  * Created by Administrator on 2017/7/24.
  */
object Akkafeatech {
  case object RetrieveSparkProps
  def main(args: Array[String]): Unit = {
    var fetcher: ActorSystem = null
    val driverUrl: String = "192.168.1.104"
//    val (fetcher, _) = AkkaUtils.createActorSystem(
//      "driverPropsFetcher",
//      hostname,
//      port,
//      executorConf,
//      new SecurityManager(executorConf))
    //      通过给定路径创建了一个actorSelection
    val driver: ActorSelection = fetcher.actorSelection(driverUrl)
    //      返回一个spark默认的超时时间
    val timeout: Duration = Duration.create(30L, "seconds")
    //      driver代表要像哪个url发送消息,RetrieveSparkProps代表真正的消息,timeout代表超时时间
    //      fut:一个Future,代表了消息结果
//    val fut = Patterns.ask(driver, RetrieveSparkProps, timeout)
//    val props = Await.result(fut, timeout).asInstanceOf[Seq[(String, String)]] ++
//      Seq[(String, String)](("spark.app.id", appId))
    fetcher.shutdown()
  }

}
