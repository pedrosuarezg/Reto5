package com.usa.ciclo3.retociclo3.reports;

import com.usa.ciclo3.retociclo3.model.Client;

public class ReservationStatus {
  private Integer completed;
  private Integer cancelled;

    public ReservationStatus(Integer completed, Integer cancelled) {
        this.completed = completed;
        this.cancelled = cancelled;
    }

    public Integer getCompleted() {
        return completed;
    }

    public void setCompleted(Integer completed) {
        this.completed = completed;
    }

    public Integer getCancelled() {
        return cancelled;
    }

    public void setCancelled(Integer cancelled) {
        this.cancelled = cancelled;
    }
}
