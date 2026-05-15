package Entity;

import Entity.Entity;



public enum TypeStatus {
    STRENGHT {
        @Override
        public int getValue(Entity e) { return e.getStrength(); }
    },
    SOURCERY {
        @Override
        public int getValue(Entity e) { return e.getSourcery(); }
    },
    RESISTANCE {
        @Override
        public int getValue(Entity e) { return e.getResistance(); }
    },
    AGILITY {
        @Override
        public int getValue(Entity e) { return e.getAgility(); }
    };

    public abstract int getValue(Entity e);
}
