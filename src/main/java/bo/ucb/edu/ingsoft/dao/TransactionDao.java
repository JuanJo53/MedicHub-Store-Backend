package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.dto.Transaction;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TransactionDao {
    public Integer create(Transaction transaction);

    public Integer getLastInsertId();
}
