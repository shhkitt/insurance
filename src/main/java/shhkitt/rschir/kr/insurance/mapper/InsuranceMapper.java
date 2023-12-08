package shhkitt.rschir.kr.insurance.mapper;

import lombok.NoArgsConstructor;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.ConfigurableMapper;
import org.springframework.stereotype.Component;
import shhkitt.rschir.kr.insurance.models.dto.*;
import shhkitt.rschir.kr.insurance.models.entity.*;

@Component
@NoArgsConstructor
public class InsuranceMapper extends ConfigurableMapper {
    @Override
    public void configure(MapperFactory factory) {
        factory.classMap(Program.class, ProgramDto.class)
                .byDefault()
                .register();

        factory.classMap(Clinic.class, ClinicDto.class)
                .byDefault()
                .register();

        factory.classMap(Insured.class, InsuredDto.class)
                .byDefault()
                .register();

        factory.classMap(Contract.class, ContractDto.class)
                .byDefault()
                .register();

        factory.classMap(Client.class, ClientDto.class)
                .byDefault()
                .register();
    }
}