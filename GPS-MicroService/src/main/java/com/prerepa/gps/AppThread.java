package com.prerepa.gps

import java.net.Socket
import java.io.DataOutputStream
import java.io.DataInputStream

class AppThread(private val appSocket: Socket, private val mysqlDb: Database) : Thread() {
    private var dataInput: DataInputStream? = null
    private var dataOutput: DataOutputStream? = null

    init {
        try {
            dataInput = DataInputStream(appSocket.getInputStream())
            dataOutput = DataOutputStream(appSocket.getOutputStream())
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }

    override fun run() {
        try {
            val id = dataInput!!.readInt()
            val username = dataInput!!.readUTF()
            val coordinates = mysqlDb.retrieveCoordinates(username, id)
            dataOutput!!.writeUTF(coordinates)
        } catch (e: Exception) {
            e.printStackTrace()
        }

    }
}

