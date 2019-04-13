package com.easternmind.jsonmaker;

import java.util.ArrayList;
import java.io.File;

public class JSONMaker {
    public ArrayList<EasternSaveObject> easternSaveObjects;

    public void GetAllFilenames(){
        File folder = new File("saves");
        try {
            File[] allSaveFiles = folder.listFiles();
            for (File tempFile : allSaveFiles) {
                System.out.println(tempFile);
            }
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
        finally {

        }
    }
}

