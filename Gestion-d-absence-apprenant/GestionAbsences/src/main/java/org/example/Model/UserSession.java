package org.example.Model;

public class UserSession {
    private static UserSession userSession;
    private static long id;

    private UserSession() {
    }


    public static UserSession getUserSession() {
        if (userSession == null) {
            userSession = new UserSession();
        }
        return userSession;
    }

    public static long getId() {
        return id;
    }

    public static void setId(long id) {
        UserSession.id = id;
    }


}
