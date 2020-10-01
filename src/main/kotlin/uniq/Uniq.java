package uniq;

import java.io.*;

public class Uniq {
    private final boolean noCase;
    private final boolean uRows;
    private final boolean changes;
    private final int noSym;
    private final String outputFile;
    private final String inputFile;

    Uniq(boolean noCase, boolean uRows, boolean changes, int noSym,
         String outputFile, String inputFile) {
        this.noCase = noCase;
        this.uRows = uRows;
        this.changes = changes;
        this.noSym = noSym;
        this.outputFile = outputFile;
        this.inputFile = inputFile;
    }

    public void main() throws FileNotFoundException {
        BufferedReader reader;
        int num = 1;
        String line;
        String prLine = null;
        if (inputFile == null) {
            reader = new BufferedReader(new InputStreamReader(System.in));
        } else {
            reader = new BufferedReader(new FileReader(inputFile));
        }
        try {
            while ((line = reader.readLine()) != null) {
                if ((line.equals(prLine)||
                        noCase && line.toLowerCase().equals(prLine.toLowerCase()) ||
                        noSym > 0 && line.substring(noSym).equals(prLine.substring(noSym))) &&
                        prLine != null) {
                    num++;
                } else {
                    if (prLine != null) {
                        if (outputFile == null) {
                            if (num > 1 && changes) System.out.println(num + ") ");
                            System.out.println(prLine + '\n');
                        }
                        else {
                            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFile));
                            if (num > 1 && changes) writer.write(num + ") ");
                            writer.write(prLine + '\n');
                        }
                    }
                    prLine = line;
                    num = 1;
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
