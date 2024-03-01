import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

// ステージの設定をするクラス
public class DefaultStage{
    protected float stageWidth;
    protected float stageHeight;
    protected float blockSize = 40;
    protected String[][] stageData;
    protected DefaultObject[][] stage;
    protected String stageFilePath = "lib\\Map1.txt";
    protected float playerStartX = 50;
    protected float playerStartY = 50;

    public DefaultStage(String path){
        try{
            Path file = Paths.get(path);
            List<String> text = Files.readAllLines(file);

            String line = text.get(0);
            String[] splitline = line.split(" ");
            stageHeight = Float.parseFloat(splitline[0]) * blockSize;
            stageWidth = Float.parseFloat(splitline[1]) * blockSize;
            
            int textsizeColumn = Integer.parseInt(splitline[0]) + 1;
            int textsizeRow = Integer.parseInt(splitline[1]);
            stageData = new String[textsizeColumn - 1][textsizeRow];
            for(int i = 1; i < textsizeColumn ; i++){
                line = text.get(i);
                splitline = line.split("");
                int splitlinesize = splitline.length;
                int j;
                for(j = 0; j < splitlinesize; j++){
                    stageData[i-1][j] = splitline[j];
                }
                for(j = splitlinesize; j < textsizeRow; j++){
                    stageData[i-1][j] = " ";
                }
            }
        } catch (Exception e) {
            System.out.println(e);
            System.exit(0);
        }
    }

    public float GetStageWidth(){
        return stageWidth;
    }

    public float GetStageHeight(){
        return stageHeight;
    }

    public float GetBlockSize(){
        return blockSize;
    }

    public String GetBlockData(int col, int row){
        return stageData[col][row];
    }

    public float GetPlayerStartX(){
        return playerStartX;
    }

    public float GetPlayerStartY(){
        return playerStartY;
    }
}