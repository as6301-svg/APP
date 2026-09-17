class Candidate {
    int candidateId;
    String name;
    int aptitude;
    int technical;
    int communication;

    Candidate(int candidateId, String name, int aptitude, int technical, int communication) {
        this.candidateId = candidateId;
        this.name = name;
        this.aptitude = aptitude;
        this.technical = technical;
        this.communication = communication;
    }

    int getTotalScore() {
        return aptitude + technical + communication;
    }
}

public class TopK {
    public static void main(String[] args) {
        // Example input, replace with actual input parsing as needed
        Candidate[] candidates = {
            new Candidate(101, "Arun", 80, 90, 70),
            new Candidate(102, "Priya", 90, 85, 80),
            new Candidate(103, "Ravi", 70, 95, 75),
            new Candidate(104, "Divya", 85, 85, 85),
            new Candidate(105, "Kiran", 80, 80, 70)
        };
        int N = candidates.length;
        int K = 3; // top k to display

        // Sort by total score descending, then by candidateId ascending
        java.util.Arrays.sort(candidates, (a, b) -> {
            int scoreDiff = Integer.compare(b.getTotalScore(), a.getTotalScore());
            if (scoreDiff != 0) return scoreDiff;
            return Integer.compare(a.candidateId, b.candidateId);
        });

        for (int i = 0; i < K; i++) {
            System.out.println(candidates[i].candidateId + " " + candidates[i].name + " " + candidates[i].getTotalScore());
        }
    }
}