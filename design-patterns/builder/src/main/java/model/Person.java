package model;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
public class Person {

    private final String name;
    private final int age;

    private Person(PersonBuilder PersonBuilder) {
        this.name = PersonBuilder.name;
        this.age = PersonBuilder.age;
    }

    public static PersonBuilder builder() {
        return new PersonBuilder();
    }

    public static class PersonBuilder {
        private String name;
        private int age;

        public PersonBuilder name(String name) {
            this.name = name;
            return this;
        }

        public PersonBuilder age(int age) {
            this.age = age;
            return this;
        }

        public Person build() {
            return new Person(this);
        }
    }

}
