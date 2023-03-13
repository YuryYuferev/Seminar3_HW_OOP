package Drugs;

import Drugs.Impl.CatDrug;
import Drugs.Impl.Components.Azitromycin;
import Drugs.Impl.Components.Penicillin;
import Drugs.Impl.Components.Water;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Component> componentCat = List.of(new Azitromycin("Азитромицин", "2", 4),
                new Water("Вода", "15", 1),
                new Azitromycin("Азитромицин", "2", 4));
        List<Component> componentCat2 = List.of(new Azitromycin("Азитромицин","4",4),
                new Penicillin("Пенициллин", "18", 6));
        List<Component> componentCat3 = List.of(new Water("Вода", "20", 12),
                new Azitromycin("Азитромицин", "10", 9));
        List<Component> componentCat4 = List.of(new Water("Вода", "20", 12),
                new Azitromycin("Азитромицин", "10", 100));
        List<Component> componentCat5 = List.of(new Azitromycin("Азитромицин","4",4),
                new Penicillin("Пенициллин", "20", 6));

        // Создаем лекарства на основе других компонентов

        CatDrug polyvercan = new CatDrug(componentCat, "polyvercan");
        CatDrug amoxisan = new CatDrug(componentCat2, "amoxisan");
        CatDrug azican = new CatDrug(componentCat2, "azican");
        CatDrug neodiar = new CatDrug(componentCat3, "neodiar");
        CatDrug ciprovet = new CatDrug(componentCat4, "ciprovet");
        CatDrug enroxil = new CatDrug(componentCat5, "enroxil");

        // Создаем список лекарств
        List<CatDrug> drugs = new ArrayList<>();
        drugs.add(polyvercan);
        drugs.add(amoxisan);
        drugs.add(neodiar);
        drugs.add(ciprovet);
        drugs.add(enroxil);
        drugs.add(azican);


        Collections.sort(drugs);
        System.out.println("Список лекарств");
        for (CatDrug item: drugs) {
            System.out.println(item);
        }


        System.out.println("Hashcodes componentCat: ");
        for (Component component: componentCat) {
            System.out.println(component.hashCode());
        }

        Set<Component> result = new HashSet<>(componentCat);
        System.out.println(result);
        for (Component res: result
        ) {
            System.out.println(res.hashCode());
        }
    }
}
