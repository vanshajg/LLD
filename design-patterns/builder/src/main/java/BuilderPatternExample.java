import model.Person;

public class BuilderPatternExample {

    public static void main(String[] args) {
        Person person = Person.builder()
                .name("Vanshaj")
                .age(28)
                .build();
        System.out.println(person);
    }

}
