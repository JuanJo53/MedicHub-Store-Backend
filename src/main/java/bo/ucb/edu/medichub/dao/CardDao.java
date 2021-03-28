package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.model.Card;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CardDao {
    public void deleteCard(Card card);
}
