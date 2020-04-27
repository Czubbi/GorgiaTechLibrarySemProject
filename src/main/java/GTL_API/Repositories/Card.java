package GTL_API.Repositories;

import GTL_API.Exceptions.NotFoundException;
import GTL_API.Models.Entities.CardEntity;
import GTL_API.Models.ReturnModels.CardReturn;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;


@Component
public class Card implements ICardCustom {
    private ICard cardRepository;

    private ModelMapper modelMapper;

    @Autowired
    public void setCardRepository(ICard cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Autowired
    public void setModelMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;
    }

    @Override
    public CardReturn findCardByNumber(int number) {
        try{
            CardEntity foundCard = findIfExistsAndReturn(number);
            return modelMapper.map(foundCard, CardReturn.class);
        }catch(Exception e){
            throw e;
        }
    }

    @Override
    public CardReturn createCard(CardEntity cardEntity) {
        try{
            CardEntity added = cardRepository.save(cardEntity);
            return modelMapper.map(added, CardReturn.class);
        }catch (Exception e){
            throw e;
        }
    }


    @Override
    public boolean checkIfExistsByCardNumber(int number) {
        try{
            boolean exists = cardRepository.existsByNumber(number);
            return exists;
        }catch (Exception e){
            throw e;
        }
    }

    @Override
    public boolean deleteCard(int number) {
        try{
            CardEntity found = findIfExistsAndReturn(number);
            found.setDeleted(true);
            CardEntity result = cardRepository.save(found);
            boolean isDeleted = result.getDeleted();
            return isDeleted;
        }catch (Exception e){
            throw e;
        }
    }


    private CardEntity findIfExistsAndReturn(int number){
        Optional<CardEntity> foundCard = cardRepository.findByNumberIs(number);
        if(foundCard.isPresent()){
            return foundCard.get();
        }else{
            throw new NotFoundException(String.format("Card with number %s was not found.", number));
        }
    }
}
