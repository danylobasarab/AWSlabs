package ua.lviv.iot.lab4.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InformationAboutOwner {
    private Integer id;
    private String name;
    private String surname;
    private Integer age;
    private Integer fortunes;
}
