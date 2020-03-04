package ke.ac.egerton.student_finance.configurations;

import ke.ac.egerton.student_finance.settings.thirdParty.models.ThirdParty;
import org.springframework.batch.item.ItemReader;
import org.springframework.beans.BeanWrapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.batch.item.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.core.RowMapper;

@Configuration
public class ExcelConfiguration {


    /*@Bean
    ItemReader<ThirdParty> helbImportReader(){
        PoiItemReader<ThirdParty> reader = new PoiItemReader<>();
        reader.setLinesToSkip(1);
        reader.setResource(new ClassPathResource("data/helb.xlsx"));
        reader.setRowMapper(excelRowMapper());
        return reader;
    }

    private RowMapper<ThirdParty> excelRowMapper(){
        BeanWrapperRowMapper<ThirdParty> rowMapper = new BeanWrapperRowMapper<>();
            rowMapper.setTargetType(ThirdParty.class);
            return rowMapper;
        }
    }*/
}
