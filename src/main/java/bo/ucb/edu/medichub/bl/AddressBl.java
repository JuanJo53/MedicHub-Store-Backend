package bo.ucb.edu.medichub.bl;

import bo.ucb.edu.medichub.dao.AddressDao;
import bo.ucb.edu.medichub.dao.ClientDao;
import bo.ucb.edu.medichub.dao.PersonDao;
import bo.ucb.edu.medichub.dao.TransactionDao;
import bo.ucb.edu.medichub.dto.AddressRequest;
import bo.ucb.edu.medichub.model.Address;
import bo.ucb.edu.medichub.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AddressBl {
    private AddressDao addressDao;
    private TransactionDao transactionDao;

    private static final Logger LOGGER = LoggerFactory.getLogger(PharmacyAdminBl.class);

    @Autowired
    public AddressBl(AddressDao addressDao, TransactionDao transactionDao) {
        this.transactionDao = transactionDao;
        this.addressDao = addressDao;
    }


    public AddressRequest updateAddress(AddressRequest addressRequest, Transaction transaction) {
        Address address=new Address();
        address.setAddressId(addressRequest.getAddresId());
        address.setNumber(addressRequest.getNumber());
        address.setStreet(addressRequest.getStreet());
        address.setZone(addressRequest.getZone());
        address.setCity(addressRequest.getCity());
        address.setCountry(addressRequest.getCountry());
        address.setTransaction(transaction);
        addressDao.updateAddress(address);
        return addressRequest;
    }

    public AddressRequest getAddressByPerson(Integer clientId){
        AddressRequest address =  addressDao.getAddressByPerson(clientId);
        return address;
    }
}
