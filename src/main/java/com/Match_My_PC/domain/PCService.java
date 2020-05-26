package com.Match_My_PC.domain;

import com.Match_My_PC.infrastructure.PCDao;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class PCService {

  private PCDao pcDao;

  public PCService(PCDao pcDao) {
    this.pcDao = pcDao;
  }

  public List<PC> getPC() {
    return pcDao.findPC();
  }

  @Cacheable("pc")
  public PC getPC(Long id) throws NotFoundException {
    log.info("********************INSIDE THE PCERVICE********************");
    return PCDao.findPC(id);
  }

  public PC addPC(PC pc) {
    return pcDao.createPC(pc);
  }

  public void deletePC(Long id) {
    pcDao.deletePC(id);
  }

  public void patchPC(PC pc) {
    pcDao.updatePC(pc);
  }

  public PC findPC(Long id) throws NotFoundException {
    return pcDao.findPC(id);
  }

  public PC replacePC(PC pc) {
    return pcDao.replacePC(pc);
  }
}
