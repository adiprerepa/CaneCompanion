package com.prerepa.accounts;

public class Main {

    public static void main(String[] args) throws Throwable {
        AccountsDatabase accountsDatabase = new AccountsDatabase("aditya", "adityapc");
        LoginServer loginServer = new LoginServer(accountsDatabase);
        loginServer.start();
        loginServer.blockUntilShutdown();
    }
}
