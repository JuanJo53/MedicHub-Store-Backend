package bo.ucb.edu.medichub.bl;

import bo.ucb.edu.medichub.dao.AddressDao;
import bo.ucb.edu.medichub.dao.SubsidiaryDao;
import bo.ucb.edu.medichub.dao.TransactionDao;
import bo.ucb.edu.medichub.dto.PersonListRequest;
import bo.ucb.edu.medichub.dto.ProductListRequest;
import bo.ucb.edu.medichub.dto.SubsidiaryRequest;
import bo.ucb.edu.medichub.model.Address;
import bo.ucb.edu.medichub.model.Pharmacy;
import bo.ucb.edu.medichub.model.Subsidiary;
import bo.ucb.edu.medichub.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubsidiaryBl {
    private SubsidiaryDao subsidiaryDao;
    private AddressDao addressDao;
    private TransactionDao transactionDao;

    @Autowired
    public SubsidiaryBl(SubsidiaryDao subsidiaryDao, AddressDao addressDao, TransactionDao transactionDao) {
        this.subsidiaryDao = subsidiaryDao;
        this.addressDao = addressDao;
        this.transactionDao = transactionDao;
    }

    public SubsidiaryRequest createSubsidiary(SubsidiaryRequest subsidiaryRequest, Transaction transaction){
        Subsidiary subsidiary = new Subsidiary();
        Address address = new Address();

        address.setNumber(subsidiaryRequest.getNumber());
        address.setStreet(subsidiaryRequest.getStreet());
        address.setZone(subsidiaryRequest.getZone());
        address.setCity(subsidiaryRequest.getCity());
        address.setCountry(subsidiaryRequest.getCountry());
        address.setTransaction(transaction);
        addressDao.createAddress(address);
        Integer getLastIdAddress = transactionDao.getLastInsertId();

        subsidiary.setPharmacyId(subsidiaryRequest.getPharmacyId());
        subsidiary.setAddressId(getLastIdAddress);
        subsidiary.setSubsidiaryName(subsidiaryRequest.getSubsidiaryName());
        subsidiary.setPhone(subsidiaryRequest.getPhone());
        subsidiary.setEmail(subsidiaryRequest.getEmail());
        subsidiary.setTransaction(transaction);
        subsidiaryDao.createSubsidiary(subsidiary);

        return subsidiaryRequest;
    }


    public SubsidiaryRequest updateSubsidiary(SubsidiaryRequest subsidiaryRequest, Transaction transaction){
        Subsidiary subsidiary = new Subsidiary();
        Address address = new Address();

        address.setAddressId(subsidiaryRequest.getAddressId());
        address.setNumber(subsidiaryRequest.getNumber());
        address.setStreet(subsidiaryRequest.getStreet());
        address.setZone(subsidiaryRequest.getZone());
        address.setCity(subsidiaryRequest.getCity());
        address.setCountry(subsidiaryRequest.getCountry());
        address.setTransaction(transaction);
        addressDao.updateAddress(address);

        subsidiary.setAddressId(subsidiaryRequest.getAddressId());
        subsidiary.setSubsidiaryId(subsidiaryRequest.getSubsidiaryId());
        subsidiary.setPharmacyId(subsidiaryRequest.getPharmacyId());
        subsidiary.setSubsidiaryName(subsidiaryRequest.getSubsidiaryName());
        subsidiary.setPhone(subsidiaryRequest.getPhone());
        subsidiary.setEmail(subsidiaryRequest.getEmail());
        subsidiary.setTransaction(transaction);
        subsidiaryDao.updateSubsidiary(subsidiary);

        return subsidiaryRequest;
    }

    public void deletePharmacy(Integer addressId, Transaction transaction){
        Subsidiary subsidiary = new Subsidiary();
        Address address = new Address();

        subsidiary.setStatus(0);
        subsidiary.setAddressId(addressId);
        subsidiary.setTransaction(transaction);
        subsidiaryDao.deleteSubsidiary(subsidiary);

        address.setStatus(0);
        address.setAddressId(addressId);
        address.setTransaction(transaction);
        addressDao.deleteAddress(address);

    }

    public SubsidiaryRequest findSubsidiaryById(Integer subsidiaryId){
        SubsidiaryRequest subsidiaryRequest = subsidiaryDao.findSubsidiaryById(subsidiaryId);
        return subsidiaryRequest;
    }

    public List<ProductListRequest> getProductsBySubsidiary(Integer subsidiaryId){
        List<ProductListRequest> products = subsidiaryDao.getProductsBySubsidiary(subsidiaryId);
        return products;
    }

    public List<PersonListRequest> getAdminsBySubsidiary(Integer subsidiaryId){
        List<PersonListRequest> admins = subsidiaryDao.getAdminsBySubsidiary(subsidiaryId);
        return  admins;
    }
}
