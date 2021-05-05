package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.dto.ProductReserveRequest;
import bo.ucb.edu.medichub.dto.ReserveRequest;
import bo.ucb.edu.medichub.model.Reserve;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ReserveDao {
    public void createReserve(Reserve reserve);

    public List<ReserveRequest> getListReserve(Integer page, Integer size, Integer state);

    public List<ProductReserveRequest> getListProductReserve(ReserveRequest reserveRequests);

    public Integer getLastReserveStatus(Integer clientId);
}
