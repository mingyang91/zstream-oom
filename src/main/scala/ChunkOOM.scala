import zio.stream.{ZSink, ZStream}
import zio.{ExitCode, URIO, ZIO}

import scala.util.Random

object ChunkOOM extends zio.App {

  override def run(args: List[String]): URIO[zio.ZEnv, ExitCode] = {
    ZStream.repeatEffect(zio.random.nextInt)
      .chunkN(128)
      .as(Random.alphanumeric.take(1024 * 1024).mkString.getBytes("UTF-8"))
      .mapConcat(bytes => bytes)
      .chunkN(1024 * 10)
      .run(ZSink.foreachChunk(_ => ZIO.unit))
      .exitCode
  }
}
