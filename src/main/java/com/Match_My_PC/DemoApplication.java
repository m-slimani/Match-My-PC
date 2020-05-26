package com.Match_My_PC;

import com.Match_My_PC.infrastructure.Match_My_PCRepository;
import com.Match_My_PC.infrastructure.PCEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@Slf4j
@SpringBootApplication
@EnableScheduling
public class DemoApplication implements CommandLineRunner {

  @Autowired
  private Match_My_PCRepository match_my_pcRepository;

  public DemoApplication(Match_My_PCRepository match_my_pcRepository) {
    this.match_my_pcRepository = match_my_pcRepository;
  }

  public static void main(String[] args) {

    SpringApplication.run(DemoApplication.class, args);
    System.out.println("Hello SUDRIA !");
  }

  @Override
  public void run(String... args) {

    log.info("Data initilisation...");
    savePC(1L, "Garfield", 5, "FELINE");
    savePC(2L, "Nemo", 1, "FISCH");
  }

  private void savePC(long id, String name, int age, String category) {
    this.match_my_pcRepository.save(
        PCEntity
            .builder()
            .id(id)
            .name(name)
            .age(age)
            .category(category)
            .build());
  }

}
