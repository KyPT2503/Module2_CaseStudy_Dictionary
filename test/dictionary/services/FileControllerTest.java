package dictionary.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class FileControllerTest {
    private String input;
    private String result;

    public FileControllerTest(String input, String result) {
        this.input = input;
        this.result = result;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {FileController.getInstance().getWord("summer").toString(), FileController.getInstance().getContent("summer")},
                {FileController.getInstance().getWord("firstSummer").toString(), FileController.getInstance().getContent("firstSummer")},
        });
    }

    @Test
    public void getWord() {
        assertEquals(input, result);
    }
}