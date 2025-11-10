package com.mycompany.digimonproyect.model.digimon;

import java.io.Serializable;

/**
 *
 * @author dam2_alu04@inf.ald
 */
public class Image implements Serializable{

    private String href;
    private boolean transparent;

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public boolean isTransparent() {
        return transparent;
    }

    public void setTransparent(boolean transparent) {
        this.transparent = transparent;
    }
}
