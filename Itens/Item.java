package Itens;

import Entity.Entity;

public abstract class Item {
    private String name;
    private TypeItem itemType;
    public enum TypeItem{
        EQUIPMENT,
        MATERIAL
    }

    public Item(String name) {
        this.name = name;
    }
    
    public Item(String name, TypeItem itemType) {
        this.name = name;
        this.itemType = itemType;
    }
    
    public abstract String display();
    
    public void use(Entity target){
        
    };

    public void equip(Entity target){
        System.out.println("This item cannot be equipped");
    }
    
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean getIsEquipment() {
        return this.itemType == TypeItem.EQUIPMENT;
    }
    
    public boolean getIsMaterial(){
        return this.itemType == TypeItem.MATERIAL;
    }
}
