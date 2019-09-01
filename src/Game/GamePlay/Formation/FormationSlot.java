package Game.GamePlay.Formation;

import Game.GamePlay.GamePlayer;
import Game.Routes.Route;
import Game.Utils.Location;
import JavaXMLUtility.MalformedXMLException;
import JavaXMLUtility.XMLHeader;
import Position.References.Lists.PositionList;
import Tuple.Tuple2;

import java.util.ArrayList;
import java.util.List;

public class FormationSlot {

    private final int index;
    private final Location location;
    private final Route route;
    private final List<PositionList> recommendedPositions;
    private GamePlayer housedPlayer;

    private final static String XML_TITLE = "slot";
    private final static String INDEX_ATTRIBUTE = "index";
    private final static String LOCATION_CHILD = "location";
    private final static String ROUTE_CHILD = "route";

//    <slot index="2">
//        <location x="2" y="2"></location>
//        <route>"TESTING 3"</route>
//        <recommendedPositions>QB,WR,RB,FB</recommendedPositions>
//    </slot>

    @Deprecated
    public FormationSlot(final XMLHeader input) throws MalformedXMLException {
        verifyXMLInput(input);
//        If we have made it this far, we can assume the xml is valid
        index = Integer.parseInt(input.getAttribute(INDEX_ATTRIBUTE).getAttribute());
        location = parseLocation(input);
        route = parseRoute(input);
        recommendedPositions = new ArrayList<>();
    }

    private final void verifyXMLInput(final XMLHeader input) throws MalformedXMLException {
        if(!input.getName().equalsIgnoreCase(XML_TITLE)) throw new MalformedXMLException("Invalid XML Input "+input.getName()+ "for slot");
//        TODO Create an "intelligent" way to handle situations where we are missing the index
        if(!input.containsAttribute(INDEX_ATTRIBUTE)) throw new MalformedXMLException("FormationSlot is missing the assigned index.");
        if(!input.containsChild(LOCATION_CHILD)) throw new MalformedXMLException("FormationSlot is missing location.");
        if(!input.containsChild(ROUTE_CHILD)) throw new MalformedXMLException("FormationSlot is missing route.");
    }

    private final Location parseLocation(final XMLHeader locationInput) throws MalformedXMLException {
        if(!locationInput.getName().equalsIgnoreCase(LOCATION_CHILD) && !locationInput.containsChild(LOCATION_CHILD)) throw new MalformedXMLException("FormationSlot is missing location");
        double x = -10000;
        double y = -10000;

        if(locationInput.getName().equalsIgnoreCase(LOCATION_CHILD)){
            x = Double.parseDouble(locationInput.getAttribute("x").getAttribute());
            y = Double.parseDouble(locationInput.getAttribute("y").getAttribute());
        } else {
            for(final XMLHeader header: locationInput.getChildren()){
                if(header.getName().equalsIgnoreCase(LOCATION_CHILD)) return parseLocation(header);
            }
        }

        return new Location(x,y);
    }

    private final Route parseRoute(final XMLHeader routeInput) throws MalformedXMLException {
        if(!routeInput.getName().equalsIgnoreCase(LOCATION_CHILD) && !routeInput.containsChild(LOCATION_CHILD)) throw new MalformedXMLException("FormationSlot is missing location");
//        TODO
        return new Route();
    }

    public final int getIndex(){
        return index;
    }

    public final Tuple2<Double, Double> getLocation(){
        return location.getLocation();
    }

    public final Route getRoute(){
        return route;
    }

    public final List<PositionList> getRecommendedPositions(){
        return new ArrayList<>(recommendedPositions);
    }

    public final void setPlayer(final GamePlayer player){
        housedPlayer = player;
    }

    public final GamePlayer getPlayer(){
        return housedPlayer;
    }

}
