package legoset;

import legoset.LegoSet;
import legoset.Minifig;
import  legoset.Weight;
import jaxb.JAXBHelper;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.time.Year;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception {
        LegoSet legos = new LegoSet();
        legos.setNumber("75211");
        legos.setName("Imperial TIE Fighter");
        legos.setTheme("StarWars");
        legos.setYear(Year.of(2018));
        legos.setPieces(549);

        ArrayList<Tags> tags = new ArrayList<>();
        tags.add(new Tags("Starfighter"));
        tags.add(new Tags("Stromtrooper"));
        tags.add(new Tags("Star Wars"));
        tags.add(new Tags("Solo"));
        legos.setTags(tags);

        ArrayList<Minifig> minifigs = new ArrayList<>();
        minifigs.add(new Minifig("Imperial Mudtrooper",2));
        minifigs.add(new Minifig("Imperial Pilot",1));
        minifigs.add(new Minifig("Mimban Stormtrooper",1));
        legos.setMinifigs(minifigs);

        ArrayList<Weight> weight = new ArrayList<>();
        weight.add(new Weight(0.89,"kg"));
        legos.setWeight(weight);

        legos.setUrl("https://brickset.com/sets/75211-1/Imperial-TIE-Fighter");

        JAXBHelper.toXML(legos,System.out);
        JAXBHelper.toXML(legos, new FileOutputStream("legos.xml"));
        System.out.println(JAXBHelper.fromXML(LegoSet.class, new FileInputStream("legos.xml")));
    }

}
