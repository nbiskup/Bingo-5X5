package hr.algebra.java2.bingoproject.client.model;

import java.io.Serializable;

public class ClientModel implements Serializable {

    private Integer port;
    private String ipAddress;


    public ClientModel(Integer port, String ipAddress){
        this.port = port;
        this.ipAddress = ipAddress;
    }

    public Integer getPort() { return port; }

}
