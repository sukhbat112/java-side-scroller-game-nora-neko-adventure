import java.awt.*;

// 画面上に表示される全オブジェクトの母体となるクラス
public class DefaultObject {
    protected int viewWidth;     // 画面の幅を保持する変数
    protected int viewHeight;    // 画面の高さを保持する変数
    protected float locateX;     // オブジェクトの表示位置の x 座標
    protected float locateY;     // オブジェクトの表示位置の y 座標
    protected float stageX;      // オブジェクトのステージ上の x 座標
    protected float stageY;      // オブジェクトのステージ上の y 座標
    protected float hitboxWidth; // オブジェクトの当たり判定領域の幅
    protected float hitboxHeight;// オブジェクトの当たり判定領域の高さ 
    protected boolean isVisible; // オブジェクトが画面上に表示されているなら true, されていないなら false
    protected Image nowImage;    // オブジェクトの画像データ
    protected float sizeX;       // オブジェクトの表示サイズの高さ
    protected float sizeY;       // オブジェクトの表示サイズの幅

    public DefaultObject(float x, float y){
        viewWidth = 800;    
        viewHeight = 600;
        locateX = 0;
        locateY = 0;
        stageX = x;
        stageY = y;
        sizeX = 0;
        sizeY = 0;    
        hitboxWidth = 0;
        hitboxHeight = 0;
        isVisible = false;
    }

    // オブジェクトの x 座標を取得
    public float GetLocateX(){
        return locateX;
    }

    // オブジェクトの y 座標を取得
    public float GetLocateY(){
        return locateY;
    }

    // オブジェクトのステージ上の x 座標を取得
    public float GetStageX(){
        return stageX;
    }

    // オブジェクトのステージ上の y 座標を取得
    public float GetStageY(){
        return stageY;
    }

    // オブジェクトの当たり判定の幅を取得
    public float GetHitBoxWidth(){
        return hitboxWidth;
    }

    // オブジェクトの当たり判定の幅を取得
    public float GetHitBoxHeight(){
        return hitboxHeight;
    }

    // オブジェクトの表示状態を取得
    public boolean IsVisible(){
        return isVisible;
    }

    // オブジェクトの表示サイズの幅を取得
    public float GetSizeX(){
        return sizeX;
    }
    
    // オブジェクトの表示サイズの高さを取得
    public float GetSizeY(){
        return sizeY;
    }

    // オブジェクトの表示位置の座標を (x, y) に設定
    public void SetLocate(float x, float y){
        locateX = x;
        locateY = y;
    }

    // オブジェクトのステージ上の位置の座標を (x, y) に設定
    public void SetStageLocate(float x, float y){
        stageX = x;
        stageY = y;
    }

    // オブジェクトの当たり判定を設定
    // 当たり判定は長方形とする
    // 円形や複数の図形の組み合わせの実装は要相談
    public void SetHitBox(float width, float height){
        hitboxWidth = width;
        hitboxHeight = height;
    }

    // 他オブジェクトとの接触判定
    // 処理は子クラスでオーバーライドする
    public boolean isHit(MoveObject obj){
        return false;
    }

    // isHitメソッドがTRUEを返した時に起動するイベント
    // 処理は子クラスでオーバーライドする
    public void hitEvent(MoveObject obj){}

    public void SetSize(float x, float y){
        sizeX = x;
        sizeY = y;
    }

    // オブジェクトの表示状態を設定
    public void SetVisible(boolean flag){
        isVisible = flag;
    }

    // 子クラスでオーバーライドする用
    // 毎フレーム呼び出して描画位置の更新などを行う
    public void update() {}

    // 子クラスでオーバーライドする用
    // オブジェクトの画像を取得する
    public Image GetImage(){
        return null;
    }

    // 子クラスでオーバーライドする用
    // 画像を指定位置に描画する
    public void draw(Graphics g) {}
}