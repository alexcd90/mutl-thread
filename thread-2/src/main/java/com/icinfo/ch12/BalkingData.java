package com.icinfo.ch12;

import java.io.FileWriter;
import java.io.IOException;

/**
 * 描述:  <br>
 *
 * @author jkk
 * @date 2019年09月05
 */
public class BalkingData {
    private final String fileName;

    private String content;

    private boolean changed;

    public BalkingData(String fileName, String content) {
        this.fileName = fileName;
        this.content = content;
        this.changed = true;
    }

    public synchronized void change(String newContent){
        this.content = newContent;
        this.changed = true;
    }

    public synchronized void save() throws IOException {
        if (!changed){
            return;
        }
        doSave();
        this.changed = false;
    }

    private void doSave() throws IOException {
        System.out.println(Thread.currentThread().getName() + " calls do save,content=" + content);

        try(FileWriter writer = new FileWriter(fileName,true)){
            writer.write(content);
            writer.write("\n");
            writer.flush();
        }
    }
}
