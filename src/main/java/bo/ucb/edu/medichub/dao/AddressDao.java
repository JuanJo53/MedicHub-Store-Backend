package bo.ucb.edu.medichub.dao;

import bo.ucb.edu.medichub.dto.AddressRequest;
import bo.ucb.edu.medichub.model.Address;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressDao {

    public void createAddress(Address address);

    public void updateAddress(Address address);

    public void deleteAddress(Address address);

    public AddressRequest getAddressByPerson(Integer clientId);

}
