public class Candidate {
    private final String fio;
    private final Integer relevance;
    private final Integer rating;

    public Candidate(String fio, Integer relevance, Integer rating) {
        this.fio = fio;
        this.relevance = relevance;
        this.rating = rating;
    }

    public String getFio() {
        return this.fio;
    }

    public Integer getRelevance() {
        return this.relevance;
    }

    public Integer getRating() {
        return this.rating;
    }

}
