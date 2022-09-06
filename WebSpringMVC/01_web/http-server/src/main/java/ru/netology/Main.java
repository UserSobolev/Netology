package ru.netology;

import java.io.*;

public class Main {
  public static void main(String[] args) throws IOException {
    Server server = new Server(44040);
    server.startServer();
  }
}


