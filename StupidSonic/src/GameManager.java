import java.util.Stack;

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
