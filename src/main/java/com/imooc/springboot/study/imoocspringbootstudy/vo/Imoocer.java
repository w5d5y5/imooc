package com.imooc.springboot.study.imoocspringbootstudy.vo;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIgnoreProperties({"address"})
public class Imoocer {

    private  String name;

    private  int age;
    //忽略一个
    //@JsonIgnore()
    private  String address;

    @JsonProperty("rt")
   // @JsonFormat(pattern = "yyyy-MM-dd  HH:mm:ss")
    private Date  registerTime;


}
