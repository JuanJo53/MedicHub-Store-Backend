package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.dto.*;
import bo.ucb.edu.medichub.model.Client;
import bo.ucb.edu.medichub.model.PharmacyAdmin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClientDao {

    public void createClient(Client client);
    public void updateClient(Client client);
    public Integer getPersonId(Client client);
    public List<ClientListRequest> getClients();
    public void deleteClient(Client client);

    public Integer getAddressId(Client client);

    public ClientRequest getClient(Integer idClient);

    public List<CardRequest> getCards(Integer clientId);
}
