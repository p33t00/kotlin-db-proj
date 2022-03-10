import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class DbConnect(private val host: String?, private val user: String?, private val pass: String?) {
    fun getConnect(): Connection? {
        var conn: Connection? = null
        try {
            conn = DriverManager.getConnection(
                "jdbc:mysql://" + host +
                        "/employment_agency?" +
                        "user=" + user +
                        "&password=" + pass)
        } catch (e: SQLException) {
            e.printStackTrace()
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return conn
    }

}