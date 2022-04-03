import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class Main {

    public static void main(String[] args) {
        Set<Candidate> candidates = new TreeSet<>
                (Comparator.comparing(Candidate::getRelevance, Comparator.reverseOrder()).
                        thenComparing(Candidate::getRating, Comparator.reverseOrder()));

        addCandidates(candidates);

        for (Candidate candidate : candidates) {
                System.out.println(candidate.getFio() + ", релевантности резюме - " + candidate.getRelevance()
                        + ", оценке на собеседовании - " + candidate.getRating() + ".");
        }
    }

    public static void addCandidates(Set<Candidate> candidates) {
        candidates.add(new Candidate("Иванов", 5, 5));
        candidates.add(new Candidate("Петров", 5, 5));
        candidates.add(new Candidate("Сидоров", 0, 4));
        candidates.add(new Candidate("Царевич", 5, 1));
        candidates.add(new Candidate("Баков", 1, 3));
        candidates.add(new Candidate("Синицин", 2, 0));
        candidates.add(new Candidate("Жданов", 5, 4));
        candidates.add(new Candidate("Кротов", 4, 3));
        candidates.add(new Candidate("Палкин", 0, 0));
        candidates.add(new Candidate("Овечкин", 3, 1));
        candidates.add(new Candidate("Малкин", 1, 2));
    }

}
