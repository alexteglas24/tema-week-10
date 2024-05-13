import java.io.*;
import java.nio.file.*;
import java.time.*;
import java.util.*;
import java.util.stream.*;

public class Main {
    public static void main(String[] args) throws IOException {
        String inputFileName = args[0];
        int targetMonth = Integer.parseInt(args[1]);
        String outputFileName = args[2];

        List<Person> people = Files.lines(Paths.get(inputFileName))
                .map(line -> line.split(","))
                .map(parts -> new Person(parts[0], parts[1], LocalDate.parse(parts[2])))
                .collect(Collectors.toList());

        List<Person> filteredPeople = people.stream()
                .filter(person -> person.getDateOfBirth().getMonthValue() == targetMonth)
                .sorted(Comparator.comparing(Person::getFirstName).thenComparing(Person::getLastName))
                .collect(Collectors.toList());

        Files.write(Paths.get(outputFileName),
                filteredPeople.stream()
                        .map(person -> person.getFirstName() + "," + person.getLastName())
                        .collect(Collectors.toList()));
    }
}