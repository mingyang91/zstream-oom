import zio.Chunk

object ChunkOOM extends App {
  var chunk = Chunk.fill(1025)(0.toByte)
  while(true) {
    chunk = chunk ++ Chunk.fill(1024)(0.toByte)
    val (_, tail) = chunk.splitAt(1024)
    chunk = tail
  }
}
