public class Wizard {
    String name;
    int hp;
    public void heal(Hero h){
        h.hp += 10;
        System.out.println("魔法を使って" + h.name + "のHPを１０回復した。");
    }
}
