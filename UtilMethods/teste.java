package UtilMethods;

import Entity.Skill;
import Entity.EntityClass;
import Itens.TypeItens.Armor;
import Entity.Entity;
import Entity.TypeStatus;
import Itens.Material.Iron;
import Itens.TypeItens.Potion;

public class teste {
    public static void main(String[] args) {
        Combat com = new Combat();
        
        // Skills
        Skill lunge = new Skill("Lunge", 5, TypeStatus.STRENGHT);
        Skill manaBall = new Skill("Mana ball", 7, TypeStatus.SOURCERY);
        Skill bite = new Skill("Bite", 4, TypeStatus.STRENGHT);
        
        // Class
        EntityClass paladin = new EntityClass("Paladin");
        paladin.setStrength(1);
        paladin.setResistance(1);
        
        // Entities        
        Entity player = new Entity("Davi");
        player.setLevel(1);
        player.setIsPlayer(true);
        player.setSkills(new Skill[] {lunge, manaBall});
        player.setClasse(paladin);
        
        Entity goblin = new Entity("Goblin");
        goblin.setLevel(1);
        goblin.setSkills(new Skill[] {lunge, manaBall});
        
        Entity wolf = new Entity("Wolf");
        wolf.setLevel(3);
        wolf.setSkills(new Skill[] {bite});
        
        // Itens
        Potion healingPotion = new Potion("Healing potion", 20);
        Armor leatherArmor = new Armor("Leather armor", 2, Armor.ArmorType.CHESTPLATE);
        Armor plateArmor = new Armor("Plate armor", 10, Armor.ArmorType.CHESTPLATE);
        
        player.addItem(healingPotion, 1);
        player.addItem(leatherArmor);
        player.addItem(plateArmor);
        
        Iron iron = new Iron();
        player.addItem(iron);
        
        // Others
        com.battle(player, wolf);
    }
}
