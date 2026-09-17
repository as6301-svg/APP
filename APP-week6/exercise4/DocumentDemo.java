public class DocumentDemo {
    public static void main(String[] args) {
        ConfidentialDocument confDoc = new ConfidentialDocument("Secret data");
        PublicDocument pubDoc = new PublicDocument("Open data");

        checkConfidential(confDoc);
        checkConfidential(pubDoc);
    }

    public static void checkConfidential(Object obj) {
        if (obj instanceof Confidential) {
            System.out.println("Document is confidential.");
        } else {
            System.out.println("Document is not confidential.");
        }
    }
}