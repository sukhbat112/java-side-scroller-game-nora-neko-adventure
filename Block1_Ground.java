import java.io.File;

import javax.imageio.ImageIO;

public class Block1_Ground extends BlockObject {
    protected String imageFilePath = "lib\\GroundBlock5.png";

    public Block1_Ground(float x, float y){
        super(x,y);
        try {
            nowImage = ImageIO.read(new File(imageFilePath));
        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
    }
}
