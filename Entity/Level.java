package Entity;

import Entity.Entity;



public class Level {
    public static void setLevel(int quantity, Entity entity){
        if (quantity < 1) return;
        entity.level = quantity;
        
        int temp = entity.getXp() - getNecessaryXp(entity);
        if (temp > 0) {
            entity.setXp(temp);
        } else {
            entity.setXp(0);
        }
        statusUp(quantity, entity);
    }
    
    public static void gainXp(int xp, Entity entity){
        entity.setXp(entity.getXp() + xp);
        
        while (canUp(entity)) {
            levelUp(entity);
        }
        
        System.out.println(entity.getName()+" | xp: ["+entity.getXp()+"/"+Level.getNecessaryXp(entity)+"]");
    } 
    
    private static void levelUp(Entity entity){
        entity.setXp(entity.getXp() - getNecessaryXp(entity));
        setLevel(entity.getLevel() + 1, entity);
        System.out.println("You leveled up");
    }
    
    private static void statusUp(int quantity, Entity entity){
        if (entity.getClasse() != null) {
            entity.status.setStrength(
                entity.status.getStrength() + (entity.classe.getStrength() + 1) * quantity
            );
            entity.status.setSourcery(
                entity.status.getSourcery() + (entity.classe.getSourcery() + 1) * quantity
            );
            entity.status.setResistance(
                entity.status.getResistance() + (entity.classe.getResistance() + 1) * quantity
            );
            entity.status.setAgility(
                entity.status.getAgility() + (entity.classe.getAgility() + 1) * quantity
            );
        } else {
            entity.status.setStrength(entity.status.getStrength() + 1 * quantity);
            entity.status.setSourcery(entity.status.getSourcery() + 1 * quantity);
            entity.status.setResistance(entity.status.getResistance() + 1 * quantity);
            entity.status.setAgility(entity.status.getAgility() + 1 * quantity);
        }
        entity.setHp(entity.getMaxHp());
    }
    
    private static int getNecessaryXp(Entity entity){
        return entity.level*entity.level*2 + 250;
    }
    
    private static boolean canUp(Entity entity){
        return entity.getXp() >= getNecessaryXp(entity);
    }
}
