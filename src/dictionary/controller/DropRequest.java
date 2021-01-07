package dictionary.controller;

public class DropRequest extends Request {

    public DropRequest(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getKeyWord() {
        return keyWord;
    }

    @Override
    public String toString() {
        return "Request: kind_drop, keyword_" + this.keyWord;
    }
}
