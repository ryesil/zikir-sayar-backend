package com.fikir.zikirsayar.entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class ZikirDTO {

    private Long id;
    private Integer amount;

    public ZikirDTO(ZikirEntity zkr){
        this.id = zkr.getId();
        this.amount = zkr.getAmount();
    }
}
