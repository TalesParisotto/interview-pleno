package br.com.brainweb.interview.model;

import java.util.Date;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Data
@Getter
@Setter

@Entity
public class PowerStats {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long    id;

    Integer strength  ;
    Integer agility;
    Integer dexterity  ;
    Integer intelligence;
    Date created_at;
    Date    updated_at ;

}
