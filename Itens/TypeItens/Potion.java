package Itens.TypeItens;

import Entity.Entity;
import Itens.Item;

public class Potion extends Item {
    private final int healAmount;
    
    public Potion(String name, int healAmount) {
        super(name);
        this.healAmount = healAmount;
    }

    public int getHealing() {
        return healAmount;
    }
    
    @Override
    public String display(){
        return "Heal a target in " + this.healAmount + " HP";
    }

    @Override
    public void use(Entity target) {
        int hp = target.getHp() + this.healAmount;
        if (hp > target.getMaxHp()){
            target.setHp(target.getMaxHp());
        } else {
            target.setHp(hp);
        }
    }
}
