package dictionary.controller;

public class lookupRequest extends Request {
    private String action = "lookup";
    private String keyWord;

    public lookupRequest(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getKeyWord() {
        return keyWord;
    }
}