package ir.mohamadcm.plugins

import com.mongodb.ConnectionString
import com.mongodb.client.MongoDatabase
import org.litote.kmongo.KMongo

const val CONNECTION_STRING = "mongodb://localhost:27017/"
const val DATABASE_NAME = "plutus"

class Database private constructor(){

    private val client = KMongo.createClient(ConnectionString(CONNECTION_STRING))
    private val database = client.getDatabase(DATABASE_NAME)
    companion object {

        @Volatile
        private var instance: Database? = null

        fun getInstance(): MongoDatabase {
            if (instance == null) {
                synchronized(this){
                    instance = Database().also { instance = it}
                }
            }

            return instance!!.database
        }
    }
}