package com.example.fileuploader.entity;

import org.springframework.data.annotation.Id;
import java.time.LocalDate;

public class ForeignAgent {
    @Id
    private long id;
    private String fullName;
    private String reason;
    private LocalDate dateIncluded;
    private LocalDate dateExcluded;

    public ForeignAgent(Long id, String fullName, String reason, LocalDate dateIncluded, LocalDate dateExcluded) {
        this.id = id;
        this.fullName = fullName;
        this.reason = reason;
        this.dateIncluded = dateIncluded;
        this.dateExcluded = dateExcluded;
    }

    public ForeignAgent() {

    }

    public Long getId() {
        return id;
    }
    public String getFullName() {
        return fullName;
    }
    public String getReason() {
        return reason;
    }
    public LocalDate getDateIncluded() {
        return dateIncluded;
    }
    public LocalDate getDateExcluded() {
        return dateExcluded;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    public void setReason(String reason) {
        this.reason = reason;
    }

    public void setDateIncluded(LocalDate dateIncluded) {
        this.dateIncluded = dateIncluded;
    }

    public void setDateExcluded(LocalDate dateExcluded) {
        this.dateExcluded = dateExcluded;
    }

    @Override
    public String toString() {
        return "ForeignAgents{" +
                "id=" + id +
                ", fullName='" + fullName + '\'' +
                ", reason='" + reason + '\'' +
                ", dateIncluded=" + dateIncluded +
                ", dateExcluded=" + dateExcluded +
                '}';
    }
}
