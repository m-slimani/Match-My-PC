package com.Match_My_PC.infrastructure;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter
@ToString
@EqualsAndHashCode
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class PCEntity {

  @Id
  @GeneratedValue
  private Long id;
  @Column(name = "MARQUE", length = 50, nullable = false)
  private String marque;
  @Column(name = "DATE_SORTIE", length = 10, nullable = false)
  private String date_sortie;
  @Column(name = "CATEGORY", length = 50, nullable = false)
  private String category;
}
