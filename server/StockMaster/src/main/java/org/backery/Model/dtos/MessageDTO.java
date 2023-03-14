package org.backery.Model.dtos;

import lombok.*;

@Setter
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MessageDTO {

    private String message;
    private String content;


//
//    public MessageDTO() {
//        super();
//    }
//
//    public MessageDTO(String message) {
//        super();
//        this.message = message;
//    }
//
//    public String getMessage() {
//        return message;
//    }
//
//    public void setMessage(String message) {
//        this.message = message;
//    }
//

}
