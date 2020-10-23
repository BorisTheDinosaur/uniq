package uniq;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Uniq {
    boolean noCase;
    boolean uRows;
    boolean changes;
    int noSym;
    Path outputPath;
    Path inputPath;

    Uniq(boolean noCase, boolean uRows, boolean changes, int noSym,
         Path outputFile, Path inputFile) {
        this.noCase = noCase;
        this.uRows = uRows;
        this.changes = changes;
        this.noSym = noSym;
        this.outputPath = outputFile;
        this.inputPath = inputFile;
    }

    ArrayList<String> inputStr;
    BufferedReader reader;
    ArrayList<String> strs;
    ArrayList<Integer> num;

    public void main() throws IOException {

        try {
            if (uRows && changes || noSym < 0) throw new IOException();

        } catch (IOException e) {
            System.err.println(e.getMessage());
            return;
        }

        inputStr = new ArrayList<>();
        reader = inputPath != null ? Files.newBufferedReader(inputPath) : new BufferedReader(new InputStreamReader(System.in));
        try {
            String str;
            while ((str = reader.readLine()) != null) {
                inputStr.add(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        strs = new ArrayList<>();
        num = new ArrayList<>();
    }



    public void build() {
        if (inputStr.size() != 0) {
            strs.add(inputStr.get(0));
            num.add(1);
            int a = 0;
            int n = 1;

            for (int i =0; i < inputStr.size() - 1; i++) {
                if (ignore(inputStr.get(i), inputStr.get(i + 1)) == 0) {
                    n++;
                    num.set(a, n);
                } else {
                    strs.add(inputStr.get(i + 1));
                    n = 1;
                    num.add(1);
                    a++;
                }
            }
        }
    }

    public int ignore(String str1, String str2) {
        if (noSym > 0) {
            str1 = str1.length() <= noSym ? "" : str1.substring(noSym);
            str2 = str2.length() <= noSym ? "" : str2.substring(noSym);
        }

        if (noCase) return str1.compareToIgnoreCase(str2);
        else return str1.compareTo(str2);
    }

    public ArrayList<String> getStrs() { return strs; }

    public ArrayList<Integer> getNum() { return num; }

}
