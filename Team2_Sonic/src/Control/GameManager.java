package Control;

import java.util.Stack;
import View.*;
/**
 * Created by DuongPTIT14 on 3/19/2016.
 */

public class GameManager {
    public Stack<Scene> stackMenuGame;
    private static GameManager ourInstance = new GameManager();

    public static GameManager getInstance() {
        return ourInstance;
    }

    private GameManager() {
        stackMenuGame = new Stack<Scene>();
    }
}

