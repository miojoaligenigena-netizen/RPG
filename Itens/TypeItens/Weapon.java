package Itens.TypeItens;

import Entity.Entity;
import Itens.Item;

public class Weapon extends Item{
    private int damage;
    
    public Weapon(String name, int damage) {
        super(name, Item.TypeItem.EQUIPMENT);
        if (damage >= 1) {
            this.damage = damage;
        } else {
            this.damage = 1;
        }
    }
    
    @Override
    public void equip(Entity target){
        if (target.getWeapon() != null) target.addItem(target.getWeapon());
        target.setWeapon(this);
    }
    
    @Override
    public String display() {
        return "Damage: +" + this.damage;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }
    
    public void addDamage(int damage){
        this.damage += damage;
    }
}