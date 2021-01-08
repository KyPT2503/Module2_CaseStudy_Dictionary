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
    public static final String CAN_T_HANDLE_REQUEST = "Can't handle request!";

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
        if (request instanceof InvalidRequest) {
            UserInterfaceController.getInstance().display(request);
            return;
        }
        if (!words.contains(request.getKeyWord() + ".txt") && !(request instanceof DefineRequest)) {
            UserInterfaceController.getInstance().display(WORD_NOT_FOUND_IN_DATABASE);
            return;
        }
        if (request instanceof LookupRequest) {
            UserInterfaceController.getInstance().display(FileController.getInstance().getWord(request.getKeyWord()));
        } else if (request instanceof DefineRequest) {
            Word word;
            try {
                word = FileController.getInstance().getWord(request.getKeyWord());
            } catch (IllegalArgumentException e) {
                word = new Word(request.getKeyWord(), "//", "", "", "", "");
                UserInterfaceController.getInstance().display("New word: " + request.getKeyWord());
            }
            defineWord(word, ((DefineRequest) request).getKind());
        } else if (request instanceof DropRequest) {
            FileController.getInstance().deleteWord(request.getKeyWord());
        } else {
            UserInterfaceController.getInstance().display(CAN_T_HANDLE_REQUEST);
        }
    }

    private void defineWord(Word word, kindOfDefine kind) {
        UserInterfaceController.getInstance().display("Enter your new define: ");
        String newDefine = UserInterfaceController.getInstance().getRequest();
        if (kind == kindOfDefine.NOUN) {
            word.addDefineNoun(newDefine);
        } else if (kind == kindOfDefine.SYNONYMOUS) {
            word.addDefineSynonymous(newDefine);
        } else if (kind == kindOfDefine.PRONOUN) {
            word.addDefinePronoun(newDefine);
        } else if (kind == kindOfDefine.VERB) {
            word.addDefineVerb(newDefine);
        } else if (kind == kindOfDefine.ADJECTIVE) {
            word.addDefineAdjective(newDefine);
        } else{
            UserInterfaceController.getInstance().display("Can not define.");
        }
        FileController.getInstance().defineWord(word);
        this.updateWordList();
        UserInterfaceController.getInstance().display("Define complete.");
    }
}
