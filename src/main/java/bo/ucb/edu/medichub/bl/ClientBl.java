package bo.ucb.edu.medichub.bl;


import bo.ucb.edu.medichub.dao.*;
import bo.ucb.edu.medichub.dto.CardRequest;
import bo.ucb.edu.medichub.dto.ClientListRequest;
import bo.ucb.edu.medichub.dto.ClientRequest;
import bo.ucb.edu.medichub.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClientBl {
    private ClientDao clientDao;
    private PersonDao personDao;
    private AddressDao addressDao;
    private TransactionDao transactionDao;
    private AuthDao authDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(PharmacyAdminBl.class);

    @Autowired
    public ClientBl(ClientDao clientDao, PersonDao personDao, AddressDao addressDao, TransactionDao transactionDao, AuthDao authDao) {
        this.clientDao = clientDao;
        this.personDao = personDao;
        this.transactionDao = transactionDao;
        this.addressDao = addressDao;
        this.authDao = authDao;
    }



    public ClientRequest createClient(ClientRequest clientRequest, Transaction transaction){
        Client clientprueb = authDao.findClientByEmail(clientRequest.getEmail());
        if(clientprueb==null){
            Person person = new Person();
            Address address = new Address();
            Client client = new Client();

            person.setFirstName(clientRequest.getFirstName());
            person.setFirstSurname(clientRequest.getFirstSurname());
            person.setSecondSurname(clientRequest.getSecondSurname());
            person.setCi(clientRequest.getCi());
            person.setPhone(clientRequest.getPhone());
            person.setTransaction(transaction);
            personDao.createPerson(person);
            Integer getLastIdPerson = transactionDao.getLastInsertId();

            address.setNumber(clientRequest.getNumber());
            address.setStreet(clientRequest.getStreet());
            address.setZone(clientRequest.getZone());
            address.setCity(clientRequest.getCity());
            address.setCountry(clientRequest.getCountry());
            address.setTransaction(transaction);
            addressDao.createAddress(address);
            Integer getLastIdAddress = transactionDao.getLastInsertId();

            client.setPersonId(getLastIdPerson);
            client.setAddressId(getLastIdAddress);
            client.setEmail(clientRequest.getEmail());
            client.setUserName(clientRequest.getUserName());
            client.setPassword(clientRequest.getPassword());
            client.setBirthdate(clientRequest.getBirthdate());
            client.setTransaction(transaction);
            clientDao.createClient(client);

            return clientRequest;
        } else {
            return null;
        }
    }



    public ClientRequest updateClient(ClientRequest clientRequest, Transaction transaction) {
        Client client = new Client();
        Person person = new Person();
        Address address= new Address();

        client.setClientId(clientRequest.getClientId());
        client.setEmail(clientRequest.getEmail());
        client.setUserName(clientRequest.getUserName());
        client.setPassword(clientRequest.getPassword());
        client.setBirthdate(clientRequest.getBirthdate());
        client.setTransaction(transaction);
        clientDao.updateClient(client);
        Integer idPerson = clientDao.getPersonId(client);

        person.setPersonId(idPerson);
        person.setFirstName(clientRequest.getFirstName());
        person.setFirstSurname(clientRequest.getFirstSurname());
        person.setSecondSurname(clientRequest.getSecondSurname());
        person.setCi(clientRequest.getCi());
        person.setPhone(clientRequest.getPhone());
        person.setTransaction(transaction);
        personDao.updatePerson(person);

        Integer idAddress = clientDao.getAddressId(client);
        address.setAddressId(idAddress);
        address.setNumber(clientRequest.getNumber());
        address.setStreet(clientRequest.getStreet());
        address.setZone(clientRequest.getZone());
        address.setCity(clientRequest.getCity());
        address.setCountry(clientRequest.getCountry());
        address.setTransaction(transaction);
        addressDao.updateAddress(address);


        return clientRequest;
    }

    public void deleteClient(Integer clientId, Transaction transaction) {
        Client client = new Client();
        client.setStatus(0);
        client.setClientId(clientId);
        client.setTransaction(transaction);
        clientDao.deleteClient(client);
    }

    public List<ClientListRequest> getClients(){
        List<ClientListRequest> clients = clientDao.getClients();
        return clients;
    }



    public ClientRequest getClient(Integer idClient){
        return clientDao.getClient(idClient);
    }



    public List<CardRequest> getCards(Integer clientId){
        List<CardRequest> cards = clientDao.getCards(clientId);
        return cards;
    }
}
