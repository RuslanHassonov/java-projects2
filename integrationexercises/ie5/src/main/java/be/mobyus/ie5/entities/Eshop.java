package be.mobyus.ie5.entities;

import javax.persistence.*;

@Entity
public class Eshop {
    // TODO: this class is not complete, only here to get you started
    // complete the properties following the IE3 requirements
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Embedded
    private EshopInfo eshopInfo;
    private Address address;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EshopInfo getEshopInfo() {
        return eshopInfo;
    }

    public void setEshopInfo(EshopInfo eshopInfo) {
        this.eshopInfo = eshopInfo;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
