import java.util.Random;

public class Cleric {
    String name;
    int hp = 50;
    final int maxHp = 50;

    int mp = 5;
    final int maxMp = 10;

    public void selfAid(){
        System.out.println(this.name + "はセルフエイドを唱えた。");
        this.mp -= 5;
        this.hp = this.maxHp;
        System.out.println("HPが全回復した。");
        System.out.println("今現在のMPは" + this.mp);
    }

    public int pray(int sec){
        System.out.println("聖職者は祈った。");
        Random rand = new Random();
        int recover = rand.nextInt(3) + sec;
        //  Random(),nextInt():nextInt() は 0 から引数に指定した値未満の整数を返します。
        int recoverActual = Math.min(this.maxMp - this.mp, recover);
        //  Math.min:静的関数で、引数で渡されたもののうち最小の値を返します
        this.mp += recoverActual;
        System.out.println("MPが" + recoverActual + "回復した。");
        System.out.println("今現在のMPは" + this.mp);
        return recoverActual;
    }
}
