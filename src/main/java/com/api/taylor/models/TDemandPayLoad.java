package com.api.taylor.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TDemandPayLoad {
    private long id;
    private String object;
    private String content;
    private long municipality_id;
    private List<String> imageModele;
    private Date dateRetrait;
    private Date dateDmd;
    private long sender_id;
    private String category;

}
