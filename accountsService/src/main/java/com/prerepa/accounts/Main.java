package com.prerepa.accounts;

import java.io.File;

public class Main {

    public static void main(String[] args) throws Throwable {
        File consts = new File("/home/aditya/CaneCompanion/ipAddrs");
        AccountsDatabase accountsDatabase = new AccountsDatabase(consts);
        LoginServer loginServer = new LoginServer(accountsDatabase, consts);
        loginServer.start();
        loginServer.blockUntilShutdown();
    }
}
