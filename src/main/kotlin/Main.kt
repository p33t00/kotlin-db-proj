import java.sql.ResultSet

fun main(args: Array<String>) {
    val conf: Map<String, String> = args.map{it.split("=")}.map{it[0] to it[1]}.toMap()

    val dbConnect = DbConnect(conf["host"], conf["user"], conf["pass"])
    val dbApi = DbApi(dbConnect)
    val rs: ResultSet? = dbApi.getBranches()
    while (rs?.next() == true) {
//        println(rs.getArray(0))
        println(rs.getString("title"))
    }
}