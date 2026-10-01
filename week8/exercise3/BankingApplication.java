public class BankingApplication implements AdvancedSecurity {
    private boolean loggedIn = false;

    @Override
    public void login() {
        loggedIn = true;
        System.out.println("User logged in.");
    }

    @Override
    public void logout() {
        loggedIn = false;
        System.out.println("User logged out.");
    }

    @Override
    public void fingerprintAuth() {
        if (loggedIn) {
            System.out.println("Fingerprint authentication successful.");
        } else {
            System.out.println("Please login first.");
        }
    }

    @Override
    public void faceAuth() {
        if (loggedIn) {
            System.out.println("Face authentication successful.");
        } else {
            System.out.println("Please login first.");
        }
    }

    public static void main(String[] args) {
        BankingApplication app = new BankingApplication();
        app.login();
        app.fingerprintAuth();
        app.faceAuth();
        app.logout();
    }
}