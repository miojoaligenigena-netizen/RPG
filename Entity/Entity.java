package Entity;

import Itens.TypeItens.Armor;
import Itens.Item;
import Itens.TypeItens.Weapon;

public class Entity {
    private String name;
    protected Status status = new Status();
    private int hp = getMaxHp();
    private Skill[] skills;
    private boolean isPlayer = false;
    private int xp;
    protected int level;
    protected EntityClass classe;
    private Inventory inventory = new Inventory();
    private Armor helmet = null;
    private Armor chestplate = null;
    private Armor leggings = null;
    private Armor boots = null;
    private Weapon weapon = null;

    public Entity(String name){
        this.name = name;
    }
    
    public int getArmorClass(){
        int i = 0;
        for (Armor armor : new Armor[] {helmet, chestplate, leggings, boots}) {
            if (armor == null) continue;
            i += armor.getArmor();
        }
        return i + this.getResistance();
    }
    
    public void addItem(Item item){
        this.inventory.addItem(item);
    }
    
    public void addItem(Item item, int quantity){
        this.inventory.addItem(item, quantity);
    }
    
    public void useItem(Item item, Entity target){
        this.inventory.useItem(item, target);
    }
    
    public int getMaxHp(){
        return this.status.getResistance() * 30;
    }
    
    public void setLevel(int quantity){
        Level.setLevel(quantity, this);
    }
    
    public void gainXp(int xp){
        Level.gainXp(xp, this);
    }

    public String getName() {
        return name;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public Skill[] getSkills() {
        return skills;
    }

    public void setSkills(Skill[] skills) {
        if (skills.length > 4) return;
        this.skills = skills;
    }

    public int getLevel() {
        return level;
    }
    
    public void setIsPlayer(boolean type) {
        this.isPlayer = type;
    }
    
    public boolean isPlayer(){
        return this.isPlayer;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        if (xp < 0) return;
        this.xp = xp;
    }

    public EntityClass getClasse() {
        return classe;
    }

    public void setClasse(EntityClass classe) {
        this.classe = classe;
    }
    
    public void setStrength(int strength) {
        this.status.setStrength(strength);
    }

    public void setSourcery(int sourcery) {
        this.status.setSourcery(sourcery);
    }

    public void setResistance(int resistance) {
        this.status.setResistance(resistance);
    }

    public void setAgility(int agility) {
        this.status.setAgility(agility);
    }

    public int getStrength() {
        return this.status.getStrength();
    }

    public int getSourcery() {
        return this.status.getSourcery();
    }

    public int getResistance() {
        return this.status.getSourcery();
    }

    public int getAgility() {
        return this.status.getAgility();
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public Item getHelmet() {
        return helmet;
    }

    public void setHelmet(Armor helmet) {
        this.helmet = helmet;
    }

    public Item getChestplate() {
        return chestplate;
    }

    public void setChestplate(Armor chestplate) {
        this.chestplate = chestplate;
    }

    public Item getLeggings() {
        return leggings;
    }

    public void setLeggings(Armor leggings) {
        this.leggings = leggings;
    }

    public Item getBoots() {
        return boots;
    }

    public void setBoots(Armor boots) {
        this.boots = boots;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
