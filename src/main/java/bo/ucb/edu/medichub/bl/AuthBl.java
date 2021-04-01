/*package bo.ucb.edu.medichub.bl;


import bo.ucb.edu.medichub.dao.AuthDao;
import bo.ucb.edu.medichub.dto.AuthRole;
import bo.ucb.edu.medichub.dto.AuthenticationRequest;
import bo.ucb.edu.medichub.dto.AuthenticationResponse;
import bo.ucb.edu.medichub.util.security.JWTUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class AuthBl implements UserDetailsService {

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JWTUtil jwtUtil;
    @Autowired
    private AuthDao authDao;

    private String password;

    private static final Logger LOGGER = LoggerFactory.getLogger(BankAccountBl.class);
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return new User(username,"{noop}"+ password, new ArrayList<>());
    }

    public ResponseEntity createToken(AuthenticationRequest authenticationRequest){
        if(authenticationRequest.getRole() == 1){
            AuthRole authRole = authDao.getIdAdmin(authenticationRequest.getEmail(), authenticationRequest.getPassword());
            return loadToken(authenticationRequest, authRole);
        } else {
            if(authenticationRequest.getRole() == 2){
                AuthRole authRole = authDao.getIdPharmacyAdmin(authenticationRequest.getEmail(), authenticationRequest.getPassword());
                return loadToken(authenticationRequest, authRole);
            } else {
                if(authenticationRequest.getRole() == 3) {
                    AuthRole authRole= authDao.getIdClient(authenticationRequest.getEmail(), authenticationRequest.getPassword());
                    return loadToken(authenticationRequest, authRole);
                } else {
                    return new ResponseEntity(HttpStatus.UNPROCESSABLE_ENTITY, HttpStatus.UNPROCESSABLE_ENTITY);
                }
            }
        }
    }

    public ResponseEntity loadToken(AuthenticationRequest authenticationRequest, AuthRole authRole){
        if(authRole != null){
            try {
                password = authenticationRequest.getPassword();
                UserDetails userDetails = loadUserByUsername(String.valueOf(authRole.getRoleId()));
                String jwt = jwtUtil.generateToken(userDetails);
                LOGGER.error(jwt);
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getEmail(),
                        authenticationRequest.getPassword()));
                // Cambiar
                AuthenticationResponse authenticationResponse =  new AuthenticationResponse();
                authenticationResponse.setJwt(jwt);
                authenticationResponse.setSubsidiaryId(authRole.getId());
                return new ResponseEntity<>(authenticationResponse, HttpStatus.OK);
            } catch (BadCredentialsException e) {
                return new ResponseEntity(HttpStatus.FORBIDDEN, HttpStatus.FORBIDDEN);
            }
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND, HttpStatus.NOT_FOUND);
        }
    }
}*/
















