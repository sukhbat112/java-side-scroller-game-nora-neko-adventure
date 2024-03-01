import java.awt.*;
import java.io.*;
 
import javax.imageio.*;

// playerが操作するキャラクターのクラス
public class PlayerCharacter extends MoveObject{
    // プレイヤーキャラクターの画像を格納する変数
    protected Image nowImage;
    protected Image idleImageRight;
    protected Image idleImageLeft;
    protected Image walkImage1Right;
    protected Image walkImage1Left;
    protected Image walkImage2Right;
    protected Image walkImage2Left;
    protected Image jumpImageRight;
    protected Image jumpImageLeft;
    protected Image fallImageRight;
    protected Image fallImageLeft;

    // プレイヤーキャラクターのステータス
    protected static final float moveVelocity = 400; // プレイヤーキャラクターの横方向の速度
    protected static final float jumpVelocity = 1000; // プレイヤーキャラクターの縦方向の速度
    protected static final float fallAcceleration = 35; // 重力加速度
    protected boolean directRight; // プレイヤーキャラクターの向き. true:right, false:left. 
    protected boolean onBlock; // プレイヤーキャラクターがブロックの上にいるか(アニメーションを破綻なく動かすための苦肉の策)
    protected float onBlockX; // プレイヤーキャラクターがブロックの上にいるときのブロックの x 座標
    protected float onBlockY; // プレイヤーキャラクターがブロックの上にいるときのブロックの y 座標

    // プレイヤーキャラクターのファイルの位置
    protected String imageFilePathIdleRight = "lib\\Cat1.png";
    protected String imageFilePathIdleLeft = "lib\\Cat2.png";
    protected String imageFilePathWalk1Right = "lib\\Cat3.png";
    protected String imageFilePathWalk1Left = "lib\\Cat5.png";
    protected String imageFilePathWalk2Right = "lib\\Cat4.png";
    protected String imageFilePathWalk2Left = "lib\\Cat6.png";
    protected String imageFilePathJumpRight = "lib\\Cat7.png";
    protected String imageFilePathJumpLeft = "lib\\Cat8.png";
    protected String imageFilePathFallRight = "lib\\Cat9.png";
    protected String imageFilePathFallLeft = "lib\\Cat10.png";
    
    
    public PlayerCharacter(float x, float y){
        super(x, y);
        locateX = x;
        locateY = y;
        this.SetSize(40, 40);
        this.SetVisible(true);
        this.SetHitBox(40, 40);
        onBlock = false;
        onBlockX = 0;
        onBlockY = 0;
        try {
            idleImageRight = ImageIO.read(new File(imageFilePathIdleRight));
            idleImageLeft = ImageIO.read(new File(imageFilePathIdleLeft));
            walkImage1Right = ImageIO.read(new File(imageFilePathWalk1Right));
            walkImage1Left = ImageIO.read(new File(imageFilePathWalk1Left));
            walkImage2Right = ImageIO.read(new File(imageFilePathWalk2Right));
            walkImage2Left = ImageIO.read(new File(imageFilePathWalk2Left));
            jumpImageRight = ImageIO.read(new File(imageFilePathJumpRight));
            jumpImageLeft = ImageIO.read(new File(imageFilePathJumpLeft));
            fallImageRight = ImageIO.read(new File(imageFilePathFallRight));
            fallImageLeft = ImageIO.read(new File(imageFilePathFallLeft));
        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
        nowImage = idleImageRight;
    }

    public void MoveRight(){
        velocityX = moveVelocity;
    }

    public void MoveLeft(){
        velocityX = - moveVelocity;
    }

    public void MoveStop(){
        velocityX = 0;
    }

    public void Jump(){
        if(isJamping == false){
            velocityY = - jumpVelocity;
            isFalling = true;
            isJamping = true;
        }
    }

    public void setOnBlockXY() {
        onBlockX = stageX;
        onBlockY = stageY + 40;
    }

    @Override
    public void update(){
        stageX += velocityX/100;
        if(isFalling == true){
            if(velocityY > 1000){
                velocityY = 1000;
            } else {
                velocityY += fallAcceleration;
            }
            stageY += velocityY/100;
        } else{
            velocityY = 0;
            stageY += 0;
        }
        if(velocityX > 0){
            directRight = true;
        } else if(velocityX < 0) {
            directRight = false;
        }

        if((stageX < onBlockX-45) || (stageX > onBlockX+45) || (stageY < onBlockY-42) || (stageY > onBlockY-38)){
            if(velocityY > 0){
                if(directRight == true){
                    nowImage = fallImageRight;
                } else {
                    nowImage = fallImageLeft;
                }
            } else {
                if(directRight == true){
                    nowImage = jumpImageRight;
                } else {
                    nowImage = jumpImageLeft;
                }
            }
        } else {
            if(velocityX > 0){
                if(nowImage == walkImage1Right){
                    nowImage = walkImage2Right;
                } else{
                    nowImage = walkImage1Right;
                } 
            } else if(velocityX < 0){
                if(nowImage == walkImage1Left){
                    nowImage = walkImage2Left;
                } else{
                    nowImage = walkImage1Left;
                } 
            } else {
                if(directRight == true){
                    nowImage = idleImageRight;
                } else {
                    nowImage = idleImageLeft;
                }
            }
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(nowImage, (int) locateX, (int) locateY, (int) sizeX, (int) sizeY, null);
    }
}