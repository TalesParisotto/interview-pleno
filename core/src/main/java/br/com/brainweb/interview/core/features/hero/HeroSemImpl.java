package br.com.brainweb.interview.core.features.hero;

import br.com.brainweb.interview.model.Hero;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class HeroSemImpl implements HeroService {

    @Autowired
    private final HeroRepository heroRepository;

    public HeroSemImpl(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @Override
    public List<Hero> findAll() {
        return (List<Hero>) heroRepository.findAll();
    }

    @Override
    public Optional<Hero> findById(Long id) {
        return heroRepository.findById(id);
    }

    @Override
    public Hero save(Hero stock) {
        return heroRepository.save(stock);
    }

    @Override
    public Optional<Hero> deleteById(Long id) {
        heroRepository.deleteById(id);
        return null;
    }
}
