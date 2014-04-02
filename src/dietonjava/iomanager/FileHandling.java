/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dietonjava.iomanager;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author vasouv
 */
public class FileHandling {
    
    public void writeJSONFile(String jsonString, String filename) throws IOException {
        FileWriter fileWriter = null;
        File newJSONFile = new File(filename);
        fileWriter = new FileWriter(newJSONFile);
        fileWriter.write(jsonString);
        fileWriter.close();
    }
    
    public String readJSONFile(String filename) throws FileNotFoundException, IOException {
        StringBuilder willBeReturned = new StringBuilder();
        BufferedReader fileReader = new BufferedReader(new FileReader(filename));
        String currentLine;
        while((currentLine = fileReader.readLine()) != null) {
            willBeReturned.append(currentLine);
        }
        return willBeReturned.toString().trim();
    }
    
}
