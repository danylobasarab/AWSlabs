package ua.lviv.iot.lab4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Establishment {
    private Integer id;
    private String name;
    private Integer typeOfEstablishmentId;
    private float rating;
    private Integer streetId;
    private Integer InformationAboutOwnerId;
}
