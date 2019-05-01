package com.company;

public class WorkerException extends Exception {

    private int workerId;

    public WorkerException(String message, int workerId) {
        super(message);
        this.workerId = workerId;
    }

    public int getWorkerId() {
        return workerId;
    }

    public void setWorkerId(int workerId) {
        this.workerId = workerId;
    }
}
