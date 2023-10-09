package ru.mirea.marketplace.service.impl;

import org.springframework.stereotype.Service;
import ru.mirea.marketplace.DTO.Telephone;
import ru.mirea.marketplace.repository.TelephoneRepository;
import ru.mirea.marketplace.service.TelephoneService;

import java.util.List;
import java.util.Optional;

@Service
public class TelephoneServiceImpl implements TelephoneService {

    private final TelephoneRepository telephoneRepository;

    public TelephoneServiceImpl(TelephoneRepository telephoneRepository) {
        this.telephoneRepository = telephoneRepository;
    }

    public Telephone getOne(Integer id) {
        return this.telephoneRepository.findById(id).orElse(null);
    }

    public List<Telephone> getAll() {
        return this.telephoneRepository.findAll();
    }

    public void create(Telephone telephone) {
        this.telephoneRepository.saveAndFlush(telephone);
    }

    public boolean update(Integer id, Telephone telephone) {
        Optional<Telephone> optionalTelephone = telephoneRepository.findById(id);
        if (optionalTelephone.isPresent()) {
            Telephone oldTelephone = optionalTelephone.get();
            oldTelephone.setProducer(telephone.getProducer());
            oldTelephone.setAccumulatorVolume(telephone.getAccumulatorVolume());
            oldTelephone.setTitle(telephone.getTitle());
            oldTelephone.setSellerId(telephone.getSellerId());
            oldTelephone.setProductType(telephone.getProductType());
            oldTelephone.setPrice(telephone.getPrice());
            this.telephoneRepository.saveAndFlush(oldTelephone);
            return true;
        }
        return false;
    }

    public void delete(Integer id) {
        this.telephoneRepository.deleteById(id);
    }
}
