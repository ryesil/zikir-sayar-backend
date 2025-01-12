package com.fikir.zikirsayar.entity;

import jdk.jfr.Description;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Table(name = "zikirs")
public class ZikirEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "svg_content", nullable = false, columnDefinition="TEXT")
    private String svgContent;

    @Column(name="amount", nullable = false)
    private Integer amount;

    @Column(name="date", nullable=false)
    @Description("The date zikir was added to the database")
    private Date date;

    @Column(name="cycle")
    @Description("Number of times the zikir was completed")
    private Integer cycle;

    @Column(name="description")
    private String description;

    @Column(name="goal")
    private Integer goal;

    public ZikirDTO toDto(){
        return new ZikirDTO(this);
    }
}
