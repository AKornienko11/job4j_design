package ru.job4j.io;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServers {
    public static void main(String[] args) throws IOException {
        try (ServerSocket server = new ServerSocket(9000)) {
            boolean status = server.isClosed();
            while (!status) {
                Socket socket = server.accept();
                try (OutputStream output = socket.getOutputStream();
                     BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
                    for (String string = input.readLine(); string != null && !string.isEmpty(); string = input.readLine()) {
                        if (string.contains("msg=Hello")) {
                            output.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            output.write("Hello".getBytes());
                        }
                        if (!string.contains("msg=Hello") && !string.contains("msg=Exit")) {
                            output.write("HTTP/1.1 200 OK\r\n\r\n".getBytes());
                            output.write(string.getBytes());
                        }
                        if (string.contains("msg=Exit")) {
                            status = !server.isClosed();
                            break;
                        }
                    }
                    output.flush();
                }
            }
        }
    }
}

