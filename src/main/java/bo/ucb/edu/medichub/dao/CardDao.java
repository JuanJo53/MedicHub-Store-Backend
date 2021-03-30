package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.model.Card;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CardDao {

    public void createCard(Card card);
    public void updateCard(Card card);
    public void deleteCard(Card card);


}
