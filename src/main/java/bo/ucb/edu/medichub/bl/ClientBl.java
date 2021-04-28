package bo.ucb.edu.medichub.bl;


import bo.ucb.edu.medichub.dao.*;
import bo.ucb.edu.medichub.dto.CardRequest;
import bo.ucb.edu.medichub.dto.ClientListRequest;
import bo.ucb.edu.medichub.dto.PasswordRequest;
import bo.ucb.edu.medichub.dto.ClientRequest;
import bo.ucb.edu.medichub.model.*;
import bo.ucb.edu.medichub.util.ImageUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClientBl {
    private ClientDao clientDao;
    private PersonDao personDao;
    private AddressDao addressDao;
    private TransactionDao transactionDao;
    private AuthDao authDao;
    private BCryptPasswordEncoder passwordEncoder;

    private static final Logger LOGGER = LoggerFactory.getLogger(PharmacyAdminBl.class);

    @Autowired
    public ClientBl(ClientDao clientDao, PersonDao personDao, AddressDao addressDao, TransactionDao transactionDao, AuthDao authDao,
                    BCryptPasswordEncoder passwordEncoder) {
        this.clientDao = clientDao;
        this.personDao = personDao;
        this.transactionDao = transactionDao;
        this.addressDao = addressDao;
        this.authDao = authDao;
        this.passwordEncoder = passwordEncoder;
    }



    public ClientRequest createClient(ClientRequest clientRequest, Transaction transaction){
        Client clientprueb = authDao.findClientByEmail(clientRequest.getEmail());
        Admin admin = authDao.findAdminByEmail(clientRequest.getEmail());
        PharmacyAdmin pharmacyAdmin = authDao.findPharmacyAdminByEmail(clientRequest.getEmail());
        if(clientprueb==null && admin==null && pharmacyAdmin==null){
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
            String password = passwordEncoder.encode(clientRequest.getPassword());
            client.setPassword(password);
            client.setBirthdate(clientRequest.getBirthdate());
            client.setTransaction(transaction);
            clientDao.createClient(client);

            return clientRequest;
        } else {
            return null;
        }
    }

    //public ClientRequest update
            //(Recibir Dao ID cleinte
    // LA COontraseña actual
    // if (password.equals(passwordID)){
    //            //encrit
    //        }
    // contraseña nueva
    // )
    public PasswordRequest updatepasswordClient(PasswordRequest clientPasswordReques, Transaction transaction) {


        String passwordClient = clientDao.passwordClient(clientPasswordReques.getId());
        if (passwordEncoder.matches(clientPasswordReques.getOldPassword(),passwordClient)){
            String passwordNew = passwordEncoder.encode(clientPasswordReques.getNewPassword());
            clientPasswordReques.setNewPassword(passwordNew);
            clientDao.passwordNewClient(clientPasswordReques);
            return clientPasswordReques;
        }
        else{
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
        //String password = passwordEncoder.encode(clientRequest.getPassword());
        //client.setPassword(password);
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

    public List<ClientListRequest> getClients(Integer page, Integer size, String order, Boolean asc){

        List<ClientListRequest> clients = new ArrayList<>();
        LOGGER.error(String.valueOf(page));
        LOGGER.error(String.valueOf(size));
        LOGGER.error(order);
        LOGGER.error(asc.toString());
        if(order.equals("id") && asc){
            clients = clientDao.getClientsOrderById(page, size);
        }
        if(order.equals("id") && !asc){
            clients = clientDao.getClientsOrderByIdDesc(page, size);
        }
        if(order.equals("username") && asc){
            clients = clientDao.getClientsOrderByUsername(page, size);
        }
        if(order.equals("username") && !asc){
            clients = clientDao.getClientsOrderByUsernameDesc(page, size);
        }
        if(order.equals("email") && asc){
            clients = clientDao.getClientsOrderByEmail(page, size);
        }
        if(order.equals("email") && !asc){
            clients = clientDao.getClientsOrderByEmailDesc(page, size);
        }
        return clients;
    }



    public ClientRequest getClient(Integer idClient){
        return clientDao.getClient(idClient);
    }



    public List<CardRequest> getCards(Integer clientId){
        List<CardRequest> cards = clientDao.getCards(clientId);
        return cards;
    }

    public Integer getClientTotal(){
        Integer cant = clientDao.getClientTotal();
        return cant;
    }

    public void uploadImage(MultipartFile image, Integer clientId, Transaction transaction){
        ImageUtil imageUtil = new ImageUtil();
        Client client = new Client();
        String newImageName = imageUtil.uploadImage(image,"images/clientImage","Client",clientId);
        client.setClientId(clientId);
        client.setPicture(newImageName);
        client.setTransaction(transaction);
        clientDao.updateImage(client);
    }
}
