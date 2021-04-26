package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.dto.DoseTypeRequest;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface DoseTypeDao {
    public List<DoseTypeRequest> listDoseType();
}
