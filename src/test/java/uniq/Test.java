package uniq;

import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Test {

    @org.junit.Test
    public void test1() throws IOException {
        String[] args = new String[]{"-o", "src/test/java/uniq/res/Test", "src/test/java/uniq/res/File"};
        uniqLauncher.main(args);
        List<String> test1 = Files.readAllLines(Paths.get("src/test/java/uniq/res/test1"));
        List<String> Test = Files.readAllLines(Paths.get("src/test/java/uniq/res/Test"));
        assertEquals(test1, Test);
    }

    @org.junit.Test
    public void test2() throws IOException {
        String[] args = new String[]{"-i", "-o", "src/test/java/uniq/res/Test", "src/test/java/uniq/res/File"};
        uniqLauncher.main(args);
        List<String> test2 = Files.readAllLines(Paths.get("src/test/java/uniq/res/test2"));
        List<String> Test = Files.readAllLines(Paths.get("src/test/java/uniq/res/Test"));
        assertEquals(test2, Test);
    }

    @org.junit.Test
    public void test3() throws IOException {
        String[] args = new String[]{"-s", "3", "-o", "src/test/java/uniq/res/Test", "src/test/java/uniq/res/File"};
        uniqLauncher.main(args);
        List<String> test3 = Files.readAllLines(Paths.get("src/test/java/uniq/res/test3"));
        List<String> Test = Files.readAllLines(Paths.get("src/test/java/uniq/res/Test"));
        assertEquals(test3, Test);
    }

    @org.junit.Test
    public void test4() throws IOException {
        String[] args = new String[]{"-c", "-o", "src/test/java/uniq/res/Test", "src/test/java/uniq/res/File"};
        uniqLauncher.main(args);
        List<String> test4 = Files.readAllLines(Paths.get("src/test/java/uniq/res/test4"));
        List<String> Test = Files.readAllLines(Paths.get("src/test/java/uniq/res/Test"));
        assertEquals(test4, Test);
    }

    @org.junit.Test
    public void test5() throws IOException {
        String[] args = new String[]{"-u", "-o", "src/test/java/uniq/res/Test", "src/test/java/uniq/res/File"};
        uniqLauncher.main(args);
        List<String> test5 = Files.readAllLines(Paths.get("src/test/java/uniq/res/test5"));
        List<String> Test = Files.readAllLines(Paths.get("src/test/java/uniq/res/Test"));
        assertEquals(test5, Test);
    }

    @org.junit.Test
    public void test6() throws IOException {
        String[] args = new String[]{"-i", "-s", "3", "-o", "src/test/java/uniq/res/Test", "src/test/java/uniq/res/File"};
        uniqLauncher.main(args);
        List<String> test6 = Files.readAllLines(Paths.get("src/test/java/uniq/res/test6"));
        List<String> Test = Files.readAllLines(Paths.get("src/test/java/uniq/res/Test"));
        assertEquals(test6, Test);
    }

    @org.junit.Test
    public void test7() throws IOException {
        String[] args = new String[]{"-c", "-s", "3", "-o", "src/test/java/uniq/res/Test", "src/test/java/uniq/res/File"};
        uniqLauncher.main(args);
        List<String> test7 = Files.readAllLines(Paths.get("src/test/java/uniq/res/test7"));
        List<String> Test = Files.readAllLines(Paths.get("src/test/java/uniq/res/Test"));
        assertEquals(test7, Test);
    }

    @org.junit.Test
    public void test8() throws IOException {
        String[] args = new String[]{"-i", "-u", "-o", "src/test/java/uniq/res/Test", "src/test/java/uniq/res/File"};
        uniqLauncher.main(args);
        List<String> test8 = Files.readAllLines(Paths.get("src/test/java/uniq/res/test8"));
        List<String> Test = Files.readAllLines(Paths.get("src/test/java/uniq/res/Test"));
        assertEquals(test8, Test);
    }
}
