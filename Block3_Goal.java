import java.io.File;

import javax.imageio.ImageIO;

public class Block3_Goal extends BlockObject {
    protected String imageFilePath = "lib\\GoalBlock.png";

    public Block3_Goal(float x, float y){
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
        obj.SetGameState(1);
    }
}
