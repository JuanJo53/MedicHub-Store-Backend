package bo.ucb.edu.ingsoft.dao;

import bo.ucb.edu.ingsoft.model.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminDao {
    public void createAdmin(Admin admin);
}
