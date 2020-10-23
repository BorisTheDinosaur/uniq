package uniq;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import static org.junit.Assert.assertEquals;


public class Test {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();

    @org.junit.Test
    public void test1() throws IOException {
        String output = "src/test/java/uniq/res/Test";
        String[] args = {"-i", "-c", "-o", output, "src/test/java/uniq/res/File"};
        String test1 = "src/test/java/uniq/res/test1";
        uniqLauncher.main(args);
        assertEquals(Files.readAllLines(Paths.get(output)), Files.readAllLines(Paths.get(test1)));
    }

    @org.junit.Test
    public void test2() throws IOException {
        String output = "src/test/java/uniq/res/Test";
        String[] args = {"-i", "-o", output, "src/test/java/uniq/res/File"};
        String test2 = "src/test/java/uniq/res/test2";
        uniqLauncher.main(args);
        assertEquals(Files.readAllLines(Paths.get(output)), Files.readAllLines(Paths.get(test2)));
    }

    @org.junit.Test
    public void test3() throws IOException {
        String output = "src/test/java/uniq/res/Test";
        String[] args = {"-s", "3", "-o", output, "src/test/java/uniq/res/File"};
        String test3 = "src/test/java/uniq/res/test3";
        uniqLauncher.main(args);
        assertEquals(Files.readAllLines(Paths.get(output)), Files.readAllLines(Paths.get(test3)));
    }

    @org.junit.Test
    public void test4() throws IOException {
        String output = "src/test/java/uniq/res/Test";
        String[] args = {"-c", "-o", output, "src/test/java/uniq/res/File"};
        String test4 = "src/test/java/uniq/res/test4";
        uniqLauncher.main(args);
        assertEquals(Files.readAllLines(Paths.get(output)), Files.readAllLines(Paths.get(test4)));
    }

    @org.junit.Test
    public void test5() throws IOException {
        String output = "src/test/java/uniq/res/Test";
        String[] args = {"-u", "-o", output, "src/test/java/uniq/res/File"};
        String test5 = "src/test/java/uniq/res/test5";
        uniqLauncher.main(args);
        assertEquals(Files.readAllLines(Paths.get(output)), Files.readAllLines(Paths.get(test5)));
    }

    @org.junit.Test
    public void test6() throws IOException {
        String output = "src/test/java/uniq/res/Test";
        String[] args = {"-i", "-s", "3", "-o", output, "src/test/java/uniq/res/File"};
        String test6 = "src/test/java/uniq/res/test6";
        uniqLauncher.main(args);
        assertEquals(Files.readAllLines(Paths.get(output)), Files.readAllLines(Paths.get(test6)));
    }

    @org.junit.Test
    public void test7() throws IOException {
        String output = "src/test/java/uniq/res/Test";
        String[] args = {"-c", "-s", "3", "-o", output, "src/test/java/uniq/res/File"};
        String test7 = "src/test/java/uniq/res/test7";
        uniqLauncher.main(args);
        assertEquals(Files.readAllLines(Paths.get(output)), Files.readAllLines(Paths.get(test7)));
    }

    @org.junit.Test
    public void test8() throws IOException {
        String output = "src/test/java/uniq/res/Test";
        String[] args = {"-i", "-u", "-o", output, "src/test/java/uniq/res/File"};
        String test8 = "src/test/java/uniq/res/test8";
        uniqLauncher.main(args);
        assertEquals(Files.readAllLines(Paths.get(output)), Files.readAllLines(Paths.get(test8)));
    }
}
