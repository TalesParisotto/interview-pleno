package br.com.brainweb.interview.model;

import java.util.Date;

import lombok.*;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;

@Data
@Getter
@Setter


@AllArgsConstructor
@NoArgsConstructor
@DynamicUpdate
@Entity
public class Hero {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long    id;

    String  name;
    String  race;
    Long    power_stats_id;
    Boolean enabled;
    Date    created_at;
    Date    updated_at;
}
