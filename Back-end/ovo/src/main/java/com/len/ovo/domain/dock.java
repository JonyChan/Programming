package com.len.ovo.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "dock")
public class dock implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String dockpn;

    @Column(nullable = true)
    private String dockdescription;

    @Column(nullable = true)
    private String compatibilitypn;

    @Column(nullable = true)
    private String compatibilitydescription;

    @Column(nullable = true)
    private String footnoteid;

    @Column(nullable = true)
    private String footnotetext;

    public dock() {
    }

    public dock(String dockpn, String dockdescription, String compatibilitypn, String compatibilitydescription, String footnoteid, String footnotetext) {
        this.dockpn = dockpn;
        this.dockdescription = dockdescription;
        this.compatibilitypn = compatibilitypn;
        this.compatibilitydescription = compatibilitydescription;
        this.footnoteid = footnoteid;
        this.footnotetext = footnotetext;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

//    get/set方法
    public String getDockpn() {
        return dockpn;
    }
    public void setDockpn(String dockpn) {
        this.dockpn = dockpn;
    }
    public String getDockdescription() {
        return dockdescription;
    }
    public void setDockdescription(String dockdescription) {
        this.dockdescription = dockdescription;
    }
    public String getCompatibilitypn() {
        return compatibilitypn;
    }
    public void setCompatibilitypn(String compatibilitypn) {
        this.compatibilitypn = compatibilitypn;
    }
    public String getCompatibilitydescription() {
        return compatibilitydescription;
    }
    public void setCompatibilitydescription(String compatibilitydescription) {
        this.compatibilitydescription = compatibilitydescription;
    }
    public String getFootnoteid() {
        return footnoteid;
    }
    public void setFootnoteid(String footnoteid) {
        this.footnoteid = footnoteid;
    }
    public String getFootnotetext() {
        return footnotetext;
    }
    public void setFootnotetext(String footnotetext) {
        this.footnotetext = footnotetext;
    }

    @Override
    public String toString() {
        return "dock{" +
                "id=" + id +
                ", dockpn='" + dockpn + '\'' +
                ", dockdescription='" + dockdescription + '\'' +
                ", compatibilitypn='" + compatibilitypn + '\'' +
                ", compatibilitydescription='" + compatibilitydescription + '\'' +
                ", footnoteid='" + footnoteid + '\'' +
                ", footnotetext='" + footnotetext + '\'' +
                '}';
    }
}
