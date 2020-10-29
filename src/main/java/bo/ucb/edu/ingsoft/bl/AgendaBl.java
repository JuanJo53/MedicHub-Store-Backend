package bo.ucb.edu.ingsoft.bl;

import bo.ucb.edu.ingsoft.dao.ContactDao;
import bo.ucb.edu.ingsoft.dao.TransactionDao;
import bo.ucb.edu.ingsoft.dto.Contact;
import bo.ucb.edu.ingsoft.dto.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaBl {
    private ContactDao contactDao;
    private TransactionDao transactionDao;
    @Autowired
    public AgendaBl(ContactDao contactDao, TransactionDao transactionDao) {

        this.contactDao = contactDao;
        this.transactionDao = transactionDao;
    }

    public Contact findContactById(Integer contactId) {
        return  contactDao.findByContactId(contactId);
    }

    public Contact createContact(Contact contact, Transaction transaction) {
        contact.setTxId(transaction.getTxId());
        contact.setTxUserId(transaction.getTxUserId());
        contact.setTxHost(transaction.getTxHost());
        contact.setTxDate(transaction.getTxDate());
        contactDao.create(contact);
        Integer getLastId = transactionDao.getLastInsertId();
        contact.setContactId(getLastId);
        return contact;
    }
}
