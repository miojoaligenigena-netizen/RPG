package Entity;



public class EntityClass {
    private String name;
    private int strength;
    private int sourcery;
    private int resistance;
    private int agility;

    public EntityClass(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getSourcery() {
        return sourcery;
    }

    public void setSourcery(int sourcery) {
        this.sourcery = sourcery;
    }

    public int getResistance() {
        return resistance;
    }

    public void setResistance(int resistance) {
        this.resistance = resistance;
    }

    public int getAgility() {
        return agility;
    }

    public void setAgility(int agility) {
        this.agility = agility;
    }
}
