import java.util.Comparator;

    public class MyComparator implements Comparator<Candidate> {

        @Override
        public int compare(Candidate candidate1, Candidate candidate2) {
            return candidate2.getRating().compareTo(candidate1.getRating());
        }
    }

