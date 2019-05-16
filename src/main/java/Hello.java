import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.ibm.gol.GameConfig;
import com.ibm.gol.GameController;
import com.ibm.gol.Generation;

public class Hello {	
	public static JsonObject main(JsonObject args) {
		
		GameConfig game = new GameConfig();
		game.setGridDimensions(game.getRows(),8);
		game.setAliveCell(1,5);
		game.setAliveCell(2,5);
		game.setAliveCell(2,4);
		GameController controller = new GameController(game);
		Generation gen1 = controller.getFirstGeneration();
		
		return (JsonObject) new Gson().toJsonTree(gen1);
	}

}
