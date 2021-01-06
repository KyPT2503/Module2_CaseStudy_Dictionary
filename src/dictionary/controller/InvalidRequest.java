package dictionary.controller;

public class InvalidRequest extends Request{
    private String message;

    public InvalidRequest() {
        this.message = "Invalid request.";
    }

    public InvalidRequest(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return this.message;
    }
}
