package com.Match_My_PC.infrastructure;

import com.Match_My_PC.domain.PC;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class PCDao {

  private Match_My_PCRepository match_my_pcRepository;

  public PCDao(Match_My_PCRepository zooRepository) {
    this.match_my_pcRepository = match_my_pcRepository;
  }

  public List<PC> findPC() {
    return StreamSupport.stream(match_my_pcRepository.findAll().spliterator(), false)
        .map(pcEntitie -> buildPC(pcEntitie))
        .collect(Collectors.toList());
  }

  public PC findPC(Long id) throws NotFoundException {
    return buildAnimal(match_my_pcRepository.findById(id).orElseThrow(NotFoundException::new));
  }

  public PC createAnimals(PC pc) {
    return buildPC(match_my_pcRepository.save(buildEntity(pc)));
  }

  public void deleteAnimals(Long id) {
    match_my_pcRepository.delete(match_my_pcRepository.findById(id).get());
  }

  public void updateAnimal(PC pc) {
    match_my_pcRepository.save(buildEntity(pc));
  }

  public PC replaceAnimal(PC pc) {
    return buildPC(match_my_pcRepository.save(buildEntity(pc)));
  }

  private PCEntity buildEntity(PC pc) {
    return PCEntity
        .builder()
        .id(pc.getId())
        .name(pc.getName())
        .age(pc.getAge())
        .category(pc.getCategory())
        .build();
  }

  private PC buildAnimal(PCEntity pcEntity) {
    return PC.builder()
        .id(pcEntity.getId())
        .name(pcEntity.getName())
        .age(pcEntity.getAge())
        .category(pcEntity.getCategory())
        .build();
  }


}
