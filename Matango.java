//オブジェクト指向という明確な思想に基づいてクラス・メソッドが作られている
public class Matango {
    String name;
    int hp;
    int level = 10;

    public void attack(){
        System.out.println(this.name + "は戦った！");
    }
    public void run(){
        System.out.println(this.name + "は逃げ出した！");
    }
}
