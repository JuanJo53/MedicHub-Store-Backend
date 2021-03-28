package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.dto.PharmacyAdminRequest;
import bo.ucb.edu.medichub.model.Client;
import bo.ucb.edu.medichub.model.PharmacyAdmin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClientDao {

    public void createClient(Client client);
    public void updateClient(Client client);
    public Integer getPersonId(Client client);


    public void deleteClient(Client client);
}
