package com.co.challenge.farmu.tools.web.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Null;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UrlDto implements Serializable {

    static final long serialVersionUID = -4702712557554549560L;

    @Null
    private Integer id;

    @ApiModelProperty(required = true, notes = "Url origin")
    private String urlOrigin;

    @Null
    @ApiModelProperty(notes = "Url after transformation")
    private String shortUrl;

    @Null
    @ApiModelProperty(notes = "Creation date")
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ssZ", shape= JsonFormat.Shape.STRING)
    private OffsetDateTime createdDate;

}
