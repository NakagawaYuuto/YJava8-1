/*仮想世界の作り方
    手順
    １：クラス定義する
    ２：そのクラスに基づいてオブジェクトを生成する

   クラスをひとつ作っておけば必要な数だけオブジェクトを生成できる。
   クラスは金型。
   それを使って製品（オブジェクト）を作っていく。

   クラスだけを作っても動かないので必ずMainメソッドがいる。
 */

//Mainメソッドは天の声（神様クラス
public class Main {
    public static void main(String[] args) {
        //勇者の生成
        Hero h = new Hero();
        h.name = "ミナト"; //nameの設定
        h.hp = 100;//hpの設定
        h.mp = 20;
        System.out.println("勇者" + h.name + "を生み出しました。");

        Matango m = new Matango();
        m.name = "お化けキノコ";
        m.hp = 10;
        System.out.println(m.name + "を生み出しました。");
        Matango m1 = new Matango();
        m1.name = "毒キノコ";
        m1.hp = 5;
        System.out.println(m1.name + "を生み出した。");

        h.sit(5);
        System.out.println(h.name + "のHPは" + h.hp);
        h.slip();
        System.out.println(h.name + "のHPは" + h.hp);

        System.out.println(h.name + "は" + m.name + "と遭遇した！");
        System.out.println(m.name + "のHPは" + m.hp);
        System.out.println(h.name + "の攻撃！");
        m.hp -= 5;
        System.out.println(m.name + "の体力は残り" + m.hp);
        m.run();
        m1.run();
        h.run();


        //お化けキノコの生成
        //戦え勇者
        //逃げるキノコ
    }
}
