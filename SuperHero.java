/*
以前に作ったクラスとは似たよったクラスを作るときに継承を使う。
例えばHeroが冒険するにつれ進化してSuperHeroになったとすると・・・
飛べるようになる・着地もできるようになった。
新たにコピペでSuperHeroクラスを作ってしまってもいいが後々の修正、追加に手間がかかってしまう。
管理も難しくなってしまう。そういう時に『継承』を使う。
 */

public class SuperHero extends Hero{
    /* extends Hero （基本的にはHeroと同じと宣言,違いだけ記述するという意味）

    public class クラス名 extends 元となるクラス名　{
        親クラスとの『差分』メンバ
        }

        ２つのクラスの関係を継承関係といい
        元となるクラスを『スーパークラス』（ここならHero）
        新たに定義されるクラスを『サブクラス』(ここならSuperHero）
        ただしJavaでは複数のクラスを親として１つの子クラスを定義する多重継承を許可していない。
    */
    boolean flying;
    public void fly(){
        this.flying = true;
        System.out.println("飛び上がった。");
    }   //追加したfly

    public void land(){
        this.flying = false;
        System.out.println("着地した。");
    }   //追加したland

    public void run(){
        /* Heroクラスにあるrunメソッドを上書きした。
            親クラスのメンバを小クラス側で上書きすることをオーバーライドという。
            オーバーライドされればSuperHeroとしてのrunとHeroとしてのrunの２つ持っているが
            外部から呼び出された場合は優先的に外側にあるSuperHeroのrunが動作する
            （親クラスのrunが無くなる訳ではない。上書きされたように見えるだけ）
         */
        System.out.println(this.name + "は撤退した。");
    }

    public void attack (Matango m){
        // これだと将来Heroクラスのattack()が修正されて５ではなく１０ダメージに修正されたときに困る
//        System.out.println(this.name + "の攻撃”");
//        m.hp -= 5;
//        System.out.println("5ポイントのダメージを与えた。");
//        if(this.flying){
//            System.out.println(this.name + "の攻撃。");
//            m.hp -= 5;
//            System.out.println("5ポイントのダメージを与えた。");
//        }
        //superを使って今より一つ内側のインスタンス部分にアクセスする
        /* superをつけないということはthis.attack()を同じ意味でインスタンスの最も外側部分を意味するため
        無限ループになってしまう。
        AがBの親。BがCの親といった関係ではCはBにへのSuperでのアクセスは出来るが
        AへのSuperのアクセスは出来ない。
         */
        super.attack(m);
        if(this.flying){
            super.attack(m);
        }
    }
    public SuperHero(){
//        System.out.println("SuperHeroのコンストラクタが動作");
        super();
    }
}
