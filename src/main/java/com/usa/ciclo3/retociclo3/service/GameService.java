package com.usa.ciclo3.retociclo3.service;

import com.usa.ciclo3.retociclo3.model.Game;
import com.usa.ciclo3.retociclo3.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameService {
    @Autowired
    private GameRepository gameRepository;

    public List<Game> getAll(){
        return gameRepository.getAll();
    }

    public Optional<Game> getGame(int id){
        return gameRepository.getGame(id);
    }

    public Game save(Game game){
      if(game.getId()==null){
         return gameRepository.save(game);
      }else{
          Optional<Game> tmpGame = gameRepository.getGame(game.getId());
          if(tmpGame.isEmpty()) {
              return gameRepository.save(game);
          }else{
              return game;
          }
      }
    }

    public Game update(Game game){
        if(game.getId()!=null){
            Optional<Game> e= gameRepository.getGame(game.getId());
            if(!e.isEmpty()){
                if(game.getName()!=null){
                    e.get().setName(game.getName());
                }
                if(game.getDeveloper()!=null){
                    e.get().setDeveloper(game.getDeveloper()); ;
                }
                if(game.getYear() !=null){
                    e.get().setYear(game.getYear());
                }
                if(game.getDescription()!=null){
                    e.get().setDescription(game.getDescription());
                }
                if(game.getCategory()!=null){
                    e.get().setCategory(game.getCategory());
                }
                gameRepository.save(e.get());
                return e.get();
            }else{
                return game;
            }
        }else{
            return game;
        }
    }

    public boolean deleteGame(int id){
        Boolean aBoolean = getGame(id).map(game -> {
            gameRepository.delete(game);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
