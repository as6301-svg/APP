public class PublicDocument {
    private String content;

    public PublicDocument(String content) {
        this.content = content;
    }

    public void display() {
        System.out.println("Public Document: " + content);
    }
}