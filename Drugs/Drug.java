package Drugs;
import org.jetbrains.annotations.NotNull;
import java.util.Iterator;
import java.util.List;

public abstract class Drug implements Iterable<Component>, Comparable<Drug> {
    private List<Component> components;
    int index;
    private String name;

    public Drug(List<Component> component, String name) {
        this.components = component;
        this.index = 0;
        this.name = name;
    }

    @Override
    public int compareTo(@NotNull Drug obj) {
        int power = getDrugPower();
        String name = getName();
        if (power == obj.getDrugPower()) {
            return name.compareTo(obj.getName());
        }
        if (power < obj.getDrugPower()) {
            return -1;
        } else return 1;

    }
    @NotNull
    @Override
    public Iterator<Component> iterator() {
        return new Iterator<Component>() {
            public boolean hasNext() {
                return index < components.size();
            }

            public Component next() {
                return components.get(index++);
            }
        };
    }

    public int getDrugPower() {
        int power = 0;
        for (Component component : components) {
            power += component.getPower();
        }
        return power;
    }

    public int getDrugWeight() {
        int weight = 0;
        for (Component component : components) {
            weight += Integer.parseInt(component.getWeight());
        }
        return weight;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return String.format(
                "%s {Components: %s, Total power: %s, Total weight %s}%n", getName(), components,
                getDrugPower(), getDrugWeight());
    }
}
