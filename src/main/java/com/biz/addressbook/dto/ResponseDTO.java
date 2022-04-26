package com.biz.addressbook.dto;

import lombok.*;

/**
 * Class for send response in for of string message and data object
 */
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

