package bo.ucb.edu.medichub.bl;

import bo.ucb.edu.medichub.dao.CardDao;
import bo.ucb.edu.medichub.dao.TransactionDao;
import bo.ucb.edu.medichub.dto.CardRequest;
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

    public CardRequest createCard(CardRequest cardRequest, Transaction transaction) {
        Card card=new Card();
        card.setClientId(cardRequest.getClientId());
        card.setAccountNumber(cardRequest.getAccountNumber());
        card.setBank(cardRequest.getBank());
        card.setTypeAccount(cardRequest.getTypeAccount());
        card.setCvvCode(cardRequest.getCvvCode());
        card.setMonth(cardRequest.getMonth());
        card.setYear(cardRequest.getYear());
        card.setTransaction(transaction);
        cardDao.createCard(card);
        return cardRequest;
    }

    public CardRequest updateCard(CardRequest cardRequest, Transaction transaction) {
        Card card=new Card();
        card.setCardId(cardRequest.getCardId());
        card.setAccountNumber(cardRequest.getAccountNumber());
        card.setBank(cardRequest.getBank());
        card.setTypeAccount(cardRequest.getTypeAccount());
        card.setCvvCode(cardRequest.getCvvCode());
        card.setMonth(cardRequest.getMonth());
        card.setYear(cardRequest.getYear());
        card.setTransaction(transaction);
        cardDao.updateCard(card);
        return cardRequest;
    }

    public void deleteCard(Integer cardId, Transaction transaction) {
        Card card = new Card();
        card.setStatus(0);
        card.setCardId(cardId);
        card.setTransaction(transaction);
        cardDao.deleteCard(card);
    }


}
