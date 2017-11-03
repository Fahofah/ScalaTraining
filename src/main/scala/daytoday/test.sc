import java.time.Instant
import java.util.Calendar

def hourToMilli(hour: Double): Long = {
  (hour * 60 * 60 * 1000).toLong
}
val now = System.currentTimeMillis()

val instant = Instant.ofEpochMilli(now)


val late = now + hourToMilli(1.24)

val duration = ((late - now)/1000.0/60.0/60.0).toFloat
val lateTime = Instant.ofEpochMilli(late)

