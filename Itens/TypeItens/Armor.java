package Itens.TypeItens;

import Entity.Entity;
import Itens.Item;

public class Armor extends Item{
    private int armor;
    private ArmorType armorType;
    public enum ArmorType{HELMET, CHESTPLATE, LEGGINGS, BOOTS}
    
    public Armor(String name, int armor, ArmorType armorType) {
        super(name, TypeItem.EQUIPMENT);
        if (armor > 1) this.armor = armor;
        this.armorType = armorType;
    }
    
    @Override
    public void equip(Entity target){
        switch(this.armorType){
            case HELMET ->  {
                if (target.getHelmet() != null) target.addItem(target.getHelmet());
                target.setHelmet(this);
            }
            case CHESTPLATE ->  {
                if (target.getChestplate() != null) target.addItem(target.getChestplate());
                target.setChestplate(this);
            }
            case LEGGINGS ->  {
                if (target.getLeggings() != null) target.addItem(target.getLeggings());
                target.setLeggings(this);
            }
            case BOOTS ->  {
                if (target.getBoots() != null) target.addItem(target.getBoots());
                target.setBoots(this);
            }
        }
    }
    
    @Override
    public String display() {
        return "Armor class: " + this.armor + " | Armor type: " + this.armorType;
    }

    public int getArmor() {
        return armor;
    }
    
    public void addArmor(int value){
        this.armor += value;
    }
}