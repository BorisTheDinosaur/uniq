package uniq;


import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class uniqLauncher {

    @Option(name = "-i", metaVar = "NoCase", usage = "Сase-insensitive")
    private boolean noCase;

    @Option(name = "-u", metaVar = "URows", usage = "Show only unique rows")
    private boolean uRows;

    @Option(name = "-c", metaVar = "Changes", usage = "Show changes")
    private boolean changes;

    @Option(name = "-s", metaVar = "Num", usage = "Ignore first amount of symbols")
    private int noSym;

    @Option(name = "-o", metaVar = "Output", usage = "Output file name")
    private Path outputPath;

    @Argument(metaVar = "Input", usage = "Input file name")
    private Path inputPath;

    public static void main(String[] args) throws IOException {
        new uniqLauncher().launch(args);
    }

    private void launch(String[] args) throws IOException {
        CmdLineParser parser = new CmdLineParser(this);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("java -jar uniq.jar -i -u -c -s num -o ofile file");
            parser.printUsage(System.err);
            return;
        }

        try {
            Uniq uniq = new Uniq(noCase, uRows, changes, noSym, outputPath, inputPath);

            uniq.main();
            uniq.build();

            ArrayList<String>  strs = uniq.getStrs();
            ArrayList<Integer>  num = uniq.getNum();
            output(strs, num);

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    private void output(ArrayList<String> strs, ArrayList<Integer>  num) throws IOException {
        BufferedWriter writer = outputPath != null ? Files.newBufferedWriter(outputPath) : new BufferedWriter(new OutputStreamWriter(System.out));
        if (strs.size() == 0) writer.write(" ");
        else for (int i = 0; i < strs.size(); i++) {
            if (changes) {
                if (num.get(i) == 1) writer.write(strs.get(i));
                else writer.write(num.get(i) + " " + strs.get(i));
            }
            else writer.write(strs.get(i));
            writer.newLine();
        }
        writer.close();
    }
}