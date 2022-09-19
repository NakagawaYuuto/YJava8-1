//オブジェクト指向という明確な思想に基づいてクラス・メソッドが作られている
public class Hero {
    String name;
    int hp;
    int mp;
    Sword sword;

    public Hero(String name){
        this.hp = 100;
        /*　new された直後に自動的に実行される処理（コンストラクタ）
            コンストラクタは開発者が直接読み出す物ではない（JVMによって呼び出される）
            条件：メソッド名がクラス名と完全に等しい・メソッド宣言に戻り値が記述されていない voidも❌　*/
        this.name = name;
    }

    //オーバーロード
    public Hero(){
        this ("ダミー");
        System.out.println("Heroのコンストラクタが動作");
    }

    public void attack(Matango m){
        System.out.println(this.name + "は戦った！");
    }

//    クラスとメンバの命名のルール
//    クラス名：名詞　単語の頭が大文字
//    フィールド名：最初以外の単語の頭が大文字
//    メソッド名；最初以外の単語の頭が大文字

//操作の記述    眠った後にHPが１００回復する
    public void sleep(){
        this.hp = 100;
        System.out.println(this.name + "は、眠って回復した");
    }

    public void sit(int sec){
        this.hp += sec;
        System.out.println(this.name + "は" + sec + "秒座った");
        System.out.println("HPが" + sec + "ポイント回復した。");
    }

    // これでslipメソッドは子クラスでのオーバーライド禁止になった。
    public final void slip(){
        this.hp -= 5;
        System.out.println(this.name + "は転んだ。");
        System.out.println("5のダメージ");
    }

    public void run(){
        System.out.println(this.name + "は、逃げ出した。");
//        System.out.println("ゲームオーバー");
//        System.out.println("最終HPは" + this.hp + "です。");
    }

/*
thisを省略すると予想外の動作になる可能性があるのでフィールドに用いるときは明示的にthisを付ける
インスタンスの生成には new を付ける。
フィールドを利用する場合は「変数名.フィールド名」を記述する
メソッドを呼び出す場合は「変数名.メソッド名()」と記述する
 */
}
