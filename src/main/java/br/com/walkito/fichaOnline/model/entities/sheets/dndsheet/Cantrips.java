package br.com.walkito.fichaOnline.model.entities.sheets.dndsheet;

import br.com.walkito.fichaOnline.model.entities.sheets.SheetDnD;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "dnd_cantrips")
public class Cantrips {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(length = 20)
    private String cantrip1;

    @Column(length = 20)
    private String cantrip2;

    @Column(length = 20)
    private String cantrip3;

    @Column(length = 20)
    private String cantrip4;

    @Column(length = 20)
    private String cantrip5;

    @Column(length = 20)
    private String cantrip6;

    @Column(length = 20)
    private String cantrip7;

    @Column(length = 20)
    private String cantrip8;

    public Cantrips(){
    }

    public Cantrips(String cantrip1, String cantrip2, String cantrip3, String cantrip4, String cantrip5, String cantrip6, String cantrip7, String cantrip8) {
        this.cantrip1 = cantrip1;
        this.cantrip2 = cantrip2;
        this.cantrip3 = cantrip3;
        this.cantrip4 = cantrip4;
        this.cantrip5 = cantrip5;
        this.cantrip6 = cantrip6;
        this.cantrip7 = cantrip7;
        this.cantrip8 = cantrip8;
    }

    public String getCantrip1() {
        return cantrip1;
    }

    public void setCantrip1(String cantrip1) {
        this.cantrip1 = cantrip1;
    }

    public String getCantrip2() {
        return cantrip2;
    }

    public void setCantrip2(String cantrip2) {
        this.cantrip2 = cantrip2;
    }

    public String getCantrip3() {
        return cantrip3;
    }

    public void setCantrip3(String cantrip3) {
        this.cantrip3 = cantrip3;
    }

    public String getCantrip4() {
        return cantrip4;
    }

    public void setCantrip4(String cantrip4) {
        this.cantrip4 = cantrip4;
    }

    public String getCantrip5() {
        return cantrip5;
    }

    public void setCantrip5(String cantrip5) {
        this.cantrip5 = cantrip5;
    }

    public String getCantrip6() {
        return cantrip6;
    }

    public void setCantrip6(String cantrip6) {
        this.cantrip6 = cantrip6;
    }

    public String getCantrip7() {
        return cantrip7;
    }

    public void setCantrip7(String cantrip7) {
        this.cantrip7 = cantrip7;
    }

    public String getCantrip8() {
        return cantrip8;
    }

    public void setCantrip8(String cantrip8) {
        this.cantrip8 = cantrip8;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
