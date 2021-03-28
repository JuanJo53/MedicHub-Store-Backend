package bo.ucb.edu.medichub.bl;

import bo.ucb.edu.medichub.dao.CardDao;
import bo.ucb.edu.medichub.dao.TransactionDao;
import bo.ucb.edu.medichub.model.Card;
import bo.ucb.edu.medichub.model.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CardBl {
    private CardDao cardDao;
    private TransactionDao transactionDao;

    @Autowired
    public CardBl(CardDao cardDao, TransactionDao transactionDao) {
        this.cardDao = cardDao;
        this.transactionDao = transactionDao;
    }

    public void deleteCard(Integer cardId, Transaction transaction) {
        Card card = new Card();
        card.setStatus(0);
        card.setCardId(cardId);
        card.setTransaction(transaction);
        cardDao.deleteCard(card);
    }
}
