package Entity;

import Itens.Item;
import java.util.ArrayList;
import UtilMethods.Input;
import java.util.HashMap;
import java.util.Map;

public class Inventory {
    private ArrayList<Item> inventory = new ArrayList<>();
    private Input input = new Input();
    
    private ArrayList<Item> lastDisplayedItems = new ArrayList<>();

    private void print() {
        System.out.println("\n ============= Inventory =============");

        Map<Item, Integer> count = new HashMap<>();
        lastDisplayedItems.clear();

        for (Item item : inventory) {
            if (!count.containsKey(item)) {
                lastDisplayedItems.add(item);
            }
            if (item.getIsMaterial()) continue; 
            count.put(item, count.getOrDefault(item, 0) + 1);
        }

        for (int i = 0; i < lastDisplayedItems.size(); i++) {
            Item item = lastDisplayedItems.get(i);

            Integer quantityObj = count.get(item);
            int quantity = (quantityObj == null) ? 0 : quantityObj;

            if (quantity > 0) {
                System.out.println("--> [" + (i + 1) + "] " + item.getName() + " - " + 
                quantity + "x - " + item.display());
            }
        }
    }
    
    public void open(Entity target){
        print();
        
        System.out.println("\n[0] to end turn");
        System.out.print("\nSelect an item: ");
        
        int num = input.inputInt();
        if (num == 0) return;
        
        if (num > 0 && num <= lastDisplayedItems.size()){
            Item item = lastDisplayedItems.get(num - 1);
            
            if (item.getIsEquipment() && target.isPlayer()) {
                item.equip(target);
                this.inventory.remove(item);
            } else if (!item.getIsEquipment()){
                useItem(item, target);
            }
        } else {
            System.out.println("Invalid selection!");
        }
    }
    
    public void addItem(Item item){
        this.inventory.add(item);
    }
    
    public void addItem(Item item, int quantity){
        for (int i = 0; i < quantity; i++) {
            this.inventory.add(item);
        }
    }
    
    public void useItem(Item item, Entity target){
        item.use(target);
        this.inventory.remove(item);
    }

    public ArrayList getInventory() {
        return inventory;
    }
}