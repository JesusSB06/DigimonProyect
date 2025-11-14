/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.digimonproyect.model.digimon;

import java.util.List;
import java.io.Serializable;

/**
 *
 * @author dam2_alu09@inf.ald
 */
public class Digimon implements Serializable{
    private int id;
    private String name;
    private boolean xAntibody;
    private List<Image> images;
    private List<Level> levels;
    private List<Type> types;
    private List<Attribute> attributes;
    private List<Field> fields;
    private String releaseDate;
    private List<Description> descriptions;
    private List<Skill> skills;
    private List<Evolution> priorEvolutions;
    private List<Evolution> nextEvolutions;

    public Digimon(int id, String name, boolean xAntibody, List<Image> images, List<Level> levels, List<Type> types, List<Attribute> attributes, List<Field> fields, String releaseDate, List<Description> descriptions, List<Skill> skills, List<Evolution> priorEvolutions, List<Evolution> nextEvolutions) {
        this.id = id;
        this.name = name;
        this.xAntibody = xAntibody;
        this.images = images;
        this.levels = levels;
        this.types = types;
        this.attributes = attributes;
        this.fields = fields;
        this.releaseDate = releaseDate;
        this.descriptions = descriptions;
        this.skills = skills;
        this.priorEvolutions = priorEvolutions;
        this.nextEvolutions = nextEvolutions;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isxAntibody() {
        return xAntibody;
    }

    public void setxAntibody(boolean xAntibody) {
        this.xAntibody = xAntibody;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }

    public List<Level> getLevels() {
        return levels;
    }

    public void setLevels(List<Level> levels) {
        this.levels = levels;
    }

    public List<Type> getTypes() {
        return types;
    }

    public void setTypes(List<Type> types) {
        this.types = types;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<Attribute> attributes) {
        this.attributes = attributes;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public List<Description> getDescriptions() {
        return descriptions;
    }

    public void setDescriptions(List<Description> descriptions) {
        this.descriptions = descriptions;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public List<Evolution> getPriorEvolutions() {
        return priorEvolutions;
    }

    public void setPriorEvolutions(List<Evolution> priorEvolutions) {
        this.priorEvolutions = priorEvolutions;
    }

    public List<Evolution> getNextEvolutions() {
        return nextEvolutions;
    }

    public void setNextEvolutions(List<Evolution> nextEvolutions) {
        this.nextEvolutions = nextEvolutions;
    }
    
}
