package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.model.Reserve;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ReserveDao {
    public void createReserve(Reserve reserve);
}
