package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.dto.ProductReserveRequest;
import bo.ucb.edu.medichub.dto.ReserveRequest;
import bo.ucb.edu.medichub.model.ProductReserve;
import bo.ucb.edu.medichub.model.Reserve;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReserveDao {
    public void createReserve(Reserve reserve);

    public List<ReserveRequest> getListReserve(Integer page, Integer size, Integer state);


    public Integer getLastReserveStatus(Integer clientId);

    public Integer getLastReserveId(Integer clientId);

    public Integer getReserveId(Integer clientId, Integer state);

    public void deleteClientReserve(ProductReserve productReserve);
    public void updateReserveStatus(Reserve reserve);
}
