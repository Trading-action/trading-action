package com.trading.clientservice.domain.pojo;



public class Actionnaire {
    private Long id;
    private String username;
    private  String ref;
    private String  refCompte;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getRef() {
        return ref;
    }

    public void setRef(String ref) {
        this.ref = ref;
    }

    public String getRefCompte() {
        return refCompte;
    }

    public void setRefCompte(String refCompte) {
        this.refCompte = refCompte;
    }
}
