import java.io.File;

import javax.imageio.ImageIO;

public class Block2_Damage extends BlockObject {
    protected String imageFilePath = "lib\\DamageBlock.png";

    public Block2_Damage(float x, float y){
        super(x,y);
        try {
            nowImage = ImageIO.read(new File(imageFilePath));
        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
    }

    @Override
    public void hitEvent(MoveObject obj){
        obj.SetGameState(2);
    }
}
