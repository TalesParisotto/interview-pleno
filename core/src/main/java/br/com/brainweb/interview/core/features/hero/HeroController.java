package br.com.brainweb.interview.core.features.hero;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import br.com.brainweb.interview.model.Hero;

import java.util.List;
import java.util.Objects;
import java.util.Optional;


@Slf4j
@RestController
@RequestMapping("/api/v1/heroes")
public class HeroController {

    private final HeroService heroService;


    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }


    @GetMapping
    public ResponseEntity<List<Hero>> findAll() {
        return ResponseEntity.ok(heroService.findAll());
    }

    @GetMapping("/{heroId}")
    public ResponseEntity<Hero> findById(@PathVariable Long heroId) {
        Optional<Hero> heroOptional = heroService.findById(heroId);
        if (!heroOptional.isPresent()) {
            log.error("heroId " + heroId + " is not existed");
            ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(heroOptional.get());
    }

    @PostMapping
    public ResponseEntity create(@RequestBody Hero hero) {
        System.out.println("Hero: " + hero.getName() + " race " + hero.getRace());
        return ResponseEntity.status(HttpStatus.CREATED).body(heroService.save(hero));
    }

    @PatchMapping("/{heroId}")
    public ResponseEntity<Hero> update(@PathVariable Long heroId, @RequestBody Hero updatingHero) {
        Optional<Hero> heroOptional = heroService.findById(heroId);
        if (!heroOptional.isPresent()) {
            log.error("herokId " + heroId + " is not existed");
            ResponseEntity.notFound().build();
        }

        Hero Hero = heroOptional.get();
        if (!StringUtils.isEmpty(updatingHero.getName())) Hero.setName(updatingHero.getName());
        if (!Objects.isNull(updatingHero.getRace())) Hero.setRace(updatingHero.getRace());
        if (!Objects.isNull(updatingHero.getCreated_at())) Hero.setCreated_at(updatingHero.getCreated_at());
        if (!Objects.isNull(updatingHero.getEnabled())) Hero.setEnabled(updatingHero.getEnabled());
        if (!Objects.isNull(updatingHero.getUpdated_at())) Hero.setUpdated_at(updatingHero.getUpdated_at());

        return ResponseEntity.accepted().body(heroService.save(Hero));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Long id) {

        Optional<Hero> heroOptional = heroService.deleteById(id);
        if (!heroOptional.isPresent()) {
            log.error("herokId " + id + " is not existed");
            ResponseEntity.notFound().build();
        }


        return ResponseEntity.accepted().build();
    }
}
