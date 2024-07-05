package br.com.walkito.fichaOnline.model.dtos;

public class ImageDTO {

    private int id;

    private String imageB64;

    private String fileName;

    public ImageDTO() {
    }

    public ImageDTO(int id, String imageB64, String fileName) {
        this.imageB64 = imageB64;
        this.fileName = fileName;
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImageB64() {
        return imageB64;
    }

    public void setImageB64(String imageB64) {
        this.imageB64 = imageB64;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }
}
