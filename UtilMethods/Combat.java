package UtilMethods;

import Entity.Skill;
import Entity.Entity;
import java.util.Random;
import java.util.Scanner;

public class Combat {
    private Scanner scanner = new Scanner(System.in);
    private Random random = new Random();
    private Input input = new Input();
    
    public void battle(Entity entity1, Entity entity2){
        Entity temp;
        Entity attacker = entity1.getAgility() >= entity2.getAgility() ? entity1 : entity2;
        Entity target = attacker == entity1 ? entity2 : entity1;
        
        while (entity1.getHp() > 0 && entity2.getHp() > 0) {
            System.out.println("\n"+entity1.getName()+" ["+entity1.getHp()+"/"+entity1.getMaxHp()+"] "+entity2.getName()+" ["+entity2.getHp()+"/"+entity2.getMaxHp()+"] ");
            if (turn(attacker, target)){
                return;
            }
            
            temp = attacker;
            attacker = target;
            target = temp;
        }
        
        if (entity1.getHp() > 0 && entity2.getHp() <= 0) {
            isPlayerDie(entity2);
            reward(entity1, entity2);
        } else {
            isPlayerDie(entity1);
            reward(entity2, entity1);
        }
    }
    
    private void isPlayerDie(Entity entity){
        if (entity.isPlayer()) System.exit(0);
    }
    
    private boolean turn(Entity attacker, Entity target){
        if (attacker.isPlayer()){
            return playerTurn(attacker, target);
        } else {
            useSkill(attacker, randomSkill(attacker), target);
        }
        return false;
    }
    
    private boolean playerTurn(Entity attacker, Entity target){
        switch (chooseAction()){
            case 1 ->  {              
                useSkill(attacker, chooseSkill(attacker), target);
            }
            
            case 2 ->  {
                openInventory(attacker, target);
            }
            
            case 3 ->  {
                if (canRun(attacker, target)) {
                return true;

                } else {
                    System.out.println("\nYou failed");
                }
            }
        }
        return false;
    }
    
    private int chooseAction(){
        printActions();
        while (true){
            System.out.print("\nChoose an action: ");
            int action = input.inputInt();
            if (input.choiseInRange(action, 3)) return action;
        }
    }
    
    private void printActions(){
        System.out.print("\nActions: ");
        System.out.print("[1] Attack | ");
        System.out.print("[2] Inventory | ");
        System.out.print("[3] Run");
    }
    
    private Skill chooseSkill(Entity entity) {
        printSkills(entity);
        int i;
        while (true) {
            System.out.print("Choose your skill: ");
            i = input.inputInt();
            if (input.choiseInRange(i, entity.getSkills().length)) break;
        }

        return entity.getSkills()[i - 1];
    }
  
    private Skill randomSkill(Entity entity){
            int index = random.nextInt(entity.getSkills().length);
            return entity.getSkills()[index];
    }
    
    private void printSkills(Entity entity){
        int x = 1;
        for (Skill i : entity.getSkills()){
            System.out.print(i.getName()+ " ["+x+"]    ");
            x++;
        }
    }
    
    private void useSkill(Entity attacker, Skill skill, Entity target){
        int damage = getDamage(attacker, skill, target);
        
        target.setHp(target.getHp() - damage);
        
        System.out.println(attacker.getName()+" used "+skill.getName()+" and dealt "+damage+" damage");
    }
    
    private int getDamage(Entity attacker, Skill skill, Entity target){
        int damage = (skill.getType().getValue(attacker) * skill.getBaseDamage()) - target.getArmorClass();
        if (damage < 0) damage = 0;
        if (attacker.getWeapon() != null) damage += attacker.getWeapon().getDamage();
        return damage;
    }
    
    private boolean canRun(Entity entity, Entity attacker){
        return random.nextInt(entity.getAgility()) > random.nextInt(attacker.getAgility());
    }
    
    private void reward(Entity winner, Entity loser){
        int xp = loser.getLevel() * 100;
        winner.gainXp(xp);
    }
    
    private void openInventory(Entity attacker, Entity target){
        attacker.getInventory().open(getTarget(attacker, target));
    }
    
    private Entity getTarget(Entity entity, Entity target){
        System.out.println("Select a target: ");
        System.out.println("[1] Yourself");
        System.out.println("[2] Enemy");
        
        int num = input.inputChoise(2);
        
        if (num == 1) {
            return entity;
        } else {
            return target;
        }
    }
}