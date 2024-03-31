package hello.itemservice;

import hello.itemservice.config.*;
import hello.itemservice.repository.ItemRepository;
import javax.sql.DataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.Profile;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


//@Import(MemoryConfig.class)
//v1
//@Import(JdbcTemplateV1Config.class)
//v2
//@Import(JdbcTemplateV2Config.class)
//v3
//@Import(JdbcTemplateV3Config.class)
//MyBatis
//@Import(MyBatisConfig.class)
//Jpa
//@Import(JpaConfig.class)
//SpringDataJap
//@Import(SpringDataJpaConfig.class)
//querydsl
//@Import(QuerydslConfig.class)
//practical architecture
@Import(V2Config.class)
@Slf4j
@SpringBootApplication(scanBasePackages = "hello.itemservice.web")
public class ItemServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItemServiceApplication.class, args);
	}

	@Bean
	@Profile("local")
	public TestDataInit testDataInit(ItemRepository itemRepository) {
		return new TestDataInit(itemRepository);
	}

//	@Bean
//	@Profile("test")
//	public DataSource dataSource() {
//		//임베디드 db
//		log.info("메모리 데이터베이스 초기화");
//		DriverManagerDataSource dataSource = new DriverManagerDataSource();
//		dataSource.setDriverClassName("org.h2.Driver");
//		dataSource.setUrl("jdbc:h2:mem:db;DB_CLOSE_DELAY=-1");
//		dataSource.setUsername("sa");
//		dataSource.setPassword("");
//		return dataSource;
//	}
}
