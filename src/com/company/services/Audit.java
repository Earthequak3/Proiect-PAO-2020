package com.company.services;

import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Date;

public class Audit {

    BufferedWriter writer;

    public Audit(BufferedWriter writer) {
        this.writer = writer;
    }

    public void logs(String action_name) {
        Date timestamp = new Date();
        String printLogs = action_name + ", " + timestamp;
        try {
            writer.write(printLogs);
            writer.newLine();
            writer.flush();
        } catch (IOException e) {
            System.out.println("Problema la audit!");
        }
    }
}
