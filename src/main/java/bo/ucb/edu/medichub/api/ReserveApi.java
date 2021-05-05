package bo.ucb.edu.medichub.api;

import bo.ucb.edu.medichub.bl.ReserveBl;
import bo.ucb.edu.medichub.bl.TransactionBl;
import bo.ucb.edu.medichub.dto.ReserveRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RequestMapping(value = "/reserve")
public class ReserveApi {
    private ReserveBl reserveBl;
    private TransactionBl transactionBl;

    @Autowired
    public ReserveApi(ReserveBl reserveBl, TransactionBl transactionBl) {
        this.reserveBl = reserveBl;
        this.transactionBl = transactionBl;
    }

    @RequestMapping(method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ReserveRequest> getPharmacies(@RequestParam Integer page, @RequestParam Integer size,@RequestParam Integer state) {
        List<ReserveRequest> reserve=reserveBl.getListReserve(page,size,state);

        return reserve;
    }

}
