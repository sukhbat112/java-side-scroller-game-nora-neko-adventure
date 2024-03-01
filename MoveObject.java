// 画面上を動くオブジェクトのクラス
public class MoveObject extends DefaultObject{
    protected float velocityX;
    protected float velocityY;
    protected Boolean isFalling;
    protected boolean isJamping;
    protected int gameState;

    public MoveObject(float x, float y){
        super(x, y);
        velocityX = 0;
        velocityY = 0;
        gameState = 0;
    }

    // オブジェクトの x 方向の速度を取得
    public float GetVelocityX(){
        return velocityX;
    }

    // オブジェクトの y 方向の速度を取得
    public float GetVelocityY(){
        return velocityY;
    }

    // オブジェクトの速度を設定
    public void SetVelocity(float vx, float vy){
        velocityX = vx;
        velocityY = vy;
    }
    
    public boolean IsFalling(){
        return isFalling;
    }

    public void setFalling(boolean t){
        isFalling = t;
    }

    public boolean IsJamping(){
        return isJamping;
    }

    public void setJamping(boolean t){
        isJamping = t;
    }

    public int GetGameState(){
        return gameState;
    }

    public void SetGameState(int gs){
        gameState = gs;
    }
}