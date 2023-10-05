package ir.mohamadcm.model

import org.bson.codecs.pojo.annotations.BsonId
import org.litote.kmongo.Id
import java.time.Instant
import java.util.Date

data class User(
    val name: String,
    var createdAt: Date = Date.from(Instant.now()),
    @BsonId
    val id: Id<User>? = null,
) {
}