package uniq;

import org.kohsuke.args4j.Argument;
import org.kohsuke.args4j.CmdLineException;
import org.kohsuke.args4j.CmdLineParser;
import org.kohsuke.args4j.Option;

import java.io.IOException;

public class uniqLauncher {

    @Option(name = "-i", usage = "Сase-insensitive")
    private final boolean noCase = false;

    @Option(name = "-u", usage = "Show only unique rows")
    private final boolean uRows = false;

    @Option(name = "-c", usage = "Show changes")
    private final boolean changes = false;

    @Option(name = "-s", metaVar = "num", usage = "Ignore first amount of symbols")
    private final int noSym = 0;

    @Option(name = "-o", metaVar = "ofile", usage = "Output file name")
    private final String outputFile = null;

    @Argument(metaVar = "file", usage = "Input file name")
    private final String inputFile = null;

    public static void main(String[] args) {
        new uniqLauncher().launch(args);
    }

    private void launch(String[] args) {
        CmdLineParser parser = new CmdLineParser(this);

        try {
            parser.parseArgument(args);
        } catch (CmdLineException e) {
            System.err.println(e.getMessage());
            System.err.println("java -jar uniq.jar -i -u -c -s num -o ofline file");
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