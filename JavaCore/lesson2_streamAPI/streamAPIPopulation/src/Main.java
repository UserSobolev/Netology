import java.util.*;
import java.util.stream.Collectors;

public class    Main {

    public static void main(String[] args) {

        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies", "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 1_000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );
        }

        long count = persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.printf("Количество совершеннолетних: %d\n", count);

        List<String> conscripts = persons.stream()
                .filter(personAge -> personAge.getAge() > 18 && personAge.getAge() < 28)
                .filter(personSex -> personSex.getSex().equals(Sex.MAN))
                .map(Person::getFamily)
                .collect(Collectors.toList());
        System.out.println(conscripts);

        List<Person> potentialWorker = persons.stream()
                .filter(personAge -> personAge.getAge() > 18)
                .filter(x -> (x.getSex() == Sex.WOMAN && x.getAge() < 61) ||
                        (x.getSex() == Sex.MAN && x.getAge() < 65))
                .filter(personEducation -> personEducation.getEducation().equals(Education.HIGHER))
                .sorted(Comparator.comparing(Person::getFamily))
                .collect(Collectors.toList());
        System.out.println(potentialWorker);
    }
}
