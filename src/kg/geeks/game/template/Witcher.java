package kg.geeks.game.template;

public class Witcher extends Hero{
    private boolean hasRevived = false;
    public Witcher(String name, int health, int damage) {
        super(name, health, damage, SuperAbility.REVIVE);
    }

    @Override
    public void applySuperPower(Boss boss, Hero[] heroes) {
        if (hasRevived){
            return;
        }
        for (Hero hero : heroes){
            if(hero.getHealth() <= 0){
                hero.setHealth(this.getHealth());
                System.out.println(this.getName() + " пожертвовал собой, чтобы оживить " + hero.getName());

                this.setHealth(0);
                hasRevived = true;
                break;
            }
        }
    }
}
