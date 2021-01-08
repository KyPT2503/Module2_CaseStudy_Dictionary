/*
   get request by scanner
   display words, result, alert ... in object
   send got request to request analysis
 */

package dictionary.controller;

import java.util.Scanner;

public class UserInterfaceController {
    private static UserInterfaceController instance;
    private Scanner scanner;

    private UserInterfaceController() {
        scanner = new Scanner(System.in);
    }

    public static UserInterfaceController getInstance() {
        if (instance == null) {
            synchronized (UserInterfaceController.class) {
                if (instance == null) {
                    instance = new UserInterfaceController();
                }
            }
        }
        return instance;
    }

    public void display(Object object) {
        System.out.println(object);
        UserInterfaceController.getInstance();
    }

    public String getRequest() {
        String request = scanner.nextLine();
        return request;
    }
}
