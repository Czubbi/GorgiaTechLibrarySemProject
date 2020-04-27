package GTL_API.Services;

import GTL_API.Models.CreationModels.CardCreation;
import GTL_API.Models.Entities.CardEntity;
import GTL_API.Models.ReturnModels.CardReturn;
import GTL_API.Repositories.ICardCustom;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;
@Service
public class CardService implements ICardService {

    private ICardCustom cardRepository;

    private ModelMapper modelMapper;

    private static final int MINIMAL_VALUE = 1000000000;

    private static final int MAXIMAL_VALUE = 2147483647;


    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Autowired
    public void setCardRepository(ICardCustom cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public CardReturn findCardByNumber(int number) {
        CardReturn found = cardRepository.findCardByNumber(number);
        return found;
    }

    @Override
    public CardReturn createCard(CardCreation cardCreation) {
        boolean isNotValid = true;
        int generatedNumber = 0;
        while (isNotValid) {
            int generatedCardNumber = generateNumber();
            boolean exists = validateCardNumber(generatedCardNumber);
            if (!exists) {
                isNotValid = false;
                generatedNumber = generatedCardNumber;
            }
        }
        cardCreation.setNumber(generatedNumber);
        CardReturn created = cardRepository.createCard(modelMapper.map(cardCreation, CardEntity.class));
        return created;
    }

    @Override
    public String deleteCard(int number) {
        boolean result = cardRepository.deleteCard(number);
        if(result){
            return String.format("Card with number: %d was successfully deleted", number);
        }else{
            return String.format("Card with number: %d was not deleted", number);
        }
    }

    private int generateNumber() {
        return new Random().nextInt((MAXIMAL_VALUE - MINIMAL_VALUE) + 1) + MINIMAL_VALUE;
    }

    private boolean validateCardNumber(int number) {
        return cardRepository.checkIfExistsByCardNumber(number);
    }
}
