import java.sql.Connection
import java.sql.ResultSet
import java.sql.Statement

class DbApi(private val dbConnect: DbConnect) {

    fun getBranches(): ResultSet? {
        var cnx: Connection? = null
        var stmt: Statement? = null
        var result = null
        val q = "SELECT b.title, SUM(e.employees_count) employees_count, \n" +
                "COUNT(v.id) vacancies_count, b.description \n" +
                "FROM branches b \n" +
                "LEFT JOIN employers e ON b.title = e.branch\n" +
                "LEFT JOIN vacancies v ON e.organization_num = v.organization_num\n" +
                "GROUP BY b.title;"
        try {
            val cnx = dbConnect.getConnect()
            val stmt = cnx!!.createStatement()
            stmt!!.execute(q)
            result = stmt?.resultSet.getArray()
        } catch (e: Exception) {
            e.printStackTrace()
            println("Connection error.")
        } finally {
// TODO : close all recources
        }
        return result

        //close connections
    }

//    private fun resultToList(rs: ResultSet): Array<Array<String>> {
//        val parsed: Array<Array<String>> =
//        while (rs.next()) {
//
//        }
//    }
}