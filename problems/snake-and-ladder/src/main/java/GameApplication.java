import service.GameService;

public class GameApplication {
    public static void main(String[] args) {
        GameService gameService = new GameService();
        gameService.startGame();
    }
}
