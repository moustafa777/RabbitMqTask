package com.marketnation.rabbitqtask.models;


import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Entity;
import jakarta.persistence.Column;
import jakarta.persistence.OneToOne;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "results")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultEntity {

    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "id")
    private RandomNumberEntity randomNumberEntity;

    @Column(name = "result")
    private Integer result;

}
