package Itens.Material;

import Itens.Item;
import Itens.TypeItens.Weapon;
import Itens.TypeItens.Armor;

public abstract class Material extends Item{
    private int durability;

    public Material(String nome, int durability) {
        super(nome, TypeItem.MATERIAL);
        this.durability = durability;
    }
    
    public abstract void weaponProperty(Weapon weapon);
    
    public abstract void armorProperty(Armor armor);
    
    @Override
    public String display() {
        return "Durablity: "+ this.getDurability();
    }
    
    public int getDurability() {
        return durability;
    }

    public void setDurability(int durability) {
        this.durability = durability;
    }
}
