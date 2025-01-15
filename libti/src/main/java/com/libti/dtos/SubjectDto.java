package com.libti.dtos;

public class SubjectDto {
    
    private String name;

    private String code;

    private String teacher;

    private String semester;

    private String fileLink;

    private byte[] file;

    
    public SubjectDto() {
    }
    
    public SubjectDto(String name, String code, String teacher, String semester, String fileLink, byte[] file) {
        this.name = name;
        this.code = code;
        this.teacher = teacher;
        this.semester = semester;
        this.fileLink = fileLink;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getCode() {
        return code;
    }
    
    public void setCode(String code) {
        this.code = code;
    }
    
    public String getTeacher() {
        return teacher;
    }
    
    public void setTeacher(String teacher) {
        this.teacher = teacher;
    }
    
    public String getSemester() {
        return semester;
    }
    
    public void setSemester(String semester) {
        this.semester = semester;
    }
    
    public String getFileLink() {
        return fileLink;
    }
    
    public void setFileLink(String fileLink) {
        this.fileLink = fileLink;
    }
    public byte[] getFile() {
        return file;
    }
    
    public void setFile(byte[] file) {
        this.file = file;
    }
}
