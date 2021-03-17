package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.model.Person;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonDao {
    public void createPerson(Person person);
}
