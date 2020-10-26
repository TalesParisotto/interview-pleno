package br.com.brainweb.interview.core.features.hero;

import br.com.brainweb.interview.model.Hero;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.*;

import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest
public class HeroControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private HeroService heroService;

    @Test
    public void findAll() throws Exception {
        // given
        Hero hero = new Hero();
        hero.setId(1L);
        hero.setName("Batman");
        hero.setRace("Human");
        hero.setUpdated_at(new GregorianCalendar(2020, Calendar.OCTOBER, 25).getTime());
        System.out.println("up: " + hero.getUpdated_at().toString());
        hero.setCreated_at(new GregorianCalendar(2020, Calendar.OCTOBER, 25).getTime());
        System.out.println("cre: " + hero.getCreated_at().toString());
        hero.setEnabled(true);
        hero.setPower_stats_id(2L);

        List<Hero> heros = Arrays.asList(hero);
        given(heroService.findAll()).willReturn(heros);

        // when + then
        this.mockMvc.perform(get("/api/v1/heros"))
                .andExpect(status().isOk())
                .andExpect(content().json("[{'id': 1,'name': 'Batman';'race': 'Human','Updated_at':''}]"));
    }

}
