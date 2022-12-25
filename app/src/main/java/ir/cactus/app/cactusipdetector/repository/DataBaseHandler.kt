package ir.cactus.app.cactusipdetector.repository

import android.annotation.SuppressLint
import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import ir.cactus.app.cactusipdetector.model.Ip
import kotlin.coroutines.coroutineContext

class DataBaseHandler(context:Context):SQLiteOpenHelper(context, DATABASE_NAME,null,
    DATABASE_VERSION) {

    companion object{
        private val DATABASE_VERSION=1
        private val DATABASE_NAME="IP_DATABASE"
        private val TABLE_NAME="IP_TABLE"
        private val KEY_ID="Id"
        private val IP_NAME="Ip"
    }

    override fun onCreate(p0: SQLiteDatabase?) {
        val CREATE_IP_TABLE=("CREATE TABLE $TABLE_NAME($KEY_ID INTEGER PRIMARY KEY AUTOINCREMENT,$IP_NAME TEXT)")
        p0?.execSQL(CREATE_IP_TABLE)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        p0!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(p0)

    }
    fun addIp(ip:Ip){
        val db=this.writableDatabase
        val contentVarargs=ContentValues()
        contentVarargs.put(IP_NAME,ip.Ip_Address)
        db.insert(TABLE_NAME,null,contentVarargs)

        db.close()
    }
    @SuppressLint("Range")
    fun showIp():List<Ip>{
        val IpList:ArrayList<Ip> =ArrayList<Ip>()
        val selectQuery="SELECT * FROM $TABLE_NAME"
        val db=this.readableDatabase
        var curse:Cursor?=null
        try{
            curse=db.rawQuery(selectQuery,null)
        }catch (e:Exception){
            db.execSQL(selectQuery)
            return ArrayList()
        }
        var Ip_name:String
        if (curse.moveToFirst()){
            do {
                Ip_name=curse.getString(curse.getColumnIndex("Ip"))
                val ip=Ip(Ip_name)
                IpList.add(ip)
            }while (curse.moveToNext())
        }
        return IpList
    }
}