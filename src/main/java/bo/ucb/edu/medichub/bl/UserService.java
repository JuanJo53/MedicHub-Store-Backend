package bo.ucb.edu.medichub.bl;

import bo.ucb.edu.medichub.dao.AuthDao;
import bo.ucb.edu.medichub.dto.AuthenticationRequest;
import bo.ucb.edu.medichub.model.Admin;
import bo.ucb.edu.medichub.model.Client;
import bo.ucb.edu.medichub.model.PharmacyAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private AuthDao authDao;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Admin admin = authDao.findAdminByEmail(username);
        if(admin != null){
            return new User(admin.getEmail(), admin.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_ADMIN")));
        } else {
            PharmacyAdmin pharmacyAdmin = authDao.findPharmacyAdminByEmail(username);
            if(pharmacyAdmin != null){
                return new User(pharmacyAdmin.getEmail(), pharmacyAdmin.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_PHARMACY_ADMIN")));
            } else {
                Client client = authDao.findClientByEmail(username);
                if(client !=  null){
                    return new User(client.getEmail(), client.getPassword(), List.of(new SimpleGrantedAuthority("ROLE_CLIENT")));
                } else {
                    throw new UsernameNotFoundException("User not found");
                }
            }
        }
    }
}
