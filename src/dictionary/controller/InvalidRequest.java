package dictionary.controller;

public class InvalidRequest {
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
