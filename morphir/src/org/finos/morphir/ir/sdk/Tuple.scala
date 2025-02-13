package org.finos.morphir.ir.sdk

import zio.Chunk
import org.finos.morphir.ir.Module
import org.finos.morphir.ir.Type._

object Tuple extends MorphirIRSdkModule("Tuple") {

  val moduleSpec: Module.USpecification = Module.USpecification(
    types = Map.empty,
    values = Map(
      vSpec("pair", "a" -> tVar("b"), "b" -> tVar("b"))(tuple(Chunk(tVar("a"), tVar("b")))),
      vSpec("first", "tuple" -> tuple(Chunk(tVar("a"), tVar("b"))))(tVar("a")),
      vSpec("second", "tuple" -> tuple(Chunk(tVar("a"), tVar("b"))))(tVar("b")),
      vSpec("mapFirst", "f" -> tFun(tVar("a"))(tVar("x")), "tuple" -> tuple(Chunk(tVar("a"), tVar("b"))))(
        tuple(Chunk(tVar("x"), tVar("b")))
      ),
      vSpec("mapSecond", "f" -> tFun(tVar("b"))(tVar("y")), "tuple" -> tuple(Chunk(tVar("a"), tVar("b"))))(
        tuple(Chunk(tVar("a"), tVar("y")))
      ),
      vSpec(
        "mapBoth",
        "f"     -> tFun(tVar("a"))(tVar("x")),
        "g"     -> tFun(tVar("b"))(tVar("y")),
        "tuple" -> tuple(Chunk(tVar("a"), tVar("b")))
      )(tuple(Chunk(tVar("x"), tVar("y"))))
    )
  )

  // todo nativeFunctions
}
