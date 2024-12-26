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

    @Column(name = "svg_content", nullable = false)
    private String svgContent;

    @Column(name="amount", nullable = false)
    Integer amount;

    @Column(name="date", nullable=false)
    @Description("The date zikir was added to the database")
    Date date;

    @Column(name="cycle" , nullable = false)
    @Description("Number of times the zikir was completed")
    Integer cycle;

    @Column(name="description", nullable = false)
    String description;

    public ZikirDTO toDto(){
        return new ZikirDTO(this);
    }
}
