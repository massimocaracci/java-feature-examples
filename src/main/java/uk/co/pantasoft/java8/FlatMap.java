package uk.co.pantasoft.java8;

import java.util.List;
import java.util.stream.Collectors;

public class FlatMap {

    public static void main(String[] args) {

        List<User> users = List.of(
                new User("Massimo", "Caracci", List.of("massimo@gmail.com", "email2@yahoo.com", "massimo@gmail.com")),
                new User("Ettore", "Caracci", List.of("ettore@gmail.com", "ettore@yahoo.com", "ettore@cloud.com"))
        );


        var gmailEmails =
                users.stream()
                        .map(User::getEmails)
                        .flatMap(emails -> emails.stream().filter(e -> e.endsWith("@gmail.com")))
                        .collect(Collectors.toSet());

        gmailEmails.forEach(System.out::println);
    }

    static class User {

        String firstName;
        String lastName;
        List<String> emails;

        public User(String firstName, String lastName, List<String> emails) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.emails = emails;
        }

        public String getFirstName() {
            return firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public List<String> getEmails() {
            return emails;
        }
    }
}
