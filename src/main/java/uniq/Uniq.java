package uniq;

import java.io.*;

public class Uniq {
    private final boolean noCase;
    private final boolean uRows;
    private final boolean changes;
    private final int noSym;
    private final File outputFile;
    private final File inputFile;

    Uniq(boolean noCase, boolean uRows, boolean changes, int noSym,
         File outputFile, File inputFile) {
        this.noCase = noCase;
        this.uRows = uRows;
        this.changes = changes;
        this.noSym = noSym;
        this.outputFile = outputFile;
        this.inputFile = inputFile;
    }

    public void main() throws IOException {
        BufferedReader reader;
        BufferedWriter writer;
        int num = 1;
        String line;
        String prLine = null;
        if (inputFile == null) {
            reader = new BufferedReader(new InputStreamReader(System.in));
        } else {
            reader = new BufferedReader(new FileReader(inputFile));
        }
        if (outputFile == null) {
            writer = new BufferedWriter(new OutputStreamWriter(System.out));
        } else {
            writer = new BufferedWriter(new FileWriter(outputFile));
        }
        try {
            while ((line = reader.readLine()) != null) {
                if (Equals(line, prLine)) {
                    num++;
                } else {
                    if (prLine == null) return;
                    if (!uRows && !changes) writer.write(prLine + System.lineSeparator());
                    if (uRows && num == 1) writer.write(prLine + System.lineSeparator());
                    if (changes && num > 1) writer.write(num + ") ");
                    writer.write(prLine + System.lineSeparator());
                }

                prLine = line;
                num = 1;
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean Equals(String line, String prLine) {
        if (prLine == null) return false;
        if (line.equals(prLine)) return true;
        if (noCase && line.equalsIgnoreCase(prLine)) return true;
        if (noSym > 0 && line.substring(noSym).equals(prLine.substring(noSym))) return true;
        return false;
    }

}
