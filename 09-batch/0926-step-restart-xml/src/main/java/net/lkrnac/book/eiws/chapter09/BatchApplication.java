package net.lkrnac.book.eiws.chapter09;

import lombok.extern.slf4j.Slf4j;

import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ImportResource;

@Slf4j
@SpringBootApplication
@EnableBatchProcessing
@ImportResource("classpath:batch-config.xml")
public class BatchApplication {
  public static void main(String[] args) throws Exception {
    ConfigurableApplicationContext context =
        SpringApplication.run(BatchApplication.class, args);

    JobLauncher jobLauncher = (JobLauncher) context.getBean(JobLauncher.class);
    Job job = (Job) context.getBean("prepareTeaJob");

    JobExecution execution1 = jobLauncher.run(job, new JobParameters());
    log.info("Exit Status : {}", execution1.getStatus());

    JobExecution execution2 = jobLauncher.run(job, new JobParameters());
    log.info("Exit Status : {}", execution2.getStatus());

    JobExecution execution3 = jobLauncher.run(job, new JobParameters());
    log.info("Exit Status : {}", execution3.getStatus());

    Job jobNotRestarteble =
        (Job) context.getBean("prepareTeaJobNotRestartable");

    JobExecution execution4 =
        jobLauncher.run(jobNotRestarteble, new JobParameters());
    log.info("Exit Status : {}", execution4.getStatus());

    context.close();

  }
}
