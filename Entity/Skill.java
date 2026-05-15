package Entity;



public class Skill {
    private String name;
    private int baseDamage;
    private TypeStatus type;

    public Skill(String name, int baseDamage, TypeStatus type) {
        this.name = name;
        this.baseDamage = baseDamage;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBaseDamage() {
        return baseDamage;
    }

    public void setBaseDamage(int baseDamage) {
        this.baseDamage = baseDamage;
    }

    public TypeStatus getType() {
        return type;
    }

    public void setType(TypeStatus type) {
        this.type = type;
    }
}
