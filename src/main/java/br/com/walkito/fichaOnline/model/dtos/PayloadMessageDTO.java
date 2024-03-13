package br.com.walkito.fichaOnline.model.dtos;

public class PayloadMessageDTO {

    private String message;
    private int number;

    public PayloadMessageDTO() {
    }

    public PayloadMessageDTO(String message, int number) {
        this.message = message;
        this.number = number;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
