package bo.ucb.edu.medichub.bl;

import bo.ucb.edu.medichub.dao.AddressDao;
import bo.ucb.edu.medichub.dao.AdminDao;
import bo.ucb.edu.medichub.dao.AuthDao;
import bo.ucb.edu.medichub.dao.TransactionDao;
import bo.ucb.edu.medichub.dto.PasswordRequest;
import bo.ucb.edu.medichub.model.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminBl {

    private AdminDao adminDao;
    private TransactionDao transactionDao;
    private AuthDao authDao;
    private BCryptPasswordEncoder passwordEncoder;

    private static final Logger LOGGER = LoggerFactory.getLogger(PharmacyAdminBl.class);

    @Autowired
    public AdminBl(AdminDao adminDao, TransactionDao transactionDao, AuthDao authDao, BCryptPasswordEncoder passwordEncoder) {
        this.adminDao = adminDao;
        this.transactionDao = transactionDao;
        this.authDao = authDao;
        this.passwordEncoder = passwordEncoder;
    }

    public PasswordRequest updatepasswordAdmin(PasswordRequest adminPasswordReques, Transaction transaction) {

        String passwordClient = adminDao.passwordAdmin(adminPasswordReques.getId());
        if (passwordEncoder.matches(adminPasswordReques.getOldPassword(),passwordClient)){
            String passwordNew = passwordEncoder.encode(adminPasswordReques.getNewPassword());
            adminPasswordReques.setNewPassword(passwordNew);
            adminDao.passwordNewAdmin(adminPasswordReques);
            return adminPasswordReques;
        }
        else{
            return null;
        }
    }
}
