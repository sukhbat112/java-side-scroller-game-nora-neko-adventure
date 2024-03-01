import java.awt.*;
import java.io.*;

import javax.imageio.ImageIO;

public class DefaultBackGround extends DefaultObject{
    protected float blockSize;
    protected String imageFilePath = "lib\\DefaultBG.jpg";
    
    public DefaultBackGround(float x, float y){
        super(x,y);
        isVisible = true;
        this.SetSize(800, 600);
        this.SetVisible(true);
        try {
            nowImage = ImageIO.read(new File(imageFilePath));
        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawImage(nowImage, (int) locateX, (int) locateY, (int) sizeX, (int) sizeY, null);
    }
}
