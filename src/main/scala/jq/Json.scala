package jq

import io.circe._

object IsArray: 
    def unapply(v: Json): Option[Vector[Json]] = 
        v.asArray

object IsObject: 
    def unapply(v: Json): Option[JsonObject] = 
        v.asObject

object IsString: 
    def unapply(v: Json): Option[String] = 
        v.asString

object IsInt: 
    def unapply(v: Json): Option[Int] = 
        v.asNumber.flatMap(_.toInt)
