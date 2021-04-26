package bo.ucb.edu.medichub.bl;

import bo.ucb.edu.medichub.dao.DoseTypeDao;
import bo.ucb.edu.medichub.dao.TransactionDao;
import bo.ucb.edu.medichub.dto.DoseTypeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DoseTypeBl {
    private DoseTypeDao doseTypeDao;
    private TransactionDao transactionDao;

    @Autowired
    public DoseTypeBl(DoseTypeDao doseTypeDao, TransactionDao transactionDao) {
        this.doseTypeDao = doseTypeDao;
        this.transactionDao = transactionDao;
    }

    public List<DoseTypeRequest> listDoseType(){
        List<DoseTypeRequest> list = doseTypeDao.listDoseType();
        return list;
    }
}
