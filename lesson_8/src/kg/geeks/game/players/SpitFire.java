package kg.geeks.game.players;

import kg.geeks.game.general.RPG_Game;


public class SpitFire extends Hero {
    public SpitFire(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.CRITICAL_DAMAGE);

    }
    public void applySuperPower(Boss boss, Hero[] heroes){
        int randomHeroIndex = RPG_Game.random.nextInt(heroes.length);
        Hero randomHero = heroes[randomHeroIndex];
        if (randomHero.getHealth() > 0) {
            SpitFire damage = new SpitFire (heroes[randomHero]);
            damage.setHealth(damage.getHealth() - this.getDamage() * 2);
            damage.applySuperPower(boss, heroes);
        }

        boss.setHealth(boss.getHealth() - this.getDamage() * 2);
        System.out.println("Mr. Anger " + this.getName() + " hits critically "
                + this.getDamage() + " damages to boss.");
    }
}
