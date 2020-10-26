package br.com.brainweb.interview.core.features.hero;

import br.com.brainweb.interview.model.Hero;

import java.util.List;
import java.util.Optional;



public interface HeroService {


     List<Hero> findAll();

     Optional<Hero> findById(Long id);

     Hero save(Hero stock);

     Optional<Hero> deleteById(Long id);

}
