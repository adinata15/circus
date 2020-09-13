package circus;

import circus.animal.Animal;
import circus.animal.Duck;
import circus.animal.Parrot;
import circus.animal.Tiger;
import circus.stuff.Cage;
import circus.stuff.Cannon;
import circus.stuff.Equipment;
import circus.stuff.Ladder;

import java.util.ArrayList;
import java.util.Arrays;

public class Circus {
    private static Animal[] animals = {
            new Duck("Drake"),
            new Parrot("Polly")
    };
    private static Equipment[] equipments = {
            new Ladder(50),
            new Cannon(5),
            new Cannon(100)
    };

    private static void makeAnimalsTalk() {
        for (Animal a : animals) {
            System.out.println(a);
            System.out.println(a.speak());
        }
    }

    private static int calculateValue(Asset[] assets) {
        int total = 0;
        for (Asset a : assets) {
            if (a.getValue() <= 5) {
                System.out.println("Ignoring low value item: " + a.getValue());
                continue;
            }
            total += a.getValue();
            System.out.println("Adding item value: " + a.getValue());
        }
        return total;
    }

    public static void main(String[] args) {

//        makeAnimalsTalk();
//        System.out.println("Total value of equipments " + calculateValue(equipments));
//        System.out.println("Total value of animals " + calculateValue(animals));
        System.out.println(animals.length);

        ArrayList<Animal> animalArrayList = new ArrayList<>(Arrays.asList(animals));
        animalArrayList.add(new Duck("Ulala"));
        Parrot parot = new Parrot("Parot");
        animalArrayList.add(parot);
        System.out.println(animalArrayList.size());
        animalArrayList.sort(Animal.compareByName);
        for(Animal a: animalArrayList){
            System.out.println(a.name);
        }
        System.out.println(animalArrayList.indexOf(parot));

        makeAnimalsTalk();
        System.out.println("Total value of equipments " + calculateValue(equipments));
        System.out.println("Total value of animals " + calculateValue(animals));
        Cage<Duck> duckCage = new Cage<>();
        Duck duck = new Duck("Duckgo");
        duckCage.lockUp(duck);
        Parrot parrot = new Parrot("newParot");
        Cage<Parrot> parrotCage = new Cage<>();
        parrotCage.lockUp(parrot);

        Tiger tiger = new Tiger("libro");
        Cage<Tiger> tigerCage = new Cage<>();
        tigerCage.lockUp(tiger);

        ArrayList<Cage> cages = new ArrayList<>();
        cages.add(duckCage);
        cages.add(parrotCage);
        cages.add(tigerCage);

        for(Cage c: cages) {
            c.release();
        }
    }
}
