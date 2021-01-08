import dictionary.controller.*;
import dictionary.services.*;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Thread main = new Thread(new MainThread());
        main.start();
    }
}

class MainThread implements Runnable {
    @Override
    public void run() {
        UserInterfaceController userInterfaceController = UserInterfaceController.getInstance();
        RequestAnalysis requestAnalysis = RequestAnalysis.getInstance();
        RequestCreator requestCreator = RequestCreator.getInstance();
        Service service = Service.getInstance();

        while (true) {
            service.handleRequest(requestCreator.createRequest(requestAnalysis.analysis(userInterfaceController.getRequest())));
        }
    }
}
