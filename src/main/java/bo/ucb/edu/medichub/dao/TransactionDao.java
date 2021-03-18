package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.model.Transaction;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TransactionDao {
    public Integer create(Transaction transaction);

    public Integer getLastInsertId();
}
