public class ConfidentialDocument implements Confidential {
    private String content;

    public ConfidentialDocument(String content) {
        this.content = content;
    }

    public void display() {
        System.out.println("Confidential Document: " + content);
    }
}