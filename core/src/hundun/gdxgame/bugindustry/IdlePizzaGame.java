package hundun.gdxgame.bugindustry;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import hundun.gdxgame.bugindustry.logic.ConstructionId;
import hundun.gdxgame.bugindustry.logic.BuiltinConstructionsLoader;
import hundun.gdxgame.bugindustry.logic.GameArea;
import hundun.gdxgame.bugindustry.logic.GameDictionary;
import hundun.gdxgame.bugindustry.logic.TextureManager;
import hundun.gdxgame.bugindustry.ui.screen.PlayScreen;
import hundun.gdxgame.bugindustry.ui.screen.MenuScreen;
import hundun.gdxgame.bugindustry.ui.screen.ScreenContext;
import hundun.gdxgame.idleframe.BaseIdleGame;
import hundun.gdxgame.idleframe.data.ChildGameConfig;
import hundun.gdxgame.idleframe.model.construction.BaseConstructionFactory;
import lombok.Getter;

public class IdlePizzaGame extends BaseIdleGame {

    @Getter
    private TextureManager textureManager;
    
    @Getter
    private ScreenContext screenContext;
    
    @Getter
    private GameDictionary gameDictionary;
    
    ;
    
    public IdlePizzaGame() {
        super(640, 480);
        drawGameImageAndPlayAudio = false;
    }
    
    @Override
    protected ChildGameConfig getChildGameConfig() {
        return new IdlePizzaGameConfig(this);
    }
    
    @Override
    public void create () {
        super.create();
       
        setScreen(screenContext.getMenuScreen());
        getAudioPlayManager().intoMenu();
    }
    
    @Override
    protected void initContexts() {
        super.initContexts();
        
        this.gameDictionary = new GameDictionary();
        this.textureManager = new TextureManager();
        
        this.screenContext = new ScreenContext();
        screenContext.setMenuScreen(new MenuScreen(this));
        screenContext.setGameBeeScreen(new PlayScreen(this));
    }
    
}
