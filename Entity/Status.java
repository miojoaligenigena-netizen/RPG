package Entity;



public class Status {
    private int strength = 1;
    private int sourcery = 1;
    private int resistance = 1;
    private int agility = 1;
    
    public void print(){
        System.out.println("====== Status ======");
        System.out.println("strength: "+strength);
        System.out.println("sourcery: "+sourcery);
        System.out.println("resistance: "+resistance);
        System.out.println("agility: "+agility);        
    }
    
    private boolean canSet(int stat){
        if (stat <= 1){
            System.out.println("You can't set the status to 1 or less");
            return false;
        }
        return true;
    }

    public void setStrength(int strength) {
        if (canSet(strength)) {
            this.strength = strength;
        }
    }

    public void setSourcery(int sourcery) {
        if (canSet(sourcery)) {
            this.sourcery = sourcery;
        }
    }

    public void setResistance(int resistance) {
        if (canSet(resistance)) {
            this.resistance = resistance;
        }
    }

    public void setAgility(int agility) {
        if (canSet(agility)) {
            this.agility = agility;
        }
    }

    public int getStrength() {
        return strength;
    }

    public int getSourcery() {
        return sourcery;
    }

    public int getResistance() {
        return resistance;
    }

    public int getAgility() {
        return agility;
    }
}
