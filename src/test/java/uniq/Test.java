package uniq;

import org.junit.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Test {

    public void test1() throws IOException {
        String[] args = new String[]{"-o", "src/test/java/uniq/Test", "src/test/java/uniq/File"};
        uniqLauncher.main(args);
        List<String> test1 = Files.readAllLines(Paths.get("src/test/java/uniq/test1"));
        List<String> Test = Files.readAllLines(Paths.get("src/test/java/uniq/Test"));
        assertEquals(test1, Test);
    }

    public void test2() throws IOException {
        String[] args = new String[]{"-i", "-o", "src/test/java/uniq/Test", "src/test/java/uniq/File"};
        uniqLauncher.main(args);
        List<String> test2 = Files.readAllLines(Paths.get("src/test/java/uniq/test2"));
        List<String> Test = Files.readAllLines(Paths.get("src/test/java/uniq/Test"));
        assertEquals(test2, Test);
    }

    public void test3() throws IOException {
        String[] args = new String[]{"-s", "3", "-o", "src/test/java/uniq/Test", "src/test/java/uniq/File"};
        uniqLauncher.main(args);
        List<String> test3 = Files.readAllLines(Paths.get("src/test/java/uniq/test3"));
        List<String> Test = Files.readAllLines(Paths.get("src/test/java/uniq/Test"));
        assertEquals(test3, Test);
    }

    public void test4() throws IOException {
        String[] args = new String[]{"-c", "-o", "src/test/java/uniq/Test", "src/test/java/uniq/File"};
        uniqLauncher.main(args);
        List<String> test4 = Files.readAllLines(Paths.get("src/test/java/uniq/test4"));
        List<String> Test = Files.readAllLines(Paths.get("src/test/java/uniq/Test"));
        assertEquals(test4, Test);
    }

    public void test5() throws IOException {
        String[] args = new String[]{"-u", "-o", "src/test/java/uniq/Test", "src/test/java/uniq/File"};
        uniqLauncher.main(args);
        List<String> test5 = Files.readAllLines(Paths.get("src/test/java/uniq/test5"));
        List<String> Test = Files.readAllLines(Paths.get("src/test/java/uniq/Test"));
        assertEquals(test5, Test);
    }

    public void test6() throws IOException {
        String[] args = new String[]{"-i", "-s", "3", "-o", "src/test/java/uniq/Test", "src/test/java/uniq/File"};
        uniqLauncher.main(args);
        List<String> test6 = Files.readAllLines(Paths.get("src/test/java/uniq/test6"));
        List<String> Test = Files.readAllLines(Paths.get("src/test/java/uniq/Test"));
        assertEquals(test6, Test);
    }

    public void test7() throws IOException {
        String[] args = new String[]{"-c", "-s", "3", "-o", "src/test/java/uniq/Test", "src/test/java/uniq/File"};
        uniqLauncher.main(args);
        List<String> test7 = Files.readAllLines(Paths.get("src/test/java/uniq/test7"));
        List<String> Test = Files.readAllLines(Paths.get("src/test/java/uniq/Test"));
        assertEquals(test7, Test);
    }

    public void test8() throws IOException {
        String[] args = new String[]{"-i", "-u", "-o", "src/test/java/uniq/Test", "src/test/java/uniq/File"};
        uniqLauncher.main(args);
        List<String> test8 = Files.readAllLines(Paths.get("src/test/java/uniq/test8"));
        List<String> Test = Files.readAllLines(Paths.get("src/test/java/uniq/Test"));
        assertEquals(test8, Test);
    }
}
