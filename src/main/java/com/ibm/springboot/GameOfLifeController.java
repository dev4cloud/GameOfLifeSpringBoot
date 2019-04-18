package com.ibm.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.ibm.gol.GameConfig;
import com.ibm.gol.GameController;
import com.ibm.gol.Generation;

@Controller
public class GameOfLifeController {
	
    @Autowired
    private SimpMessagingTemplate template;
	
	@MessageMapping("/generations")
	public void getData(GameConfig game)  {
		game.setGridDimensions(game.getRows(),8);
		game.setAliveCell(1,5);
		game.setAliveCell(2,5);
		game.setAliveCell(2,4);
		GameController controller = new GameController(game);
		Generation gen1 = controller.getFirstGeneration();
		template.convertAndSend("/topic/gameOfLife", gen1);
		Generation gen2 = controller.nextGeneration();
		template.convertAndSend("/topic/gameOfLife", gen2);
////		setup.setGenerations(game.getGenerations());
//
//			@Override
//			public void draw(Grid grid, int generation) {
//				template.convertAndSend("/topic/gameOfLife", grid);
//				
//			}});
//		
//		useCase.run();
		
	}

}
