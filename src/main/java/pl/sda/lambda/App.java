package pl.sda.lambda;

import com.sun.org.apache.xerces.internal.xs.StringList;
import pl.sda.lambda.model.Artist;
import pl.sda.lambda.model.Track;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@FunctionalInterface
interface Square{
    int square(int x);
}

public class App
{
    public static void main( String[] args ) {
        List<String> names = Arrays.asList("Kasia", "Ania", "Zosia", "Bartek");
        Collections.sort(names, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2);
            }
        });

        Collections.sort(names, (String s1, String s2) -> s1.compareTo(s2));

        System.out.println(names);

        Collections.sort(SampleData.membersOfTheBeatles, new Comparator<Artist>() {
            @Override
            public int compare(Artist o1, Artist o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });

        Square square = (int x) -> x * x;
        System.out.println(square.square(2));

        String[] a = {"cat", "dog", "mouse", "rat", "pig", "rabbit", "hamster", "parrot"};
        List<String> animals = Arrays.asList(a);
        // Tradycyjna pętla
        for (String animal : animals) {
            System.out.print(animal + "; ");
        }
        // Wyrażenie lambda
        animals.forEach((animal) -> System.out.print(animal + "; "));
        animals.forEach(System.out::println);

        List<String> fruits = Arrays.asList("apple", "banana", "cherry", "plum", "pear", "pinapple");
        List<String> result = fruits.stream()
                .filter(s -> s.startsWith("p"))
                .map(s -> s.toUpperCase())
                .collect(Collectors.toList());

        List<String> dataWithNumbers = Arrays.asList("a", "122as", "a23", "b32ss", "3a");
        for (String data : dataWithNumbers){
            if (Character.isDigit(data.charAt(0))) {
                System.out.println(data);
            }
        }

        dataWithNumbers.stream()
                .filter(s -> Character.isDigit(s.charAt(0)))
                .forEach(System.out::println);

        List<Integer> flat = Stream.of(Arrays.asList(2,3,4), Arrays.asList(33,32,44))
                .flatMap(number -> number.stream())
                .collect(Collectors.toList());
        System.out.println(flat);

        List<Track> tracks = Arrays.asList(new Track("Bakai", 524),
                new Track("Violets for Your Furs", 378),
                new Track ("Time Was", 451));

        Track minTrack = tracks.stream().min(Comparator.comparing(track -> track.getLength())).get();
        System.out.println(minTrack);

        System.out.println(findShortest(tracks));
    }

    private static Track findShortest(List<Track> tracks){
        Track currentTrack = tracks.get(0);
        for (Track t : tracks){
            if (t.getLength() < currentTrack.getLength()){
                currentTrack = t;
            }
        }
        return currentTrack;
    }
}
