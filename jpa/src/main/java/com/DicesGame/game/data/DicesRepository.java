package com.DicesGame.game.data;
import org.springframework.data.repository.CrudRepository;
import com.DicesGame.game.data.Dices;
import java.util.List;

// This will be AUTO IMPLEMENTED by Spring into a Bean called PicturesRepository
// CRUD refers Create, Read, Update, Delete

public interface DicesRepository extends CrudRepository<Dices, Integer>
{

}
