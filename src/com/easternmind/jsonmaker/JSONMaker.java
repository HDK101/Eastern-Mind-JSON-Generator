package com.easternmind.jsonmaker;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class JSONMaker {
    public List<EasternSaveObject> easternSaveObjects;

    public void GetAllFilenames() {
        File folder = new File("saves");
        try {
            File[] allSaveFiles = folder.listFiles();
            for (File tempFile : allSaveFiles) {
                System.out.println("Converting " + tempFile.getPath() + "...");
                ConvertIntoObject(tempFile.getPath());
                //System.out.println(tempFile);
            }
        } catch (NullPointerException ex) {
            System.out.println("Folder doesn't exist or it's empty");
        }
    }

    public EasternSaveObject ConvertIntoObject(String fileName) {
        EasternSaveObject tempEasternSaveObject = new EasternSaveObject();
        BufferedReader bufferedReader = null;
        try {
            //Initialize bufferedReader
            bufferedReader = new BufferedReader(new FileReader(fileName));

            //Read file
            //System.out.println(bufferedReader.lines().count());
            List<String> lineList = new ArrayList();
            int charCount = 0;
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                lineList.add(line);
            }


            String[] lines = new String[lineList.size()];
            lines = lineList.toArray(lines);

            //extract current place
            char[] charLinePlace = lines[2].toCharArray();
            String reverseCurrentPlace = "",currentPlace = "";
            for (int i = charLinePlace.length - 1; i > 0; i--) {
                if (charLinePlace[i] != '\\') reverseCurrentPlace += charLinePlace[i];
                else break;
            }
            for (int i = reverseCurrentPlace.length() - 1; i >= 0; i--) {
                currentPlace += reverseCurrentPlace.charAt(i);
            }

            System.out.println(currentPlace);

        } catch (FileNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        } catch (ArrayIndexOutOfBoundsException ex) {
            System.out.println("Array out of index in line: " + ex.getCause());
        }
        finally {

        }
        return tempEasternSaveObject;
    }
}

