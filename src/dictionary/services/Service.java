package dictionary.services;

import dictionary.controller.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import static dictionary.controller.DefineRequest.*;

public class Service {
    public static final String WORD_NOT_FOUND_IN_DATABASE = "Word not found in Database.";
    public static final String CANT_FIND_WORDS_FILE = "Can't find words file.";

    private enum kindOfDefine {PRONOUN, ADJECTIVE, NOUN, VERB, SYNONYMOUS}

    private static Service instance;

    private static File file;
    private List<String> words;

    static {
        try {
            file = new File("words");
            if (!file.exists()) {
                throw new FileNotFoundException(CANT_FIND_WORDS_FILE);
            }
        } catch (Exception e) {
        }
    }

    private void updateWordList() {
        words = Arrays.asList(file.list());
    }

    private Service() {
        updateWordList();
    }

    public static Service getInstance() {
        if (instance == null) {
            synchronized (Service.class) {
                if (instance == null) {
                    instance = new Service();
                }
            }
        }
        return instance;
    }

    public void handleRequest(Request request) {
        if (!words.contains(request.getKeyWord()) && !(request instanceof DefineRequest)) {
            UserInterfaceController.getInstance().display(WORD_NOT_FOUND_IN_DATABASE);
        }
        if (request instanceof LookupRequest) {
            UserInterfaceController.getInstance().display(FileController.getInstance().getWord(request.getKeyWord()));
        } else if (request instanceof DefineRequest) {
            UserInterfaceController.getInstance().display("Enter your new define: ");
            String newDefine = UserInterfaceController.getInstance().getRequest();

            //update word and define

        } else if (request instanceof DropRequest) {
            FileController.getInstance().deleteWord(request.getKeyWord());
        }
    }
}
