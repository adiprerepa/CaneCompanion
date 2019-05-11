package com.prerepa.accounts;

import java.io.IOException;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SqlTest {

    public static void main(String[] args) throws SQLException, IOException {
        Socket s = new Socket("10.0.1.201", 26672);

    }
}
