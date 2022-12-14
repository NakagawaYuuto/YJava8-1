/*仮想世界の作り方
    手順
    １：クラス定義する。
    ２：そのクラスに基づいてオブジェクトを生成する。

   クラスをひとつ作っておけば必要な数だけオブジェクトを生成できる。
   クラスは金型。
   それを使って製品（オブジェクト）を作っていく。

   クラスだけを作っても動かないので必ずMainメソッドがいる。

    登場人物を一つのクラスとして捉える。
    操作をメソッドとしてコードを書く。
    オブジェクト指向を意識したプログラム開発とは、現実世界の人や物、出来事をクラスに変えてく作業。
    現実に似せて作り、動かしていくのがオブジェクト指向の根本的な思想。
*/

/*
    正しい継承とは「is - a の原則」というルールに則っている継承。
    「A　は　B　の一種である」という意味が自然であれば正しい継承。
    例：　ヒーローはスーパーヒーローの一種である　○
         家はアイテムの一種である　×

    is-aの関係ではない継承をしてはいけない理由は・・・
    将来、クラスを拡張していった場合に現実世界と矛盾が生じる。
    オブジェクト指向の３台昨日の多様性を利用できなくなる。

    子クラスになればなるほど「特殊で具体的なもの」具体化（特化）していき、
    親クラスになるほど「抽象的で曖昧なもの」一般化（汎化）する。
    キャラクターであれば、名前とHPは必ず持っているのでnameとhpは定義出来るが
    具体的なキャラクターとして魔法使いになればMPや火の玉などを使うMPフィールドや
    FireBallメソッドなどが加わる。（継承ツリーを書いてみる）
    継承とは『ある２つのクラスに特化・汎化の関係があることを示す」ための道具でもある。
 */

/*
クラス型と参照
    Java仮想世界として表現してきた「勇者」「お化けキノコ」「聖職者」等は、実際は「コンピューターのメモリ領域」
    実行する際にJVMが大量にメモリ領域を使って準備するもの。（ヒープ）
    newを用いてインスタンスを生成するたびにヒープの一部の領域が確保され、インスタンスの情報を格納するために
    利用される。
    「インスタンスはヒープの中に確保されたメモリ領域に過ぎない」
 */

//Mainメソッドは天の声（神様クラス
// finalを付けると継承はできない。（外から弄れない）
public final class Main {
    public static void main(String[] args) {
        /*勇者の生成
        Hero h :「Hero型の変数　h」をメモリ内に準備する。(Hero型の箱が準備されただけ）
        h = new Hero(); :　代入文。ここで生まれたHeroインスタンスの情報領域の確保
                             （名前のフィールドの保存領域、HPフィールドの保存領域）＊中身は空っぽ
        注意！　h　にはHeroインスタンスが入るのではなく勇者インスタンスが生成されている番地が入る。
        流れ：勇者の箱が作られる。詳細な情報は別のメモリ領域に保存。この勇者についての情報は別のメモリの番地を
               参照してもらう。
        参照の解決、アドレス解決：変数から番地情報を取り出し、次にその番地にアクセスする。

         */
        Sword s = new Sword();
        s.name = "炎の剣";
        s.damage = 10;

        Hero h = new Hero("ミナト");
//        h.name = "ミナト"; //nameの設定
//        h.hp = 100; //hpの設定
//        Hero h1 = new Hero();
        System.out.println(h.name);
//        System.out.println(h1.name + h1.hp);
        h.sword =s; //swordフィールドの生成ずみの剣インスタンスの番地を代入してる
        System.out.println("現在の武器は" + h.sword.name); //勇者(h)の剣（sword）の名前（name）
        /*
        勇者　h　の変数の番地から勇者インスタンスのSword領域から剣インスタンスのname領域にアクセスする
         */
        System.out.println(h.name + "は" + h.sword.name + "で攻撃した！");
        h.mp = 20;
        System.out.println("勇者" + h.name + "を生み出しました。" + h.hp);

        Wizard w = new Wizard();
        w.name = "スガワラ";
        System.out.println("魔術師" + w.name + "を生み出した");
        w.hp = 50;
        w.heal(h);
        System.out.println(h.hp);
        w.heal(h);
        System.out.println(h.hp);


        Hero h2;
        h2 = h;
        h2.hp = 200;
        System.out.println("****" + h.hp);

        // 敵の生成
        Matango m = new Matango();
        m.name = "お化けキノコ";
        m.hp = 10;
        System.out.println(m.name + "を生み出しました。");
        Matango m1 = new Matango();
        m1.name = "毒キノコ";
        m1.hp = 5;
        System.out.println(m1.name + "を生み出した。");

        //聖職者の生成
        Cleric c = new Cleric();
        c.name = "クリス";
        c.hp = 20;
        c.mp = 10;
        System.out.println(c.name + "を生み出した。");
        c.selfAid();
        c.pray(1);

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

        //戦え勇者
        //逃げるキノコ

        Thief t = new Thief("アサカ", 40, 5);
        Thief t1 = new Thief("アサカ", 35);
        Thief t2 = new Thief("アサカ");

        h.run();
        SuperHero sh = new SuperHero();
        sh.run();

        h.attack(m);

        //コンストラクタは内側の部分のものから順に動いていく
        SuperHero sh1 = new SuperHero();

        Weapon we = new Weapon();

        /*
        練習問題
        ①Student　は　Person　の1種である　○
        ②Engine　は　Car　の1種である　×
        ③Child　は　Father　の1種である　×
        ④Susi　は　Food　の1種である　○
        ⑤Man　は　 SuperMan　の 1種である　×

        Character　Hero　SuperHero
        機械　Phone　携帯電話
        乗り物　Car　スーパーカー
        book Dictionary 英語辞典
         */


    }
}
