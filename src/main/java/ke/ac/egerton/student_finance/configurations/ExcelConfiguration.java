package ke.ac.egerton.student_finance.configurations;

import ke.ac.egerton.student_finance.settings.thirdParty.models.ThirdParty;
import org.springframework.batch.item.ItemReader;
import org.springframework.context.annotation.Configuration;
@Configuration
public class ExcelConfiguration {


    ItemReader<ThirdParty> helbImportReader(){
        PoiItemReader<ThirdParty> reader = new PoiItemReader<>();
        reader.setLinesToSkip(1);
    }
}
