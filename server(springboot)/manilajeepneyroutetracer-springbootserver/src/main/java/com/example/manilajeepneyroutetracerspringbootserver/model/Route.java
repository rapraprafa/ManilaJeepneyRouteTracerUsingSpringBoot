package com.example.manilajeepneyroutetracerspringbootserver.model;

import javax.persistence.*;

@Entity
@Table(name = "jeepneyroutes")
public class Route {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long routeid;

    @Column(name = "routename")
    private String routename;

    @Column(name = "numberofwaypointsadded")
    private int numberofwaypointsadded;

    @Column(name = "waypointlat")
    private String waypointlat;

    @Column(name = "waypointlng")
    private String waypointlng;

    public Route(){

    }

    public Route(String routename, int numberofwaypointsadded, String waypointlat, String waypointlng) {
        this.routename = routename;
        this.numberofwaypointsadded = numberofwaypointsadded;
        this.waypointlat = waypointlat;
        this.waypointlng = waypointlng;
    }


    public long getRouteid() {
        return routeid;
    }

    public String getRoutename() {
        return routename;
    }

    public int getNumberofwaypointsadded() {
        return numberofwaypointsadded;
    }

    public String getwaypointlat() {
        return waypointlat;
    }

    public String getwaypointlng() {
        return waypointlng;
    }
}
