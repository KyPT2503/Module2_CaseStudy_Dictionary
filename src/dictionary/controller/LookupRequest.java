package dictionary.controller;

public class LookupRequest extends Request {
    private String keyWord;

    public LookupRequest(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getKeyWord() {
        return keyWord;
    }

    @Override
    public String toString() {
        return "Request: kind_lookup, keyword_" + this.keyWord;
    }
}