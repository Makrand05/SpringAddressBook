package com.biz.addressbook.dto;

import lombok.*;

@Data
@Getter
@Setter
@NoArgsConstructor
public class ResponseDTO {
    private String message;
    private Object data;

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}

