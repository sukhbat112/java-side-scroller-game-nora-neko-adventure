import java.awt.*;
import java.io.*;
 
import javax.imageio.*;

// ステージを構成するブロックのクラス
public class BlockObject extends DefaultObject{
    protected float blockSize;
    protected String imageFilePath = "lib\\GroundBlock4.png";
    
    public BlockObject(float x, float y){
        super(x,y);
        isVisible = true;
        blockSize = 40;
        this.SetSize(blockSize, blockSize);
        this.SetHitBox(blockSize, blockSize);
        this.SetVisible(true);
        try {
            nowImage = ImageIO.read(new File(imageFilePath));
        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
    }

    // 他オブジェクトobjとの接触判定
    // objのステージ座標を(sx, sy)とし、objの当たり判定の幅を hw, 高さを hh とする
    // objの当たり判定は(sx ~ sx+hw, sy ~ sy+hh)にある
    @Override
    public boolean isHit(MoveObject obj){
        float otherX = obj.GetStageX();
        float otherY = obj.GetStageY();
        float otherWidth = obj.GetHitBoxWidth();
        float otherHeight = obj.GetHitBoxHeight();

        // 他のオブジェクトの座標とサイズから、他のオブジェクトの長方形の各頂点を計算
        float otherRightX = otherX + otherWidth;
        float otherBottomY = otherY + otherHeight;

        // 与えられたオブジェクトと当たり判定を行う
        // このオブジェクトの長方形が他のオブジェクトの長方形と交差しているかを判定
        boolean collisionX = this.stageX < otherRightX && this.stageX + this.hitboxWidth > otherX;
        boolean collisionY = this.stageY < otherBottomY && this.stageY + this.hitboxHeight > otherY;

        // 交差していれば当たっている
        return collisionX && collisionY;
    }

    @Override
    public void hitEvent(MoveObject obj){
        float otherX = obj.GetStageX();
        float otherY = obj.GetStageY();
        float otherWidth = obj.GetHitBoxWidth();
        float otherHeight = obj.GetHitBoxHeight();
        // ここで押し戻す処理を記述
        // 例えば、接触した方向に対して座標を調整するなどの処理を行う
        // この例では、単純にX軸とY軸それぞれでオブジェクトを押し戻しています
        float overlapX = (this.stageX + this.hitboxWidth / 2) - (otherX + otherWidth / 2);
        float overlapY = (this.stageY + this.hitboxHeight / 2) - (otherY + otherHeight / 2);

        if (Math.abs(overlapX) > Math.abs(overlapY)) {
            // X軸方向へ押し戻す
            float moveX = hitboxWidth/2 + otherWidth /2 - Math.abs(overlapX);
            if (overlapX > 0) {
                obj.SetStageLocate(otherX - moveX, otherY);
            } else {
                obj.SetStageLocate(otherX + moveX, otherY);
            }
        } else {
            // Y軸方向へ押し戻す
            float moveY = hitboxHeight/2 + otherHeight /2 - Math.abs(overlapY);
            if (overlapY > 0) {
                obj.SetStageLocate(otherX, otherY - moveY);
                obj.setFalling(false);
                obj.setJamping(false);
            } else {
                obj.SetStageLocate(otherX, otherY + moveY);
                obj.SetVelocity(obj.GetVelocityX(), 0);
            }
        }
    }

    @Override
    public void update(){
        float sx = GameManager.GetPlayerStagelocateX();
        float sy = GameManager.GetPlayerStagelocateY();
        float lx = GameManager.GetPlayerLocateX();
        float ly = GameManager.GetPlayerLocateY();
        locateX = stageX - sx + lx;
        locateY = stageY - sy + ly;
    }

    @Override
    public Image GetImage(){
        return nowImage;
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(nowImage, (int) locateX, (int) locateY, (int) sizeX, (int) sizeY, null);
    }
}