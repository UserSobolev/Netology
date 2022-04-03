public class Main {

    public static void main(String[] args) {

        for (Event event: getMovies()) {
            validEvent(event);
            System.out.println(event.toString());
        }
        for (Event event: getTheatres()) {
            validEvent(event);
            System.out.println(event.toString());
        }
        System.out.println("Все события корректны");
    }

    public static void validEvent(Event event) {
        if (event.getTitle() == null || event.getReleaseYear() == 0 || event.getAge() == 0) {
            throw new RuntimeException("Поле заполнено некорректно");
        }
    }

    public static Movie[] getMovies() {
        return new Movie[]{
                //поправь меня чтобы работало =) или обнули одно из значение чтобы сломать
                new Movie("Начало", 2010, 16),
                new Movie("Конец", 2011, 17),
                new Movie("Война", 2012, 14)
        };
    }

    public static Theatre[] getTheatres() {
        return new Theatre[]{
                new Theatre("Анна Каренина", 1798, 10),
                new Theatre("Преступление и наказание", 1925, 14),
                new Theatre("Два капитана", 1930, 18)
        };
    }
}
