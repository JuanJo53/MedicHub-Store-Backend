package bo.ucb.edu.medichub.api;

import bo.ucb.edu.medichub.bl.DoseTypeBl;
import bo.ucb.edu.medichub.bl.TransactionBl;
import bo.ucb.edu.medichub.dto.DoseTypeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/doseType")
public class DoseTypeApi {
    private DoseTypeBl doseTypeBl;
    private TransactionBl transactionBl;

    @Autowired
    public DoseTypeApi(DoseTypeBl doseTypeBl, TransactionBl transactionBl) {
        this.doseTypeBl = doseTypeBl;
        this.transactionBl = transactionBl;
    }

    @GetMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public List<DoseTypeRequest> listDoseType(){
        List<DoseTypeRequest> list = doseTypeBl.listDoseType();
        return list;
    }
}
