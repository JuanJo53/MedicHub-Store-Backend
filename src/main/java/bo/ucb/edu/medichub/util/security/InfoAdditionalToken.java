package bo.ucb.edu.medichub.util.security;

import bo.ucb.edu.medichub.dao.AuthDao;
import bo.ucb.edu.medichub.model.Admin;
import bo.ucb.edu.medichub.model.Client;
import bo.ucb.edu.medichub.model.PharmacyAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.oauth2.common.DefaultOAuth2AccessToken;
import org.springframework.security.oauth2.common.OAuth2AccessToken;
import org.springframework.security.oauth2.provider.OAuth2Authentication;
import org.springframework.security.oauth2.provider.token.TokenEnhancer;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
public class InfoAdditionalToken implements TokenEnhancer {

    @Autowired
    private AuthDao authDao;

    @Override
    public OAuth2AccessToken enhance(OAuth2AccessToken oAuth2AccessToken, OAuth2Authentication oAuth2Authentication) {
        Map<String, Object> info = new HashMap<>();

        Admin admin = authDao.findAdminByEmail(oAuth2Authentication.getName());
        if(admin != null){
            info.put("adminId", admin.getAdminId());
            info.put("email", admin.getEmail());
            info.put("userName", admin.getUserName());
            info.put("role", 1);
        }
        PharmacyAdmin pharmacyAdmin = authDao.findPharmacyAdminByEmail(oAuth2Authentication.getName());
        if(pharmacyAdmin != null){
            info.put("pharmAdminId", pharmacyAdmin.getPharmacyAdminId());
            info.put("subsidiaryId", pharmacyAdmin.getSubsidiaryId());
            info.put("email", pharmacyAdmin.getEmail());
            info.put("userName", pharmacyAdmin.getUserName());
            info.put("role", 2);
        }
        Client client = authDao.findClientByEmail(oAuth2Authentication.getName());
        if(client != null){
            info.put("clientId", client.getClientId());
            info.put("email", client.getEmail());
            info.put("userName", client.getUserName());
            info.put("role", 3);
        }

        //info.put("info_adicional","Cualquier_valor".concat(oAuth2Authentication.getName()));

        ((DefaultOAuth2AccessToken) oAuth2AccessToken).setAdditionalInformation(info);

        return oAuth2AccessToken;
    }
}
