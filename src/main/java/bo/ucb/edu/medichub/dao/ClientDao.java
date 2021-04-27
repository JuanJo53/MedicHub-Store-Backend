package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.dto.*;
import bo.ucb.edu.medichub.model.Client;
import bo.ucb.edu.medichub.model.Pharmacy;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ClientDao {

    public void createClient(Client client);
    public void updateClient(Client client);
    public Integer getPersonId(Client client);
    public List<ClientListRequest> getClientsOrderById(Integer page, Integer size);
    public List<ClientListRequest> getClientsOrderByIdDesc(Integer page, Integer size);
    public List<ClientListRequest> getClientsOrderByUsername(Integer page, Integer size);
    public List<ClientListRequest> getClientsOrderByUsernameDesc(Integer page, Integer size);
    public List<ClientListRequest> getClientsOrderByEmail(Integer page, Integer size);
    public List<ClientListRequest> getClientsOrderByEmailDesc(Integer page, Integer size);
    public void deleteClient(Client client);

    public Integer getClientTotal();

    public Integer getAddressId(Client client);

    public ClientRequest getClient(Integer idClient);

    public List<CardRequest> getCards(Integer clientId);

    public String passwordClient(Integer clientId);

    public void passwordNewClient(Integer clientId, String passwordNew);

    public void passwordNewClient(PasswordRequest clientPasswordReques);

    public void updateImage(Client client);
}
