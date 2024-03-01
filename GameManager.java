import java.util.Timer;
import java.util.TimerTask;

class GameManager extends Observable{
    // タイマー(UpdateStage用)
    protected Timer timer;

    // ステージ系の変数
    static DefaultStage stagedata;
    static float stageWidth;
    static float stageHeight;
    static float blockSize;
    static int colBlockNum;
    static int rowBlockNum;
    static DefaultObject[][] stage;
    protected DefaultBackGround BG;

    // プレイヤーキャラクター用の変数
    static PlayerCharacter player;
    static float playerStageX;
    static float playerStageY;
    static float playerLocateX;
    static float playerLocateY;

    // ゲームの状態用の変数（ゲーム中 or ゲームクリア or ゲームオーバー）
    protected int gameState; // 0:ゲーム中, 1:クリア, 2:ゲームオーバー
    ViewControll viewControll;

    // PlayerCharacterを取得する関数
    public PlayerCharacter GetPlayer(){
        return player;
    }

    // BackGroundを取得する関数
    public DefaultBackGround GetBG(){
        return BG;
    }

    // プレイヤーキャラクターのステージ上の位置を格納する
    static void SetPlayerStageLocate(float x, float y){
        playerStageX = x;
        playerStageY = y;
    }

    // プレイヤーキャラクターの画面上の位置を格納する
    static void SetPlayerLocate(float x, float y){
        playerLocateX = x;
        playerLocateY = y;
    }

    static float GetPlayerStagelocateX(){
        return playerStageX;
    }

    static float GetPlayerStagelocateY(){
        return playerStageY;
    }

    static float GetPlayerLocateX(){
        return playerLocateX;
    }

    static float GetPlayerLocateY(){
        return playerLocateY;
    }

    public DefaultObject[][] GetStageObjects(){
        return stage;
    }

    public int GetColBlockNum(){
        return colBlockNum;
    }

    public int GetRowBlockNum(){
        return rowBlockNum;
    }

    public int GetGameState(){
        return gameState;
    }

    public void SetGameState(int gs){
        gameState = gs;
    }

    public void Move(int n){
        switch (n) {
            case 1: // 右に移動
                player.MoveRight();
                System.out.println("Right");
                break;
            case 2: // 左に移動
                player.MoveLeft();
                System.out.println("Left");
                break;
            case 3: // ジャンプ
                player.Jump();
                System.out.println("Jump");
                break;
            default:
                player.MoveStop();
                break;
        }
    }

    // ステージの構築
    public void CreateStage(int stagecode){
        this.SetGameState(0);
        switch (stagecode) {
            case 1:
                stagedata = new DefaultStage("lib\\Map1.txt");
                break;
            case 2:
                stagedata = new DefaultStage("lib\\Map2.txt");
                break;
            case 3:
                stagedata = new DefaultStage("lib\\Map3.txt");
                break;
            default:
                stagedata = new DefaultStage("lib\\Map1.txt");
                break;
        }
        stageHeight = stagedata.GetStageHeight();
        stageWidth = stagedata.GetStageWidth();
        blockSize = stagedata.GetBlockSize();
        colBlockNum = (int)(stageHeight / blockSize);
        rowBlockNum = (int)(stageWidth / blockSize);
        stage = new DefaultObject[colBlockNum][rowBlockNum];
        for(int i = 0; i < colBlockNum; i++){
            for(int j = 0; j < rowBlockNum; j++){
                switch (stagedata.GetBlockData(i, j)) {
                    case "#":
                        stage[i][j] = new BlockObject(j * blockSize, i * blockSize);
                        break;
                    case "=":
                        stage[i][j] = new Block1_Ground(j * blockSize, i * blockSize);
                        break;
                    case "a":
                        stage[i][j] = new Block2_Damage(j * blockSize, i * blockSize);
                        break;
                    case "g":
                        stage[i][j] = new Block3_Goal(j * blockSize, i * blockSize);
                        break;
                    default:
                        stage[i][j] = new DefaultObject(j * blockSize, i * blockSize);
                        break;
                }
            }
        }
        player = new PlayerCharacter(stagedata.GetPlayerStartX(), stagedata.GetPlayerStartY());
        player.SetLocate(stagedata.GetPlayerStartX(), stagedata.GetPlayerStartY());
        player.setFalling(true);
        BG = new DefaultBackGround(0, 0);
        timer = new Timer();
        timer.schedule(new UpdateTask(), 0, 10);
    }

    public void updateStage(){
        player.update();
        playerLocateX = player.GetLocateX();
        playerLocateY = player.GetLocateY();
        playerStageX = player.GetStageX();
        playerStageY = player.GetStageY();

        // 配列stage[col:縦][row:横]の index と整合性が取れるように i に stageY, j に stageX を対応させる
        int i = (int)playerStageY / 40;
        int j = (int)playerStageX / 40;

        if((i >= 0 && i < colBlockNum) && (j >= 0 && j < rowBlockNum)){
            boolean isFall = true;
            // player の接している位置にあるオブジェクトについて接触判定と接触処理を実行
            if(stage[i+1][j+1].isHit(player) == true){
                stage[i+1][j+1].hitEvent(player);
                player.setOnBlockXY();
                isFall = false;
            }
            if(stage[i+1][j].isHit(player) == true){
                stage[i+1][j].hitEvent(player);
                player.setOnBlockXY();
                isFall = false;
            }
            if(stage[i][j+1].isHit(player) == true){
                stage[i][j+1].hitEvent(player);
            }
            if(stage[i][j].isHit(player) == true){
                stage[i][j].hitEvent(player);
            }
            if(player.IsFalling() == false && isFall == true){
                player.setFalling(true);
            }
        }

        playerStageX = player.GetStageX();
        playerStageY = player.GetStageY();

        // 画面サイズ 横800×縦600 を想定
        if(playerStageX < 400){
            playerLocateX = playerStageX;
        } else if (stageWidth - playerStageX < 400){
            playerLocateX = 800 - stageWidth + playerStageX;
        } else {
            playerLocateX = 400;
        }
        if(playerStageY < 300){
            playerLocateY = playerStageY;
        } else if (stageHeight - playerStageY < 300){
            playerLocateY = 600 - stageHeight + playerStageY;
        } else {
            playerLocateY = 300;
        }

        //
        player.SetLocate(playerLocateX, playerLocateY);

        //
        for(int k = 0; k < colBlockNum; k++){
            for(int l = 0; l < rowBlockNum; l++){
                stage[k][l].update();
            }
        }

        this.SetGameState(player.GetGameState());
        setChanged();
        notifyObservers();
    }

    public void gameClearEvent(){
        setChanged();
        notifyObservers();
    }

    public void gameOverEvent(){
        setChanged();
        notifyObservers();
    }

    private class UpdateTask extends TimerTask {
        @Override
        public void run() {
            if(gameState == 0){
                updateStage(); // Timerによって定期的に呼び出されるメソッド
            } else if(gameState == 1){
                gameClearEvent();
                timer.cancel();
            } else {
                gameOverEvent();
                timer.cancel();
            }
        }
    }
}