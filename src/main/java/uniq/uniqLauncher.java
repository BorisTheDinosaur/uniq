package uniq;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.File;
import java.io.IOException;

public class uniqLauncher {

    @Option(name = "-i", metaVar = "NoCase", usage = "Сase-insensitive")
    private boolean noCase = false;

    @Option(name = "-u", metaVar = "URows", usage = "Show only unique rows")
    private boolean uRows = false;

    @Option(name = "-c", metaVar = "Changes", usage = "Show changes")
    private boolean changes = false;

    @Option(name = "-s", metaVar = "Num", usage = "Ignore first amount of symbols")
    private int noSym = 0;

    @Option(name = "-o", metaVar = "Output", usage = "Output file name")
    private File outputFile = null;

    @Argument(metaVar = "Input", usage = "Input file name")
    private File inputFile = null;

    public static void main(String[] args) throws IOException {
        new uniqLauncher().launch(args);
    }

    private void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("java -jar uniq.jar -i -u -c -s num -o ofile file");
            parser.printUsage(System.err);
            return;
        }

        Uniq uniq = new Uniq(noCase, uRows, changes, noSym, outputFile, inputFile);

        try {
            uniq.main();
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}