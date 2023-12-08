package shhkitt.rschir.kr.insurance.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum InsuranceType {
    HEALTH("health"),
    PET("pet"),
    CAR("car"),
    TRAVEL("travel"),
    PROPERTY("property")
    ;

    String name;

    @Override
    public String toString() {
        return name;
    }
}
