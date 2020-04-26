package com.modesty.config.batch;

import javax.sql.DataSource;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepScope;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import com.modesty.pojo.po.People;

/**
* @author Modesty
* @Version 2020年4月7日 上午2:23:00
*/

@Configuration
public class CsvBatchJobConfig {
	@Autowired
	JobBuilderFactory jobBuilderFactory;
	
	@Autowired
	StepBuilderFactory stepBuilderFactory;
	
	@Autowired
	DataSource dataSource;
	
	@Bean
	@StepScope
	FlatFileItemReader<People>  itemReader(){
		FlatFileItemReader<People> reader = new FlatFileItemReader<People>();
		reader.setLinesToSkip(1);
		reader.setResource(new ClassPathResource("data.csv"));
		reader.setLineMapper(new DefaultLineMapper<People>() {{
			setLineTokenizer(new DelimitedLineTokenizer() {{
				setNames("id","username","address","gender");
				setDelimiter("\t");
			}});
			setFieldSetMapper(new BeanWrapperFieldSetMapper<People>() {{
				setTargetType(People.class);
			}});
		}});
		return reader;
	}
	
	@Bean
	JdbcBatchItemWriter jdbcBatchItemWriter() {
		JdbcBatchItemWriter writer  = new JdbcBatchItemWriter(); 
		writer.setDataSource(dataSource);
		writer.setSql("insert into people(id,username,address,gender) " + "values(:id,:username,:address,:gender)");
		writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
		return writer;
	}
	
	@Bean
	Step csvStep() {
		return stepBuilderFactory.get("csvStep")
				.<People,People>chunk(2)
				.reader(itemReader())
				.writer(jdbcBatchItemWriter())
				.build();
	}
	
	@Bean
	Job csvJob() {
		return jobBuilderFactory.get("csvJob").start(csvStep()).build();
	}
}


/**
* Notes
*/
